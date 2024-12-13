package com.jdbc.dao;

import com.jdbc.model.EmployeeInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {
    private Connection connection;

    private String TASK_6 = "select e.last_name, d.department_name, c.country_name from employees e\n" +
            "inner join departments d on e.department_id = d.department_id\n" +
            "inner join locations l on d.location_id = l.location_id\n" +
            "inner join countries c on c.country_id = l.country_id ;";

    private String TASK_7 = "select e.last_name, d.department_name from employees e\n" +
            "inner join departments d on e.department_id = d.department_id\n" +
            "inner join locations l on d.location_id = l.location_id\n" +
            "where l.city = 'Bern';";

    private String TASK_8 = "select concat(e.last_name , '  ', e.phone_number) as employeeContact, \n" +
            "\t\tconcat(e2.last_name, '  ', e2.phone_number) as managerContact\n" +
            "from employees e \n" +
            "inner join employees e2 on e2.employee_id = e.manager_id\n" +
            "where e.manager_id notnull ;";

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<EmployeeInfo> executeTask6() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(TASK_6);
            return mapEmployeeInfoForTask6(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeeInfo> executeTask7() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(TASK_7);
            return mapEmployeeInfoForTask7(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, List<String>> executeTask8() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(TASK_8);
            return mapEmployeeInfoForTask8(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<EmployeeInfo> mapEmployeeInfoForTask6(ResultSet resultSet) throws SQLException {
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        while (resultSet.next()) {
            employeeInfo.setLastName(resultSet.getString("last_name"));
            employeeInfo.setDepartmentName(resultSet.getString("department_name"));
            employeeInfo.setCountryName(resultSet.getString("country_name"));
            employeeInfoList.add(employeeInfo);
        }
        return employeeInfoList;
    }

    private List<EmployeeInfo> mapEmployeeInfoForTask7(ResultSet resultSet) throws SQLException {
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        while (resultSet.next()) {
            employeeInfo.setLastName(resultSet.getString("last_name"));
            employeeInfo.setDepartmentName(resultSet.getString("department_name"));
            employeeInfoList.add(employeeInfo);
        }
        return employeeInfoList;
    }

    private Map<Integer, List<String>> mapEmployeeInfoForTask8(ResultSet resultSet) throws SQLException {
        Map<Integer, List<String>> map = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            map.put(i++, List.of(resultSet.getString("employeeContact"), resultSet.getString("managerContact")));
        }
        return map;
    }
}
