package exercises;

import java.util.ArrayList;
import static java.lang.System.out;

public class Apartment {
    protected ArrayList<Room> rooms;
    protected Room entrance;

    public Apartment(Room hallway){
        rooms = new ArrayList<Room>();
        rooms.add(hallway);
        entrance = hallway;
    }

    public void enter(){
        //start at the enter() Method of the room hallway
        entrance.enter();

        //this code is reached if the Hallway is left
        //printing the warnings
        for (Room r : rooms){
            if (r.getLightning()){
                out.println("WARNING: Light in the " + r.getName() + " is still on!");
            }
            if (r instanceof Kitchen){
                if (((Kitchen) r).getStove()){
                    out.println("WARNING: Stove in the " + r.getName() + " is still on!");
                }
            }
            else if (r instanceof Bathroom){
                if (((Bathroom) r).getShower()){
                    out.println("WARNING: Shower in the " + r.getName() + " is still on!");
                }
            }
        }
    }

    public void extension(Room newRoom){
        rooms.add(newRoom);
    }
}
