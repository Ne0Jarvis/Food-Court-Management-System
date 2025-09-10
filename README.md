# 🍴 Food Court Management System

A **Java Console Application** to efficiently manage a food court with Admin, Food Stall, and Customer portals.  
Users can manage stalls, menus, and search food stalls by type or ID. Perfect for learning **OOP concepts** and **Java programming**.

---

## 🚀 Features

### 🛡 Admin Portal
- Secure login (`username: admin`, `password: password`)  
- Add **single** or **multiple** food stalls  
- View all food stalls with menu details  
- Delete any food stall record  

### 🍔 Food Stall Portal
- Login with Stall ID & Password  
- Recover password using a **unique keyword**  
- View & modify stall profile  
- Manage menu:
  - Add new items  
  - Delete existing items  
  - View menu with prices  

### 👨‍🍳 Customer Portal
- View all food stalls and menus  
- Search by **Stall ID** or **Food Type**  
- Easily explore available dishes and prices  

---

## 🛠 Installation & Usage

### Requirements
- Java JDK 8 or higher  
- IDE or terminal to run Java programs
  
### Workflow

Launch the application

Choose a portal:

Admin Portal → Manage food stalls

Food Stall Portal → Login and manage menu/profile

Customer Portal → View/search stalls

Perform operations

Exit when done

🍽 Supported Food Types

South Indian

Continental

Chinese

Thailand

Multiple

📌 Notes

Maximum 10 menu items per stall (modifiable in code)

Password recovery available via unique keyword

Admin login is mandatory to manage stalls

🧑‍💻 Author

Yashasvi Singh
Java Console Project | Learning & Practice

🌟 Tech Stack

Java – Object-Oriented Programming

Console Application – CLI-based user interface

🎯 Future Enhancements

GUI version using JavaFX

Database integration (MySQL/SQLite)

Real-time search & sorting

Multiple customer profiles and orders tracking

### Compile & Run
```bash
javac FoodCourtManagementSystem.java
java FoodCourtManagementSystem

