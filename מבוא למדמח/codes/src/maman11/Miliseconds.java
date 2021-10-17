package maman11;

import java.util.Scanner;

public class Miliseconds {
    public static void main(String[] args) {

        long days, hours, minutes, seconds;

        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads integer as miliseconds and will convert it to days, hours, minutes and" +
                "seconds");
        System.out.print("Please enter number of maman11.Miliseconds: ");
        long ms = scan.nextLong();

        seconds = ms/1000;
        minutes = seconds/60;
        seconds %= 60;
        hours = minutes/60;
        minutes %= 60;
        days = hours/24;
        hours %= 24;

        System.out.println(days + " days " + hours + ":" + minutes + ":" + seconds + " hours");

    } // end of method main
} // end of method maman11.Miliseconds
