package ManyToMany.client;

import ManyToMany.entity.Address;
import ManyToMany.entity.Employee;
import ManyToMany.impl.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        List<Address> addressList_total3Address = getListOfAddress();
        List<Address> addressList_tital2Address = Arrays.asList(addressList_total3Address.get(0), addressList_total3Address.get(1));
        List<Employee> employeeList = getListOfEmployee();


        Employee employee1 = employeeList.get(0);
        employee1.setAddressList(addressList_tital2Address);

        Employee employee2 = employeeList.get(1);
        employee2.setAddressList(addressList_total3Address);

       // employeeDao.addEmployee(employee1);
       employeeDao.addEmployee(employee2);


    }

    private static List<Employee> getListOfEmployee() {
        Employee employee1 = new Employee();
        employee1.setEmployeeFirstName("Rohit");
        employee1.setEmployeeLastName("Mishra");
        employee1.setEmail("rohit.sharma@gmail.com");
        employee1.setDoj("01-01-2022");
        employee1.setSalary(1000000.0);

        Employee employee2 = new Employee();
        employee2.setEmployeeFirstName("Mohit");
        employee2.setEmployeeLastName("Mishra");
        employee2.setEmail("mohit.sharma@gmail.com");
        employee2.setDoj("01-01-2021");
        employee2.setSalary(3000000.0);
        return Arrays.asList(employee1, employee2);
    }

    private static List<Address> getListOfAddress() {
        List<Address> addressList = new ArrayList<>();
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

        Address address3 = new Address();
        address3.setPinCode(234444);
        address3.setCity("pune");
        address3.setState("MH");
        address3.setStreet("pune");
        addressList.add(address3);

        return addressList;
    }
}
