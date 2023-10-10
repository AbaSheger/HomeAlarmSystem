package submission;
public class SmokeDetector implements Detector {
        private boolean isActive = false;
        private boolean isDetecting = false;

        @Override
        public void activate() {  //activate the smoke detector
            isActive = true;

        }
        @Override
        public void deactivate() {

            isActive=true;
        }
        @Override
        public boolean isActive() {  //return the current active status
            return isActive;

        }

        @Override
        public boolean detect() {  //return the current detection status

            return isDetecting;

        }

        @Override
        public void trigger() {   // Simulate the detection of smoke

            System.out.println("Smoke detected!");
        }

        @Override
        public String getStatus() {    //report whether a smoke is detected or not
            if (isActive && isDetecting) {
                return "Smoke detected";
            } else {
                return "No smoke detected";
            }
        }

        @Override
        public String getDetectorType() {  //return the string type of the Detector type
            return "SmokeDetector";
        }
    }


