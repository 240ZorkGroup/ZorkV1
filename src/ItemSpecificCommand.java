
//package zeitz_borkv3;

import java.util.ArrayList;

class ItemSpecificCommand extends Command {

    private String verb;
    private String noun;
    private String command;
    private int nums;


    ItemSpecificCommand(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public String execute() {

        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemInVicinityNamed(noun);
        } catch (Item.NoItemException e) {
            return "There's no " + noun + " here.";
        }

        String msg = itemReferredTo.getMessageForVerb(verb);

        /**
         * This part needs a switch, but also needs some kind of hashtable to process what is being "kicked"
         * and the consequences for doing so. When you kick the can, you are not harmed. If you kick the bomb, you are wounded, etc.
         */
        //TODO switch for ItemSpecificCommands
        ArrayList<String> events = itemReferredTo.getEventForVerb(verb);
        for (String evt : events) {
            if (evt.contains("(")) {
                String[] evt2 = evt.split("\\(");
                command = evt2[0];
                //nums = Integer.parseInt(evt2[1].substring(0, evt2[1].indexOf(")")));
                //mesages.put(command, verbParts[1]);                                        // puts the command and verb in "messages"
            } else {
                command = evt;
            }
            try {
                switch (verb) {
                    case "kick":
                        if (noun.equals("Bomb")) {
                            GameState.instance().wound(2);
                        }
                        break;
                    case "detonate":
                        if (noun.equals("Bomb")) {
                            GameState.instance().die();
                        }
                        break;
                    case "drink":
                        if (noun.equals("DrPepper")) {
                            try {
                                itemReferredTo.transform(GameState.instance().getDungeon().getItems().get("emptyCan")); //emptyCan
                            } catch (Item.NoItemException e) {
                                e.printStackTrace();
                            }
                            GameState.instance().wound(-1);
                            System.out.print("You were just wounded.");
                        }
                        break;
                    case "stomp":
                        if (noun.equals("emptyCan")) {
                            try {
                                itemReferredTo.transform(GameState.instance().getDungeon().getItems().get("squishedCan")); //emptyCan
                            } catch (Item.NoItemException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case "wave":
                        if (noun.equals("magicWand")) {
                            GameState.instance().setScore(5);
                            GameState.instance().teleport();
                        }
                    case "break":
                        if (noun.equals("magicWand")) {
                            GameState.instance().wound(10);
                            try {
                                GameState.instance().disappear(itemReferredTo);
                            } catch (Item.NoItemException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case "touch":
                        if (noun.equals("StarWarsToy")) {
                            GameState.instance().setScore(1);
                        }
                        break;
                    case "refill":
                        if (noun.equals("WawaTravelMug")) {
                            GameState.instance().win();
                        }
                        break;
                    case "eat":
                        if (noun.equals("donut")) {
                            try {
                                GameState.instance().disappear(itemReferredTo);
                            } catch (Item.NoItemException e) {
                                e.printStackTrace();
                            }
                            GameState.instance().wound(-2);
                        }
                        break;
                }
            } catch (java.util.InputMismatchException err) {
                System.out.println("\nINVALID!");
            }
        }

        return (msg == null ?
                "Sorry, you can't " + verb + " the " + noun + "." : msg) + "\n";
    }
}
