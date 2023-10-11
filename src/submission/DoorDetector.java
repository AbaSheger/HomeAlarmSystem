package submission;

import java.util.Random;

public class DoorDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {
        isActive = true;
    }

    @Override
    public void deactivate() {
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
        System.out.println("Door broken or opened, burglary detected!");
    }


    @Override
    public void reset() {
        deactivate();
    }

    @Override
    public String getDetectorType() {
        return "DoorDetector";
    }
}
