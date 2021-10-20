package maman11;

import java.util.Scanner;

public class Einstein {
    public static void main(String[] args) {

        long difference, reversedDifference;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Einstein magic game");
        System.out.print("Please enter a 3 digit positive number whose first and last digits are different: ");
        long number = scan.nextLong();
        if (number < 100 || number > 999) System.out.println("The number you entered is not a 3 digit positive number");
        else {
            if (number/100 == number%10) System.out.println("The first and last digits are the same!");
            else {
                System.out.println("User number is: " + number);
                difference = Math.abs(number - ((number%10) * 100 + (number/10)%10*10 + number/100));
                System.out.println("Difference: " + difference);
                reversedDifference = difference%10*100 + (difference/10)%10*10 + difference/100;
                System.out.println("Reversed Difference: " + reversedDifference);
                if (difference + reversedDifference == 1089) System.out.println("SUCCEEDED");
            }

        }


    } // end of method main
} // end of class maman11.Einstein
