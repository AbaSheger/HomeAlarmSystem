package submission;

import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList<Detector> detectors;

    public Room(String roomName) {
        this.roomName = roomName;
        this.detectors = new ArrayList<>();
    }

    public void addDetector(Detector detector) {
        detectors.add(detector);
    }

    public void activateDetectors() {
        for (Detector detector : detectors) {
            detector.activate();
        }
    }

    public void deactivateDetectors() {
        for (Detector detector : detectors) {
            detector.deactivate();
        }
    }

    public void sprinklerON() {
        System.out.println("Sprinkler Activated");
    }

    public void sirenON() {
        System.out.println("Siren Activated");
    }

    public boolean triggerDetectorsForBurglary() {
        boolean detectionOccurred = false;
        for (Detector detector : detectors) {
            String type = detector.getDetectorType();
            if ("MotionDetector".equals(type) || "DoorDetector".equals(type) || "WindowDetector".equals(type)) {
                if (detector.detect()) {
                    detectionOccurred = true;
                    detector.trigger();
                    break;
                }
            }
        }
        return detectionOccurred;
    }

    public boolean triggerDetectorsForFire() {
        boolean detectionOccurred = false;
        for (Detector detector : detectors) {
            if ("SmokeDetector".equals(detector.getDetectorType())) {
                if (detector.detect()) {
                    detectionOccurred = true;
                    detector.trigger();
                }
            }
        }
        return detectionOccurred;
    }

    public ArrayList<Detector> getDetectors() {
        return detectors;
    }

    public String getRoomName() {
        return roomName;
    }
}
