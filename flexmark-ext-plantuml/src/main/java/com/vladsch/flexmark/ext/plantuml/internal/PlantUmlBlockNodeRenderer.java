package com.vladsch.flexmark.ext.plantuml.internal;

import com.vladsch.flexmark.ext.plantuml.PlantUmlBlockNode;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.data.DataHolder;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class PlantUmlBlockNodeRenderer implements NodeRenderer {

    @Override
    public @Nullable Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet<NodeRenderingHandler<?>> set = new HashSet<>();
        set.add(new NodeRenderingHandler<>(PlantUmlBlockNode.class, this::render));
        return set;
    }

    private void render(PlantUmlBlockNode node, NodeRendererContext context, HtmlWriter htmlWriter) {
        htmlWriter.tagLine("figure").indent();
        String plantUmlToHtmlResult = translatePlantUmlToHtml(node.getChars().toString());
        htmlWriter.append(plantUmlToHtmlResult);
        htmlWriter.unIndent().tagLine("/figure");
    }

    private String translatePlantUmlToHtml(String plantUmlSourceCode) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            SourceStringReader reader = new SourceStringReader(plantUmlSourceCode);
            reader.outputImage(os, new FileFormatOption(FileFormat.SVG));
            return new String(os.toByteArray(), Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return "Could not render HTML from PlantUML source code.";
        }
    }

    public static class Factory implements NodeRendererFactory {
        @NotNull
        @Override
        public NodeRenderer apply(@NotNull DataHolder options) {
            return new PlantUmlBlockNodeRenderer();
        }
    }

}
