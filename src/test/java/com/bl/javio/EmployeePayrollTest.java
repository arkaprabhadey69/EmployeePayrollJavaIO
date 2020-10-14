package com.bl.javio;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EmployeePayrollTest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY = "TempPlay";

    @Test
    public void givenPathConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY);
        if (Files.notExists(playPath))
            Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));
    }

    @Test
    public void given3NamesShouldBeWrittenToFile() {
        EmployeePayrollData[] emp = {
                new EmployeePayrollData(1, "Arka", 50000),
                new EmployeePayrollData(2, "Swapnaneel", 60000),
                new EmployeePayrollData(3, "Pooja", 70000)
        };
        ArrayList<EmployeePayrollData> arrayList = new ArrayList<>();
        arrayList.add(emp[0]);
        arrayList.add(emp[1]);
        arrayList.add(emp[2]);
        EmployeePayroll employeePayroll = new EmployeePayroll(arrayList);
        employeePayroll.writeData(arrayList);
        long entries=employeePayroll.countEntries();
        Assert.assertEquals(3,entries);

    }
    @Test
    public void given3NamesShouldBeWrittenToFileAndPrintFromFile() {
        EmployeePayrollData[] emp = {
                new EmployeePayrollData(1, "Arka", 50000),
                new EmployeePayrollData(2, "Swapnaneel", 60000),
                new EmployeePayrollData(3, "Pooja", 70000)
        };
        ArrayList<EmployeePayrollData> arrayList = new ArrayList<>();
        arrayList.add(emp[0]);
        arrayList.add(emp[1]);
        arrayList.add(emp[2]);
        EmployeePayroll employeePayroll = new EmployeePayroll(arrayList);
        employeePayroll.writeData(arrayList);
        employeePayroll.printData();
        long entries=employeePayroll.countEntries();
        Assert.assertEquals(3,entries);

    }
}