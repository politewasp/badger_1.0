import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GoalDate {
    private ArrayList<Goal> goals;
    private Calendar date = Calendar.getInstance();

    GoalDate(int year, int month, int day)
    {
        date.set(year,month,day);
        goals = getGoalsOnDate();
    }
    private ArrayList<Goal> getGoalsOnDate()
    {
        ArrayList<Goal> goals1 = new ArrayList<>();

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
