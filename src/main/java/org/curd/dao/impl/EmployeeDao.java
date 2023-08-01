package org.curd.dao.impl;

import org.curd.entity.Employee;

public interface EmployeeDao {

    public abstract void addEmployee(Employee employee);
    public abstract Employee fetchEmployeeById(int employeeId);
    public abstract void updateEmployeeById(int employeeId, Double newSal);
    public abstract void deleteEmployeeById(int employeeId);
}
