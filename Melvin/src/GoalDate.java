import javax.crypto.AEADBadTagException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class GoalDate {
    Storage storage = Storage.load();
    private ArrayList<Goal> goals = Storage.load().goals;
    private ArrayList<Goal> goalsOnDay = new ArrayList<>();
    private Calendar date = Calendar.getInstance();
    int month;
    int year;
    int day;

    GoalDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        date.set(year,month,day);
        goalsOnDay = getGoalsOnDate();
    }
    private ArrayList<Goal> getGoalsOnDate()
    {
        Calendar c = Calendar.getInstance();
        c.set(year,month,day);
        ArrayList<Goal> goals1 = new ArrayList<>();
        for(Goal goal: goals)
        {
            for (Integer days: goal.getDaysOfWeek())
            {
                c.set(Calendar.DAY_OF_WEEK, days);
                if(c.before(goal.getEnd()) && c.after(goal.getStart()))
                {
                    if(c.equals(date))
                    {
                        goalsOnDay.add(goal);
                    }
                }

            }

        }
        return goals1;
    }





    public void setDate(Calendar date) {
        this.date = date;
    }
    public void setDate(int year, int month, int day) {
        date.set(year,month,day);
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public Calendar getDate() {
        return date;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }
    //function that will generate list of goals through them and add goals to its goal list

}
