package com.vladsch.flexmark.ext.heading.anchors;

import com.vladsch.flexmark.ext.heading.anchors.internal.HeadingAnchorNodePostProcessor;
import com.vladsch.flexmark.ext.heading.anchors.internal.HeadingAnchorNodeRenderer;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Extension for heading anchors and links to such anchors.
 * <p>
 * Create it with {@link #create()} and then configure it on the builders
 * <p>
 * The parsed Heading text is turned into a {@Heading} node with a {@link HeadingAnchor} node.
 */
public class HeadingAnchorExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension {

    private HeadingAnchorExtension() {
    }

    public static HeadingAnchorExtension create() {
        return new HeadingAnchorExtension();
    }

    @Override
    public void parserOptions(MutableDataHolder options) {

    }

    @Override
    public void rendererOptions(@NotNull MutableDataHolder options) {

    }

    @Override
    public void extend(Parser.Builder parserBuilder) {
        parserBuilder.postProcessorFactory(new HeadingAnchorNodePostProcessor.Factory(parserBuilder));
    }

    @Override
    public void extend(@NotNull HtmlRenderer.Builder htmlRendererBuilder, @NotNull String rendererType) {
        if (htmlRendererBuilder.isRendererType("HTML")) {
            htmlRendererBuilder.nodeRendererFactory(new HeadingAnchorNodeRenderer.Factory());
        }
    }

}