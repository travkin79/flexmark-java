package com.vladsch.flexmark.ext.plantuml;

import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlantUmlBlockNode extends CodeBlock {

    private BasedSequence startMarker;
    private BasedSequence endMarker;

    public PlantUmlBlockNode() {
    }

    public PlantUmlBlockNode(BasedSequence chars) {
        super(chars);
    }

    public PlantUmlBlockNode(BasedSequence chars, List<BasedSequence> lineSegments) {
        super(chars, lineSegments);
    }

    public PlantUmlBlockNode(List<BasedSequence> lineSegments) {
        this(getSpanningChars(lineSegments), lineSegments);
    }

    private static @NotNull BasedSequence getSpanningChars(@NotNull List<BasedSequence> lineSegments) {
        return lineSegments.isEmpty() ? BasedSequence.NULL : lineSegments.get(0).baseSubSequence(
                lineSegments.get(0).getStartOffset(),
                lineSegments.get(lineSegments.size() - 1).getEndOffset());
    }

    public PlantUmlBlockNode(BlockContent blockContent) {
        super(blockContent);
    }

    public BasedSequence getStartMarker() {
        return startMarker;
    }

    public void setStartMarker(BasedSequence startMarker) {
        this.startMarker = startMarker;
    }

    public BasedSequence getEndMarker() {
        return endMarker;
    }

    public void setEndMarker(BasedSequence endMarker) {
        this.endMarker = endMarker;
    }

}