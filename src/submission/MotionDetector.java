package submission;

public class MotionDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {  // activate motion detector
        isActive = true;

    }

    @Override
    public void deactivate() {  // deactivate motion detector
        isActive = false;
    }

    @Override  // return the current active status
    public boolean isActive() {
        return isActive;
    }

    @Override  // return the current detection status
    public boolean detect() {
        return isDetecting;
    }

    @Override  // simulate Movement in the pool(backyard)
    public void trigger() {
        System.out.println("door broken or opened, burglary detected");
    }

    @Override  // report whether "Motion Detected" or "No Motion detected"
    public String getStatus() {
        if (isActive && isDetecting) {
            return "Motion detected";
        } else {
            return "no movement detected";
        }
    }

    @Override  // return the string type of the detector type
    public String getDetectorType() {
        return "MotionDetector";
    }



}
