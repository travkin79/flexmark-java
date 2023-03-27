package com.vladsch.flexmark.ext.heading.anchors.internal;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ext.heading.anchors.HeadingAnchor;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HeadingAnchorNodeRenderer implements NodeRenderer {

    @Override
    public @Nullable Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet<NodeRenderingHandler<?>> set = new HashSet<>();
        set.add(new NodeRenderingHandler<>(HeadingAnchor.class, this::render));
        return set;
    }

    private void render(HeadingAnchor node, NodeRendererContext context, HtmlWriter html) {
        String id = node.getAnchorId().toString();
        html.attr("id", id);
    }

    public static class Factory implements NodeRendererFactory {
        @NotNull
        @Override
        public NodeRenderer apply(@NotNull DataHolder options) {
            return new HeadingAnchorNodeRenderer();
        }
    }

}
