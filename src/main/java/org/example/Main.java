package org.example;

import com.jdbc.config.DatabaseConnectionManager;
import com.jdbc.dao.EmployeeDAO;
import com.jdbc.model.EmployeeInfo;

import java.sql.Connection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Connection connection = new DatabaseConnectionManager("localhost",
                "java_somethingdb",
                "", "").getConnection();

        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        String collect = employeeDAO.executeTask6().stream().map(EmployeeInfo::toString).collect(Collectors.joining("\n"));

        System.out.println("Task 6:\n" + collect);

        collect = employeeDAO.executeTask7().stream().map(EmployeeInfo::toString).collect(Collectors.joining("\n"));
        System.out.println("\nTask 7:\n" + collect);

        collect = employeeDAO.executeTask8().toString();
        System.out.println("\nTask 8:\n" + collect);

    }
}