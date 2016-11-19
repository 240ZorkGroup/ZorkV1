
//package zeitz_borkv3;

/**
 * The type Movement command.
 */
class MovementCommand extends Command {

    private String dir;


    /**
     * Instantiates a new Movement command.
     *
     * @param dir the direction
     */
    MovementCommand(String dir) {
        this.dir = dir;
    }

    public String execute() {
        Room currentRoom = GameState.instance().getAdventurersCurrentRoom();
        Room nextRoom = currentRoom.leaveBy(dir);
        if (nextRoom != null) {  // could try/catch here.
            GameState.instance().setAdventurersCurrentRoom(nextRoom);
            return "\n" + nextRoom.describe() + "\n";
        } else {
            return "You can't go " + dir + ".\n";
        }
    }
}
