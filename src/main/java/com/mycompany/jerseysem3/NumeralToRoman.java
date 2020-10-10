package com.mycompany.jerseysem3;

public class NumeralToRoman {

    private int inputNumber;
    private int remainder = -1;
    private String romanNumeral = "";

    // A string array to represent each of the RomanNumerals. 
    // Note: I have included "CM" as the inputNumber 1999 was not outputting correctly.
    private final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // An int array to represent the value of each RomanNumeral.
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /*
     * An int array to represents the amount of each letter needed to display the correct RomanNumeral equivalent. 
     * For example: 
     * (At startup): M = 0, CM = 0, D = 0 and so on..
     * (After processing:) M = 1, CM = 2, D = 0 and so on..
     */
    private int[] letterAmounts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public NumeralToRoman(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String convertNumeralToRoman() {

        // A loop to calculate how many of each RomanNumeral symbol make up a inputNumber.
        // Once the remainder is not 0 keep iterating.
        for (int i = 0; remainder != 0; i++) {

            // Divide the the inputNumber input by each value starting at 1000. 
            letterAmounts[i] = inputNumber / values[i];

            // Calculate the remainder left over.. 
            remainder = inputNumber - (letterAmounts[i] * values[i]);

            // The inputNumber for the next iteration must = remainder.
            inputNumber = remainder;
        }

        // A loop to add the amount of each RomanNumeral symbol to the 'romanNumeral' string 
        // Iterate the 'letterAmounts' array..
        for (int j = 0; j < letterAmounts.length; j++) {

            // For each letter amount add the amount of that letter to the romanNumeral
            // string.
            for (int k = 0; k < letterAmounts[j]; k++) {
                romanNumeral += romanNumerals[j];
            }
        }
        return romanNumeral;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}
