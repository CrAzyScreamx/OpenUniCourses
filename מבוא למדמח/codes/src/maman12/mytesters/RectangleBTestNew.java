package maman12.mytesters; /**  kilroy
 *               _____   here
 *         was  /     \    
 *     ____    /(.) (.)\    ____
 * ---/    \------| |------/    \---
 *    |/\/\/      | |      |/\/\/
 *                \_/  
 *   created by B.A.
 *   version: v1.2
 */

import maman12.Point;
import maman12.RectangleB;

import java.util.Scanner;
public class RectangleBTestNew
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int answer2;
        double answer3;
        
        Point p1 = new Point(3, 2);
        Point sw;
        Point ne;
        Point tempP;
        
        String answer = "", answer4 = "";
        
        //********************************************************************
        System.out.println("Constructur Test");
        System.out.println("----------------");
        
        System.out.println("first constructur check");
        System.out.println("-----------------------");
        
        RectangleB rec1 = new RectangleB(0, 0);
        System.out.print("Invalid width and height:......");
        answer = rec1.toString();
        if (answer.equals("Width=1 Height=1 PointSW=(0,0)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec1 + " Should be: Width=1 Height=1 PointSW=(0,0)");
        
        rec1 = new RectangleB(2, 0);
        System.out.print("Invalid height:................");
        answer = rec1.toString();
        if (answer.equals("Width=2 Height=1 PointSW=(0,0)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec1 + "Should be: Width=2 Height=1 PointSW=(0,0)");
        
        rec1 = new RectangleB(0, 2);
        System.out.print("Invalid width:.................");
        answer = rec1.toString();
        if (answer.equals("Width=1 Height=2 PointSW=(0,0)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec1 + "Should be: Width=1 Height=2 PointSW=(0,0)");
        
        
        rec1 = new RectangleB(2, 2);
        System.out.print("Valid width and height:........");
        answer = rec1.toString();
        if (answer.equals("Width=2 Height=2 PointSW=(0,0)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec1 + "Should be: Width=2 Height=2 PointSW=(0,0)");
        
        
        //********************************************************************
        System.out.println("\nsecound constructur check");
        System.out.println("-------------------------");
        
        RectangleB rec2 = new RectangleB(p1, 0, 0);
        System.out.print("Invalid width and height:......");
        answer = rec2.toString();
        if (answer.equals("Width=1 Height=1 PointSW=(3,2)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec2 + "Expected: Width=1 Height=1 PointSW=(3,2)");
                
        rec2 = new RectangleB(p1, 2, 0);
        System.out.print("Invalid height:................");
        answer = rec2.toString();
        if (answer.equals("Width=2 Height=1 PointSW=(3,2)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec2 + "Expected: Width=2 Height=1 PointSW=(3,2)");
        
        rec2 = new RectangleB(p1, 0, 2);
        System.out.print("Invalid width:.................");
        answer = rec2.toString();
        if (answer.equals("Width=1 Height=2 PointSW=(3,2)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec2 + "Expected: Width=1 Height=2 PointSW=(3,2)");
                
        rec2 = new RectangleB(p1, 2, 2);
        System.out.print("Valid width and height:........");
        answer = rec2.toString();
        if (answer.equals("Width=2 Height=2 PointSW=(3,2)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec2 + "Expected: Width=2 Height=2 PointSW=(3,2)");
                
        
        //*********************************************************************
        System.out.print("third constructur check:.......");
        
        sw = new Point(1, 3);
        ne = new Point(3, 7);
        
        RectangleB rec3 = new RectangleB(sw, ne);
        answer = rec3.toString();
        if (answer.equals("Width=2 Height=4 PointSW=(1,3)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec3 + "Expected: Width=2 Height=4 PointSW=(1,3)");
                
        
        //*********************************************************************
        System.out.print("fourth constructur check:......");
        
        RectangleB rec4 = new RectangleB(rec3);
        answer = rec4.toString();
        if (answer.equals("Width=2 Height=4 PointSW=(1,3)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + rec4 + "Expected: Width=2 Height=4 PointSW=(1,3)");
                
        
        //*********************************************************************
        System.out.println("\n\nMethods Test");
        System.out.println("------------");
        
    
        System.out.print("getWidth:......");
        answer2 = rec1.getWidth();
        if (answer2==2)
            System.out.println("OK");
        else
            System.out.println("Error - your width: " + rec1.getWidth() + "Expected: 2");
        
        System.out.print("getHeight:.....");
        answer2 = rec1.getHeight();
        if (answer2==2)
            System.out.println("OK");
        else
            System.out.println("Error - your Height: " + rec1.getHeight() + "Expected: 2");
 
        System.out.println("\nsetWidth");
        System.out.println("--------");
        System.out.print("Invalid value:.....");
        rec1.setWidth(0);
        answer2 = rec1.getWidth();
        if (answer2==2)
            System.out.println("OK");
        else
            System.out.println("Error - your width: " + rec1.getWidth() + "Expected: 2");
        
        System.out.print("Valid value:.......");
        rec1.setWidth(3);
        answer2 = rec1.getWidth();
        if (answer2==3)
            System.out.println("OK");
        else
            System.out.println("Error - your width: " + rec1.getWidth() + "Expected: 3\n");
        
            
        //***********************************************************    
        System.out.println("\nsetHeight");
        System.out.println("--------");
        
        System.out.print("Invalid value:.....");
        rec1.setHeight(0);
        answer2 = rec1.getHeight();
        if (answer2==2)
            System.out.println("OK");
        else
            System.out.println("Error - your Height: " + rec1.getHeight() + " Expected: 2");
        
        System.out.print("Valid value:.......");
        rec1.setHeight(3);
        answer2 = rec1.getHeight();
        if (answer2==3)
            System.out.println("OK");
        else
            System.out.println("Error - your Height: " + rec1.getHeight() + " Expected: 3\n");
          
            
            
        //************************************************************
        System.out.print("\ngetPointSW & setPointSW:.....");
        tempP = new Point(3, 7);
        rec1.setPointSW(tempP);
        answer = rec1.getPointSW().toString();
        answer4 = rec1.getPointNE().toString();
        if (answer.equals("(3,7)") && answer4.equals("(6,10)"))
            System.out.println("OK");
        else
            System.out.println("Error - your pointSW & pointNE: " + rec1.getPointSW() + " " + rec1.getPointNE() + " Expected: (3,7) (6,10)\n");
        
        //***********************************************************
            
        //initial rec1
        sw = new Point(3,2);
        rec1 = new RectangleB(sw, 3, 4);
        
        //***********************************************************
        System.out.print("\ngetPointNE:.........");
        answer = rec1.getPointNE().toString();
        if (answer.equals("(6,6)"))
            System.out.println("OK\n");
        else
            System.out.println("Error - your pointNE: " + rec1.getPointNE() + " Expected: (6,6)\n");

        
        //***********************************************************
        System.out.print("getPerimeter:.......");
        
        answer2 = rec1.getPerimeter();
        if (answer2==14)
            System.out.println("OK\n");
        else
            System.out.println("Error - your Perimeter: " + rec1.getPerimeter() + " Expected: 14\n");
        
                
        //***********************************************************
        System.out.print("getArea:............");
        answer2 = rec1.getArea();
        if (answer2==12)
            System.out.println("OK\n");
        else
            System.out.println("Error - your Area: " + rec1.getArea() + " Expected: 12\n");
        
        
        //***********************************************************
        System.out.print("move (+3, +4):......");
        rec1.move(3, 4);
        answer = rec1.getPointSW().toString();
        answer4 = rec1.getPointNE().toString();
        if (answer.equals("(6,6)") && answer4.equals("(9,10)"))
            System.out.println("OK\n");
        else
            System.out.println("Error - your pointSW & pointNE: " + rec1.getPointSW() + " " + rec1.getPointNE() + " Expected: (6,6) (9,10)\n");
        
        
        //***********************************************************
        System.out.print("getDiagonalLength:.");
        answer3 = rec1.getDiagonalLength();
        if (answer3==5.0)
            System.out.println("OK");
        else
            System.out.println("Error - your Diagona lLength: " + rec1.getDiagonalLength() + " Expected: 5.0");
        
        
        //***************************************************
        System.out.print("\nchangeSides:........");
        rec1.changeSides();
        answer = rec1.toString();
        if (answer.equals("Width=4 Height=3 PointSW=(6,6)"))
            System.out.println("OK\n");
        else
            System.out.println("Error - your pointSW: " + rec1 + " Expected: Width=4 Height=3 PointSW=(6,6)\n");
            
        //***********************************************************
        
        //initial rec2
        sw = new Point(4, 3);
        ne = new Point(6, 5);
        rec2 = new RectangleB(sw, ne);
        
        //***********************************************************
        
        System.out.println("\nequals");
        System.out.println("------");
        System.out.print("Good equals:.....");
        if (rec3.equals(rec4))
            System.out.println("OK");
        else
            System.out.println("Error - your equals: " + rec3.equals(rec4) + " Expected: true");
        
        System.out.print("Bad equals:......");
        if (!rec1.equals(rec2))
            System.out.println("OK\n");
        else
            System.out.println("Error - your equals: " + rec1.equals(rec2) + " Expected: false\n");
            
       
        
        
        //***********************************************************
                
        System.out.println("isLarger");
        System.out.println("--------");
        
        System.out.print("Good isLarger:.....");
        if (rec1.isLarger(rec2))
            System.out.print("OK\n");
        else
            System.out.print("Error - your isLarger: " + rec1.isLarger(rec2) + " Expected: true\n");
        
        System.out.print("Bad isLarger:......");
        if (!rec3.isLarger(rec4))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec3.isLarger(rec4) + " Expected: false\n");
        

        //***************************************************
        //rec to compare
        sw = new Point(4, 4);
        ne = new Point(7, 8);
        RectangleB origin = new RectangleB(sw, ne);
        
        //common vertex 
        sw = new Point(2, 8);
        ne = new Point(4, 9);
        rec1 = new RectangleB(sw, ne);
        
        sw = new Point(7, 8);
        ne = new Point(9, 9);
        rec2 = new RectangleB(sw, ne);
        
        sw = new Point(7, 3);
        ne = new Point(9, 4);
        rec3 = new RectangleB(sw, ne);
        
        sw = new Point(2, 3);
        ne = new Point(4, 4);
        rec4 = new RectangleB(sw, ne);
        
        
        System.out.println("Common vertexs rectangle");
        System.out.println("------------------------");
               
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (!rec1.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: false");
        System.out.print("rec2:......");
        if (!rec2.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.isIn(origin) + " Expected: false");
        System.out.print("rec3:......");
        if (!rec3.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.isIn(origin) + " Expected: false");
        System.out.print("rec4:......");
        if (!rec4.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.isIn(origin) + " Expected: false\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (rec1.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: true");
        System.out.print("rec2:......");
        if (rec2.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.overlap(origin) + " Expected: true");
        System.out.print("rec3:......");
        if (rec3.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.overlap(origin) + " Expected: true");
        System.out.print("rec4:......");
        if (rec4.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.overlap(origin) + " Expected: true\n");    
            
            
            
        //common sides
        sw = new Point(4, 8);
        ne = new Point(6, 11);
        rec1 = new RectangleB(sw, ne);
        
        sw = new Point(7, 7);
        ne = new Point(10, 9);
        rec2 = new RectangleB(sw, ne);
        
        sw = new Point(5, 2);
        ne = new Point(6, 4);
        rec3 = new RectangleB(sw, ne);
        
        sw = new Point(2, 4);
        ne = new Point(4, 8);
        rec4 = new RectangleB(sw, ne);
        
        
        System.out.println("Common sides rectangle");
        System.out.println("------------------------");
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (!rec1.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: false");
        System.out.print("rec2:......");
        if (!rec2.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.isIn(origin) + " Expected: false");
        System.out.print("rec3:......");
        if (!rec3.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.isIn(origin) + " Expected: false");
        System.out.print("rec4:......");
        if (!rec4.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.isIn(origin) + " Expected: false\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (rec1.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: true");
        System.out.print("rec2:......");
        if (rec2.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.overlap(origin) + " Expected: true");
        System.out.print("rec3:......");
        if (rec3.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.overlap(origin) + " Expected: true");
        System.out.print("rec4:......");
        if (rec4.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.overlap(origin) + " Expected: true\n");   
        
        
        //Half inside
        sw = new Point(3, 7);
        ne = new Point(5, 10);
        rec1 = new RectangleB(sw, ne);
        
        sw = new Point(6, 5);
        ne = new Point(9, 7);
        rec2 = new RectangleB(sw, ne);
        
        sw = new Point(4, 3);
        ne = new Point(7, 5);
        rec3 = new RectangleB(sw, ne);
        
        sw = new Point(6, 3);
        ne = new Point(8, 9);
        rec4 = new RectangleB(sw, ne);
        
        System.out.println("half inside rectangle");
        System.out.println("------------------------");
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (!rec1.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: false");
        System.out.print("rec2:......");
        if (!rec2.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.isIn(origin) + " Expected: false");
        System.out.print("rec3:......");
        if (!rec3.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.isIn(origin) + " Expected: false");
        System.out.print("rec4:......");
        if (!rec4.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.isIn(origin) + " Expected: false\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (rec1.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: true");
        System.out.print("rec2:......");
        if (rec2.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.overlap(origin) + " Expected: true");
        System.out.print("rec3:......");
        if (rec3.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.overlap(origin) + " Expected: true");
        System.out.print("rec4:......");
        if (rec4.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.overlap(origin) + " Expected: true\n");   
        
        
        //full inside
        sw = new Point(4, 7);
        ne = new Point(5, 8);
        rec1 = new RectangleB(sw, ne);
        
        sw = new Point(5, 5);
        ne = new Point(6, 7);
        rec2 = new RectangleB(sw, ne);
        
        sw = new Point(6, 4);
        ne = new Point(7, 5);
        rec3 = new RectangleB(sw, ne);
        
        sw = new Point(4, 4);
        ne = new Point(7, 8);
        rec4 = new RectangleB(sw, ne);
        
        
        System.out.println("Full inside rectangle");
        System.out.println("---------------------");
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (rec1.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: true");
        System.out.print("rec2:......");
        if (rec2.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.isIn(origin) + " Expected: true");
        System.out.print("rec3:......");
        if (rec3.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.isIn(origin) + " Expected: true");
        System.out.print("rec4:......");
        if (rec4.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.isIn(origin) + " Expected: true\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (rec1.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: true");
        System.out.print("rec2:......");
        if (rec2.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.overlap(origin) + " Expected: true");
        System.out.print("rec3:......");
        if (rec3.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.overlap(origin) + " Expected: true");
        System.out.print("rec4:......");
        if (rec4.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.overlap(origin) + " Expected: true\n");   
                
         
        //uncommon
        sw = new Point(1, 9);
        ne = new Point(3, 11);
        rec1 = new RectangleB(sw, ne);
        
        sw = new Point(8, 8);
        ne = new Point(10, 10);
        rec2 = new RectangleB(sw, ne);
        
        sw = new Point(8, 1);
        ne = new Point(10, 3);
        rec3 = new RectangleB(sw, ne);
        
        sw = new Point(0, 0);
        ne = new Point(2, 2);
        rec4 = new RectangleB(sw, ne);
        
        
        System.out.println("Uncommon");
        System.out.println("--------");
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (!rec1.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: false");
        System.out.print("rec2:......");
        if (!rec2.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.isIn(origin) + " Expected: false");
        System.out.print("rec3:......");
        if (!rec3.isIn(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.isIn(origin) + " Expected: false");
        System.out.print("rec4:......");
        if (!rec4.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.isIn(origin) + " Expected: false\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (!rec1.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: false");
        System.out.print("rec2:......");
        if (!rec2.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec2.overlap(origin) + " Expected: false");
        System.out.print("rec3:......");
        if (!rec3.overlap(origin))
            System.out.println("OK");
        else
            System.out.println("Error - your isLarger: " + rec3.overlap(origin) + " Expected: false");
        System.out.print("rec4:......");
        if (!rec4.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec4.overlap(origin) + " Expected: false\n"); 
        
            
        //overlap
        sw = new Point(3, 3);
        ne = new Point(8, 9);
        rec1 = new RectangleB(sw, ne);
        
        System.out.println("Larger rectangle");
        System.out.println("----------------");
        System.out.println("isIn");
        System.out.println("----");
        System.out.print("rec1:......");
        if (!rec1.isIn(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec1.isIn(origin) + " Expected: false\n");
        
        System.out.println("overleap");
        System.out.println("--------");
        System.out.print("rec1:......");
        if (rec1.overlap(origin))
            System.out.println("OK\n");
        else
            System.out.println("Error - your isLarger: " + rec1.overlap(origin) + " Expected: true\n");
        
        
        
        System.out.println("Aliasing Check");
        System.out.println("--------------");
        System.out.print("Secound constructur:......");
        tempP = new Point(3, 7);
        rec2 = new RectangleB(tempP, 3, 2);
        tempP.setX(1);
        answer = rec2.getPointSW().toString();
        if (answer.equals("(1,7)"))
            System.out.println("Aliasing Error");
        else
            System.out.println("OK");
        
        System.out.print("Third constructur:........");
        tempP = new Point(3, 7);
        p1 = new Point (5, 10);
        rec3 = new RectangleB(tempP, p1);
        tempP.setX(1);
        p1.setX(6);
        answer = rec3.getPointSW().toString();
        answer4 = rec3.getPointNE().toString();
        if (answer.equals("(1,7)") || answer4.equals("(6,10)"))
            System.out.println("Aliasing Error");
        else
            System.out.println("OK");
                
        
        System.out.print("setPointSW:...............");
        tempP = new Point(3, 7);
        rec1.setPointSW(tempP);
        tempP.setX(1);
        answer = rec1.getPointSW().toString();
        if (answer.equals("(1,7)"))
            System.out.println("Aliasing Error");
        else
            System.out.println("OK");

        Point ptest = new Point(5, -3);
        RectangleB rTest = new RectangleB(ptest, 0, 0);
        System.out.println(rTest.getPointNE());
    }
}
