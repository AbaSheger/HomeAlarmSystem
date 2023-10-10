package submission;

import java.util.ArrayList;


public class Room {
        private String roomName;
        private ArrayList<Detector> detectors;

      //private void Siren siren;
        //private void SprinklerSystem sprinklerSystem;
/*
        public Room(String roomName, Siren siren, SprinklerSystem sprinklerSystem) {
            this.roomName = roomName;
            //this.siren = siren;
           // this.sprinklerSystem = sprinklerSystem;
            this.detectors = new ArrayList<>();
        } */

    public Room(String roomName ) {
        this.roomName = roomName;
        //this.siren = siren;
        // this.sprinklerSystem = sprinklerSystem;
        this.detectors = new ArrayList<>();
    }

        public void addDetector(Detector detector) {
            detectors.add(detector);
        }

        public void activateDetectors() {
            for (Detector detector : detectors) {
                detector.activate();
            }
        }

        public void deactivateDetectors() {
            for (Detector detector : detectors) {
                detector.deactivate();
            }
        }

    public void sprinklerON () {
        System.out.println("Sprinkler Activated");
    }

   /*public void sprinklerOff() {
        System.out.println("Sprinkler Deactivated");
    } */


    public void sirenON() {
        System.out.println("Siren Activated");
    }

   /* public void sirenOff() {
        System.out.println("Siren Deactivated");
    } */
        public void triggerDetectors() {

          // SprinklerSystem sprinkler= new SprinklerSystem();

           //Siren warningBell = new Siren();

            for (Detector detector : detectors) {
                if (detector.detect()) {
                    detector.trigger();
                    if ("SmokeDetector".equals(detector.getDetectorType())) {
                        sprinklerON ();
                    }
                    //warningBell.activate();
                    //sirenOff();
                    sirenON();

                }
            }
        }
        public ArrayList<Detector>getDetectors() {

            return detectors;
        }

        public String getRoomName() {
            return roomName;
        }

    }
