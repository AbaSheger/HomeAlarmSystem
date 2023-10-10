package submission;

import java.util.ArrayList;
import java.util.Random;

public class House {
    private ArrayList<Room> rooms;
    //private Siren siren;
    //private SprinklerSystem sprinklerSystem;

    private ArrayList<MotionList>motions;
    public House() {
        this.rooms = new ArrayList<>();
        this.motions= new ArrayList<>();
      //  this.siren = new Siren();
       // this.sprinklerSystem = new SprinklerSystem();
    }

    public Room createRoom(String roomName) {   //here we add all the detectors to the room array list
        //Room newRoom = new Room(roomName, siren, sprinklerSystem); //create instance of Room class

        Room newRoom = new Room(roomName);
       // Siren sharedResource1 = new Siren ();
       // SprinklerSystem sharedResource2 = new SprinklerSystem ();
        newRoom.addDetector(new SmokeDetector());
        newRoom.addDetector(new DoorDetector());
        newRoom.addDetector(new WindowDetector());
       // newRoom.addDetector(new MotionDetector());
        rooms.add(newRoom);
        return newRoom;
    }

  public MotionList createAreaForMotion (String areaOfDetection) {

        MotionList newAreaForMotion = new MotionList(areaOfDetection); //instance of the MotionList class
        newAreaForMotion.addDetector(new MotionDetector()); //add the string value to the list
        motions.add(newAreaForMotion);
        return newAreaForMotion;
  }


   /* public Room getRandomRoom() {
        Random random = new Random();
        return rooms.get(random.nextInt(rooms.size()));
    }

      public MotionList getRandomAreaForMotion() {
        Random random = new Random();
        return motions.get(random.nextInt(motions.size()));
    }*/

}

