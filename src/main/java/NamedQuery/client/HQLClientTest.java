package NamedQuery.client;

import NamedQuery.impl.EmployeeDaoImpl;
import NamedQuery.impl.PeronDaoImpl;

public class HQLClientTest {

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        //getEmployeeById(employeeDao);
        //getTotalSalaryOfEmployeeByDept(employeeDao);

        //getEmployeeUsingNativeQueryById(employeeDao);
        //getPerson();
        getPersonIdAndName();
    }

    private static void getEmployeeUsingNativeQueryById(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployeeUsingNativeQueryById();
    }

    private static void getEmployeeById(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployeeById();
    }

    private static void getTotalSalaryOfEmployeeByDept(EmployeeDaoImpl employeeDao) {
        employeeDao.getTotalSalaryOfEmployeeByDept();
    }

    private static void getPerson(){
        PeronDaoImpl peronDao = new PeronDaoImpl();
        peronDao.getPerson();
    }
    private static void getPersonIdAndName(){
        PeronDaoImpl peronDao = new PeronDaoImpl();
        peronDao.getPersonIdAndName();
    }


}
