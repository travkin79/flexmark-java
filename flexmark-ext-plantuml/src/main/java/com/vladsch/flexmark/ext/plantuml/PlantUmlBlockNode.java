package com.vladsch.flexmark.ext.plantuml;

import com.vladsch.flexmark.ast.CodeBlock;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;

import java.util.List;

public class PlantUmlBlockNode extends CodeBlock {

    private BasedSequence startMarker;
    private BasedSequence endMarker;

    public PlantUmlBlockNode() {
    }

    public PlantUmlBlockNode(BasedSequence chars) {
        super(chars);
    }

    public PlantUmlBlockNode(BasedSequence chars, List<BasedSequence> segments) {
        super(chars, segments);
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