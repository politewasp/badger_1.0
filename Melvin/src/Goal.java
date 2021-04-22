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
    private Calendar start;
    private Calendar end;
    private ArrayList<Integer> daysOfWeek;
    private boolean completed;
    private String message;
//TODO set DaysOfWeek back to null
    public Goal(){
        name = "";
        description = "";
        categoryName = "";
        start = Calendar.getInstance();
        end = null;
        daysOfWeek.add(2);
        message = "";
        completed = false;

    }
    //TODO Temporary for testing, will be removed
    public Goal(String name){
        this.name = name;
        description = "";
        categoryName = "";
        start = Calendar.getInstance();
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
     * Gets the date Calendar object of the Goal
     * @return Calendar object
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

    public String getMessage() {
        return message;
    }

    public Calendar getEnd() {
        return end;
    }

    public ArrayList<Integer> getDaysOfWeek() {
        return daysOfWeek;
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
    public void setStart(Calendar date) {
        date = start;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public void setDaysOfWeek(ArrayList<Integer> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    /**
     * Sets completed status to true or false
     * @param completed sets the goal to be complete or not
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
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
     * to string method for debugging
     * @return string version of important fields in both goal and habit
     */
    public String toString()
    {
        return "Name: " + name ;
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
