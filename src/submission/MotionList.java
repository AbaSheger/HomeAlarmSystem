package submission;

import java.util.ArrayList;

public class MotionList {

    private ArrayList <Detector> motions = new ArrayList<>();

    private String areaOfDetection;


    public MotionList (String areaOfDetection) {
        this.areaOfDetection = areaOfDetection;

    }

    public void addDetector(Detector motion) {
        motions.add(motion);

    }

    public void activateDetectors() {
        for (Detector motion : motions) {
            motion.activate();
        }
    }

    public void deactivateDetectors() {
        for (Detector motion : motions) {
            motion.deactivate();
        }
    }

    public void sirenON() {
        System.out.println("Siren Activated");
    }

    public void sprinklerON () {
        System.out.println("Sprinkler Activated");
    }

    public void triggerDetectors() {

        // SprinklerSystem sprinkler= new SprinklerSystem();

        //Siren warningBell = new Siren();

        for (Detector motion: motions) {
            if (motion.detect()) {
                motion.trigger();
                if ("SmokeDetector".equals(motion.getDetectorType())) {
                    sprinklerON ();
                }

                sirenON();

            }
        }
    }



    public ArrayList<Detector> getDetectors() {
        return motions;
    }

    public String getAreaOfDetection () {

        return areaOfDetection;
    }
}
