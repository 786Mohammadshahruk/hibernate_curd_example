package NamedQuery.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "employee_db")

@NamedQueries(value = {
        @NamedQuery(name = "findEmployee",
                query = "From Employee where empId=:emp_id"),
        @NamedQuery(name = "getTotalSalaryOfEmployeeByDept",
                query = "Select dept.departmentName,emp.salary, emp.employeeFirstName from Department dept " +
                        "LEFT JOIN dept.employee emp where dept.departmentId=:department_id"
        )

})


@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "findEmployeeWithNativeQuery", query = "Select * From employee_db where emp_Id=:emp_id", resultClass = Employee.class)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "email")
    private String email;

    @Column(name = "doj")
    private String doj;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "designation")
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", email='" + email + '\'' +
                ", doj='" + doj + '\'' +
                ", salary=" + salary +
                ", designation=" + designation +
                '}';
    }
}
