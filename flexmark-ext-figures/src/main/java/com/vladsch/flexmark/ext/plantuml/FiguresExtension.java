package com.vladsch.flexmark.ext.plantuml;

import com.vladsch.flexmark.ext.plantuml.internal.ImageNodeRenderer;
import com.vladsch.flexmark.ext.plantuml.internal.ImageParagraphRemovingPostProcessor;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import org.jetbrains.annotations.NotNull;


public class FiguresExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension {

    private FiguresExtension() {
    }

    public static FiguresExtension create() {
        return new FiguresExtension();
    }

    @Override
    public void parserOptions(MutableDataHolder options) {

    }

    @Override
    public void rendererOptions(@NotNull MutableDataHolder options) {

    }

    @Override
    public void extend(Parser.Builder parserBuilder) {
        parserBuilder.postProcessorFactory(new ImageParagraphRemovingPostProcessor.Factory(parserBuilder));
    }

    @Override
    public void extend(@NotNull HtmlRenderer.Builder htmlRendererBuilder, @NotNull String rendererType) {
        if (htmlRendererBuilder.isRendererType("HTML")) {
            htmlRendererBuilder
                    .nodeRendererFactory(new ImageNodeRenderer.Factory());
        }
    }

}
