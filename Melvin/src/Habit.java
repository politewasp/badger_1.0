import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

/**
 * Class Habit. Integrated into goal, manages dates and frequency of check ins
 */
public class Habit
{
    //TODO add logic to store dates into respective array if checked in or not
    //frequency aka number of days between check in

    private ArrayList<Integer> daysOfWeek;
    private String message;
    private boolean checked;

    /**
     * Default constructor
     */
    Habit()
    {
        message = "TBD";
        checked = false;
        daysOfWeek = new ArrayList<>();
    }

    /**
     * Constructor that takes in all values needed
     * @param mess message to user about the check in what they are supposed to do
     * @param start the start date of checkins
     */
    Habit( String mess, String start)
    {

        message = mess;
        checked = false;
        daysOfWeek = new ArrayList<>();
    }




    /**
     * Returns the frequency value for checkins
     * @return int days between
     */
    public ArrayList<Integer> getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * returns the check in message
     * @return string message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns whether the goal has been logged today or not
     * @return boolean checked
     */
    public boolean getChecked()
    {
        return checked;
    }



    /**
     * sets the boolean checked if the log has been completed or not
     * and adds the date to the corresponding array
     * @param checked boolean if logged
     */
    public void setChecked(boolean checked) {
        this.checked = checked;

    }

    /**
     * sets the frequency of checkins
     * @param days ArrayList of Integer representations of what days of the week
     */
    public void setDaysOfWeek(ArrayList<Integer> days) {
        this.daysOfWeek = days;
    }

    /**
     * Sets the check in message
     * @param message check in message
     */
    public void setMessage(String message) {
        this.message = message;
    }



    /**
     * toString method for debugging
     * @return string frequency , message ,start , next check in
     */
    public String toString()
    {
        return "days of the week "  + daysOfWeek + " message: " + message + "isChecked: "+ checked;
    }





}
