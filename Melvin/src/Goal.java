import java.util.ArrayList;
import java.util.*;

/**
 *  Goal class
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.0
 *  @since 2021-03-22
 */
public class Goal
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
    private Date start;
    private boolean completed;

    Goal()
    {
        name = "TBD";
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = null;
        completed = false;
    }
    //TODO Temporary for testing, will be removed
    Goal(String name){
        this.name = name;
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = null;
        completed = false;
    }
    //Getter methods

    /**
     * Get name of goal
     * @return String name
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
     * Gets the start date of the Goal
     * @return date object
     */
    public Date getStart() {
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

    //Setter Methods

    /**
     * Sets the Goals name to param name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Goals description to param description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets Goals categoryName to param categoryName
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Sets Goals isShort to short or long
     * @param aShort
     */
    public void setShortLong(boolean aShort) {
        isShort = aShort;
    }

    /**
     * Sets Goals isGood to good or bad
     * @param gb
     */
    public void setGoodBad(boolean gb) {
        isGood = gb;
    }

    /**
     * Sets the start date of Goal to start
     * @param start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Sets completed status to true or false
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
