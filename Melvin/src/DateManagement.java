
import java.time.Month;
import java.util.ArrayList;
import java.time.LocalDate;


/**
 *  Date Management class
 *  In charge of all dates and date calculations for the LocalDate
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.0
 *  @since 2021-04-14
 */
public class DateManagement {

    public int toIndex(Month month)
    {
        switch (month)
        {
            case JANUARY:
                return 1;
            case FEBRUARY:
                return 2;
            case MARCH:
                return 3;
            case APRIL:
                return 4;
            case MAY:
                return 5;
            case JUNE:
                return 6;
            case JULY:
                return 7;
            case AUGUST:
                return 8;
            case SEPTEMBER:
                return 9;
            case OCTOBER:
                return 10;
            case NOVEMBER:
                return 11;
            case DECEMBER:
                return 12;
        }
        return -1;
    }

    /**
     *gets all the check in dates for all the provided goals
     * @param goals arrayList of all the goals to be on LocalDate
     * @param month target month
     * @param year target year
     * @return returns Arraylist of all goals date instances in target month
     */
    public ArrayList<GoalDate> getAllMonth(ArrayList<Goal> goals, int month, int year)
    {
        LocalDate inMonth = LocalDate.of(year,month, 1);
        int count = 0;
        ArrayList<GoalDate> dates = new ArrayList<>();
        while (toIndex(inMonth.getMonth()) != (month +1))
        {
            for (Goal goal:goals) {
                GoalDate days = new GoalDate(year,month, count);
                dates.add(days);

            }
            count++;
            inMonth = inMonth.plusDays(1);
        }


        return dates;
    }

}
