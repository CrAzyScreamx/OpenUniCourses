package maman13.testers;
/**  kilroy
 *               _____   here
 *         was  /     \    
 *     ____    /(.) (.)\    ____
 * ---/    \------| |------/    \---
 *    |/\/\/      | |      |/\/\/
 *                \_/  
 *   created by B.A.
 */

import maman13.Square3x3;

import java.util.Scanner;

public class Square3x3Tester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner (System.in);
        
        int [][] arrTest3x3 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int [][] arrTest2x2 = new int[][] {{1,2},{3,4}};
        int [][] arrTest4x4 = new int[][] {{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        int [][] arrTest3x2 = new int[][] {{1,2,3},{4,5,6}};
        int [][] arrTest2x3 = new int[][] {{1,2},{3,4},{5,6}};
        int [][] arrTest4x2 = new int[][] {{1,2,3,4},{4,5,6,8}};
        int [][] arrTest1x4 = new int[][] {{1},{2},{3},{4}};
        
        
        System.out.println("Square3x3 tester");
        System.out.println("----------------\n");
        
        System.out.println("Constructurs test");
        System.out.println("----------------");
        
        System.out.println("First constructur test");
        System.out.println("----------------------");
        Square3x3 square1 = new Square3x3();
        System.out.println("your square3x3:\n" + square1);
        System.out.println("currect square3x3:\n" +
                            "-1\t-1\t-1\n" +
                            "-1\t-1\t-1\n" +
                            "-1\t-1\t-1\n");
        
        System.out.println("Secound constructur test #1: arr3x3");
        System.out.println("-----------------------------------");
        Square3x3 square2 = new Square3x3(arrTest3x3);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t3\n" +
                            "4\t5\t6\n" +
                            "7\t8\t9\n");
        
        System.out.println("Secound constructur test #2: arr4x4");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest4x4);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t3\n" +
                            "4\t5\t6\n" +
                            "7\t8\t9\n");
        
        System.out.println("Secound constructur test #3: arr2x2");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest2x2);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t-1\n" +
                            "3\t4\t-1\n" +
                            "-1\t-1\t-1\n");
        
        System.out.println("Secound constructur test #4: arr3x2");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest3x2);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t3\n" +
                            "4\t5\t6\n" +
                            "-1\t-1\t-1\n");
                            
        System.out.println("Secound constructur test #5: arr2x3");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest2x3);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t-1\n" +
                            "3\t4\t-1\n" +
                            "5\t6\t-1\n");                    
                            
        System.out.println("Secound constructur test #6: arr4x2");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest4x2);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t3\n" +
                            "4\t5\t6\n" +
                            "-1\t-1\t-1\n");
                            
        System.out.println("Secound constructur test #7: arr1x4");
        System.out.println("-----------------------------------");
        square2 = new Square3x3(arrTest1x4);
        System.out.println("your square3x3:\n" + square2);
        System.out.println("currect square3x3:\n" +
                            "1\t-1\t-1\n" +
                            "2\t-1\t-1\n" +
                            "3\t-1\t-1\n");
        square2 = new Square3x3(arrTest3x3);
        
        System.out.println("Third constructur test - copy constructur");
        System.out.println("-----------------------------------------");
        Square3x3 square3 = new Square3x3(square2);
        System.out.println("your square3x3:\n" + square3);
        System.out.println("currect square3x3:\n" +
                            "1\t2\t3\n" +
                            "4\t5\t6\n" +
                            "7\t8\t9\n\n");
    
                            
        //*******************************************************************
        System.out.println("Methods test");
        System.out.println("------------\n");
        
        //*************************************
        System.out.println("getCell Methods");
        System.out.println("---------------");
        
        System.out.println("All cells");
        System.out.println("---------");
        System.out.println("your print:");
        for (int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                System.out.print(square3.getCell(i,j) + " ");
        System.out.println("\ncurrect print:\n1 2 3 4 5 6 7 8 9\n");
        
        System.out.println("outband row\\col");
        System.out.println("---------------");
        System.out.println("your print:");
        System.out.println(square3.getCell(-1,1) + " " + square3.getCell(3,1) + " " +
                           square3.getCell(1,-1) + " " + square3.getCell(1,3) + " " +
                           square3.getCell(-1,-1) + " " + square3.getCell(-1,3) + " " +
                           square3.getCell(3,-1) + " " + square3.getCell(3,3) );
        System.out.println("currect print:\n-1 -1 -1 -1 -1 -1 -1 -1\n\n");
        
        
        //*************************************
        System.out.println("setXY Method");
        System.out.println("------------");
        square1.setXY(0, 0, 1);
        square1.setXY(1, 1, 2);
        square1.setXY(2, 2, 3);
        square1.setXY(0, 2, 4);
        square1.setXY(2, 0, 5);
        square1.setXY(0, 1, 6);
        square1.setXY(1, 2, 7);
        square1.setXY(1, 0, -3);
        square1.setXY(2, 1, 10);
        square1.setXY(-1, 3, 1);
        square1.setXY(3, -1, 2);
        square1.setXY(-1, 1, 3);
        square1.setXY(3, 1, 4);
        square1.setXY(0, -1, 5);
        square1.setXY(0, 3, 6);
        
        System.out.println("your square3x3:\n" + square1);
        System.out.println("currect square3x3:\n" +
                            "1\t6\t4\n" +
                            "-1\t2\t7\n" +
                            "5\t-1\t3\n\n");
        
                            
        //*************************************
        System.out.println("allThere Method");
        System.out.println("---------------");
        System.out.println("square1: " + square1.allThere());
        System.out.println("currect: false");
        System.out.println("square3: " + square3.allThere());
        System.out.println("currect: true\n\n");
        
        
        //*************************************
        System.out.println("whosThereRow Method");
        System.out.println("-------------------");
        boolean[] digits = new boolean[10];
        
        for(int i=0; i<3; i++)
        {
            square3.whosThereRow(i, digits);
            System.out.print("row no." + i + " : ");
            for(int j=1; j<10; j++)
                if(digits[j])
                    System.out.print(j + " ");
            System.out.print("\n");
            digits = new boolean[10];
        }
        System.out.println("\ncurrect:\nrow no.0 : 1 2 3\nrow no.1 : 4 5 6\nrow no.2 : 7 8 9\n\n");

        
        //*************************************
        System.out.println("whosThereCol Method");
        System.out.println("-------------------");
        
        for(int i=0; i<3; i++)
        {
            square3.whosThereCol(i, digits);
            System.out.print("col no." + i + " : ");
            for(int j=1; j<10; j++)
                if(digits[j])
                    System.out.print(j + " ");
            System.out.print("\n");
            digits = new boolean[10];
        }
        System.out.println("\ncurrect:\ncol no.0 : 1 4 7\ncol no.1 : 2 5 8\ncol no.2 : 3 6 9");
    }  
}//End of class