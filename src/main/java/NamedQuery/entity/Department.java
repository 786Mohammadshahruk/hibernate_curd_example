package NamedQuery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department_table")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_Id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_location")
    private String departmentLocation;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "department")
    private Employee employee;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
