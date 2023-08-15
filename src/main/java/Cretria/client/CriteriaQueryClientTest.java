package Cretria.client;

import Cretria.impl.EmployeeDaoImpl;

public class CriteriaQueryClientTest {


    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        getEmployee(employeeDao);
        //getEmployeeBasedOnId(employeeDao);
        //getEmpNameEmailSalary(employeeDao);
        //getTotalNumberOfEmployee(employeeDao);
        //getMAxSalaryOfEmployee(employeeDao);
        //getAvgSalaryOfEmployee(employeeDao);
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

    private static void getTotalNumberOfEmployee(EmployeeDaoImpl employeeDao) {
        employeeDao.getTotalNumberOfEmployee();

    }

    private static void getMAxSalaryOfEmployee(EmployeeDaoImpl employeeDao) {
        employeeDao.getMaxSalaryOfEmployee();

    }

    private static void getAvgSalaryOfEmployee(EmployeeDaoImpl employeeDao) {
        employeeDao.getAverageSalary();
    }


}
