package com.nicolaetopalautomationacademy.wordcount;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class WordCount {
    public static void main(String[] args) throws Exception {
        String text = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";

//            String text = "No repeat text.";

        Map<String, Integer> wordCount = new HashMap<>();

        String[] sentences = text.split("\\.");

        sentences[0] = "";

        for (String sentence : sentences) {
            // Split each sentence into words
            String[] words = sentence.split("\\s+");

            for (String word : words) {
                // Remove punctuation marks
                word = word.replaceAll("[,;'\\-]", "");

                // Ignore empty strings
                if (!word.isEmpty()) {
                    // Count the word
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        boolean noRepeatedWords = true;
        // Print duplicate words and their counts
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Word: " + entry.getKey() + "\nCount: " + entry.getValue());
                noRepeatedWords = false;
            }
        }

        try {
            if (noRepeatedWords) {
                throw new Exception("No words repeat.");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

