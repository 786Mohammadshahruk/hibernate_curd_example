package OneToMany.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address_table")
public class AddressBiDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "street_name")
    private String street;
    @Column(name = "city_name")
    private String city;
    @Column(name = "state_name")
    private String state;
    @Column(name = "pin_code")
    private long pinCode;

    @ManyToOne
    private EmployeeBiDirectional employee;

    public EmployeeBiDirectional getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBiDirectional employee) {
        this.employee = employee;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

}
