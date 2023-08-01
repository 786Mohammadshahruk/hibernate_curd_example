package org.curd.service.impl;

import org.curd.dao.impl.EmployeeDao;
import org.curd.dao.impl.EmployeeDaoImpl;
import org.curd.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void createEmployee(Employee employee) {

        if (employee != null && employee.getDoj() != null) {
            employeeDao.addEmployee(employee);
        }

    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.fetchEmployeeById(employeeId);
    }

    @Override
    public void updateEmployeeById(int employeeId, Double newSal) {
        employeeDao.updateEmployeeById(employeeId, newSal);

    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }
}
