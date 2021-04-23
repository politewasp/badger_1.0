
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
//TODO set DaysOfWeek back to null
    public Goal(){
        name = "";
        description = "";
        categoryName = "";
        start = LocalDate.now();
        end = null;
        lastChecked = "";
        daysOfWeek.add(2);
        message = "";
        completed = false;

    }
    //TODO Temporary for testing, will be removed
    public Goal(String name){
        this.name = name;
        description = "";
        categoryName = "";
        daysOfWeek.add(2);
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

    public String getMessage() {
        return message;
    }

    public LocalDate getEnd() {
        return end;
    }

    public ArrayList<Integer> getDaysOfWeek() {
        return daysOfWeek;
    }

    public String getLastChecked() {
        return lastChecked;
    }
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

    public void setEnd(LocalDate end) {
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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    public boolean equals(Goal goal) {
        return this.getName().equals(goal.getName());
    }
    public int compareTo(Goal goal){
        return this.getName().compareTo(goal.getName());
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
