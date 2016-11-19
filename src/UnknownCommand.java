
//package zeitz_borkv3;

/**
 * The type Unknown command.
 */
class UnknownCommand extends Command {

    private String bogusCommand;

    /**
     * Instantiates a new Unknown command.
     *
     * @param bogusCommand the bogus command
     */
    UnknownCommand(String bogusCommand) {
        this.bogusCommand = bogusCommand;
    }

    String execute() {
        return "I'm not sure what you mean by \"" + bogusCommand + "\".\n";
    }
}
