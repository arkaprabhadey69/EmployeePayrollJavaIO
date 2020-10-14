package com.bl.javio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll {
    public enum IOService {CONSOLE_IO, FILE_IO, REST_IO}

    public ArrayList<EmployeePayrollData> employeePayrollList;

    public EmployeePayroll(ArrayList<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = new ArrayList<EmployeePayrollData>();
    }

   public void welcomeMessage(){
        System.out.println("Welcome to employee payroll system");
   }

   public void writeData(ArrayList<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get("Employee_PayRoll.txt"), empBuffer.toString().getBytes());

        } catch (IOException e) {

        }
    }

    public void readData(Scanner input) {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        System.out.println("Enter name: ");
        String name = input.next();
        System.out.println("Enter salary: ");
        int salary = input.nextInt();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));

    }

    public void printData() {
        try {
            Files.lines(new File("Employee_PayRoll.txt").toPath())
                    .forEach(System.out::println);

        } catch (IOException e) {

        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File("Employee_PayRoll.txt").toPath())
                    .count();
        } catch (IOException e) {

        }
        return entries;
    }

    public ArrayList<EmployeePayrollData> readData(ArrayList<EmployeePayrollData> employeePayrollList) {

        try {
            Files.lines(new File("Employee_PayRoll.txt").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));

        } catch (IOException e) {

        }
        return employeePayrollList;
    }
}
