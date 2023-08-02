package org.curd.client;

import org.curd.entity.Employee;
import org.curd.model.Address;
import org.curd.service.impl.EmployeeService;
import org.curd.service.impl.EmployeeServiceImpl;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();

        // Create Operation
        createEmployee(employeeService);








        // Get Operation
        //Employee employee = employeeService.getEmployeeById(2);
        //System.out.println("Employee Details : "+employee);

        //Update Operation
        //employeeService.updateEmployeeById(2, 500000.0);

        // Delete Operation
        //employeeService.deleteEmployeeById(1);
    }

    private static void createEmployee(EmployeeService employeeService) {
        employeeService.createEmployee(getEmployee());
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeFirstName("Rohit");
        employee.setEmployeeLastName("Sharma");
        employee.setEmail("rohit.sharma@mail.com");
        employee.setDoj("01-01-2022");
        employee.setSalary(1000000.0);

        Address homeAddress = new Address();
        homeAddress.setPinCode(108763);
        homeAddress.setCity("Navi Mumbai");
        homeAddress.setState("Navi Mumbai11");
        homeAddress.setStreet("Navi");

        Address officeAddress = new Address();
        officeAddress.setPinCode(733637);
        officeAddress.setCity("Mumbai");
        officeAddress.setState("Mumbai11");
        officeAddress.setStreet("Mumbai112");

        employee.setHomeAddress(homeAddress);
        employee.setOfficeAddress(officeAddress);
        return employee;
    }
}
