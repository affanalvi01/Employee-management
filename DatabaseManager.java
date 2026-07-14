package employee_management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String FILE_NAME = "C:/Users/DELL/Documents/employees.csv";

    // Static method to save the list to a CSV file
    public static void saveToFile(ArrayList<Employee> list) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Employee m : list) {
                writer.write(m.getID() + "," +
                             m.getname() + "," +
                             m.getdepartment() + "," +
                             m.getphoneNO() + "," +
                             m.getsalary() + "\n");
            }
        } catch (IOException e) {
            System.out.println("     Warning: Could not save employee data to disk: " + e.getMessage());
        }
    }

    // Static method to load data from the CSV file back into the list
    public static void loadFromFile(ArrayList<Employee> list) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] tokens = line.split(",");
                if (tokens.length == 5) {
                    Employee emp = new Employee();
                    
                    emp.setID(Integer.parseInt(tokens[0].trim()));
                    emp.setName(tokens[1].trim());
                    emp.setDepartment(tokens[2].trim());
                    emp.setphoneNO(tokens[3].trim());
                    emp.setsalary(Double.parseDouble(tokens[4].trim()));
                    
                    list.add(emp);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("     Warning: Error loading saved database: " + e.getMessage());
        }
    }
}