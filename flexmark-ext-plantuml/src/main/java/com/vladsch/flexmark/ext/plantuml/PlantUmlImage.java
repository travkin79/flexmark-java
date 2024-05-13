/*
 * This work is made available under the terms of the Eclipse Public License (EPL) Version 1.0.
 * The EPL 1.0 accompanies this distribution.
 * 
 * You may obtain a copy of the License at
 * https://www.eclipse.org/org/documents/epl-v10.html
 * 
 * Copyright © 2022-2024 Advantest Europe GmbH. All rights reserved.
 */
package com.vladsch.flexmark.ext.plantuml;

import com.vladsch.flexmark.ast.Image;

/**
 * Node representing statements like the following
 *
 * <pre>
 *     ![image label](path/to/diagram.puml)
 * </pre>
 *
 */
public class PlantUmlImage extends Image {
    public PlantUmlImage() {}

    public PlantUmlImage(Image image) {
        this.setChars(image.getChars());
        this.setTextOpeningMarker(image.getTextOpeningMarker());
        this.setText(image.getText());
        this.setTextClosingMarker(image.getTextClosingMarker());
        this.setLinkOpeningMarker(image.getLinkOpeningMarker());
        this.setUrlOpeningMarker(image.getUrlOpeningMarker());
        this.setUrl(image.getUrl());
        this.setPageRef(image.getPageRef());
        this.setUrlClosingMarker(image.getUrlClosingMarker());
        this.setUrlContent(image.getUrlContent());
        this.setAnchorMarker(image.getAnchorMarker());
        this.setAnchorRef(image.getAnchorRef());
        this.setLinkClosingMarker(image.getLinkClosingMarker());
        this.setTitleOpeningMarker(image.getTitleOpeningMarker());
        this.setTitle(image.getTitle());
        this.setTitleClosingMarker(image.getTitleClosingMarker());
    }
}
