import javax.crypto.AEADBadTagException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.time.LocalDate;


public class GoalDate {
    Storage storage = Storage.load();
    private ArrayList<Goal> goals = Storage.load().goals;
    private ArrayList<Goal> goalsOnDay = new ArrayList<>();
    private LocalDate date = LocalDate.now();
    int month;
    int year;
    int day;

    GoalDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        date.of(year,month,day);
        goalsOnDay = getGoalsOnDate();
    }
    public int toIndex(DayOfWeek day)
    {
         switch (day)
         {
            case  MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 7;
        }
        return -1;
    }

    private ArrayList<Goal> getGoalsOnDate()
    {
        LocalDate c = LocalDate.now();
        c.of(year,month,day);
        int date;
        ArrayList<Goal> goals1 = new ArrayList<>();
        for(Goal goal: goals)
        {
            date = toIndex(c.getDayOfWeek());
            for (Integer days: goal.getDaysOfWeek())
            {
                if(date == days)
                {
                    goals1.add(goal);
                }

            }

        }
        return goals1;
    }





    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDate(int year, int month, int day) {
        date.of(year,month,day);
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }
    //function that will generate list of goals through them and add goals to its goal list

}
