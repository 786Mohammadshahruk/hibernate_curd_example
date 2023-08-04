package OneToMany.impl;

import OneToMany.entity.EmployeeBiDirectional;
import OneToMany.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDaoImplBiDirectional {

    public void addEmployee(EmployeeBiDirectional employee) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*public void fetchEmployeeById(int employeeId) {

        try (Session session = HibernateUtil.getSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                System.out.println(employee);
                if (employee.getAddress() != null) {
                    System.out.println(employee.getAddress());
                }
            } else {
                System.out.println("Employee Does Not Exist With provided EmployeeId");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteEmployeeById(int employeeId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
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
    }*/

}
