package maman11;

import java.util.Scanner;

/*
 * Author: Amit
 * Date: 16/10/2021
 * The Einstein class represents a riddle made by Einstein to get always 1089 from any positive number 100-999
 */
public class Einstein {

    /*
     * This method takes a number between 100 and 999 from the user, flips the last digit and first digit ( ex. 568 => 865 )
     * Afterwards it subtracts it from the actual number, flips the first and last digits again ( ex. 862 => 268 )
     * At the end it adds the last number, and it's reverse ( 693 + 396 ) and calculates 1089
     * The result will say success if it's 1089 and failed if otherwise
     */
    public static void main(String[] args) {

        int MIN_NUMBER = 100, MAX_NUMBER = 999, SPECIAL_NUMBER = 1089;
        int FIRST_DIGIT_DIVIDER = 100, LAST_DIGIT_DIVIDER = 10;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Einstein magic game");
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different: ");
        int number = scan.nextInt();
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            System.out.println("The number you entered is not a 3 digit positive number");
        }
        else {
            if (number/FIRST_DIGIT_DIVIDER == number%LAST_DIGIT_DIVIDER) {
                System.out.println("The first and last digits of the number should be different");
            }
            else {
                System.out.println("User number is: " + number);
                int firstDigit = number / 100; // Takes the first digit
                int secondDigit = number/10%10; // Takes the second digit
                int thirdDigit = number % 10; // Takes the third digit
                int difference = Math.abs(number - (thirdDigit * 100 + secondDigit*10 + firstDigit)); // Multiplies third digit by 100, second digit by 10 and adds the first digit
                System.out.println("Difference: " + difference);
                firstDigit = difference / 100; // Takes the first digit from the difference
                secondDigit = difference/10%10; // Takes the second digit from the difference
                thirdDigit = difference % 10; // Takes the third digit from the difference
                int reversedDifference = thirdDigit*100 + secondDigit*10 + firstDigit; // Reversing the Difference like last time
                System.out.println("Reversed Difference: " + reversedDifference);
                if (difference + SPECIAL_NUMBER == 1089) System.out.println("SUCCEEDED"); // Checks if the result is 1089
                else System.out.println("FAILED");
            }

        }


    } // end of method main
} // end of class Einstein
