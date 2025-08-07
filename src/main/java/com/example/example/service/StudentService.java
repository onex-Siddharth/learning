package com.example.service;

import com.example.model.Student;
import com.example.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public void insertStudent(Student s) {
        String sql = "INSERT INTO student_sports (name, sport, age) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, s.getName());
            stmt.setString(2, s.getSport());
            stmt.setInt(3, s.getAge());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert student", e);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT name, sport, age FROM student_sports";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getString("name"),
                        rs.getString("sport"),
                        rs.getInt("age")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch students", e);
        }

        return list;
    }
}
