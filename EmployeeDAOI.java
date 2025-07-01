package com.CodeClause.EMS.dao;

import com.CodeClause.EMS.model.Employee;
import java.util.List;

public interface EmployeeDAOI {
    void createEmployee(Employee emp);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void updateEmployee(Employee emp);
    void deleteEmployee(int id);
}

