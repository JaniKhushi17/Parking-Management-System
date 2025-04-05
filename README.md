# 🚗 Parking Management System

A simple **Java-based console application** to manage parking slots, vehicles, and user login. It simulates the basic functionalities of a real-world parking lot.

---

## 🛠 Features

- Login system with password verification
- Park a vehicle by providing license plate and company name
- Leave parking and free up the spot
- View list of currently occupied parking spots
- Generate a basic parking receipt (placeholder)
- Allocates parking based on lowest numbered available spot (priority)

---

## 💻 Technologies Used

- Java (Core)
- Object-Oriented Programming (OOP)
- Data Structures: `HashMap`, `LinkedList`, `PriorityQueue`

---

## 🧩 Components

### 1. `ParkingSpot`
- Represents each parking space
- Attributes: `spotNumber`, `isOccupied`, `vehicleLicensePlate`

### 2. `Vehicle`
- Represents a vehicle to be parked
- Attributes: `licensePlate`, `companyName`

### 3. `ParkingLot`
- Manages all parking logic, login system, and spot tracking

### 4. `ParkingManagementSystem` (Main Class)
- Command-line interface with options for parking, leaving, and displaying occupied spots

---

## 🔐 Login System

- User is prompted to enter their email and password
- The default password is `Worker1234`
- If incorrect, the system recursively asks for the correct password

---

## 🚀 How to Run

1. Save the code in a file named `ParkingManagementSystem.java`
2. Open terminal/command prompt
3. Compile the code:
   ```bash
   javac ParkingManagementSystem.java
   ```
4. Run the program:
```bash
java ParkingManagementSystem
```


## 📋 Sample Output
```bash
WELCOME TO PARKING MANAGEMENT SYSTEM
1. Login
2. Park Vehicle
3. Leave Parking
4. Print Occupied Spots
5. Print Receipt of Parking
6. Logout/Exit
Enter your Choice:
```

✅ Future Improvements
--> Store parking history and generate actual parking receipts <br>
--> Email-based user verification or login sessions <br>
--> Calculate parking charges based on time duration <br>
--> GUI interface using Java Swing or JavaFX <br>
--> Persistent storage using files or database integration

📄 License <br>
--> This project is open-source and available under the MIT License.


