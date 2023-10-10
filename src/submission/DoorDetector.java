package submission;

// Door Detector Implementation
public class DoorDetector implements Detector {
    private boolean isActive = false;
    private boolean isDetecting = false;

    @Override
    public void activate() {  // activate the Door detector
        isActive = true;

    }

    @Override
    public void deactivate() {  // deactivate the Door detector
        isActive = false;
        //System.out.println("Alarm Deactivated");
    }

    @Override
    public boolean isActive() {  // return the current active status
        return isActive;
    }

    public boolean detect() {  // return the current detection status
        return isDetecting;
    }

    @Override
    public void trigger() {  // Simulate Burglery through Door
        System.out.println("door broken or opened, burglary detected");
    }

    public String getStatus() {  // report whether burglary is detected or not
        if (isActive && isDetecting) {
            return "door broken or opened, burglary detected";
        } else {
            return "no Suspicious activity at the door";
        }
    }

    @Override
    public String getDetectorType() {  // return the string type of the Detector type
        return "DoorDetector";
    }
}
