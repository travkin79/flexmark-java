package com.vladsch.flexmark.ext.plantuml.internal;

import com.vladsch.flexmark.ext.plantuml.PlantUmlBlockNode;
import com.vladsch.flexmark.ext.plantuml.PlantUmlMarker;
import com.vladsch.flexmark.parser.block.*;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class PlantUmlCodeBlockParser extends AbstractBlockParser {

    private final PlantUmlBlockNode blockNode;
    private final BlockData blockData;

    public PlantUmlCodeBlockParser(BlockData blockData) {
        this.blockData = blockData;
        this.blockNode = new PlantUmlBlockNode();
        this.blockNode.setStartMarker(blockData.startMarker);
    }

    @Override
    public PlantUmlBlockNode getBlock() {
        return blockNode;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        if (state.isBlank()) {
            return BlockContinue.atIndex(state.getNextNonSpaceIndex());
        }

        BasedSequence line = state.getLine();
        int nextNoneSpaceCharIndex = state.getNextNonSpaceIndex();
        char firstChar = line.charAt(nextNoneSpaceCharIndex);
        if (firstChar == '@') {
            BlockData blockData = tryReadingEndMarker(line, this.blockData);
            if (blockData != null) {
                this.blockNode.setEndMarker(blockData.endMarker);
                return BlockContinue.atIndex(state.getNextNonSpaceIndex());
            }
            return BlockContinue.none();
        }

        return BlockContinue.atIndex(state.getNextNonSpaceIndex());
    }

    @Override
    public void addLine(ParserState state, BasedSequence line) {
        if (this.blockData.contents == null) {
            this.blockData.contents = line;
        } else {
            this.blockData.contents = this.blockData.contents.append(line);
        }
    }

    @Override
    public void closeBlock(ParserState state) {
        //blockNode.setCharsFromContent();
        BasedSequence start = blockNode.getStartMarker();
        BasedSequence end = blockNode.getEndMarker();

        if (start != null && end != null
                && start.length() > 1 && end.length() > 1) {
            blockNode.setChars(this.blockData.contents);
        }
    }

    public static class Factory implements CustomBlockParserFactory {
        @Nullable
        @Override
        public Set<Class<?>> getAfterDependents() {
            return null;
        }

        @Nullable
        @Override
        public Set<Class<?>> getBeforeDependents() {
            return null;
        }

        @Override
        public boolean affectsGlobalScope() {
            return false;
        }

        @NotNull
        @Override
        public BlockParserFactory apply(@NotNull DataHolder options) {
            return new BlockFactory(options);
        }
    }

    private static class BlockFactory extends AbstractBlockParserFactory {

        BlockFactory(DataHolder options) {
            super(options);
        }

        @Override
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            BasedSequence line = state.getLine();
            int nextNoneSpaceCharIndex = state.getNextNonSpaceIndex();
            char firstChar = line.charAt(nextNoneSpaceCharIndex);
            if (firstChar != '@') {
                return BlockStart.none();
            }

            BlockData blockData = tryReadingStartMarker(line);
            if (blockData != null) {
                return BlockStart.of(new PlantUmlCodeBlockParser(blockData))
                        .atColumn(state.getColumn());
            }

            return BlockStart.none();
        }

    }

    private static BlockData tryReadingStartMarker(BasedSequence currentLine) {
        for (PlantUmlMarker marker: PlantUmlMarker.values()) {
            if (currentLine.startsWith(marker.getStart())) {
                BasedSequence remainder = currentLine.subSequence(marker.getStart().length());
                if (remainder.isBlank()) {
                    return new BlockData(marker, currentLine.getStartOffset(),
                            currentLine.subSequence(0, marker.getStart().length()));
                }
            }
        }
        return null;
    }

    private static BlockData tryReadingEndMarker(BasedSequence currentLine, BlockData blockData) {
        if (currentLine.startsWith(blockData.marker.getEnd())) {
            BasedSequence remainder = currentLine.subSequence(blockData.marker.getEnd().length());
            if (remainder.isBlank()) {
                blockData.endOffset = currentLine.getEndOffset();
                blockData.endMarker = currentLine.subSequence(0, blockData.marker.getEnd().length());
                return blockData;
            }
        }
        return null;
    }

    private static class BlockData {
        final PlantUmlMarker marker;
        int startOffset;
        int endOffset;
        BasedSequence startMarker;
        BasedSequence endMarker;
        BasedSequence contents;

        BlockData(PlantUmlMarker marker, int startOffset, BasedSequence startMarker) {
            this.marker = marker;
            this.startOffset = startOffset;
            this.startMarker = startMarker;
        }
    }

}
