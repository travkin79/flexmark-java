package com.vladsch.flexmark.ext.heading.anchors;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

public class HeadingAnchor extends Node {

    @Override
    public @NotNull BasedSequence[] getSegments() {
        return EMPTY_SEGMENTS;
    }

    public String getAnchorId() {
        // remove "{#" and "}"
        int length = getChars().length();
        return getChars().subSequence(2, length - 1).toString();
    }

    @NotNull
    @Override
    protected String toStringAttributes() {
        return "anchorId=" + getAnchorId();
    }
}