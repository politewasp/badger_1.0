import java.util.ArrayList;
import java.time.LocalDate;

/**
 *  <h1>GoalDate</h1>
 *  Holds a date and all Goals that occur on that date
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.1
 *  @since 2021-04-22
 */

public class GoalDate {
    Storage storage = Storage.load();
    private ArrayList<Goal> goalsToday;
    private LocalDate date;
    int month;
    int year;
    int day;

    /**
     * GoalDate Constructor
     * @param year int year
     * @param month int month
     * @param day int day
     */
    GoalDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.date = LocalDate.of(year,month,day);
        this.goalsToday = getGoalsOnDate();
    }

    /**
     * Converts DayOfWeek enum constant to integer to pass to GUI
     * @return int array index of day of the week
     */
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

    /**
     * Gets all the goals that happen on a specific day
     * @return ArrayList of Goals
     */
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

    /**
     * Tells Goal object it has been logged for the day
     * @param goal Goal object
     */
    public void checkIn(Goal goal)
    {
        LocalDate today = LocalDate.now();
        goal.setChecked(true);
        goal.setLastChecked(today.toString());
    }

    /**
     * Set LocalDate date object
     * @param date LocalDate object
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Create LocalDate date object using year, month, and day
     * @param year int year
     * @param month int month
     * @param day int day
     */
    public void setDate(int year, int month, int day) {
        date = LocalDate.of(year,month,day);
    }

    /**
     * Get LocalDate date object
     * @return LocalDate object
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Get list of Goals that occur on date
     * @return ArrayList of Goal objects
     */
    public ArrayList<Goal> getGoals() {
        return goalsToday;
    }
    //function that will generate list of goals through them and add goals to its goal list

}
