//test
//package zeitz_borkv3;

/**
 * DropCommand drops an item from the player's inventory
 *
 * @author Billy Andrews, Kelly Morgan, Maryfay Jackson
 * @version 20161109
 */
class DropCommand extends Command {

    private String itemName;

    /**
     * Constructor for DropCommand
     *
     * @param itemName Item that you want to be dropped.
     */
    DropCommand(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Execute method runs the command.
     * @return Visual confirmation that the item has been dropped from the player's inventory.
     */
    public String execute() {
        if (itemName == null || itemName.trim().length() == 0) {
            return "Drop what?\n";
        }
        try {
            Item theItem = GameState.instance().getItemFromInventoryNamed(
                itemName);
            GameState.instance().removeFromInventory(theItem);
            GameState.instance().getAdventurersCurrentRoom().add(theItem);
            return itemName + " dropped.\n";
        } catch (Item.NoItemException e) {
            return "You don't have a " + itemName + ".\n";
        }
    }
}
