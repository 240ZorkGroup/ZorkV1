//test2
//package zeitz_borkv3;

/**
 * Health Command displays the health message pertaining to the player's health.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
class SpeakCommand extends Command {

    private String noun;

    /**
     * Constructor for HealthCommand creates a healthcommand with full life.
     */
    SpeakCommand(String noun) {
        this.noun = noun;
    }


    /**
     * Execute method runs the command
     * @return Respective message according to the player's health.
     */
    public String execute() throws NPC.NoNPCException {
        GameState.instance().getAdventurersCurrentRoom().getNPCNamed(noun).converse();
        return "";
    }
}
