
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.time.*;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;
//TODO complete JAVADOCS in Goal
/**
 *  Goal class
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.0
 *  @since 2021-03-22
 */
public class Goal implements Comparable<Goal>
{
    /**
     * Goal class
     * Main class in charge of the Goal object
     * in charge of having all the getters and setters for the Goal Object
     */
    private String name;
    private String description;
    private String categoryName;
    private LocalDate start;
    private LocalDate end;
    private String lastChecked;
    private boolean checked;
    private ArrayList<Integer> daysOfWeek = new ArrayList<>();
    private boolean completed;
    private String message;

    public Goal(){
        name = "";
        description = "";
        categoryName = "";
        start = LocalDate.now();
        end = null;
        lastChecked = "";
        daysOfWeek = null;
        message = "";
        completed = false;

    }
    //TODO Temporary for testing, will be removed
    public Goal(String name){
        this.name = name;
        description = "";
        categoryName = "";
        daysOfWeek = null;
        lastChecked = "";
        start = LocalDate.now();
        completed = false;
    }

    //Getter methods

    /**
     * Get name of goal
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get Description of the Goal
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the category the Goal belongs too
     * @return String category Name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Gets the date LocalDate object of the Goal
     * @return LocalDate object
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * Get whether the goal is completed or not
     * @return True if complete false if incomplete
     */
    public boolean getCompleted()
    {
        return completed;
    }

    /**
     * Get the message attribute of goal
     * @return string message
     */
    public String getMessage() {
        return message;
    }

    /**
     *returns the end date
     * @return LocalDate End
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * returns the days of the week that goal occurs on
     * @return ArrayList days of week 1-7 1 = Monday 7=Sunday
     */
    public ArrayList<Integer> getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Gets date of last checked
     * @return String lastChecked string version of date
     */
    public String getLastChecked() {
        return lastChecked;
    }

    /**
     * gets whether the goal has been logged or not
     * @return boolean checked
     */
    public boolean getChecked()
    {
        return checked;
    }


    //Setter Methods

    /**
     * Sets the Goals name to param name
     * @param name name of goal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Goals description to param description
     * @param description description of goal
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets Goals categoryName to param categoryName
     * @param categoryName category name of the goal
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Sets the start String of Goal to start
     * @param date string date formatted "yyyy-mm-dd"
     */
    public void setStart(LocalDate date) {
        date = start;
    }

    /**
     * Sets the end date
     * @param end LocalDate
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * Sets the days of week goal occurs
     * @param daysOfWeek ArrayList<Integer></Integer>
     */
    public void setDaysOfWeek(ArrayList<Integer> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    /**
     * Sets completed status to true or false
     * @param completed sets the goal to be complete or not
     */
    public void setCompleted(GoalDate d) {
        this.lastChecked = d.toString();
    }

    /**
     * Sets message to value
     * @param mess string going over what the habit is checking
     */
    public void setMessage(String mess)
    {
        message = mess;
    }

    /**
     * To string method for debugging
     * @return string version of important fields in both goal and habit
     */
    public String toString()
    {
        return "Name: " + name ;
    }

    /**
     * Sets boolean for GUI to display Goal as completed for the day or not
     * @param checked boolean checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * Sets string to record last date checked. This allows for a way to
     * check if this.checked needs to be reset for the day
     * @param lastChecked String lastChecked
     */
    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    /**
     * Compares two goals by name to check if they are the same
     * @see Storage also to check if name is already taken when adding
     * a new goal
     * @param goal a different Goal object
     * @return boolean
     */
    public boolean equals(Goal goal) {
        return this.getName().equals(goal.getName());
    }

    /**
     * Compares two goals by name to check if they are the same
     * or for use to sort them alphabetically
     * @param goal a different Goal object
     * @return boolean
     */
    public int compareTo(Goal goal){
        return this.getName().compareTo(goal.getName());
    }

    /**
     * Converts DayOfWeek enum constant to integer to pass to GUI
     * @param day DayOfWeek day
     * @return int array index of day of the week
     */
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


    /**
     * gets the days until next checkin from given date
     * @param year int year
     * @param month int month
     * @param day int day
     * @return
     */
    public int getDaysBetween(int year, int month, int day)
    {
        int count = 0;
        int dates = 0;
        LocalDate week = LocalDate.of(year,month,day);

        while(true)
        {
            dates = toIndex(week.getDayOfWeek());
            for(int days : daysOfWeek) {
                if (dates == days) {
                    return count;
                }

            }
            count ++;
            week = week.plusDays(1);
        }

    }
}



/**
 * sorts goals by category then by name
 */
class GoalsByCategoryThenName implements Comparator<Goal> {
    public int compare(Goal goal1, Goal goal2){
        if(goal2.getCategoryName().equals(goal1.getCategoryName())){
            return goal2.getName().compareTo(goal1.getName());
        } else {
            return goal2.getCategoryName().compareTo(goal1.getCategoryName());
        }
    }
}



