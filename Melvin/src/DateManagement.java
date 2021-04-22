import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;

/**
 *  Date Management class
 *  In charge of all dates and date calculations for the calendar
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.0
 *  @since 2021-04-14
 */
public class DateManagement {

    /**
     * Populates an ArrayList of Calendar dates with in month for a goal's check in dates
     * @param Goal  Goal from goal
     * @param month target month for dates
     * @param year  target year
     * @return list of check in dates within month
     */
    public ArrayList<Calendar> getMonth(Goal Goal, int month, int year) {
        ArrayList<Calendar> dates = new ArrayList<>();
        ArrayList<Integer> daysOfWeek = Goal.getDaysOfWeek();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //c is main incremented date
        Calendar c = Calendar.getInstance();
        //limit is the first day of the next month
        Calendar limit = Calendar.getInstance();
        //start is the first day of target month
        Calendar start = Calendar.getInstance();
        // end is the last date of the goal
        Calendar end = Calendar.getInstance();

        limit.set(year, month + 1, 1);
        start.set(year, month, 1);
        try {
            //sets first date to the first ever date

            c.setTime(sdf.parse(Goal.getStart()));
            //checks if Goal has an end date if not sets end to Limit
            if(Goal.getEnd() != null)
            {
                end.setTime((sdf.parse(Goal.getEnd())));
            }
            else
            {
                end = limit;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        //checks if the start date of goal is before the start of the month if it is sets c to first of month
        if (c.before(start)) {
            c = start;
            for (int day : daysOfWeek) {
                c.set(Calendar.DAY_OF_WEEK, day);
                while (c.before(limit)) {
                    //checks if c is before the last day of the goal
                    if(c.after(end))
                    {
                        break;
                    }
                    dates.add(c);
                    c.add(Calendar.WEEK_OF_MONTH, 1);
                }
            }
        }
        //if start date is not before the first of the month then this checks if it is before the end of the month if not then there are no instances of this goal in this month
        else if( c.before(limit)) {
            for (int day : daysOfWeek) {
                c.set(Calendar.DAY_OF_WEEK, day);
                while (c.before(limit)) {
                    //checks if c is before the last day of the goal
                    if(c.after(end))
                    {
                        break;
                    }
                    dates.add(c);
                    c.add(Calendar.WEEK_OF_MONTH, 1);
                }
            }
        }
        return dates;
    }

    /**
     *gets all the check in dates for all the provided goals
     * @param goals arrayList of all the goals to be on Calendar
     * @param month target month
     * @param year target year
     * @return returns Arraylist of all goals date instances in target month
     */
    public ArrayList<ArrayList> getAllMonth(ArrayList<Goal> goals, int month, int year)
    {
        ArrayList<ArrayList> dates = new ArrayList<>();
        for (Goal goal:goals) {
            dates.add(getMonth(goal,month,year));

        }
        return dates;
    }

}
