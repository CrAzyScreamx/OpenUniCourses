package maman11;

import java.util.Scanner;

public class Einstein {
    public static void main(String[] args) {

        int MIN_NUMBER = 100, MAX_NUMBER = 999;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Einstein magic game");
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different: ");
        long number = scan.nextLong();
        if (number < MIN_NUMBER || number > MAX_NUMBER) System.out.println("The number you entered is not a 3 digit positive number");
        else {
            if (number/100 == number%10) System.out.println("The first and last digits of the number should be different");
            else {
                System.out.println("User number is: " + number);
                long firstDigit = number / 100;
                long secondDigit = number/10%10;
                long thirdDigit = number % 10;
                long difference = Math.abs(number - (thirdDigit * 100 + secondDigit*10 + firstDigit));
                System.out.println("Difference: " + difference);
                firstDigit = difference / 100;
                secondDigit = difference/10%10;
                thirdDigit = difference % 10;
                long reversedDifference = thirdDigit*100 + secondDigit*10 + firstDigit;
                System.out.println("Reversed Difference: " + reversedDifference);
                if (difference + reversedDifference == 1089) System.out.println("SUCCEEDED");
                else System.out.println("FAILED");
            }

        }


    } // end of method main
} // end of class maman11.Einstein
