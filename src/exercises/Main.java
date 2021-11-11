package exercises;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Apartment apartment1 = createApartment1();
        apartment1.enter();
    }

    public static Apartment createApartment1(){
        Room hallway = new Room("Hallway");
        Room workroom = new Room("Workroom");
        Room bedroom = new Room("Bedroom");
        Kitchen kitchen = new Kitchen();
        Bathroom bathroom = new Bathroom();

        ArrayList<Room> hallwayNeighbours= new ArrayList<Room>();
        hallwayNeighbours.add(workroom);
        hallwayNeighbours.add(bedroom);
        hallwayNeighbours.add(kitchen);
        hallwayNeighbours.add(bathroom);

        ArrayList<Room> workroomNeighbours = new ArrayList<Room>();
        workroomNeighbours.add(hallway);
        workroomNeighbours.add(bedroom);

        ArrayList<Room> bedroomNeighbours = new ArrayList<Room>();
        bedroomNeighbours.add(hallway);
        bedroomNeighbours.add(workroom);

        ArrayList<Room> kitchenNeighbours = new ArrayList<Room>();
        kitchenNeighbours.add(hallway);

        ArrayList<Room> bathroomNeighbours = new ArrayList<Room>();
        bathroomNeighbours.add(hallway);

        hallway.setNeighbours(hallwayNeighbours);
        workroom.setNeighbours(workroomNeighbours);
        bedroom.setNeighbours(bedroomNeighbours);
        kitchen.setNeighbours(kitchenNeighbours);
        bathroom.setNeighbours(bathroomNeighbours);

        Apartment apartment = new Apartment(hallway);
        apartment.extension(workroom);
        apartment.extension(bedroom);
        apartment.extension(kitchen);
        apartment.extension(bathroom);

        return apartment;
    }

}
