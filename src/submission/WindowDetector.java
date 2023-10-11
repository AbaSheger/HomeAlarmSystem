
package submission;

import java.util.Random;

public class WindowDetector implements Detector {
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
    public boolean isActive() {  // return the current active status of the detector
        return isActive;
    }

    public boolean detect() {
        Random random = new Random();
        isDetecting = random.nextBoolean();
        return isDetecting;
    }

    @Override
    public void trigger() {  // Simulate Burglery through window
        System.out.println("Window broken or opened, burglary detected!");
    }

    @Override
    public void reset() {
        deactivate();
    }
    @Override
    public String getDetectorType() {
        return "WindowDetector";
    }
}
