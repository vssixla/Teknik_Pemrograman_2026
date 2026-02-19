package id.ac.polban.employee;

import java.util.Scanner;
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan ID Employee: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan Nama Employee: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Nama Department: ");
        String deptName = input.nextLine();

        System.out.print("Masukkan Employment Type: ");
        String typeName = input.nextLine();

        System.out.print("Masukkan Salary: ");
        double salary = input.nextDouble();

        Department dept = new Department(deptName);
        EmploymentType type = new EmploymentType(typeName);
        Employee emp = new Employee(id, nama, dept, type, salary);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp);        
        service.raiseSalary(id, 10);     

        System.out.println("\n===== DATA EMPLOYEE =====");
        System.out.println("ID      : " + emp.getId());
        System.out.println("Nama    : " + emp.getName());
        System.out.println("Dept    : " + dept.getName());
        System.out.println("Type    : " + type.getType());
        System.out.printf("Salary  : %.2f\n", emp.getSalary());

        input.close();
    }
}