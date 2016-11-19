import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * NPC - Non-Player Characters
 * This class provides an NPC that the player can interact with.
 *
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
public class NPC {

    /**
     * The type No npc exception.
     */
    static class NoNPCException extends Exception {}

    /**
     * The Tictactoe.
     */
    static TTT2 tictactoe;
    /**
     * The In.
     */
    Scanner in = new Scanner(System.in);
    private boolean wait = false;
    private String monsterName;
    private String playerName;

    /**
     * Constructor class for NPCs will create a named NPC class.
     *
     * @param n The name of the NPC. Choose whatever you want.
     */
    NPC(String n){
        this.monsterName = n;
    }

    /**
     * Instantiates a new Npc.
     *
     * @param s the s
     * @throws NoNPCException                the no npc exception
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    NPC(Scanner s) throws NoNPCException,
            Dungeon.IllegalDungeonFormatException {

        // Read NPC name.
        String tempName = s.nextLine();
        this.monsterName = tempName;
        if (monsterName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoNPCException();
        }

    }

    /**
     * Converse method allows the player to play a game (within a game) with the NPC.
     */
    public void converse(){

        // Dialogue
        System.out.println("As you were examining the room, an ugly beast appears. \n" +
                "Frightened, you reach for anything to use as a weapon. \n\n" +
                "     " + monsterName + ": Don't be alarmed! I only wish to play a game with you. \n" +
                "     " + monsterName + ": It gets lonely in this dungeon of a basement... My name is " + monsterName + ".\n\n" +
                "The beast seems harmless...\n");

        System.out.print("     " + monsterName + ": So what do you say? A quick game of Tic-Tac-Toe? (y/n): ");
        String answer = in.nextLine();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) { // Wants to play Tic Tac Toe
            System.out.print("     " + monsterName + ": Great! I don't think I caught your name. (enter your name): ");
            String name = in.nextLine();
            System.out.println();
            this.playerName = name;
            System.out.println("     " + monsterName + ": Well nice to meet you, " + playerName + ". ");
            System.out.println("     " + monsterName + ": Let's play. You'll be X's and I'll be O's.");
            System.out.println("");

            // Start the TicTacToe GUI
            tictactoe = new TTT2(monsterName,playerName);
            tictactoe.setVisible(true);

        } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){ // Doesn't want to play Tic Tac Toe.
            System.out.println("     " + playerName + ": I don't have time for that right now.");
            System.out.println("     " + monsterName + ": Maybe next time.");
            System.out.println();
        } else {
            System.out.println("     " + monsterName + ": Sorry, I can't understand your mumbling. I didn't want to play with you anyway.");
        }
    }

    /**
     * Goes by boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean goesBy(String name) {
        // could have other aliases
        return this.monsterName.equals(name);
    }


    /**
     * Get monster name string.
     *
     * @return the string
     */
    public String getMonsterName(){
        return monsterName;
    }

    /**
     * Get player name string.
     *
     * @return the string
     */
    public String getPlayerName(){
        return playerName;
    }

    /**
     * Change wait status.
     *
     * @param waitStatus the wait status
     * @throws InterruptedException the interrupted exception
     */
    public void changeWaitStatus(boolean waitStatus) throws InterruptedException {
        wait = waitStatus;
        TimeUnit.SECONDS.sleep(2);
        tictactoe.hide();

        if (tictactoe.playerXWin()) {
            System.out.println("*** " + playerName + " Wins! ***");
            //break;
        } else if (tictactoe.playerOWin()) {
            System.out.println("*** " + monsterName + " Wins! ***");
            //break;
        } else {
            System.out.println("There was a tie. Try harder next time.");
        }

        System.out.println("");

        if (tictactoe.playerXWin()) {
            System.out.println("     " + monsterName + ": Thanks, " + playerName + ". Nobody ever wants to play with me. \n" +
                    "     " + monsterName + ": Everyone just walks right past me in Trinkle's basement, like I don't even exist! \n" +
                    "     " + monsterName + ": It's almost like these students can't even see me. Here's an extra 100 points for being nice to me.'");
            GameState.instance().setScore(100);
            System.out.println("");
            System.out.println("100pts added.");
        } else {
            System.out.println("You didn't win. You didn't earn any points.");
        }
        System.out.println("Score: " + GameState.instance().getScore());
    }

}

