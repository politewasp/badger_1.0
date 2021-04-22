import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GoalDate {
    private ArrayList<Goal> goals;
    private Calendar date = Calendar.getInstance();

    GoalDate(int year, int month, int day)
    {

    }
    private ArrayList<Goal> getGoalsOnDate()
    {
        ArrayList<Goal> goals1 = new ArrayList<>();

        return goals1;
    }
    private Calendar parseDate(int year,int month, int day)
    {
        Calendar c = Calendar.getInstance();
        return c;
    }




    public void setDate(Calendar date) {
        this.date = date;
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
