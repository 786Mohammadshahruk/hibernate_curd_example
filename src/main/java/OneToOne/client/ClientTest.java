package OneToOne.client;

import OneToOne.entity.Employee;

import OneToOne.entity.Address;
import OneToOne.impl.EmployeeDaoImpl;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.addEmployee(getEmployee());

        //employeeDao.fetchEmployeeById(1);
        //employeeDao.deleteEmployeeById(1);

    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeFirstName("Rohit");
        employee.setEmployeeLastName("Mishra");
        employee.setEmail("rohit.sharma@gmail.com");
        employee.setDoj("01-01-2023");
        employee.setSalary(2000000.0);

        Address homeAddress = new Address();
        homeAddress.setPinCode(987643);
        homeAddress.setCity("Bandra");
        homeAddress.setState("MH");
        homeAddress.setStreet("Navi");

        employee.setAddress(homeAddress);

        return employee;
    }
}
