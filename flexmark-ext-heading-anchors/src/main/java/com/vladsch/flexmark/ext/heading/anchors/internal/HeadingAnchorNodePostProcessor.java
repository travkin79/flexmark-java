package com.vladsch.flexmark.ext.heading.anchors.internal;

import com.vladsch.flexmark.ext.heading.anchors.HeadingAnchor;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.parser.block.NodePostProcessor;
import com.vladsch.flexmark.parser.block.NodePostProcessorFactory;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeTracker;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeadingAnchorNodePostProcessor extends NodePostProcessor {

    // regex pattern for headings like
    // ### Heading Title {#some-anchor-definition}
    private static final Pattern pattern = Pattern.compile(".+?\\s+\\{#[a-zA_Z0-9-_]+\\}");

    @Override
    public void process(@NotNull NodeTracker state, @NotNull Node node) {
        if (node instanceof Heading) {
            Heading heading = (Heading) node;

            if (heading.getText().isNull()) {
                return;
            }

            BasedSequence headingText = heading.getText();

            if (headingText.endsWith("}")) {
                Matcher headingAnchorMatcher = pattern.matcher(headingText);
                if (headingAnchorMatcher.matches()) {
                    HeadingAnchor anchorNode = new HeadingAnchor();

                    // take the anchor declaration chars to the HeadingAnchor node
                    int startIndex = headingText.lastIndexOf("{#");
                    int endIndex = headingText.lastIndexOf("}");
                    anchorNode.setChars(headingText.subSequence(startIndex, endIndex + 1));

                    // remove the anchor chars from the heading title
                    Text headingTextNode = (Text) heading.getChildOfType(Text.class);
                    int index = headingTextNode.getChars().lastIndexOf(anchorNode.getChars());
                    headingTextNode.setChars(headingTextNode.getChars().subSequence(0, index).trim());

                    heading.appendChild(anchorNode);
                }
            }
        }
    }

    public static class Factory extends NodePostProcessorFactory {
        public Factory(DataHolder options) {
            super(false);
            addNodes(Heading.class);
        }

        @NotNull
        @Override
        public NodePostProcessor apply(@NotNull Document document) {
            return new HeadingAnchorNodePostProcessor();
        }
    }

}
