package employee_management;



public class Employee {
   
    private String name;
    private double salary;
    private int id;
    private String department;
    private String phoneNO;
       public Employee(){}
       public Employee(int id,String name,String department,String phoneNO,double salary){
         this.setID(id);
         this.setName(name);
         this.setDepartment(department);
         this.setphoneNO(phoneNO);
         this.setsalary(salary);
      }
  
     public void setID(int id){
    	 if(id <= 0) {
    		 throw new IllegalArgumentException("ID must be a positive integer greater than 0.");
    	 }
      this.id=id;
     }

     public int getID(){
      return this.id;
     }

     public void setName(String name){
    	 if (name == null || name.trim().isEmpty()) {
             throw new IllegalArgumentException("Name cannot be empty.");
         }

         if (!name.matches("^[a-zA-Z\\s]{2,50}$")) {
             throw new IllegalArgumentException("Name must contain only letters and be between 2 and 50 characters.");
         }
         this.name = name.trim();
}

           public String getname(){
      return this.name;
     }
     
     public void setDepartment(String department){
    	 if (department == null || department.trim().isEmpty()) {
             throw new IllegalArgumentException("Department cannot be empty.");
         }

	 if (!department.matches("^[a-zA-Z\\s]{2,50}$")) {
        throw new IllegalArgumentException("Department must contain only letters and be between 2 and 50 characters.");
    }
         this.department = department.trim();
     }
          public String getdepartment(){
      return this.department;
     }


     public void setphoneNO(String phoneNO){
    	 String phoneStr = String.valueOf(phoneNO);
        
         if (!phoneStr.matches("^[6-9]\\d{9}$")) {
             throw new IllegalArgumentException("Phone number must be a valid 10-digit mobile number starting with 6-9.");
         }
         this.phoneNO = phoneNO;
     }
          public String getphoneNO(){
      return this.phoneNO;
     }


     public void setsalary(double salary){
    	 if (salary < 10000 || salary > 500000) { 
             throw new IllegalArgumentException("Salary must be between 10,000 and 500,000.");
         }
         this.salary = salary;
     }
          public double getsalary(){
      return this.salary;
     }
   }


