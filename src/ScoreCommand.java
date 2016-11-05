//package zeitz_borkv3;


class ScoreCommand extends Command {

    int score = 0;

    ScoreCommand() {
    }

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
