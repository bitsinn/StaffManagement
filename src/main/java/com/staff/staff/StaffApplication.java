package com.staff.staff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class StaffApplication {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "123123"); Statement statement = connection.createStatement()) {
			statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'staffdb'");
			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			int count = resultSet.getInt(1);

			if (count <= 0) {
				statement.executeUpdate("CREATE DATABASE staffdb");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		SpringApplication.run(StaffApplication.class, args);
	}

}
