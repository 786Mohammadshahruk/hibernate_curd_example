package OneToMany.client;

import OneToMany.entity.Address;
import OneToMany.entity.Employee;
import OneToMany.impl.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.addEmployee(getEmployee());

        //employeeDao.fetchEmployeeById(1);
        //employeeDao.deleteEmployeeById(1);

    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeFirstName("Mohit");
        employee.setEmployeeLastName("Mishra");
        employee.setEmail("mohit.sharma@gmail.com");
        employee.setDoj("01-01-2021");
        employee.setSalary(3000000.0);

        List<Address> addressList =new ArrayList<>();
        Address address1 = new Address();
        address1.setPinCode(985337);
        address1.setCity("HYD");
        address1.setState("HYD");
        address1.setStreet("HYD1");
        addressList.add(address1);

        Address address2 = new Address();
        address2.setPinCode(833201);
        address2.setCity("jamsh");
        address2.setState("jharkhand");
        address2.setStreet("mango");
        addressList.add(address2);

        employee.setAddress(addressList);

        return employee;
    }
}
