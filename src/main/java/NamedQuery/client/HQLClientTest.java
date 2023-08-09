package NamedQuery.client;

import NamedQuery.impl.EmployeeDaoImpl;

public class HQLClientTest {

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        getEmployeeById(employeeDao);
        //getTotalSalaryOfEmployeeByDept(employeeDao);
    }

    private static void getEmployeeById(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployeeById();
    }

    private static void getTotalSalaryOfEmployeeByDept(EmployeeDaoImpl employeeDao) {
        employeeDao.getTotalSalaryOfEmployeeByDept();
    }

}
