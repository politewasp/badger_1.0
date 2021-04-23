
import java.util.ArrayList;
import java.time.LocalDate;


public class GoalDate {
    Storage storage = Storage.load();
    private ArrayList<Goal> goalsToday;
    private LocalDate date;
    int month;
    int year;
    int day;

    GoalDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.date = LocalDate.of(year,month,day);
        this.goalsToday = getGoalsOnDate();
    }

    public int toIndex()
    {
        return switch (date.getDayOfWeek()) {
            case MONDAY -> 0;
            case TUESDAY -> 1;
            case WEDNESDAY -> 2;
            case THURSDAY -> 3;
            case FRIDAY -> 4;
            case SATURDAY -> 5;
            case SUNDAY -> 6;
        };
    }

    private ArrayList<Goal> getGoalsOnDate()
    {
        ArrayList<Goal> temp = new ArrayList<>();
        for(Goal goal: storage.getGoals())
        {
            if(toIndex() == day)
            {
                temp.add(goal);
            }
        }
        return temp;
    }

    public void checkIn(Goal goal)
    {
        LocalDate today = LocalDate.now();
        goal.setChecked(true);
        goal.setLastChecked(today.toString());
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDate(int year, int month, int day) {
        date = LocalDate.of(year,month,day);
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Goal> getGoals() {
        return goalsToday;
    }
    //function that will generate list of goals through them and add goals to its goal list

}
