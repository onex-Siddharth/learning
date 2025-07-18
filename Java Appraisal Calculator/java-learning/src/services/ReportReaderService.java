package services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReportReaderService {

    public void readAllReports() {
        String directoryPath = "/home/jivanani-saksham/IdeaProjects/Java Pactice/out";

        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("---- " + file.getName() + " ----");
                try {
                    Files.lines(file.toPath()).forEach(System.out::println);
                } catch (IOException e) {
                    System.err.println("Error reading " + file.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("No appraisal reports found in: " + directoryPath);
        }
    }
}
