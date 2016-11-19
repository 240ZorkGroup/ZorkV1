//test2
//package zeitz_borkv3;

/**
 * Health Command displays the health message pertaining to the player's health.
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
class HealthCommand extends Command {

    int health;

    /**
     * Constructor for HealthCommand creates a healthcommand with full life.
     */
    HealthCommand() {
        this.health = GameState.instance().getHealth();
    }


    /**
     * Execute method runs the command
     * @return Respective message according to the player's health.
     */
    public String execute() {
        health = GameState.instance().getHealth();
        if (health == 100) {
            return health + "% - You're in tip-top shape!\n";
        } else if (health < 100 && health > 10) {
            return health + "% - Your health is depleting.";
        } else if (health < 10) {
            return health + "$ - You are about to die.";
        }
        return "";
    }
}
