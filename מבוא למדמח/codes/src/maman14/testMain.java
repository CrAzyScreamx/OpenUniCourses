package maman14;


import org.apache.commons.lang3.time.StopWatch;

import java.time.Duration;
import java.time.Instant;

public class testMain {
    public static void main(String[] args) {
        int[] r = new int[]{1,2,3,4};
        //Start time
        long begin = System.nanoTime();
        //Starting the watch
        on(r);
        //End time
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println();
        System.out.println("Elapsed Time: "+time);

        //Start time
        begin = System.nanoTime();
        //Starting the watch
        on2(r);
        //End time
        end = System.nanoTime();
        time = end-begin;
        System.out.println();
        System.out.println("Elapsed Time: "+time);
    }

    private static void on(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    private static void on2(int[] r) {
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r.length; j++) {
                System.out.println(r[j]);
            }
        }
    }

    public static String humanReadableFormat(Duration duration) {
        return duration.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();
    }
}
