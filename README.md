# Employee Management System (Console Application)

A robust, console-based Employee Management System built in Java using Object-Oriented Programming (OOP) principles. The application includes input validation, secure administrator login, and automated CSV data persistence.

## 🚀 Features

- **Secure Admin Checkpoint**: Restricts system access behind a secure login terminal screen.
- **Full CRUD Operations**:
  - Add new employees with unique IDs.
  - Update specific details of existing employees (Name, Department, Phone, Salary).
  - Search for an employee instantly by their ID.
  - Delete records cleanly from the system.
  - View all employee records in a beautiful ASCII tabular format.
- **Fail-Safe Input Validation**: Prevents application crashes using robust exception handling (`try-catch`) for numerical inputs and specialized RegEx filters:
  - **Names & Departments**: Rejects numbers/symbols, enforces character lengths (2–50 characters).
  - **Phone Numbers**: Validates standard 10-digit mobile structures starting with digits 6–9.
  - **Salaries**: Enforces boundaries ensuring values sit within standard tiers (10,000 to 500,000).
- **Data Persistence (CSV Database)**: Automatically saves records to an external `employees.csv` file inside your operating system's local `Documents` directory. Data is preserved safely even after restarting the application.

---

## 🛠️ Project Architecture & Design

The codebase follows the **Separation of Concerns** principle by breaking the features down into highly modular, decoupled classes:

```text
JavaProject/
└── employee_management/
    ├── Employee.java          # Blueprints, getters/setters, and core data validation rules
    ├── DatabaseManager.java   # Core File I/O mechanics handling load and save routines 
    └── Main.java              # Interactive command-line UI loop and application entry point
````
🔒 Default Credentials
When launching the application, you will be prompted for an administrator login to enter the main control panel:

Username: `admin`

Password: `admin123`

⚙️ Prerequisites
Before compiling and running this project, ensure you have the following installed on your local machine:

Java Development Kit (JDK): Version 8 or higher.

A terminal or Command Prompt tool.

💻 How to Compile and Run
Follow these instructions to run the application using your terminal:

1. Open Terminal and Navigate to Project Directory
Navigate to the root directory folder sitting just outside the `employee_management` package:
```
Bash
cd /path/to/your/JavaProject
```
2. Compile All Source Files
Compile all three interdependent Java modules simultaneously using the Java compiler (`javac`):
```
DOS
javac employee_management/Employee.java employee_management/DatabaseManager.java employee_management/Main.java
```
3. Launch the Application
Execute the compiled bytecode from the fully qualified class file path package namespace:
```
DOS
java employee_management.Main
```
📂 Database Location
The persistence engine relies on dynamic tracking using Java's environment properties (`System.getProperty("user.home")`). Your database spreadsheet will be created safely without hitting directory permission locks at:

Windows:` C:\Users\<YourUsername>\Documents\employees.csv`

Mac/Linux: `/Users/<YourUsername>/Documents/employees.csv`

You can open this CSV file inside Microsoft Excel, Notepad, or any CSV parser tool to look at your saved records directly. Make sure to close it in Excel before modifying data inside the terminal app to prevent file lock crashes!
