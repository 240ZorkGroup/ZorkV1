/**
 * NPC - Non-Player Characters
 * This class provides an NPC that the player can interact with.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
public class NPC {

    private String name;
    /**
     * Constructor class for NPCs will create a named NPC class.
     * @param n The name of the NPC. Choose whatever you want.
     */
    public NPC(String n){
        this.name = n;
    }

    /**
     * Converse method allows the player to hold a conversation with the NPC.
     */
    //TODO write method.
    public void converse(){

        System.out.println("Hey! This is where the NPC Speaks!");
    }


}
