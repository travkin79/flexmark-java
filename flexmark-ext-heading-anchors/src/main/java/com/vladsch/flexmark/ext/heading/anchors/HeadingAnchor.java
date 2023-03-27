package com.vladsch.flexmark.ext.heading.anchors;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

public class HeadingAnchor extends Node {

    private BasedSequence anchorId = BasedSequence.NULL;

    @Override
    public @NotNull BasedSequence[] getSegments() {
        return EMPTY_SEGMENTS;
    }

    public void setAnchorId(BasedSequence anchorId) {
        this.anchorId = anchorId;
    }

    public BasedSequence getAnchorId() {
        return anchorId;
    }

    @NotNull
    @Override
    protected String toStringAttributes() {
        return "anchorId=" + getAnchorId().toString();
    }
}