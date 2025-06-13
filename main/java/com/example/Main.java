package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://postgres:5432/mydb"; // Docker service name as hostname
        String dbUser = "postgres_user";
        String dbPassword = "postgres_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            System.out.println("Connected to PostgreSQL!");

            // SQL Query
            String query = "SELECT * FROM employees";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String position = resultSet.getString("position");
                    double salary = resultSet.getDouble("salary");
                    System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
