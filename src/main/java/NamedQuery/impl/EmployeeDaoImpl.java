package NamedQuery.impl;

import NamedQuery.entity.Employee;
import NamedQuery.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.query.Query;

public class EmployeeDaoImpl {

    public void addEmployee(List<Employee> employee) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            employee.stream().forEach(i -> {
                session.persist(i);
            });
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getTotalSalaryOfEmployeeByDept() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Object[]> query = session.createNamedQuery("getTotalSalaryOfEmployeeByDept", Object[].class);
            query.setParameter("department_id", 1);
            /*List<Object[]> list = query.list();
            list.stream().forEach(i -> {
                System.out.println("Department Name : " + i[0]);
                System.out.println("Salary : " + i[1]);
                System.out.println("Employee name : " + i[2]);
            });*/
            Object[] i = query.uniqueResult();

            System.out.println("Department Name : " + i[0]);
            System.out.println("Salary : " + i[1]);
            System.out.println("Employee name : " + i[2]);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployeeById() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Employee> query = session.createNamedQuery("findEmployee");
            query.setParameter("emp_id", 2);
            Employee employee = query.uniqueResult();
            System.out.println(employee);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployeeUsingNativeQueryById() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Employee> query = session.createNamedQuery("findEmployeeWithNativeQuery");
            query.setParameter("emp_id", 2);
            Employee employee = query.uniqueResult();
            System.out.println(employee);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
