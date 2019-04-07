/**
 * LogUtil.java
 * This class is used for logging and debugging purposes.
 * When variabl DEBUG is set to false all the printLogs will be disabled.
 **/
public class LogUtil{
    private static final boolean DEBUG = true;
    private static final String LOG = "[LOGGING] :";
    private static final String ERROR = "[ERROR] :";
    /**
     * This class is used to print the parameters throughout the project.
     * To remove all the print out we can simply change the DEBUF value as false.
     */
    public static void printLog(String msg){
        if(DEBUG){
            System.out.println(LOG + msg);
        }
    }

    /**
     * This class is used to print the parameters throughout the project.
     * To remove all the print out we can simply change the DEBUF value as false.
     */
    public static void printError(String msg){
        if(DEBUG){
            System.err.println(ERROR + msg);
        }
    }
}
