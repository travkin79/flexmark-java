package com.vladsch.flexmark.ext.heading.anchors;

import com.vladsch.flexmark.util.ast.VisitHandler;

public class HeadingAnchorVisitorExt {
    public static <V extends HeadingAnchorVisitor> VisitHandler<?>[] VISIT_HANDLERS(V visitor) {
        return new VisitHandler<?>[] {
                new VisitHandler<>(HeadingAnchor.class, visitor::visit),
        };
    }
}
