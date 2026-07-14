package employee_management;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
     private static ArrayList<Employee>list=new ArrayList<>();
    private static Scanner sc=new Scanner (System.in);
    
    
    public static void main(String[] args) {
		login();
		DatabaseManager.loadFromFile(list);
		
    	
        while(true){
	     System.out.println("\n===== Employee Employeement System =====");
             System.out.println("     1.Add Employee");
             System.out.println("     2.Update details of Employee");
             System.out.println("     3.Show details of all Employee ");
             System.out.println("     4.Delete Employee ");
             System.out.println("     5.Search Employee ");
             System.out.println("     0.Exit");
             System.out.println();
             int x = readValidInt("     Enter a choice: ");
          
          switch (x) {
              case 1:addemployee();
                  break;    			
              case 2:updateEmployee();
                  break;
              case 3:showAllEmployees();
                  break;  
              case 4:deleteEmployee();
              		break;
	      case 5:searchEmployee();
			break;
              case 0:System.out.println("     Exiting program...");
              System.exit(0);

              default:
                  System.out.println("     Invalid Choice!\n");
                  System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
                  break;
          }
        }
        
      
      }


    private static void login() {
        int attempts = 3;
        System.out.println("\n================================================");
        System.out.println("            ADMINISTRATOR LOGIN                 ");
        System.out.println("================================================");

        while (attempts > 0) {
            System.out.print("     Enter Admin Username: ");
            String username = sc.nextLine().trim();
            int id = readValidInt("     Enter Admin ID: ");

            
            if (username.equalsIgnoreCase("admin") && id == 1234) {
                System.out.println("\n     Login Successful! Welcome, Administrator.");
                System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
                return; 
            }

            
            attempts--;
            if (attempts > 0) {
                System.out.println("\n     Error: Invalid Admin Username or ID.");
                System.out.println("     You have " + attempts + " attempt(s) remaining.\n");
                System.out.println("------------------------------------------------");
            } else {
                System.out.println("\n     Error: Too many failed login attempts. Exiting system...");
                System.exit(0);
            }
        }
    }


  
    private static void addemployee(){
    int n = readValidInt("     How many members you want to add: ");
    for(int i=1;i<=n;i++){
      Employee m=new Employee();
	  while (true) {
            ID = readValidInt("     Enter ID: ");
            
            
            if (findEmployeeById(ID) != null) {
                System.out.println("     Error: Employee with ID " + ID + " already exists. Please try another ID.");
                System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
            } else {
                
                break; 
            }
        }
  	
  	 m.setID(id);
  	 
        readValidString("     Enter name: ", m, "name");
        readValidString("     Enter Department: ", m, "department");
        readValidString("     Enter Mobile No.: ", m, "phone");        
        readValidSalary("     Enter salary: ", m);  
       
        list.add(m);
	DatabaseManager.saveToFile(list);
        System.out.println("\n     Employee added successfully!");
        System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
        
    }}




    private static void updateEmployee(){
      int id = readValidInt("     Please enter ID to update details: ");
      Employee m=findEmployeeById(id);
      	if(m == null) {
      		System.out.println("     Employee not found!");
		System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");

      		return;
      	}
        System.out.println("        -----Employee found-----");
        
        while (true) {
             System.out.print("     Enter new name (" + m.getname() + "): ");
             String newName = sc.nextLine();
             if (newName.isBlank()) {
                 break; 
        }
         try {
            m.setName(newName);
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }


       while (true) {
           System.out.print("     Enter new department (" + m.getdepartment() + "): ");
           String newDepartment = sc.nextLine();
           if (newDepartment.isBlank()) {
            break; 
        }
        try {
            m.setDepartment(newDepartment);
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }

       while (true) {
           System.out.print("     Enter new phone number (" + m.getphoneNO() + "): ");
           String newPhone = sc.nextLine();
           if (newPhone.isBlank()) {
            break; 
        }
        try {
            m.setphoneNO(newPhone);
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }

        while (true) {
            System.out.print("     Enter new salary (" + m.getsalary() + "): ");
            String newSalaryStr = sc.nextLine();
            if (newSalaryStr.isBlank()) {
            break; 
        }
        try {
            double newSalary = Double.parseDouble(newSalaryStr);
            m.setsalary(newSalary);
            break; 
        } catch (NumberFormatException e) {
            System.out.println("     Error: Please enter a valid numerical amount.");
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }    

	  DatabaseManager.saveToFile(list);                 
          System.out.println("\n     Employee updated successfully.");
     
          System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
    }
   
    private static void showAllEmployees(){
      if(list.isEmpty()){
        System.out.println("     NO Employees found!");
	System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
        return;
      }
      System.out.println("     -----Employees to show-----");
      System.out.println("     +------+----------------------+----------------------+-----------------+---------------+");
      System.out.printf("     | %-4s | %-20s | %-20s | %-15s | %-13s |%n", "ID", "Name", "Department", "Phone No", "Salary");
      System.out.println("     +------+----------------------+----------------------+-----------------+---------------+");
      for (Employee m : list) {
    	    System.out.printf("     | %-4d | %-20s | %-20s | %-15s | %,13.2f |%n", 
    	        m.getID(), 
    	        m.getname(), 
    	        m.getdepartment(), 
    	        m.getphoneNO(), 
    	        m.getsalary()
    	    );
    	}
        
        System.out.println("     +------+----------------------+----------------------+-----------------+---------------+\n");
        System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
    }
    
    
    private static void deleteEmployee() {
    	        int id = readValidInt("     Please enter ID to delete: ");
    		
    		Employee m=findEmployeeById(id);
    		
    		if(m != null) {
    			list.remove(m);
			DatabaseManager.saveToFile(list);
    			System.out.print("     Employee deleted succesfully. ");
    		}
    		else {
    			System.out.println("     Employee not found! ");
    		}
    		 System.out.println("\n+------+----------------------+----------------------+-----------------+--------------------+\n");
    }

	private static void searchEmployee(){
		int id = readValidInt("     Please enter ID to search: ");
		Employee m=findEmployeeById(id);
		
                     if(m != null) {
                    	  System.out.println("     +------+----------------------+----------------------+-----------------+---------------+");
                          System.out.printf("     | %-4s | %-20s | %-20s | %-15s | %-13s |%n", "ID", "Name", "Department", "Phone No", "Salary");
                          System.out.println("     +------+----------------------+----------------------+-----------------+---------------+");
                          
                        	    System.out.printf("     | %-4d | %-20s | %-20s | %-15s | %,13.2f |%n", 
                        	        m.getID(), 
                        	        m.getname(), 
                        	        m.getdepartment(), 
                        	        m.getphoneNO(), 
                        	        m.getsalary()
                        	    );
                        
                        	    System.out.println("     +------+----------------------+----------------------+-----------------+---------------+");
    			 
    		}
    		else {
    			System.out.println("     Employee not found! ");
    		}
                   
                     System.out.println("+------+----------------------+----------------------+-----------------+--------------------+\n");
	}
   
      
      private static Employee findEmployeeById(int id) {
    	  for(Employee m: list) {
    		  if(m.getID()==id) {
    			  return m;
    		  }
    	  }
    	  return null;
      }

    private static int readValidInt(String prompt) {
    while (true) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("     Error: Invalid input. Please enter a whole number.");
        }
    }
}

    private static String readValidString(String prompt, Employee employee, String type) {
    while (true) {
        System.out.print(prompt);
        String input = sc.nextLine();
        try {
            switch (type.toLowerCase()) {
                case "name":
                    employee.setName(input);
                    return input;
                case "department":
                    employee.setDepartment(input);
                    return input;
                case "phone":
                    employee.setphoneNO(input);
                    return input;
                default:
                    return input;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }
}


    private static double readValidSalary(String prompt, Employee employee) {
    while (true) {
        System.out.print(prompt);
        try {
            double salary = Double.parseDouble(sc.nextLine());
            // Test if the Employee class accepts it before returning
            employee.setsalary(salary); 
            return salary;
        } catch (NumberFormatException e) {
            System.out.println("     Error: Please enter a valid numerical amount.");
        } catch (IllegalArgumentException e) {
            System.out.println("     Error: " + e.getMessage());
        }
    }
}
        
    
  }

    
 





