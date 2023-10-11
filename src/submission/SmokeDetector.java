package submission;

import java.util.Random;

public class SmokeDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {
        this.isActive = true;
    }

    @Override
    public void deactivate() {
        isActive = true;
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
        System.out.println("Smoke detected!");
    }

    @Override
    public void reset() {

    }

    @Override
    public String getDetectorType() {
        return "SmokeDetector";
    }
}
