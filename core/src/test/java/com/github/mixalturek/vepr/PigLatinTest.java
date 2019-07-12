package com.github.mixalturek.vepr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PigLatinTest {
    private static Stream<Arguments> translateLineProvider() {
        return Stream.of(
                arguments("", ""),
                arguments("Hello", "Ellohay"),

                arguments("apple", "appleway"),
                arguments("apple't", "appletwa'y"),
                arguments("Apple't", "Appletwa'y"),
                arguments("applet'", "appletway'"),
                arguments("Applet'", "Appletway'"),
                arguments("a", "away"),
                arguments("A", "Away"),
                arguments("a'", "away'"),
                arguments("A'", "Away'"),
                arguments("'a", "'away"),
                arguments("'A", "'Away"),
                arguments("appl'e't", "appletw'a'y"),
                arguments("Appl'e't", "Appletw'a'y"),

                arguments("stairway", "stairway"),
                arguments("can't", "antca'y"),
                arguments("Can't", "Antca'y"),
                arguments("'cant", "'antcay"),
                arguments("c'ant", "ant'cay"),
                arguments("'Cant", "'Antcay"),
                arguments("C'ant", "Ant'cay"),
                arguments("ca'n't", "antc'a'y"),
                arguments("Ca'n't", "Antc'a'y"),
                arguments("c'a'n't", "ant'c'a'y"),
                arguments("C'a'n't", "Ant'c'a'y"),

                arguments("end.", "endway."),
                arguments("this-thing", "histay-hingtay"),
                arguments("Beach", "Eachbay"),
                arguments("McCloud", "CcLoudmay"),

                // Multiple hyphens
                arguments("this-thing-multi", "histay-hingtay-ultimay"),

                // Little longer input.
                arguments(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                        "Oremlay ipsumway olorday itsay ametway, onsecteturcay adipiscingway elitway."
                ),


                arguments("w", "way"),
                arguments("x", "xay"),
                arguments("W", "Way"),
                arguments("X", "Xay"),

                // Digits
                arguments("0123456789", "0123456789"),

                // Punctuation
                arguments("Pukak... haf?!", "Ukakpay... afhay?!"),
                arguments("...  ---  ...", "...  ---  ..."),
                arguments(" ", " "),
                arguments("'", "'"),
                arguments("     ", "     "),

                // "Broken" input, multiple line should be multiple calls, only space is the delimiter.
                arguments("multiline\nmultiline", "ultilinemay\nultilinemay"),

                arguments("4$.", "4$."),
                arguments("$4.", "$4."),

                // Corner cases
                arguments("stairwa'y", "tairwaysa'y"),
                arguments(".pivo", ".ivopay"),
                arguments(".p.i.v.o.", ".pay.iway.vay.oway.") // TODO: Hm?
        );
    }

    @ParameterizedTest
    @MethodSource("translateLineProvider")
    void translate(String input, String expected) {
        assertEquals(expected, new PigLatin().translate(input), input);
    }

    @Test
    void translateSpec() {
        assertEquals("appletw'a'y", new PigLatin().translate("appl'e't"), "appl'e't");
    }

    @Test
    void javaLetters() {
        assertTrue(Character.isLetter('a'));
        assertTrue(Character.isLetter('A'));

        assertFalse(Character.isLetter('0'));
        assertFalse(Character.isLetter('\''));
        assertFalse(Character.isLetter('-'));
        assertFalse(Character.isLetter('.'));
    }
}
