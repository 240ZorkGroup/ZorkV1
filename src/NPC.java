import java.util.Scanner;

/**
 * NPC - Non-Player Characters
 * This class provides an NPC that the player can interact with.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
public class NPC {

    Scanner in = new Scanner(System.in);
    public boolean wait = false;
    private String monsterName;
    private String playerName;
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
                monsterName + ": Don't be alarmed! I only want to play a game with you. \n" +
                monsterName + ": It gets lonely in this dungeon of a basement... My name is " + monsterName + ".\n\n" +
                "The beast seems harmless...\n");

        System.out.print(monsterName + ": So what do you say? A quick game of Tic-Tac-Toe? (y/n): ");
        System.out.println();

        if (in.nextLine().equalsIgnoreCase("yes") || in.nextLine().equalsIgnoreCase("y")){
            System.out.print(monsterName + ": Great! I don't think I caught your name. (enter your name): ");
            System.out.println();
            this.playerName = in.nextLine();
            System.out.println(monsterName + ": Well nice to meet you, " + playerName + ". ");
            System.out.println(monsterName + ": Let's play. You'll be X's and I'll be O's.");

            // Start the TicTacToe GUI
            TTT tictactoe = new TTT();
            tictactoe.setVisible(true);

            // Pause the dialogue while the GUI is on screen.

//            do {
//            } while (tictactoe.isVisible());

            //TODO - Write this code that will make the console wait until the GUI is closed. (System.exit(0))
            while (!wait){ //while wait == false
                continue;
            }

            if (tictactoe.playerXWin()) {
                tictactoe.jButtonExit.doClick();
                GameState.instance().setScore(100);
                System.out.println("100pts added. THIS IS THE CORRECT VERSION");
                System.out.println("Score: " + GameState.instance().getScore());
            } else {
                System.out.println("You didn't win. You didn't earn any points.");
            }

            // Once the GUI is closed, this will run.
            System.out.println(monsterName + ": 'Thanks, "+ playerName + ". Nobody ever wants to play with me. \n" +
                    "Everyone just walks right past me in Trinkle's basement, like I don't even exist! \n" +
                    "It's almost like these students can't even see me. Here's an extra 100 points for being nice to me.'");


            GameState.instance().setScore(100);
            System.out.println("100pts added");
            System.out.println("Score: " + GameState.instance().getScore());

        } else if (in.nextLine().equalsIgnoreCase("no") || in.nextLine().equalsIgnoreCase("n")){
            System.out.println(playerName + ": 'I don't have time for that right now.'");
            System.out.println(monsterName + ": 'Maybe next time.'");
            System.out.println();
        } else {
            System.out.println("Sorry, I can't understand your mumbling. I didn't want to play with you anyway.");
        }
    }

    public String getMonsterName(){
        return this.monsterName;
    }

    public void changeWaitStatus(boolean waitStatus){
        this.wait = waitStatus;
    }
}
