package submission;

import java.util.ArrayList;

public class MotionList {
    private ArrayList<Detector> motions = new ArrayList<>();
    private String areaOfDetection;

    public MotionList(String areaOfDetection) {
        this.areaOfDetection = areaOfDetection;
    }

    public void addDetector(Detector motion) {
        motions.add(motion);
    }


    public void sirenON() {
        System.out.println("Siren Activated");
    }

    public void sprinklerON() {
        System.out.println("Sprinkler Activated");
    }

    public boolean triggerDetectors() {
        boolean motionDetected = false;
        for (Detector motion : motions) {
            if ("MotionDetector".equals(motion.getDetectorType()) && motion.detect()) {
                motionDetected = true;
                motion.trigger();
                sirenON();
            }
        }
        return motionDetected;
    }

    public ArrayList<Detector> getDetectors() {
        return motions;
    }

    public String getAreaOfDetection() {
        return areaOfDetection;
    }
}
