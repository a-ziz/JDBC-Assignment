import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws SQLException {

    // Employee Dao
    EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    Scanner sc = new Scanner(System.in);

    boolean flag = true;
    while (flag) {
      System.out.println("*******************");
      System.out.println("Select from the options below");
      System.out.println("*******************");
      System.out.println("PRESS 1: Add Employee");
      System.out.println("PRESS 2: Update Employee");
      System.out.println("PRESS 3: Delete Employee");
      System.out.println("PRESS 4: Get All Employee");
      System.out.println("PRESS 5: Get Employee by Id");
      System.out.println("PRESS 6: Exit");

      int input = sc.nextInt();
      switch (input) {
        case 1:
          // add
          System.out.print("Enter name: ");
          String name = sc.next();
          System.out.print("Enter email: ");
          String email = sc.next();
          Employee employeeToAdd = new Employee();
          employeeToAdd.setName(name);
          employeeToAdd.setEmail(email);
          employeeDao.addEmployee(employeeToAdd);
          break;
        case 2:
          // update
          System.out.print("Enter employee id: ");
          int id = sc.nextInt();
          System.out.print("Enter your new name: ");
          String newName = sc.next();
          System.out.print("Enter your new email: ");
          String newEmail = sc.next();
          Employee employeeToUpdate = new Employee();
          employeeToUpdate.setName(newName);
          employeeToUpdate.setEmail(newEmail);
          employeeToUpdate.setId(id);
          employeeDao.updateEmployee(employeeToUpdate);
          break;
        case 3:
          // delete
          System.out.print("Enter the employee id to delete: ");
          int empId = sc.nextInt();
          employeeDao.deleteEmployee(empId);

          break;
        case 4:
          // get all emp
          System.out.println(employeeDao.getEmployee().toString());
          break;
        case 5:
          // get emp by id
          System.out.print("Enter the id of employee: ");
          int empById = sc.nextInt();
          System.out.println(employeeDao.getEmployeeId(empById));
          break;
        case 6:
          // exit
          System.out.println("Thank you");
          System.out.println("Exiting...");
          flag = false;
          break;
        default:
          System.out.println("Please choose between 1 - 6");
      }

//    Employee emp = new Employee();
//    emp.setName("Tom");
//    emp.setEmail("To@mail.com");


//    EmployeeDao employeeDao = new EmployeeDaoImpl();
//    EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

      // insert employee
//    try {
//      employeeDao.addEmployee(emp);
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }

      // update employee
//    try {
//      employeeDao.updateEmployee(emp);
//    }catch (SQLException e){
//      throw new RuntimeException(e);
//    }

      // delete employee
//    try {
//      employeeDao.deleteEmployee(2);
//    }catch (SQLException e){
//      throw new RuntimeException(e);
//    }

    }
  }
}