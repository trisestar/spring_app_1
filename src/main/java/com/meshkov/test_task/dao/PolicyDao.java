package com.meshkov.test_task.dao;

import com.meshkov.test_task.model.Policy;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PolicyDao {

    private static final String URL = "jdbc:mysql://localhost:3306/policiesdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "retevo123";
    private static final String SQL_LOAD_ALL = "SELECT * from policy";
    private static final String SQL_INSERT =
            "INSERT INTO `policiesdb`.`policy` (`client_name`, `start_date`, `expiration_date`, `policy_type`) " +
                    "VALUES ('Joe', '2003-11-11', '2022-11-11', 'Comprehensive coverage');";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Policy> loadAll() {
        List<Policy> policies = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_LOAD_ALL);

            while (resultSet.next()) {
                Policy policy = new Policy();
                policy.setId(resultSet.getInt("id"));
                policy.setClientName(resultSet.getString("client_name"));
                policy.setStartDate(String.valueOf(resultSet.getDate("start_date")));
                policy.setExpirationDate(String.valueOf(resultSet.getDate("expiration_date")));
                policy.setPolicyType(resultSet.getString("policy_type"));

                policies.add(policy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

}
