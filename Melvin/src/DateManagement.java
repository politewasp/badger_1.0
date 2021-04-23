
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

    /**
     * Converts Month enum constant to integer to pass to GUI
     * @return int array index of month
     */
    public int toIndex(Month month)
    {
        switch (month)
        {
            case JANUARY:
                return 0;
            case FEBRUARY:
                return 1;
            case MARCH:
                return 2;
            case APRIL:
                return 3;
            case MAY:
                return 4;
            case JUNE:
                return 5;
            case JULY:
                return 6;
            case AUGUST:
                return 7;
            case SEPTEMBER:
                return 8;
            case OCTOBER:
                return 9;
            case NOVEMBER:
                return 10;
            case DECEMBER:
                return 11;
        }
        return -1;
    }

    /**
     *gets all the check in dates for all the provided goals
     * @param month target month
     * @param year target year
     * @return returns Arraylist of all goals date instances in target month
     */
    public ArrayList<GoalDate> getAllMonth(int month, int year)
    {
        LocalDate inMonth = LocalDate.of(year,month, 1);
        int count = 0;
        ArrayList<GoalDate> dates = new ArrayList<>();
        while (toIndex(inMonth.getMonth()) != (month +1))
        {

                GoalDate days = new GoalDate(year,month, count);
                dates.add(days);

            count++;
            inMonth = inMonth.plusDays(1);
        }


        return dates;
    }

    public static LocalDate stringToDate(String str){
        String [] arr = str.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return LocalDate.of(year, month, day);
    }


}
