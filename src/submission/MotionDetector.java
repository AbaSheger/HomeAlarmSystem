package submission;

import java.util.Random;

public class MotionDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {
        isActive = true;

    }

    @Override
    public void deactivate() {  // deactivate motion detector
        isActive = false;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean detect() {
        Random random = new Random();
        isDetecting = random.nextBoolean();
        return isDetecting;
    }

    @Override
    public void trigger() {
        System.out.println("Motion Detected");
    }

    @Override
    public void reset() {
        deactivate();
    }
    @Override
    public String getDetectorType() {
        return "MotionDetector";
    }



}
