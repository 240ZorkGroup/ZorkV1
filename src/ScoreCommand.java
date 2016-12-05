//package zeitz_borkv3;

/**
 * Score Command
 * @author Billy Andrews, Maryfay Jackson, Kelly Morgan
 * @date 20161107
 */

class ScoreCommand extends Command {

    int score = GameState.instance().getScore();

    /**
     * Constructs a score command with the initial score of zero.
     */
    ScoreCommand() {
    }

    /**
     * Execute method runs the command.
     * @return Respective message according to the player's score.
     */
    public String execute() {
        if (score == 0) {
            return "Score: " +score +" - You haven't scored any points yet.\n";
        } else if (score < 100 && score > 0){
            return "Score: " +score +" - Your score is okay.";
        } else if (score > 100) {
            return "Score: " +score +" - Your score is great!";
        }
        return "";
    }
}
