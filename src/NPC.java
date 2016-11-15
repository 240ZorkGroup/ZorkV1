import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * NPC - Non-Player Characters
 * This class provides an NPC that the player can interact with.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
public class NPC {

    static TTT2 tictactoe;
    Scanner in = new Scanner(System.in);
    public static boolean wait = false;
    public static String monsterName;
    public static String playerName;
    /**
     * Constructor class for NPCs will create a named NPC class.
     * @param n The name of the NPC. Choose whatever you want.
     */
    public NPC(String n){
        this.monsterName = n;
    }

    /**
     * Converse method allows the player to play a game (within a game) with the NPC.
     */
    public void converse(){

        System.out.println("As you were examining the room, an ugly beast appears. \n" +
                "Frightened, you reach for anything to use as a weapon. \n\n" +
                "     " + monsterName + ": Don't be alarmed! I only wish to play a game with you. \n" +
                "     " + monsterName + ": It gets lonely in this dungeon of a basement... My name is " + monsterName + ".\n\n" +
                "The beast seems harmless...\n");

        System.out.print("     " + monsterName + ": So what do you say? A quick game of Tic-Tac-Toe? (y/n): ");
        String answer = in.nextLine();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            System.out.print("     " + monsterName + ": Great! I don't think I caught your name. (enter your name): ");
            String name = in.nextLine();
            System.out.println();
            this.playerName = name;
            System.out.println("     " + monsterName + ": Well nice to meet you, " + playerName + ". ");
            System.out.println("     " + monsterName + ": Let's play. You'll be X's and I'll be O's.");
            System.out.println("");

            // Start the TicTacToe GUI
            tictactoe = new TTT2();
            tictactoe.setVisible(true);

        } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){
            System.out.println("     " + playerName + ": I don't have time for that right now.");
            System.out.println("     " + monsterName + ": Maybe next time.");
            System.out.println();
        } else {
            System.out.println("     " + monsterName + ": Sorry, I can't understand your mumbling. I didn't want to play with you anyway.");
        }
    }

    public static String getMonsterName(){
        return monsterName;
    }

    public static String getPlayerName(){
        return playerName;
    }

    public static void changeWaitStatus(boolean waitStatus) throws InterruptedException {
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


    public static boolean playerWin(boolean win){
        boolean answer;
        if (win)
            answer = true;
        else
            answer = false;
        return answer;
    }

}

