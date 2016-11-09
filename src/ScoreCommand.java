//package zeitz_borkv3;

/**
 * Score Command
 * @author Billy Andrews, Maryfay Jackson, Kelly Morgan
 * @date 20161107
 */

public class ScoreCommand extends Command {

    int score = 0;

    /*
    ScoreCommand Constructor
     */
    ScoreCommand() {
    }

    /**
     * execute
     * @return String - Gives feedback about the player's score.
     */
    public String execute() {
        score = GameState.instance().getScore();
        if (score == 0) {
            return "You haven't scored any points yet.\n";
        } else if (score < 100 && score > 0){
            return "Your score is okay.";
        } else if (score > 100) {
            return "Your score is great!";
        }
        return "";
    }
}
