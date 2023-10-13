package com.keyin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuggestionEngineTest extends SuggestionEngine {
    @Test
    public void testCorrectWord() throws IOException, URISyntaxException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));

        // Provide a correct word
        String result = suggestionEngine.generateSuggestions("correct");

        // The result should be an empty string because the word is correct.
        Assertions.assertEquals("", result);
    }

    @Test
    public void testWordWithKnownSuggestions() throws IOException, URISyntaxException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));

        // Provide a misspelled word with known suggestions
        String result = suggestionEngine.generateSuggestions("wrod");
    }

    @Test
    public void testWordWithNoSuggestions() throws IOException, URISyntaxException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));

        // Provide a misspelled word with no known suggestions
        String result = suggestionEngine.generateSuggestions("xyzzzz");

        // The result should be an empty string because there are no known suggestions.
        Assertions.assertEquals("", result);
    }
}

