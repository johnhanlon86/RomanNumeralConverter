package com.mycompany.jerseysem3;

public class RomanToNumeral {

    private String romanNumeral = "";
    private  int number = 0;

    private final String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
    private final int[] values = {1, 5, 10, 50, 100, 500, 1000};

    public RomanToNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }
    
    /**
     * A method to convert a roman numeral to a number.
     * @return an int of the converted roman numeral. 
     */
    public int convertRomanToNumber() {

        // Iterate each letter of the RomanNumeral input.
        for (int i = 0; i < romanNumeral.length(); i++) {
            
            int currentLetterValue = 0;
            int nextLetterValue = 0;
            
            char c = romanNumeral.charAt(i);
            String currentLetter = Character.toString(c);

            // If it is not the last letter..
            if (i + 1 < romanNumeral.length()) {
                
                // Get the next letter.
                char d = romanNumeral.charAt(i + 1);
                String nextLetter = Character.toString(d);

                // Get the values of the currentLetter and nextLetter.
                for (int j = 0; j < romanNumerals.length; j++) {

                    if (currentLetter.equalsIgnoreCase(romanNumerals[j])) {
                        currentLetterValue = values[j];
                    }

                    if (nextLetter.equalsIgnoreCase(romanNumerals[j])) {
                        nextLetterValue = values[j];
                    }
                }
                
                if (currentLetterValue < nextLetterValue) {

                    number += nextLetterValue - currentLetterValue;
                    i++;

                } else {

                    number += currentLetterValue;
                }

                // If it is the last letter..
            } else {

                for (int j = 0; j < romanNumerals.length; j++) {

                    if (currentLetter.equalsIgnoreCase(romanNumerals[j])) {

                        number += values[j];
                        i++;
                    }
                }
            }

        }
        return number;
    }

}
