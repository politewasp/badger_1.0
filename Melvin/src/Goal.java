
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
    Debug debug = Debug.getInstance();
    /**
     * Goal class
     * Main class in charge of the Goal object
     * in charge of having all the getters and setters for the Goal Object
     */
    private String name;
    private String description;
    private String categoryName;
    private String lastCompleted;
    private boolean [] daysOfWeek;
    private boolean completed;
    private String message;
    private int logged;

    public Goal(){
        name = "";
        description = "";
        categoryName = "";
        lastCompleted = "";
        daysOfWeek = new boolean[] {false, false, false, false, false, false, false};
        message = "";
        completed = false;
        logged = 0;
    }
    //TODO Temporary for testing, will be removed
    public Goal(String name){
        this.name = name;
        description = "";
        categoryName = "";
        lastCompleted = "";
        daysOfWeek = new boolean[] {false, false, false, false, false, false, false};
        message = "";
        completed = false;
        logged = 0;
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
     * Get the message attribute of goal
     * @return string message
     */
    public String getMessage() {
        return message;
    }

    /**
     * returns the days of the week that goal occurs on
     * @return ArrayList days of week 1-7 1 = Monday 7=Sunday
     */
    public boolean [] getDaysOfWeek() { return daysOfWeek; }

    /**
     * Gets date of last checked
     * @return String lastCompleted string version of date
     */
    public String getLastCompleted() {
        return lastCompleted;
    }

    /**
     * gets whether the goal has been logged or not
     * @return boolean checked
     */
    public boolean getCompleted()
    {
        return completed;
    }

    /**
     * gets how many times the goal has been logged
     * @return String times logged
     */
    public String getLogged() { return String.valueOf(logged); }


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
     * Sets the days of week goal occurs
     * @param daysOfWeek ArrayList<Integer></Integer>
     */
    public void setDaysOfWeek(boolean [] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    /**
     * Sets the days of week goal occurs
     * @param daysOfWeek ArrayList<Integer></Integer>
     */

    /**
     * Sets completed status to true or false
     * @param b sets the goal to be complete or not
     */
    public void setCompleted(boolean b) {
        this.completed = b;
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
     * Sets logged to value
     * @param logged integer counting how many times goal has been logged
     */
    public void setLogged(String logged){
        this.logged = Integer.parseInt(logged);
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
     * Sets string to record last date completed. This allows for a way to
     * check if this.checked needs to be reset for the day
     * @param lastCompleted String lastCompleted
     */
    public void setLastCompleted(String lastCompleted) {
        this.lastCompleted = lastCompleted;
        debug.print(lastCompleted);
        debug.print(LocalDate.now().toString());
        if(lastCompleted.toString().equals(LocalDate.now().toString())){
            this.completed = true;
        }
    }

    /**
     * increments logged attribute and sets lastCompleted to today
     */
    public void log(){
        this.completed = true;
        this.setLastCompleted(LocalDate.now().toString());
        logged++;
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
        return switch (day) {
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
            for(boolean days : daysOfWeek) {
                if (days) {
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



