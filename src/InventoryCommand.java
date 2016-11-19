//test2
//package zeitz_borkv3;

import java.util.ArrayList;

/**
 * The type Inventory command.
 */
class InventoryCommand extends Command {

    /**
     * Instantiates a new Inventory command.
     */
    InventoryCommand() {
    }

    public String execute() {
        ArrayList<String> names = GameState.instance().getInventoryNames();
        if (names.size() == 0) {
            return "You are empty-handed.\n";
        }
        String retval = "You are carrying:\n";
        for (String itemName : names) {
            retval += "   A " + itemName + "\n";
        }
        return retval;
    }
}
