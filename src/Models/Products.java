package Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Sunny on 1/24/2016.
 */
@Entity
public class Products {
    private int productId;
    private String productName;
    private Double pricePerUnit;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Timestamp requiredTime;
    private Collection<OrderDetails> orderDetails;
    private Collection<Markets> markets;
    private Collection<Categores> categores;
    private Collection<ProductSmallfirm> productSmallfirms;


    @Id
    @Column(name = "Product_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public Collection<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="product")
    public Collection<Markets> getMarkets() {
        return markets;
    }

    public void setMarkets(Collection<Markets> markets) {
        this.markets = markets;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="product")
    public Collection<Categores> getCategores() {
        return categores;
    }

    public void setCategores(Collection<Categores> categores) {
        this.categores = categores;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="product")
    public Collection<ProductSmallfirm> getProductSmallfirms() {
        return productSmallfirms;
    }


    public void setProductSmallfirms(Collection<ProductSmallfirm> productSmallfirms) {
        this.productSmallfirms = productSmallfirms;
    }

    @Basic
    @Column(name = "Product_Name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "Price_Per_Unit")
    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Basic
    @Column(name = "Units_In_Stock")
    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Basic
    @Column(name = "Units_On_Order")
    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    @Basic
    @Column(name = "Required_Time")
    public Timestamp getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Timestamp requiredTime) {
        this.requiredTime = requiredTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (productId != products.productId) return false;
        if (productName != null ? !productName.equals(products.productName) : products.productName != null)
            return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(products.pricePerUnit) : products.pricePerUnit != null)
            return false;
        if (unitsInStock != null ? !unitsInStock.equals(products.unitsInStock) : products.unitsInStock != null)
            return false;
        if (unitsOnOrder != null ? !unitsOnOrder.equals(products.unitsOnOrder) : products.unitsOnOrder != null)
            return false;
        if (requiredTime != null ? !requiredTime.equals(products.requiredTime) : products.requiredTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        result = 31 * result + (unitsInStock != null ? unitsInStock.hashCode() : 0);
        result = 31 * result + (unitsOnOrder != null ? unitsOnOrder.hashCode() : 0);
        result = 31 * result + (requiredTime != null ? requiredTime.hashCode() : 0);
        return result;
    }
}
