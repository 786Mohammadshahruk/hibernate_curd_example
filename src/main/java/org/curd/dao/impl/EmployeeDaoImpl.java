package org.curd.dao.impl;

import org.curd.entity.Employee;
import org.curd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Employee fetchEmployeeById(int employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Employee employee = null;
        try (Session session = sessionFactory.openSession()) {
            employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                return employee;
            } else {
                System.out.println("Employee Does Not Exist With provided EmployeeId");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return employee;

    }

    @Override
    public void updateEmployeeById(int employeeId, Double newSal) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                employee.setSalary(newSal);
                transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();
            } else {
                System.out.println("Employee Does Not Exist With provided EmployeeId");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            } else {
                System.out.println("Employee Does Not Exist With provided EmployeeId");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
