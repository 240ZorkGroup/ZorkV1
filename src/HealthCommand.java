//package zeitz_borkv3;


class HealthCommand extends Command {

    int health = 100;

    HealthCommand() {
    }

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
