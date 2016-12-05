
//package zeitz_borkv3;

/**
 * The type Save command.
 */
class SaveCommand extends Command {

    private static String DEFAULT_SAVE_FILENAME = "bork";

    private String saveFilename;

    /**
     * Instantiates a new Save command.
     *
     * @param saveFilename the save filename
     */

    SaveCommand(String saveFilename) {
        if (saveFilename == null || saveFilename.length() == 0) {
            this.saveFilename = DEFAULT_SAVE_FILENAME;
        } else {
            this.saveFilename = saveFilename;
        }
    }

    public String execute() {
        try {
            GameState.instance().store(saveFilename);
            return "Data saved to " + saveFilename + GameState.SAVE_FILE_EXTENSION + ".\n";
        } catch (Exception e) {
            System.err.println("Couldn't save!");
            e.printStackTrace();
            return "";
        }
    }
}
