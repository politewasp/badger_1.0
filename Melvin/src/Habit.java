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
    private ArrayList<String> checkedInSuccess = new ArrayList<>();
    private ArrayList<String> checkedInFail = new ArrayList<>();
    private int frequency;
    private String message;
    private boolean checked;
    private String lastCheckIn;
    private String nextCheckIn;


    /**
     * Default constructor
     */
    Habit()
    {
        frequency = 1;
        message = "TBD";
        checked = false;
        lastCheckIn = null;
        nextCheckIn = null;

    }

    /**
     * Constructor that takes in all values needed
     * @param freq integer number of days between checkins
     * @param mess message to user about the check in what they are supposed to do
     * @param start the start date of checkins
     */
    Habit(int freq, String mess, String start)
    {
        frequency = freq;
        message = mess;
        checked = false;
        lastCheckIn = start;
        nextCheckIn = null;

    }

    /**
     * returns arraylist of string dates that the user failed to check in
     * @return string format "yyyy-mm-dd" dates failed
     */
    public ArrayList<String> getCheckedInFail() {
        return checkedInFail;
    }

    /**
     * returns string array list pf dates that the user successfully logged
     * @return string format "yyyy-mm-dd" dates success
     */
    public ArrayList<String> getCheckedInSuccess() {
        return checkedInSuccess;
    }

    /**
     * Returns the frequency value for checkins
     * @return int days between
     */
    public int getFrequency() {
        return frequency;
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
     * calculates the next checkInDate based on the lastCheckIn date
     * @return string date of nextCheckIn
     */
    public String getNextCheckIn() {

        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();
        try{
            //Setting the date to the given date
            c.setTime(sdf.parse(lastCheckIn));
        }catch(ParseException e){
            e.printStackTrace();
        }

        c.add(Calendar.DAY_OF_MONTH, frequency);
        //Date after adding the days to the given date
        nextCheckIn = sdf.format(c.getTime());


        lastCheckIn = nextCheckIn;
        return nextCheckIn;
    }

    /**
     * sets the boolean checked if the log has been completed or not
     * and adds the date to the corresponding array
     * @param checked boolean if logged
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
        if(checked)
        {
            checkedInSuccess.add(lastCheckIn);
        }
        else
        {
            checkedInFail.add(lastCheckIn);
        }
    }

    /**
     * sets the frequency of checkins
     * @param frequency int days between
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Sets the check in message
     * @param message check in message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets the lastCheckIn to initial value
     * @param lastCheckIn string format date of last check in
     */
    public void setLastCheckIn(String lastCheckIn) {
        this.lastCheckIn = lastCheckIn;
    }

    /**
     * toString method for debugging
     * @return string frequency , message ,start , next check in
     */
    public String toString()
    {
        return "frequency "  + frequency + " message: " + message + " start " + lastCheckIn + " next checkIn " + getNextCheckIn();
    }



}
