/**
 * Sept 3, 2021
 * Author: Jack Roach
 * Computes the area of a trapazoid using two sets of values.
 */
 
public class AreaChecker {
    public static void main(String[] args) {
 
        double longBase = 10;
        double shortBase = 5;
        double altitude = longBase * shortBase;
        double area = 0.0;
 
        // \n is called scape code and it moves the curser
        // to the next line. So whatever that is printed after
        // that, will be printed on the new/next line.
        System.out.println("Long Base = " + longBase);
        System.out.println("Short Base = " + shortBase);
 
        System.out.println("Altitude = " + altitude);
 
        System.out.println("\nAdjusting Altitude to 9:");
        altitude = 9;
 
        System.out.println("Long Base = " + longBase);
        System.out.println("Short Base = " + shortBase);
        System.out.println("Altitude = " + altitude);
 
        System.out.print("\nArea = ");
        area = (longBase + shortBase) / 2 * altitude;
        System.out.println(area);
 
    }
}