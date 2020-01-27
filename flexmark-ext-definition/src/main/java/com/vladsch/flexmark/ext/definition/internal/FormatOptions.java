package com.vladsch.flexmark.ext.definition.internal;

import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.options.DefinitionMarker;

public class FormatOptions {

    final public int markerSpaces;
    final public DefinitionMarker markerType;

    public FormatOptions(DataHolder options) {
        markerSpaces = DefinitionExtension.FORMAT_MARKER_SPACES.get(options);
        markerType = DefinitionExtension.FORMAT_MARKER_TYPE.get(options);
    }
}
