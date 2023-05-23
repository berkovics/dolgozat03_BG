/*
* File: LoadFile.java
* Author: Berkovics Gellért
* Copyright: 2023, Berkovics Gellért
* Group: Szoft I/1/N
* Date: 2023-05-23
* Github: https://github.com/janos/
* Licenc: GNU GPL
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFile {
    static final String FILE_NAME = "berkft.txt";

    public LoadFile() {
    }

    public static ArrayList<Employee> load() {
        ArrayList<Employee> empList = new ArrayList<>();
        try {
            empList = tryLoad();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
        }
        return empList;
    }

    public static ArrayList<Employee> tryLoad() throws FileNotFoundException {
        ArrayList<Employee> empList = new ArrayList<>();
        File file = new File(FILE_NAME);
        Scanner scanner = new Scanner(file, "utf-8");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            Employee emp = new Employee();
            emp.name = lineArray[0];
            emp.city = lineArray[1];
            emp.address = lineArray[2];
            String[] dateStrArray = lineArray[3].split("-");
            int year = Integer.parseInt(dateStrArray[0]);
            int month = Integer.parseInt(dateStrArray[1]);
            int day = Integer.parseInt(dateStrArray[2]);
            emp.birth = LocalDate.of(year, month, day);
            emp.salary = Double.parseDouble(lineArray[4]);

            empList.add(emp);
        }
        return empList;
    }
}
