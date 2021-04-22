import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

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
    private boolean isShort;
    private boolean isGood;
    private Calendar start;
    private boolean completed;
    private String end;
    private ArrayList<Integer> daysOfWeek;
    private String message;

    public Goal(){
        name = "TBD";
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = Calendar.getInstance();
        daysOfWeek = null;
        message = "TBD";
        completed = false;
        end = null;

    }
    //TODO Temporary for testing, will be removed
    public Goal(String name){
        this.name = name;
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = Calendar.getInstance();
        completed = false;
        end = null;
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
     * Get whether the Goal is short or long term
     * @return false if long true if short
     */
    public boolean getShortLong() {
        return isShort;
    }

    /**
     * Get whether the goal is the creation of a good habit or a breaking of a bad habit
     * @return false if bad true if good
     */
    public boolean getGoodBad() {
        return isGood;
    }

    /**
     * Gets the start String of the Goal
     * @return String object
     */
    public Calendar getStart() {
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
     * Returns the end String of the object. Can be Null if the goal does not end.
     * @return end
     */
    public String getEnd() {
        return end;
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
     * Sets Goals isShort to short or long
     * @param aShort  either short or long term short is true and long is false
     */
    public void setShortLong(boolean aShort) {
        isShort = aShort;
    }

    /**
     * Sets Goals isGood to good or bad
     * @param gb sets whether the goal is good or bad good is true and bad is false
     */
    public void setGoodBad(boolean gb) {
        isGood = gb;
    }

    /**
     * Sets the start String of Goal to start
     * @param start string date formatted "yyyy-mm-dd"
     */
    public void setStart(Calendar start) {
        this.start = start;
    }

    /**
     * Sets completed status to true or false
     * @param completed sets the goal to be complete or not
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Sets the End String of the goal
     * @param end String
     */
    public void setEnd(String end) {
        this.end = end;

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
     * sets the frequency in which the check in will be done
     * @param days int value of days between checkins
     */
    public void setFrequency(ArrayList<Integer> days)
    {
        daysOfWeek = days;
    }

    /**
     * to string method for debugging
     * @return string version of important fields in both goal and habit
     */
    public String toString()
    {
        return "Name: " + name + " description: " + description + " category: " + categoryName + " start: " + start + " end: " + end +  " isCompleted: " + completed + " isShort: " +isShort +
         " isGood: " + isGood + " message: " + message + " days of week: " + daysOfWeek;
    }



    public boolean equals(Goal goal) {
        return this.getName().equals(goal.getName());
    }
    public int compareTo(Goal goal){
        return this.getName().compareTo(goal.getName());
    }
}

class GoalsByNextLogDate implements Comparator<Goal> {
    public int compare(Goal goal1, Goal goal2){
        return 0;
        //compare by next date that goal will need to be logged once there is a function that informs when the next log date will be
        //maybe just a func that returns how many days until next log date
    }
}

class GoalsByCategoryThenName implements Comparator<Goal> {
    public int compare(Goal goal1, Goal goal2){
        if(goal2.getCategoryName().equals(goal1.getCategoryName())){
            return goal2.getName().compareTo(goal1.getName());
        } else {
            return goal2.getCategoryName().compareTo(goal1.getCategoryName());
        }
    }
}

//could add comparators or start and end dates among other things
