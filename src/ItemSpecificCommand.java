
//package zeitz_borkv3;


import java.util.ArrayList;

/**
 * The type Item specific command.
 */
class ItemSpecificCommand extends Command {

    private String verb;
    private String noun;
    private int lightTurns = 10;


    /**
     * Instantiates a new Item specific command.
     *
     * @param verb the verb
     * @param noun the noun
     */
    ItemSpecificCommand(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public String execute() {

        Item itemReferredTo;
        try {
            itemReferredTo = GameState.instance().getItemInVicinityNamed(noun);
        } catch (Item.NoItemException e) {
            return "There's no " + noun + " here.";
        }

        String msg = itemReferredTo.getMessageForVerb(verb);
        String command;
        String paramsString;
        int nums = 0;

        // switch for ItemSpecificCommands
        ArrayList<String> events = itemReferredTo.getEventForVerb(verb);
        if (events != null) {
            for (String evt : events) {
                //System.out.println(" - EVENT: " + evt);                                                        // TODO PrintLine
                if (evt.contains("(")) {                                                        // If the event contains a "("
                    String[] evt2 = evt.split("\\(");                                           // Split that up
                    command = evt2[0];                                                          // Command is the first part
                    paramsString = evt2[1].substring(evt2[1].indexOf("(") + 1, evt2[1].indexOf(")")); // numString is the string of numbers inside the "()"
                    if (isInteger(paramsString)) {
                        nums = Integer.parseInt(paramsString);                                         // turns numString into a nums int
                    } else {
                        nums = 0;
                    }
                } else {
                    command = evt;
                    paramsString = "";
                }

                switch (command) {
                    case "Wound":
                        GameState.instance().wound(nums);
                        break;
                    case "Die":
                        GameState.instance().die();
                        break;
                    case "Win":
                        GameState.instance().win();
                        break;
                    case "Disappear":
                        try {
                            GameState.instance().disappear(itemReferredTo);
                        } catch (Item.NoItemException e) {
                            System.out.println("That item is already non-existent, therefore it cannot disappear.");
                        }
                    case "Teleport":
                        GameState.instance().teleport();
                        break;
                    case "Score":
                        GameState.instance().setScore(nums);
                        break;
                    case "Transform":
                        try {
                            itemReferredTo.transform(GameState.instance().getDungeon().getItems().get(paramsString));
                        } catch (Item.NoItemException e) {
                            System.out.println("That item is not available for transformation.");
                        }
                }
            }
        }
        if (verb.equalsIgnoreCase("switch")) {
            GameState.instance().getAdventurersCurrentRoom().lightOn();
            while (lightTurns != 0) {
                lightTurns = lightTurns - 1;
                if (lightTurns == 0)
                    System.out.println("Your torch ran out.");
            }

            /*
            Room descRoom = currentRoom.setDesc("This is a well-lit, albeit cluttered office, with many geeky toys sprawling on a desk.");
            descRoom.lightOn(); //it gets the desc before it can be reset?
            if (currentRoom.equals(GameState.instance().getAdventurersCurrentRoom().describe())) {
            if (currentRoom.equals("Stephen's office"))
            System.out.println("Hey it used this one!");
            }
            */
        }

        return (msg == null ?
                "Sorry, you can't " + verb + " the " + noun + "." : msg) + "\n";
    }


    private static boolean isInteger(String s) {
        boolean isInt = false;
        try {
            Integer.parseInt(s);
            isInt = true;
        } catch (NumberFormatException ex) {
            //System.out.println("Not a number");
        }
        return isInt;
    }
}
