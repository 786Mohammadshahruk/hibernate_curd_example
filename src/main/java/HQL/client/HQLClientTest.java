package HQL.client;

import HQL.entity.Employee;
import HQL.impl.EmployeeDaoImpl;

import java.util.List;

public class HQLClientTest {

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        //getEmployeeId(employeeDao);
        //getEmployees(employeeDao);
        //getEmployeeByIdAndEmail(employeeDao);
        getAllEmployeeIdAndName(employeeDao);
    }

    private static void getEmployeeId(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployeeId(2);
    }

    private static void getEmployees(EmployeeDaoImpl employeeDao) {
        employeeDao.getEmployees();
    }

    private static void getEmployeeByIdAndEmail(EmployeeDaoImpl employeeDao) {
        List<Employee> employees = employeeDao.getEmployeeByIdAndEmail(2, "rohit.sharma@gmail.com");
        if (employees != null && !employees.isEmpty()) {
            employees.stream().forEach(System.out::println);
        } else {
            System.out.println("List IS Empty");
        }
    }

    private static void getAllEmployeeIdAndName(EmployeeDaoImpl employeeDao) {
        employeeDao.getAllEmployeeIdAndName();
    }
}
