import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;

/**
 * This class is in charge of creating an array of date instances that a goal checkin happens
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
        Calendar c = Calendar.getInstance();
        Calendar limit = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        limit.set(year, month + 1, 1);
        start.set(year, month, 1);
        try {
            //sets first date to the first ever date

            c.setTime(sdf.parse(Goal.getStart()));
            end.setTime((sdf.parse(Goal.getEnd())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.before(start)) {
            c = start;
            for (int day : daysOfWeek) {
                c.set(Calendar.DAY_OF_WEEK, day);
                while (c.before(limit)) {
                    if(c.after(end))
                    {
                        break;
                    }
                    dates.add(c);
                    c.add(Calendar.WEEK_OF_MONTH, 1);
                }
            }
        }
        else if(c.after(start) && c.before(limit)) {
            for (int day : daysOfWeek) {
                c.set(Calendar.DAY_OF_WEEK, day);
                while (c.before(limit)) {
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
}
