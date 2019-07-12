package com.github.mixalturek.vepr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Unix pipe that translates a text to pig-latin line by line.
 */
public class Vepr {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))) {
            PigLatin pigLatin = new PigLatin();

            String line;
            while ((line = reader.readLine()) != null) {
                String translatedLine = pigLatin.translate(line);
                writer.append(translatedLine);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }
}
