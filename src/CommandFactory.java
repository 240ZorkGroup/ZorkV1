/**
 * Command Factory
 * This class parses through the input and decides which command is being used.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
//package zeitz_borkv3;

import java.util.List;
import java.util.Arrays;

/**
 * The type Command factory.
 */
public class CommandFactory {

    /**
     * The Count.
     */
    static int count;
    private static CommandFactory theInstance;
    /**
     * The Movement commands.
     */
    public static List<String> MOVEMENT_COMMANDS =
        Arrays.asList("n","w","e","s","u","d" );

    /**
     * Instance command factory.
     *
     * @return the command factory
     */
    public static synchronized CommandFactory instance() {
        if (theInstance == null) {
            theInstance = new CommandFactory();
        }
        return theInstance;
    }


    /**
     * A CommandFactory constructor creates a blank commandFactory.
     */
    private CommandFactory() {
    }


    /**
     * Parse sifts through the player's input to decide which command class will be used.
     *
     * @param command The player's keyboard input
     * @return a command according to the input.
     */
    public Command parse(String command) {
        String parts[] = command.split(" ");
        count++;

        String verb = parts[0];
        String noun = parts.length >= 2 ? parts[1] : "";

        if (verb.equalsIgnoreCase("save")) {
            return new SaveCommand(noun);
        }
        if (verb.equalsIgnoreCase("verbose")){
            return new VerboseCommand(noun);
        }
        if (verb.equalsIgnoreCase("speak") && !parts[1].equalsIgnoreCase("to")) {
            return new SpeakCommand(noun);
        }
        if (verb.equalsIgnoreCase("speak") && parts[1].equalsIgnoreCase("to") && !parts[2].equalsIgnoreCase("the")) {
            return new SpeakCommand(parts[2]);
        }
        if (verb.equalsIgnoreCase("speak") && parts[1].equalsIgnoreCase("to") && parts[2].equalsIgnoreCase("the")) {
            return new SpeakCommand(parts[3]);
        }
        if (verb.equalsIgnoreCase("health")) {
            return new HealthCommand();
        }
        if (verb.equalsIgnoreCase("score")) {
            return new ScoreCommand();
        }
        if (verb.equalsIgnoreCase("take")) {
            return new TakeCommand(noun);
        }
        if (verb.equalsIgnoreCase("drop")) {
            return new DropCommand(noun);
        }
        if (verb.equalsIgnoreCase("i") || verb.equalsIgnoreCase("inventory")) {
            return new InventoryCommand();
        }
        if (MOVEMENT_COMMANDS.contains(verb)) {
            GameState.instance().depleteHunger();
            return new MovementCommand(verb);
        }
        if (parts.length == 2) {
            return new ItemSpecificCommand(verb, noun);
        }
        return new UnknownCommand(command);
    }
}
