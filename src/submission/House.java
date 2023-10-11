package submission;

import java.util.ArrayList;


public class House {
    private ArrayList<Room> rooms;


    private ArrayList<MotionList>motions;
    public House() {
        this.rooms = new ArrayList<>();
        this.motions= new ArrayList<>();

    }

    public Room createRoom(String roomName) {

        Room newRoom = new Room(roomName);
        newRoom.addDetector(new SmokeDetector());
        newRoom.addDetector(new DoorDetector());
        newRoom.addDetector(new WindowDetector());
        rooms.add(newRoom);
        return newRoom;
    }

  public MotionList createAreaForMotion (String areaOfDetection) {

        MotionList newMotionDetectionArea = new MotionList(areaOfDetection);
        newMotionDetectionArea.addDetector(new MotionDetector());
        motions.add(newMotionDetectionArea);
        return newMotionDetectionArea;
  }




}

