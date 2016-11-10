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
                "'Don't be alarmed!!' it shouted. 'I only want to play a game with you. \n" +
                "It gets lonely in this dungeon of a basement... My name is " + monsterName + ".'\n\n" +
                "The beast seems harmless.\n");

        System.out.println("'So what do you say? A quick game of Tic-Tac-Toe?'");

        if (in.nextLine().equalsIgnoreCase("yes") || in.nextLine().equalsIgnoreCase("y")){
            System.out.println(monsterName + ": 'Great! I don't think I caught your name: '");
            this.playerName = in.nextLine();
            System.out.println(monsterName + ": Well nice to meet you, " + playerName + ". ");

            // Start the TicTacToe GUI
            TTT tictactoe = new TTT();
            tictactoe.setVisible(true);

            // Result of winning/losing
            if (tictactoe.playerOWin())
                GameState.instance().setScore(100);
            else
                GameState.instance().setScore(-100);

            System.out.println("Score: " + GameState.instance().getScore());
            // Need to wait until the came is complete, then check to see who won and return a proper response.



        } else {
            System.out.println("'I don't have time for that,' you reply.");
            System.out.println("'Maybe next time.'");
            System.out.println();
        }
    }

    public String getMonsterName(){
        return this.monsterName;
    }


}
