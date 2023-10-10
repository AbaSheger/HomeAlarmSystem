
package submission;

public class WindowDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {  // activate the Window Detector
        isActive = true;

    }

    @Override
    public void deactivate() {  // deactivate the window Detector
        isActive = false;

    }

    @Override
    public boolean isActive() {  // return the current active status of the detector
        return isActive;
    }

    public boolean detect() {  // return the current detection status
        return isDetecting;
    }

    @Override
    public void trigger() {  // Simulate Burglery through window
        System.out.println("window broken or opened, burglary detected");
    }

    public String getStatus() {  // report whether burglary is detected or not
        if (isActive && isDetecting) {
            return "window broken or opened, burglary detected";
        } else {
            return "no Suspicious activity at the window";
        }
    }

    @Override  // return the string type of the Detector type
    public String getDetectorType() {
        return "WindowDetector";
    }
}
