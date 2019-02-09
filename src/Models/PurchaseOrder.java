package Models;

import javax.persistence.*;
import java.sql.Date;
import java.text.CollationElementIterator;
import java.util.Collection;


@Entity
@Table(name = "PURCHASE_ORDER", schema = "dbo", catalog = "ProjectDB")
public class PurchaseOrder {
    private int orderId;
    private int factoryId;
    private int employeeId;
    private Factories factories;
    private Employees employees;
    private Date orderDate;
    private Date requiredDate;
    private Date shipmentDate;
    private String orderSpecs;
    private Collection<OrderDetails> orderDetails;
    private Collection<Sample> samples;




    @Id
    @Column(name = "Order_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "purchaseOrder")
    public Collection<Sample> getSamples() {
        return samples;
    }

    public void setSamples(Collection<Sample> samples) {
        this.samples = samples;
    }

    @Basic
    @Column(name = "Factory_ID")
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    @Basic
    @Column(name = "Employee_ID")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "Employee_ID")
    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "Factory_ID")
    public Factories getFactories() {
        return factories;
    }

    public void setFactories(Factories factories) {
        this.factories = factories;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrders")
    public Collection<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Basic
    @Column(name = "Order_Date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "Required_Date")
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Basic
    @Column(name = "Shipment_Date")
    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    @Basic
    @Column(name = "Order_Specs")
    public String getOrderSpecs() {
        return orderSpecs;
    }

    public void setOrderSpecs(String orderSpecs) {
        this.orderSpecs = orderSpecs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseOrder that = (PurchaseOrder) o;

        if (orderId != that.orderId) return false;
        if (factoryId != that.factoryId) return false;
        if (employeeId != that.employeeId) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(that.requiredDate) : that.requiredDate != null) return false;
        if (shipmentDate != null ? !shipmentDate.equals(that.shipmentDate) : that.shipmentDate != null) return false;
        if (orderSpecs != null ? !orderSpecs.equals(that.orderSpecs) : that.orderSpecs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + factoryId;
        result = 31 * result + employeeId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shipmentDate != null ? shipmentDate.hashCode() : 0);
        result = 31 * result + (orderSpecs != null ? orderSpecs.hashCode() : 0);
        return result;
    }
}
