package OneToMany.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee_db")
public class EmployeeBiDirectional {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_address_table",
            joinColumns = @JoinColumn(name = "employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "address_Id"))
    private List<AddressBiDirectional> address;

    public List<AddressBiDirectional> getAddress() {
        return address;
    }

    public void setAddress(List<AddressBiDirectional> address) {
        this.address = address;
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
                ", address=" + address +
                '}';
    }
}
