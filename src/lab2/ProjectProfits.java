package lab2;

/**
 * Sept 3, 2021
 * Author: Jack Roach
 * Computes average profit based on predicted income.
 */
public class ProjectProfits {
    public static void main(String[] args) {

        int predicted1 = 2000000;
        int predicted2 = 2500000;
        int predicted3 = 3000000;
        int predicted4 = 4000000;

        // Year one

        // Calculates yearly percents individually
        float year1Percent1 = predicted1 * .051f;
        float year1Percent2 = predicted2 * .072f;
        float year1Percent3 = predicted3 * .093f;
        float year1Percent4 = predicted4 * .112f;

        // Averages calculations for the year #1
        float year1 =
            (year1Percent1 + year1Percent2 + year1Percent3 + year1Percent4) / 4;
        // Prints year #1 average profit
        System.out.println("The average profit for the next year: " + year1);

        // Year two

        // Calculates yearly percents individually
        float year2Percent1 = predicted1 * .06f;
        float year2Percent2 = predicted2 * .08f;
        float year2Percent3 = predicted3 * .101f;
        float year2Percent4 = predicted4 * .132f;

        // Averages calculations for the year #2
        float year2 =
            (year2Percent1 + year2Percent2 + year2Percent3 + year2Percent4) / 4;
        // Prints year #2 average profit
        System.out.println("The average profit for the second year: " + year2);

        // Year two

        // Calculates yearly percents individually
        float year3Percent1 = predicted1 * .08f;
        float year3Percent2 = predicted2 * .105f;
        float year3Percent3 = predicted3 * .13f;
        float year3Percent4 = predicted4 * .168f;

        // Averages calculations for the year #3
        float year3 =
            (year3Percent1 + year3Percent2 + year3Percent3 + year3Percent4) / 4;
        // Prints year #3 average profit
        System.out.println("The average profit for the third year: " + year3);

        // Adds total average predicted profit for all years
        int totalAverage = (int)year1 + (int)year2 + (int)year3;
        // Prints total average predicted profit for all years
        System.out.println("\nTotal profit in next 3 years: " + totalAverage);

    } // end method main

} // end class ProjectProfits
