package HQL_JOINS.impl;

import HQL_JOINS.entity.Address;
import HQL_JOINS.entity.Employee;
import HQL_JOINS.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public void getEmployeeAndAddressByAddressId(int addressId) {
        try (Session session = HibernateUtil.getSession()) {
            String HQL = "From Address addr LEFT OUTER JOIN FETCH addr.employee where addr.addressId=:addressId";
            Query<Address> addressQuery = session.createQuery(HQL, Address.class);
            addressQuery.setParameter("addressId", addressId);
            Address address = addressQuery.uniqueResult();
            System.out.println(address);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
