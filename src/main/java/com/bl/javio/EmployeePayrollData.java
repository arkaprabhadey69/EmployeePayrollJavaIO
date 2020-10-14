package com.bl.javio;

public class EmployeePayrollData {
    public int id;
    public String name;
    public int salary;

    public EmployeePayrollData(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "id= " + id + ", name= " + name + ",salary " + salary;
    }
}
