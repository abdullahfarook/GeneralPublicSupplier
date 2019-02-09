package Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ORDER_DETAILS", schema = "dbo", catalog = "ProjectDB")
@IdClass(OrderDetailsPK.class)
public class OrderDetails {
    private int orderId;
    private PurchaseOrder purchaseOrders;
    private Products products;
    private int productId;
    private Double unitPrice;
    private Integer orderQuantity;

    @Id
    @Column(name = "Order_ID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "Product_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "Product_ID",insertable = false,updatable = false,referencedColumnName = "Product_ID")
    })
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "Order_ID",insertable = false,updatable = false,referencedColumnName = "Order_ID")
    })
    public PurchaseOrder getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(PurchaseOrder purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }



    @Basic
    @Column(name = "Unit_Price")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "Order_Quantity")
    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (orderQuantity != null ? !orderQuantity.equals(that.orderQuantity) : that.orderQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + productId;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (orderQuantity != null ? orderQuantity.hashCode() : 0);
        return result;
    }
}
