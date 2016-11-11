import java.util.Scanner;

/**
 * NPC - Non-Player Characters
 * This class provides an NPC that the player can interact with.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
public class NPC {

    Scanner in = new Scanner(System.in);

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
    //TODO write method.
    public void converse(){

        System.out.println("As you were examining the room, an ugly beast appears. \n" +
                "Frightened, you reach for anything to use as a weapon. \n\n" +
                monsterName + ": 'Don't be alarmed! I only want to play a game with you.' \n" +
                monsterName + ": 'It gets lonely in this dungeon of a basement... My name is " + monsterName + ".'\n\n" +
                "The beast seems harmless...\n");

        System.out.println(monsterName + ": 'So what do you say? A quick game of Tic-Tac-Toe?' (y/n): ");

        if (in.nextLine().equalsIgnoreCase("yes") || in.nextLine().equalsIgnoreCase("y")){
            System.out.println(monsterName + ": 'Great! I don't think I caught your name: '");
            this.playerName = in.nextLine();
            System.out.println(monsterName + ": Well nice to meet you, " + playerName + ". ");

            // Start the TicTacToe GUI
            TTT tictactoe = new TTT();
            tictactoe.setVisible(true);

            // Pause the dialogue while the GUI is on screen.
            do {
            } while (tictactoe.isVisible());

            // Once the GUI is closed, this will run.
            System.out.println(monsterName + ": 'Thanks, "+ playerName + ". Nobody ever wants to play with me. \n" +
                    "Everyone just walks right past me in Trinkle's basement, like I don't even exist! \n" +
                    "It's almost like these students can't even see me. Here's an extra 100 points for being nice to me.'");


            GameState.instance().setScore(100);
            System.out.println("100pts added");
            System.out.println("Score: " + GameState.instance().getScore());

        } else {
            System.out.println("You: 'I don't have time for that right now.'");
            System.out.println(monsterName + ": 'Maybe next time.'");
            System.out.println();
        }
    }

    public String getMonsterName(){
        return this.monsterName;
    }


}
