/**
 * VerboseCommand displays the room description if toggled on, otherwise it only displays the first time.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
    class VerboseCommand extends Command {

        public static boolean verboseToggle = true;
        public static String command;

    /**
     * Constructor for VerboseCommand.
     * @param command the command
     */
        VerboseCommand(String command) {
            this.command = command;
        }

        /**
         * Execute method runs the command.
         * @return Visual confirmation that the verbose mode has been toggled on/off.
         */
        public String execute() {
            if (command.equalsIgnoreCase("on")) {
                verboseToggle = true;
                System.out.println("Verbose mode is on. You will now be told the available exits.");
            } else if (command.equalsIgnoreCase("off")) {
                verboseToggle = false;
                System.out.println("Verbose mode is off. You will no longer be told the available exits.");
            }

            return "";
        }

        public static boolean getVerbose(){
            return verboseToggle;
        }
    }