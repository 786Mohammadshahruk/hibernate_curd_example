package Cretria.impl;


import Cretria.entity.Employee;
import OneToMany.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl {
    public void createEmployee(List<Employee> listOfEmployee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            session.save(listOfEmployee.get(1));


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployee() {

        try (Session session = HibernateUtil.getSession()) {
            //Creating CriteriaBuilder Object
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root);

            Query<Employee> query = session.createQuery(criteriaQuery);
            List<Employee> list = query.list();

            list.stream().forEach(System.out::println);

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    public void getEmployeeBasedOnId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            //Creating CriteriaBuilder Object
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root);

            // Select * from Employee where empId = 1;

            criteriaQuery.where(criteriaBuilder.equal(root.get("empId"), id));

            Query<Employee> query = session.createQuery(criteriaQuery);
            List<Employee> list = query.list();

            list.stream().forEach(System.out::println);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmpNameEmailSalary() {
        try (Session session = HibernateUtil.getSession()) {
            //Creating CriteriaBuilder Object
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);

            Path<Object> employeeFirstName = root.get("employeeFirstName");
            Path<Object> email = root.get("email");
            Path<Object> salary = root.get("salary");

            criteriaQuery.multiselect(employeeFirstName, email, salary);
            List<Employee> list = session.createQuery(criteriaQuery).list();

           for (Employee objects : list){
               System.out.println("Employee Name : "+objects.getEmployeeFirstName());
               System.out.println("Employee Email : "+objects.getEmail());
               System.out.println("Employee Salary : "+objects.getSalary());
               System.out.println("------------------------------------------");
           }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
