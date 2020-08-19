package model;

import entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentModel {
    private final Connection connection = new conn().getConnection();

    public int create(String name, Integer gender, String email, String phone, String country, String dob) throws SQLException {
        int status = 0;
        StringBuilder nameCode = new StringBuilder();
        String[] names = name.split(" ");
        for (String s : names) {
            nameCode.append(s.charAt(0));
        }
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        String rollNumber = nameCode.toString() + year + month + day + hour + minute + second;
        String sql = "INSERT INTO students (roll_number, name, gender, email, phone, country, dob) VALUES ('" + rollNumber + "', '" + name + "', '" + gender + "', '" + email + "', '" + phone + "', '" + country + "', '" + dob + "')";
        Statement statement = connection.createStatement();
        status = statement.executeUpdate(sql);
        return status;
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String rollNumber = resultSet.getString("roll_number");
            String name = resultSet.getString("name");
            Integer gender = resultSet.getInt("gender");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String country = resultSet.getString("country");
            String dob = resultSet.getString("dob");
            Student student = new Student(id, rollNumber, name, gender, email, phone, country, dob);
            list.add(student);
        }
        return list;
    }

    public int update(int id, String name, int gender, String email, String phone, String country, String dob) throws SQLException {
        int status = 0;
        String sql = "UPDATE students SET name = '" + name + "', gender = '" + gender + "', email = '" + email + "', phone = '" + phone + "', country = '" + country + "', dob = '" + dob + "' WHERE id = '" + id + "'";
        Statement statement = connection.createStatement();
        status = statement.executeUpdate(sql);
        return status;
    }

    public int delete(int id) throws SQLException {
        int status = 0;
        String sql = "DELETE FROM students WHERE id = '" + id + "'";
        Statement statement = connection.createStatement();
        status = statement.executeUpdate(sql);
        return status;
    }

    public Student getById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = '" + id + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Student student = new Student();
        if (resultSet.next()) {
            student.setId(id);
            student.setRollNumber(resultSet.getString("roll_number"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getInt("gender"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));
            student.setCountry(resultSet.getString("country"));
            student.setDob(resultSet.getString("dob"));
        }
        return student;
    }

    public List<Student> getByName(String name) throws SQLException {
        String sql = "SELECT * FROM students WHERE name LIKE '%" + name + "%'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Student> list = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setRollNumber(resultSet.getString("roll_number"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getInt("gender"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));
            student.setCountry(resultSet.getString("country"));
            student.setDob(resultSet.getString("dob"));
            list.add(student);
        }
        return list;
    }
}
