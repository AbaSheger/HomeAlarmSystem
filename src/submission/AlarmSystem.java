package submission;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlarmSystem {
    private List<Room> rooms;
    private List<MotionList> motions;
    private boolean isActive = false;

    public AlarmSystem() {
        this.rooms = new ArrayList<>();
        this.motions = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addArea(MotionList motion) {
        motions.add(motion);
    }

    public void activateAlarm() {
        isActive = true;
        for (Room room : rooms) {
            room.activateDetectors();
        }
        System.out.println("Alarm activated for all rooms.");
    }


    public void deactivateAlarm() {
        isActive = false;
        for (Room room : rooms) {
            room.deactivateDetectors();
        }
        System.out.println("Alarm deactivated for all rooms.");
        System.out.println("Note: Smoke Detectors are always active.");
    }



    public void simulateFire() {
        Room randomRoom = getRandomRoom();
        if (!isActive) {
            System.out.println("Alarm system is not active. Activate the system first.");
            return;
        }
        System.out.println("Simulating fire in " + randomRoom.getRoomName());
        if (randomRoom.triggerDetectorsForFire()) {
            System.out.println("Smoke detected in " + randomRoom.getRoomName());
            randomRoom.sirenON();
            randomRoom.sprinklerON();
        }
    }

    public void simulateBurglary() {
        Room randomRoomForBurglary = getRandomRoom();
        if (!isActive) {
            System.out.println("Alarm system is not active. Activate the system first.");
            return;
        }
        System.out.println("Simulating burglary in " + randomRoomForBurglary.getRoomName());
        if (randomRoomForBurglary.triggerDetectorsForBurglary()) {
            System.out.println("Burglary detected in " + randomRoomForBurglary.getRoomName());
            randomRoomForBurglary.sirenON();
        }
    }


    public void simulateMovement() {
        MotionList poolAreaOfDetection = null;

        for (MotionList motion : motions) {
            if ("PoolArea".equals(motion.getAreaOfDetection())) {
                poolAreaOfDetection = motion;
                break;
            }
        }

        if (poolAreaOfDetection == null) {
            System.out.println("Pool area not found.");
            return;
        }

        if (!isActive) {
            System.out.println("Alarm system is not active. Activate the system first.");
            return;
        }
        System.out.println("Simulating movement in " + poolAreaOfDetection.getAreaOfDetection());
        if (poolAreaOfDetection.triggerDetectors()) {
            System.out.println("Motion detected and siren activated in " + poolAreaOfDetection.getAreaOfDetection());
        } else {
            System.out.println("No motion detected in " + poolAreaOfDetection.getAreaOfDetection());
        }
    }



    public void resetSystem() {
        for (Room room : rooms) {
            for (Detector detector : room.getDetectors()) {
                if (!"SmokeDetector".equals(detector.getDetectorType())) {
                    detector.reset();
                }
            }
        }
        for (MotionList motionArea : motions) {
            for (Detector detector : motionArea.getDetectors()) {
                if (!"SmokeDetector".equals(detector.getDetectorType())) {
                    detector.reset();
                }
            }
        }
        System.out.println("System has been reset.");
    }


    public Room getRandomRoom() {
        Random random = new Random();
        int index = random.nextInt(rooms.size());
        return rooms.get(index);
    }

    public MotionList getRandomMotionArea() {
        Random random = new Random();
        int index2 = random.nextInt(motions.size());
        return motions.get(index2);
    }
}
