package HQL.impl;

import HQL.entity.Employee;
import HQL.utils.HibernateUtil;
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

    public void getEmployeeId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            String HQL = "FROM Employee WHERE empId=:emp_id";

            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("emp_id", id);
            Employee employee = query.uniqueResult();
            System.out.println(employee);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployees() {
        try (Session session = HibernateUtil.getSession()) {
            String HQL = "FROM Employee";

            Query<Employee> query = session.createQuery(HQL, Employee.class);
            List<Employee> employee = query.list();
            System.out.println(employee);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Employee> getEmployeeByIdAndEmail(int id, String email) {
        List<Employee> employee = null;
        try (Session session = HibernateUtil.getSession()) {

            String HQL = "From Employee where empId=:emp_id AND email=:email";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("emp_id", id);
            query.setParameter("email", email);
            employee = query.list();
            return employee;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    public void getAllEmployeeIdAndName() {
        try (Session session = HibernateUtil.getSession()) {
            String HQL = "SELECT empId,employeeFirstName from Employee";
            Query query = session.createQuery(HQL);
            List<Object[]> list = query.list();
            for (Object[] objects : list) {
                Integer id = (Integer) objects[0];
                String firstName = (String) objects[1];
                System.out.println("ID : " + id);
                System.out.println("First Name : " + firstName);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void insertEmployeeRecord() {
        try (Session session = HibernateUtil.getSession()) {
            String INSERT_HQL = "INSERT INTO Employee(employeeFirstName,employeeLastName,email,doj,salary,designation)";
            String SELECT_HQL = "SELECT employeeFirstName,employeeLastName,email,doj,salary,designation from EmployeeBackup";

            String HQL = INSERT_HQL + SELECT_HQL;

            Query query = session.createQuery(HQL);
            Transaction transaction = session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            if (executeUpdate > 0) {
                System.out.println("Record Inserted");
            }
            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void updateEmployeeEmailById(int id) {

        try (Session session = HibernateUtil.getSession()) {

            String HQL = "Update Employee set email=:newEmail where empId=:empId";
            Query query = session.createQuery(HQL);
            query.setParameter("newEmail", "xyz@gmail.com");
            query.setParameter("empId", id);
            Transaction transaction = session.beginTransaction();
            int executedValue = query.executeUpdate();
            transaction.commit();
            if (executedValue > 0) {
                System.out.println("Record Updated");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteEmployeeById(int id) {

        try (Session session = HibernateUtil.getSession()) {

            String HQL = "Delete From Employee where empId=:employeeId";
            Query query = session.createQuery(HQL);
            query.setParameter("employeeId",id);
            Transaction transaction = session.beginTransaction();
            if(query.executeUpdate()>0){
                transaction.commit();
                System.out.println("Employee Is Deleted");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
