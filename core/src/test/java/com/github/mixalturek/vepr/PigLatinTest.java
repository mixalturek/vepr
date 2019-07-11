package com.github.mixalturek.vepr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PigLatinTest {
    private static Stream<Arguments> simpleWordsProvider() {
        return Stream.of(
                arguments("", ""),
                arguments("Hello", "Ellohay"),
                arguments("apple", "appleway"),
                arguments("stairway", "stairway"),
                arguments("can't", "antca'y"),
                arguments("end.", "endway."),
                arguments("this-thing", "histay-hingtay"),
                arguments("Beach", "Eachbay"),
                arguments("McCloud", "CcLoudmay"),

                arguments(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                        "Oremlay ipsumway olorday itsay ametway, onsecteturcay adipiscingway elitway."
                ),

                arguments("Pukak... haf?!", "Ukakpay... afhay?!"),
                arguments("...  ---  ...", "...  ---  ..."),
                arguments(" ", " "),
                arguments("     ", "     "),

                // "Broken" input, multiple line should be multiple calls, only space is the delimiter.
                arguments("multiline\nmultiline", "ultiline\nmultilinemay")
        );
    }

    @ParameterizedTest
    @MethodSource("simpleWordsProvider")
    void toPigLatin(String input, String expected) {
        assertEquals(expected, PigLatin.toPigLatin(input));
    }

    @Test
    void nullInput() {
        assertThrows(NullPointerException.class, () -> PigLatin.toPigLatin(null));
    }
}
