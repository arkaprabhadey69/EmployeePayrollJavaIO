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
import java.util.Comparator;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class EmployeePayrollTest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY = "TempPlay";

    @Test
    public void givenPathConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY);
        if (Files.exists(playPath))
            Files.walk(playPath)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        if (Files.notExists(playPath))
            Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        IntStream.rangeClosed(1, 10).forEach(counter -> {
            Path tempFile = Paths.get(playPath + "/temp" + counter);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {

            }
            Assert.assertTrue(Files.exists(tempFile));
        });
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
        long entries = employeePayroll.countEntries();
        Assert.assertEquals(3, entries);

    }

    @Test
    public void given3NamesShouldBeWrittenToFileAndPrintFromFile() {
        EmployeePayrollData[] emp = {
                new EmployeePayrollData(1, "Arka", 50000),
                new EmployeePayrollData(2, "Swapnaneel", 60000),
                new EmployeePayrollData(3, "Pooja", 70000),
                new EmployeePayrollData(3, "Srikanth", 70000)
        };
        ArrayList<EmployeePayrollData> arrayList = new ArrayList<>();
        arrayList.add(emp[0]);
        arrayList.add(emp[1]);
        arrayList.add(emp[2]);
        arrayList.add(emp[3]);
        EmployeePayroll employeePayroll = new EmployeePayroll(arrayList);
        employeePayroll.writeData(arrayList);
        employeePayroll.printData();
        long entries = employeePayroll.countEntries();
        Assert.assertEquals(4, entries);

    }

    @Test
    public void shouldReadPayrollFromFile() {
        EmployeePayrollData[] emp = {
                new EmployeePayrollData(1, "Arka", 50000),
                new EmployeePayrollData(2, "Swapnaneel", 60000),
                new EmployeePayrollData(3, "Pooja", 70000),
                new EmployeePayrollData(3, "Srikanth", 70000)
        };
        ArrayList<EmployeePayrollData> arrayList = new ArrayList<>();
        arrayList.add(emp[0]);
        arrayList.add(emp[1]);
        arrayList.add(emp[2]);
        arrayList.add(emp[3]);
        EmployeePayroll employeePayroll = new EmployeePayroll(arrayList);
        employeePayroll.writeData(arrayList);
        long entries = employeePayroll.readData(arrayList);
        Assert.assertEquals(4, entries);

    }
}