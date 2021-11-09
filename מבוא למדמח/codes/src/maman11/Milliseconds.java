package maman11;

import java.util.Scanner;


/*
 * Author: Amit
 * Date: 16/10/2021
 * Converts miliseconds to a format of days:hours:minutes:seconds
 */
public class Milliseconds {

    /*
     * This method reads an input number which is the Miliseconds
     * The program takes the Miliseconds and converts it to another format of days:hours:minutes:seconds
     * Example: 1000 Miliseconds will print: (0 days 0:0:1)
     */
    public static void main(String[] args) {

        final int MILISECONDS_DIVIDER = 1000;
        final int SEC_MIN_DIVIDER = 60;
        final int HOURS_DIVIDER = 24;

        long days, hours, minutes, seconds;

        Scanner scan = new Scanner(System.in);
        System.out.println ("This program reads an integer which " +
                "represents Milliseconds and converts it to days, " +
                "hours, minutes and seconds. ");
        System.out.print("Please enter number of Miliseconds: ");
        long ms = scan.nextLong();

        seconds = ms/MILISECONDS_DIVIDER; // Converts the miliseconds to seconds ( ex. 1000/1000 = 1 )
        minutes = seconds/SEC_MIN_DIVIDER; // Converts the seconds to minutes ( ex. 1/60 = 0 )
        seconds %= SEC_MIN_DIVIDER; // Takes the remaining seconds after division ( ex. 1500/1000 %= 5 )
        hours = minutes/SEC_MIN_DIVIDER; // Converts hours to minutes
        minutes %= SEC_MIN_DIVIDER; // Takes the remaining minutes after division
        days = hours/HOURS_DIVIDER; // Converts hours to days
        hours %= HOURS_DIVIDER; // Takes the remaining hours after division

        System.out.println(days + " days " + hours + ":" + minutes + ":" + seconds + " hours");

    } // end of method main
} // end of method Miliseconds
