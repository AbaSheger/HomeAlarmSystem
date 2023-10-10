package submission;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Alarm System Class
public class AlarmSystem {
    private List<Room> rooms;

    private List <MotionList>motions;
    //private Siren siren;
   // private SprinklerSystem sprinklerSystem;

    public AlarmSystem() {
        this.rooms = new ArrayList<>();
        this.motions = new ArrayList<>();
       // this.siren = new Siren();
        //this.sprinklerSystem = new SprinklerSystem();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addArea (MotionList motion ) {
        motions.add(motion);
    }


    public void activateAlarm() {

        for (Room room : rooms) {
            room.activateDetectors();
        }
        System.out.println("Alarm activated for all rooms.");
    }

    public void activateAlarmforMotions() {

        for (MotionList motion : motions) {
            motion.activateDetectors();
        }
        System.out.println("Alarm activated for all rooms.");
    }

    public void deactivateAlarm() {
        boolean smokeDetectorFound = false;
        for (Room room : rooms) {  //looking at the rooms
            room.deactivateDetectors();
            for (Detector detector : room.getDetectors()) {  //looking at the detectors
                if ("SmokeDetector".equals(detector.getDetectorType())) {
                    smokeDetectorFound = true;
                }
            }
        }
        System.out.println("Alarm deactivated for all rooms.");
        if (smokeDetectorFound) {
            System.out.println("Note: Smoke Detectors are always active.");
        }
    }

    public void deactivateAlarmForMotions() {
        boolean smokeDetectorFound = false;
        for (MotionList motion : motions) {  //looking at the rooms
            motion.deactivateDetectors();
            for (Detector detector : motion.getDetectors()) {  //looking at the detectors
                if ("SmokeDetector".equals(detector.getDetectorType())) {
                    smokeDetectorFound = true;
                }
            }
        }
        System.out.println("Alarm deactivated for all rooms.");
        if (smokeDetectorFound) {
            System.out.println("Note: Smoke Detectors are always active.");
        }
    }


    public void simulateFire() {
        // Randomly select a room to simulate fire
        //if alarm is not active,  tell the user to activate the alarm first
     /* SmokeDetector SimulationFireStop = new SmokeDetector();

     if (!SimulationFireStop.isActive()){
         System.out.println("Activate alarm First");
     }else {
        Room randomRoom = getRandomRoom();
        System.out.println("Simulating fire in " + randomRoom.getRoomName());
        randomRoom.triggerDetectors();
     } */

        // Check if any room has an active smoke detector
        /*boolean isAnySmokeDetectorActive = false;
        for (Room room : rooms) {
            for (Detector detector : room.getDetectors()) {  //
                if ("SmokeDetector".equals(detector.getDetectorType()) && detector.isActive()) {
                    isAnySmokeDetectorActive = true;
                    break;
                }
            }
            if (isAnySmokeDetectorActive) {
                break;
            }
        } */

       /* if (!isAnySmokeDetectorActive) {
            System.out.println("Activate alarm first.");
        } else { */
            Room randomRoom = getRandomRoom();
            System.out.println("Simulating fire in " + randomRoom.getRoomName());
            randomRoom.triggerDetectors();
            randomRoom.sirenON();
            randomRoom.sprinklerON();



    }

    public void simulateBurglary() {
        // Randomly select a room to simulate burglary

        Room randomRoom = getRandomRoom();
        System.out.println("Simulating burglary in " + randomRoom.getRoomName());
        randomRoom.triggerDetectors();
        randomRoom.sirenON();
    }

    public void simulateMovement() {
        // Randomly select a room to simulate movement
        MotionList randomMotionAreaOfDetection = getRandomMotionArea();
        System.out.println("Simulating movement in " + randomMotionAreaOfDetection.getAreaOfDetection());
        randomMotionAreaOfDetection .triggerDetectors();
        randomMotionAreaOfDetection .sirenON();
    }

    public void resetSystem() {
        // Deactivate all alarms and sprinklers
        deactivateAlarm();
        //sprinklerSystem.deactivate();
        System.out.println("System has been reset.");
    }

    private Room getRandomRoom() {
        Random random = new Random();
        int index = random.nextInt(rooms.size());
        return rooms.get(index);
    }

    private MotionList getRandomMotionArea() {
        Random random = new Random();
        int index2 = random.nextInt(motions.size());
        return motions.get(index2);
    }

}
