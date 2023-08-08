package HQL_JOINS.client;

import HQL_JOINS.impl.EmployeeDaoImpl;


public class HQLClientTest {

    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        getEmployeeAndAddressByAddressId(employeeDao,1);
    }

    private static void getEmployeeAndAddressByAddressId(EmployeeDaoImpl employeeDao, int addressId) {
        employeeDao.getEmployeeAndAddressByAddressId(addressId);
    }

}
