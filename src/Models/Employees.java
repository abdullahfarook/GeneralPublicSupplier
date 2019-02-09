package Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Employees {
    private int employeeId;

    private Collection<PurchaseOrder> purchaseOrders;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeTitle;
    private Date employeeHireDate;
    private String employeeNo;
    private String employeeCity;
    private String employeeState;
    private String employeeLocation;
    private Integer employeeSallery;
    private String employeeUser;
    private String employeePass;



    @Id
    @Column(name = "Employee_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    public Collection<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Collection<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @Basic
    @Column(name = "Employee_First_Name")
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    @Basic
    @Column(name = "Employee_Last_Name")
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @Basic
    @Column(name = "Employee_Title")
    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    @Basic
    @Column(name = "Employee_Hire_Date")
    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    @Basic
    @Column(name = "Employee_No")
    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    @Basic
    @Column(name = "Employee_City")
    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    @Basic
    @Column(name = "Employee_State")
    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    @Basic
    @Column(name = "Employee_Location")
    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }

    @Basic
    @Column(name = "Employee_Sallery")
    public Integer getEmployeeSallery() {
        return employeeSallery;
    }

    public void setEmployeeSallery(Integer employeeSallery) {
        this.employeeSallery = employeeSallery;
    }

    @Basic
    @Column(name = "Employee_User")
    public String getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(String employeeuser) {
        this.employeeUser = employeeuser;
    }

    @Basic
    @Column(name = "Employee_Pass")
    public String getEmployeePass() {
        return employeePass;
    }

    public void setEmployeePass(String employeepass) {
        this.employeePass = employeepass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeId != employees.employeeId) return false;
        if (employeeFirstName != null ? !employeeFirstName.equals(employees.employeeFirstName) : employees.employeeFirstName != null)
            return false;
        if (employeeLastName != null ? !employeeLastName.equals(employees.employeeLastName) : employees.employeeLastName != null)
            return false;
        if (employeeTitle != null ? !employeeTitle.equals(employees.employeeTitle) : employees.employeeTitle != null)
            return false;
        if (employeeHireDate != null ? !employeeHireDate.equals(employees.employeeHireDate) : employees.employeeHireDate != null)
            return false;
        if (employeeNo != null ? !employeeNo.equals(employees.employeeNo) : employees.employeeNo != null) return false;
        if (employeeCity != null ? !employeeCity.equals(employees.employeeCity) : employees.employeeCity != null)
            return false;
        if (employeeState != null ? !employeeState.equals(employees.employeeState) : employees.employeeState != null)
            return false;
        if (employeeLocation != null ? !employeeLocation.equals(employees.employeeLocation) : employees.employeeLocation != null)
            return false;
        if (employeeSallery != null ? !employeeSallery.equals(employees.employeeSallery) : employees.employeeSallery != null)
            return false;
        if (employeeUser != null ? !employeeUser.equals(employees.employeeUser) : employees.employeeUser != null)
            return false;
        if (employeePass != null ? !employeePass.equals(employees.employeePass) : employees.employeePass != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (employeeFirstName != null ? employeeFirstName.hashCode() : 0);
        result = 31 * result + (employeeLastName != null ? employeeLastName.hashCode() : 0);
        result = 31 * result + (employeeTitle != null ? employeeTitle.hashCode() : 0);
        result = 31 * result + (employeeHireDate != null ? employeeHireDate.hashCode() : 0);
        result = 31 * result + (employeeNo != null ? employeeNo.hashCode() : 0);
        result = 31 * result + (employeeCity != null ? employeeCity.hashCode() : 0);
        result = 31 * result + (employeeState != null ? employeeState.hashCode() : 0);
        result = 31 * result + (employeeLocation != null ? employeeLocation.hashCode() : 0);
        result = 31 * result + (employeeSallery != null ? employeeSallery.hashCode() : 0);
        result = 31 * result + (employeeUser != null ? employeeUser.hashCode() : 0);
        result = 31 * result + (employeePass != null ? employeePass.hashCode() : 0);
        return result;
    }


}
