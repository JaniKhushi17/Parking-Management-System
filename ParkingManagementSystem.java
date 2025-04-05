//Parking Management System

import java.util.*;

class ParkingSpot{
    int spotNumber;
    boolean isOccupied;
    String vehicleLicensePlate;

    ParkingSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.vehicleLicensePlate = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void occupySpot(String licensePlate){
        this.isOccupied = true;
        this.vehicleLicensePlate = licensePlate;
    }

    public void vacantSpot(String licensePlate){
        this.isOccupied = false;
        this.vehicleLicensePlate = null;
    }
    
}

class Vehicle{
    String licensePlate;
    String companyName;

    public Vehicle(String licensePlate, String companyName){
        this.licensePlate = licensePlate;
        this.companyName = companyName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCompanyName() {
        return companyName;
    }
}

class ParkingLot {
    LinkedList<ParkingSpot> parkingSpots;
    HashMap<String,ParkingSpot> occupiedSpots;
    PriorityQueue<ParkingSpot> availableSpots;
    

    public ParkingLot(int numberOfSpots){
        parkingSpots = new LinkedList<>();
        occupiedSpots = new HashMap<>();
        availableSpots = new PriorityQueue<>(numberOfSpots, Comparator.comparingInt(ParkingSpot :: getSpotNumber));
    

        for(int i = 1; i <= numberOfSpots; i++){
            ParkingSpot spots = new ParkingSpot(i);
            parkingSpots.add(spots);
            availableSpots.add(spots);
        }

    }

    public boolean parkVehicle(Vehicle vehicle){
        ParkingSpot spots = availableSpots.poll();
        if(spots != null){
            spots.occupySpot(vehicle.getLicensePlate());
            occupiedSpots.put(vehicle.getLicensePlate(), spots);
            System.out.println("The Vehicle has been Parked!!");
            return true;
        }
        else{
            System.out.println("There are no available Spots for Parking");
            return false;
        }
    }

    public boolean leaveParking(String licensePlate){
        ParkingSpot spots = occupiedSpots.get(licensePlate);
        if(spots != null){
            spots.vacantSpot(licensePlate);
            availableSpots.add(spots);
            occupiedSpots.remove(licensePlate);
            System.out.println("The Vehicle has been removed!!");
            return true;
        }
        else{
            System.out.println("Vehicle Not Found or not yet Parked");
            return false;
        }

    }

    public void printOccupiedSpots(){
        System.out.println("Occupied Spots : ");
        for(ParkingSpot spots : parkingSpots){
            if(spots.isOccupied()){
                System.out.println("Spot "+ spots.getSpotNumber() + ":" + spots.getVehicleLicensePlate());
            }
        }
    }

    public void setPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password: ");
            String pass = sc.nextLine();
            if(pass.equals("Worker1234")){
                System.out.println("You have been successfully logined");
                System.out.println();
            }
            else{
                System.out.println("Please enter Valid Password");
                setPassword();
            }
    }
}

class ParkingManagementSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.println("Enter the number of Spots :");
        int numberOfSpots = 2;
        ParkingLot parkingLot = new ParkingLot(numberOfSpots);

        System.out.println("WELCOME TO PARKING MANAGEMENT SYSTEM");
        while(true){
            System.out.println("1. Login");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Leave Parking");
            System.out.println("4. Print Occupied Spots");
            System.out.println("5. Print Receipt of Parking");
            System.out.println("6. Logout/Exit");

            System.out.println("Enter your Choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 :
                System.out.println("----- LOGIN -----"); 
                System.out.println("Enter E-Mail Id:");
                String eMail = sc.nextLine();
                parkingLot.setPassword();
                break;

                case 2 :
                System.out.println("Enter License Plate :");
                String licensePlate = sc.nextLine();
                System.out.println("Enter Company Name :");
                String companyName = sc.nextLine();
                Vehicle vehicle = new Vehicle(licensePlate, companyName);
                boolean parked = parkingLot.parkVehicle(vehicle);
                System.out.println(parked ? "Vehicle Parked Successfully." : "No Available Spots.");
                break;

                case 3 :
                System.out.println("Enter License Plate :");
                String leaveLicensePlate = sc.nextLine();
                boolean left = parkingLot.leaveParking(leaveLicensePlate);
                System.out.println(left ? "Vehicle Left Successfully." : "Vehicle not found or not parked.");
                break;

                case 4:
                parkingLot.printOccupiedSpots();
                break;

                case 5:
                System.out.println("Printing the Receipt of Users");
                

                case 6:
                sc.close();
                return;

                default :
                System.out.println("Invalid Choice!!");
                System.out.println("Please try again");
                

            }
        }
    }
}
