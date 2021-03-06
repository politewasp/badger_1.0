// Java program implementing Singleton class
// with getInstance() method
/**
 *  <h1>Debug</h1>
 *  Debugger singleton class for ease of printing debugging lines to the terminal
 *  Written Using Java 15
 *  @author Maraiah Matson
 *  @version 1.1
 *  @since 2021-04-06
 */
class Debug
{
    // static variable single_instance of type Debug
    private static Debug single_instance = null;

    // variable of type String
    public boolean active;
    public String message;

    // private constructor restricted to this class itself
    private Debug()
    {
        active = true;
    }

    /**
     * Debug.getInstance() is used to load Debug instance
     */
    public static Debug getInstance()
    {
        if (single_instance == null)
            single_instance = new Debug();

        return single_instance;
    }

    /**
     * @param message String message to print to terminal
     */
    public void print(String message){
        if(active){
            System.out.println(message);
        }
    }

    /**
     * @param bool Boolean value to print to terminal
     */
    public void print(Boolean bool){
        if(active){
            System.out.println(bool.toString());
        }
    }

    /**
     * @param i int value to print to terminal
     */
    public void print(int i){
        if(active){
            System.out.println(i);
        }
    }
}