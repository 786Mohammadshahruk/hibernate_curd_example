package Cretria.client;

import Cretria.entity.Employee;
import Cretria.impl.EmployeeDaoImpl;

import java.util.Arrays;
import java.util.List;

public class SaveDataClientTest {

    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.createEmployee(getListOfEmployee());


    }

    private static List<Employee> getListOfEmployee() {
        Employee employee1 = new Employee();
        employee1.setEmployeeFirstName("Rohit");
        employee1.setEmployeeLastName("Mishra");
        employee1.setEmail("rohit.sharma@gmail.com");
        employee1.setDoj("01-01-2022");
        employee1.setSalary(1000000.0);
        employee1.setDesignation("IT Manager");

        Employee employee2 = new Employee();
        employee2.setEmployeeFirstName("Mohit");
        employee2.setEmployeeLastName("Mishra");
        employee2.setEmail("mohit.sharma@gmail.com");
        employee2.setDoj("01-01-2021");
        employee2.setSalary(3000000.0);
        employee2.setDesignation("IT Developer");
        return Arrays.asList(employee1, employee2);
    }
}
