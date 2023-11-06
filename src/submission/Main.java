package submission;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        House house = new House();
        Room livingRoom = house.createRoom("Living Room");
        Room kitchen = house.createRoom("Kitchen");
        Room bedroom1 = house.createRoom("Bedroom1");
        Room bedroom2 = house.createRoom("Bedroom2");
        Room bedroom3 = house.createRoom("Bedroom3");
        Room bedroom4 = house.createRoom("Bedroom4");
        Room bedroom5 = house.createRoom("Bedroom5");
        Room garage = house.createRoom("Garage");
        Room hallway = house.createRoom("hallway");

        MotionList livingRoomMotion = house.createAreaForMotion("Living Room");
        MotionList poolAreaMotion = house.createAreaForMotion("PoolArea");
        MotionList hallwayMotion = house.createAreaForMotion("hallway");


        AlarmSystem homeSecurity = new AlarmSystem();
        homeSecurity.addRoom(livingRoom);
        homeSecurity.addRoom(kitchen);
        homeSecurity.addRoom(bedroom1);
        homeSecurity.addRoom(bedroom2);
        homeSecurity.addRoom(bedroom3);
        homeSecurity.addRoom(bedroom4);
        homeSecurity.addRoom(bedroom5);
        homeSecurity.addRoom(garage);
        homeSecurity.addRoom(hallway);


        homeSecurity.addArea(livingRoomMotion);
        homeSecurity.addArea(poolAreaMotion);
        homeSecurity.addArea(hallwayMotion );


        Scanner scanner = new Scanner(System.in);  //menu
        while (true) {
            System.out.println("1. Activate Alarm");
            System.out.println("2. Deactivate Alarm");
            System.out.println("3. Simulate Fire");
            System.out.println("4. Simulate Burglary");
            System.out.println("5. Simulate Movement at the pool or backyard");
            System.out.println("6. Reset System");
            System.out.println("7. Exit");
            System.out.print("Choose what you would like to do by entering a number: ");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    homeSecurity.activateAlarm();
                    break;
                case 2:
                    homeSecurity.deactivateAlarm();
                    break;
                case 3:
                    homeSecurity.simulateFire();
                    break;
                case 4:
                    homeSecurity.simulateBurglary();
                    break;
                case 5:
                    homeSecurity.simulateMovement();
                    break;
                case 6:
                    homeSecurity.resetSystem();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
