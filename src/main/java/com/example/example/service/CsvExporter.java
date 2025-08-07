package src.main.java.com.example.example.service;

import com.example.model.Student;
import org.apache.commons.csv.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    public void exportToCsv(List<Student> students, String filename) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(filename),
                CSVFormat.DEFAULT.withHeader("Name", "Sport", "Age"))) {

            for (Student s : students) {
                printer.printRecord(s.getName(), s.getSport(), s.getAge());
            }

        } catch (IOException e) {
            throw new RuntimeException("CSV export failed", e);
        }
    }
}
