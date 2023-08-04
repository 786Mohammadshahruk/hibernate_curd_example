package OneToMany.client;

import OneToMany.entity.AddressBiDirectional;
import OneToMany.entity.EmployeeBiDirectional;
import OneToMany.impl.EmployeeDaoImpl;
import OneToMany.impl.EmployeeDaoImplBiDirectional;

import java.util.ArrayList;
import java.util.List;

public class ClientTestBiDirectional {

    public static void main(String[] args) {

        EmployeeDaoImplBiDirectional employeeDao = new EmployeeDaoImplBiDirectional();
        employeeDao.addEmployee(getEmployee());

        //employeeDao.fetchEmployeeById(1);
        //employeeDao.deleteEmployeeById(1);

    }

    private static EmployeeBiDirectional getEmployee() {
        EmployeeBiDirectional employee = new EmployeeBiDirectional();
        employee.setEmployeeFirstName("Mohit");
        employee.setEmployeeLastName("Mishra");
        employee.setEmail("mohit.sharma@gmail.com");
        employee.setDoj("01-01-2021");
        employee.setSalary(3000000.0);

        List<AddressBiDirectional> addressList = new ArrayList<>();
        AddressBiDirectional address1 = new AddressBiDirectional();
        address1.setPinCode(985337);
        address1.setCity("HYD");
        address1.setState("HYD");
        address1.setStreet("HYD1");
        address1.setEmployee(employee);
        addressList.add(address1);

        AddressBiDirectional address2 = new AddressBiDirectional();
        address2.setPinCode(833201);
        address2.setCity("jamsh");
        address2.setState("jharkhand");
        address2.setStreet("mango");
        address2.setEmployee(employee);
        addressList.add(address2);

        employee.setAddress(addressList);

        return employee;
    }
}
