package ManyToMany.impl;

import ManyToMany.entity.Employee;
import ManyToMany.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDaoImpl {

    public void addEmployee(Employee employee) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
