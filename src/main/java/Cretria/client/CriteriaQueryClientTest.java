package Cretria.client;

import Cretria.impl.EmployeeDaoImpl;

public class CriteriaQueryClientTest {


    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        //getEmployee(employeeDao);
        //getEmployeeBasedOnId(employeeDao);
        getEmpNameEmailSalary(employeeDao);
    }

    private static void getEmployee(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployee();
    }

    private static void getEmployeeBasedOnId(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployeeBasedOnId(1);
    }

    private static void getEmpNameEmailSalary(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmpNameEmailSalary();

    }
}
