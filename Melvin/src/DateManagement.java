import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;

/**
 * This class is in charge of creating an array of date instances that a goal checkin happens
 */
public class DateManagement
{

    public ArrayList<Calendar> getMonth(Goal Goal, int month, int year)
    {
        ArrayList<Calendar> dates = new ArrayList<>();
        ArrayList<Integer> daysOfWeek = Goal.getDaysOfWeek();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Calendar limit = Calendar.getInstance();
        limit.set(year, month +1, 1);
        try{
            //sets first date to the first ever date
            c.setTime(sdf.parse(Goal.getStart()));
        }catch(ParseException e){
            e.printStackTrace();
        }
        for (int day: daysOfWeek)
        {
            c.set(Calendar.DAY_OF_WEEK, day);
            while(c.before(limit))
            {
                dates.add(c);
                c.add(Calendar.WEEK_OF_MONTH, 1);
            }

        }
    return dates;

    }

}
