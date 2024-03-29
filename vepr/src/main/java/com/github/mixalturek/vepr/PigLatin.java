package com.github.mixalturek.vepr;

import java.util.Set;

/**
 * Transformation of input in English to an artificial language called "pig-latin".
 */
// TODO: There is a lot of space for performance optimizations in this class.
public class PigLatin {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    /**
     * Translate a text in English to pig-latin.
     *
     * @param text a word, sentence, paragraph or just any text in a "normal" language
     * @return input transformed to pig-latin
     */
    public String translate(String text) {
        // Variant with String.split(newline | space | ...) is not suitable here, it consumes characters.

        State state = State.WORD_START;

        // This algorithm is also suitable for input to output stream processing, there is no need to has the whole `text` in memory
        StringBuilder output = new StringBuilder(text.length() * 2);

        // Possible optimization using Rust-like string slices, there is no need to copy it outside in general.
        StringBuilder word = new StringBuilder(50);

        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);

            switch (state) {
                case WORD_START:
                    if (Character.isLetter(c)) {
                        word.append(c);
                        state = State.INSIDE_WORD;
                    } else {
                        // Including "' at the beginning of the word" case
                        output.append(c); // Just copy it to the output
                    }
                    break;

                case INSIDE_WORD:
                    if (Character.isLetter(c) || c == '\'') {
                        word.append(c);
                    } else {
                        output.append(translateWord(word.toString()));
                        // Hm, no builder.clear() method to reset it?
                        word = new StringBuilder(50);
                        output.append(c);
                        state = State.WORD_START;
                    }
                    break;
            }
        }

        // Handle the rest
        if (word.length() > 0) {
            output.append(translateWord(word.toString()));
        }

        return output.toString();
    }

    /**
     * Translate single word.
     *
     * @param word non empty string that doesn't contain any punctuation on borders
     * @return word in pig-latin
     */
    private String translateWord(String word) {
        // It should be probably possible to do the whole transformation in place in char[], but I have already this implementation.
        if (word.endsWith("way")) {
            return word;
        } else if (VOWELS.contains(word.charAt(0))) {
            return translateVowelWord(word);
        } else {
            return translateConsonantWord(word);
        }
    }

    private String translateVowelWord(String word) {
        StringBuilder builder = new StringBuilder(word.length() + 3);
        builder.append(word);
        builder.append("way");
        movePunctuation(builder, 3); // way
        // No need to update the case of the characters, it just can't happen here
        return builder.toString();
    }

    private String translateConsonantWord(String word) {
        StringBuilder builder = new StringBuilder(word.length() + 2);
        builder.append(word.substring(1));
        builder.append(word.charAt(0));
        builder.append("ay");
        movePunctuation(builder, 3); // ay + first char
        syncCase(builder, word);
        return builder.toString();
    }

    @SuppressWarnings("SameParameterValue")
    private void movePunctuation(StringBuilder builder, int offset) {
        for (int i = builder.length() - offset; i >= 0; --i) {
            if (builder.charAt(i) == '\'') {
                builder.deleteCharAt(i);
                builder.insert(i + offset, '\'');
            }
        }
    }

    private void syncCase(StringBuilder builder, String word) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = builder.charAt(i);
            char updated = Character.isUpperCase(word.charAt(i)) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
            builder.setCharAt(i, updated);
        }
    }

    /**
     * State of FSM for parsing.
     */
    private enum State {
        WORD_START,
        INSIDE_WORD,
    }
}
