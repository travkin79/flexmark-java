package com.vladsch.flexmark.ext.plantuml;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlantUmlImageSpecTest {
    final private static DataHolder OPTIONS = new MutableDataSet()
            .set(Parser.EXTENSIONS, Collections.singleton(PlantUmlExtension.create()))
            .toImmutable();

    @Test
    public void test() throws IOException {
        String expected = readFileFromClasspath("/images.html");
        URL resource = this.getClass().getResource("/images.md");
        String mdFileContent = readFileFromClasspath("/images.md");

        Parser parser = Parser.builder(OPTIONS).build();
        HtmlRenderer renderer = HtmlRenderer.builder(OPTIONS).build();
        Document document = parser.parse(mdFileContent);
        document.set(PlantUmlExtension.KEY_DOCUMENT_FILE_PATH, resource.getPath());

        String resultHtml = renderer.render(document);

        assertNotNull(resultHtml);
        assertEquals(expected, resultHtml);
    }

    private String readFileFromClasspath(String filePath) throws IOException {
        String fileContents;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(filePath)))) {
            fileContents = reader.lines().collect(Collectors.joining("\n"));
        }
        return fileContents;
    }
}
