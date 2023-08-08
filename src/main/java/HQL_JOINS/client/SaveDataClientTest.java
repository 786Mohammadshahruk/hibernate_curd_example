package HQL_JOINS.client;

import HQL_JOINS.entity.Address;
import HQL_JOINS.entity.Employee;
import HQL_JOINS.impl.EmployeeDaoImpl;

import java.util.Arrays;
import java.util.List;

public class SaveDataClientTest {

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.addEmployee(getListOfEmployee());
    }

    private static List<Employee> getListOfEmployee() {
        Employee employee1 = new Employee();
        employee1.setEmployeeFirstName("Mohit");
        employee1.setEmployeeLastName("kumar");
        employee1.setEmail("mohit.sharma@gmail.com");
        employee1.setDoj("01-01-2022");
        employee1.setSalary(2000000.0);
        employee1.setDesignation("HR Manager");

        Address address = new Address();
        address.setCity("Mumbai");
        address.setPinCode(764355);
        address.setState("MH");
        address.setStreet("Navi");
        employee1.setAddress(address);
        return Arrays.asList(employee1);
    }

}
