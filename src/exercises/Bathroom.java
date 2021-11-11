package exercises;

import java.util.ArrayList;

import static java.lang.System.out;

public class Bathroom extends Room{
    private boolean shower;


    public Bathroom(){
        super("Bathroom");
        shower = false;
    }
    public Bathroom(ArrayList<Room> neighbours){
        super("Bathroom", neighbours);
        shower = false;
    }

    public boolean getShower() {
        return shower;
    }

    public void switchShower(){
        shower = !shower;
        if (shower){
            out.println("Switched shower on.");
        }
        else{
            out.println("Switched shower out.");
        }
    }

    @Override
    public void enter() {
        //as long as the user didn´t leave the room it
        do {
            printInitialText();
            //attach 4th option
            out.println("4) Switch shower.");

            switch (getUserInput(4)){
                case "1":
                    switchLight();
                    break;

                case "2":
                    //leave the current Room and return to the previous room
                    return;

                case "3":
                    enterNeighbour();
                    break;
                case "4":
                    switchShower();
                    break;
            }
        }while(true);
    }

}
