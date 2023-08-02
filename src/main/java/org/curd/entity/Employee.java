package org.curd.entity;


import jakarta.persistence.*;
import org.curd.model.Address;

@Entity
@Table(name = "employee_db")
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

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(column = @Column(name = "home_street_name"), name = "street"),
            @AttributeOverride(column = @Column(name = "home_city_name"), name = "city"),
            @AttributeOverride(column = @Column(name = "home_state_name"), name = "state"),
            @AttributeOverride(column = @Column(name = "home_pin_code"), name = "pinCode")
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(column = @Column(name = "office_street_name"), name = "street"),
            @AttributeOverride(column = @Column(name = "office_city_name"), name = "city"),
            @AttributeOverride(column = @Column(name = "office_state_name"), name = "state"),
            @AttributeOverride(column = @Column(name = "office_pin_code"), name = "pinCode")
    })
    private Address officeAddress;

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", email='" + email + '\'' +
                ", doj='" + doj + '\'' +
                ", salary=" + salary +
                '}';
    }
}
