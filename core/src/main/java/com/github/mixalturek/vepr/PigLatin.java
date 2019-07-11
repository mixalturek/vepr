package com.github.mixalturek.vepr;

/**
 * Transformation of input to an artificial language called "pig-latin".
 */
public class PigLatin {
    private static final PigLatin INSTANCE = new PigLatin();

    /**
     * Translate a line to pig-latin. Multiple lines should be split and passed to multiple calls.
     *
     * @param line a word, sentence, or paragraph in a "normal" language
     * @return input transformed to pig-latin
     */
    public static String toPigLatin(String line) {
        return INSTANCE.translate(line);
    }

    private String translate(String line) {
        // TODO: Implementation
        return line;
    }
}
