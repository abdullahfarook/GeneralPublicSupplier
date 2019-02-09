package Models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sunny on 1/24/2016.
 */
@Entity
@Table(name = "PRODUCT_SMALLFIRM", schema = "dbo", catalog = "ProjectDB")
@IdClass(ProductSmallfirmPK.class)
public class ProductSmallfirm {
    private int smallFirmId;
    private int productId;
    private Integer quantity;
    private Timestamp timeRequired;
    private Products product;
    private  SmallFirms smallFirm;

    @Id
    @Column(name = "SmallFirm_ID")
    public int getSmallFirmId() {
        return smallFirmId;
    }

    public void setSmallFirmId(int smallFirmId) {
        this.smallFirmId = smallFirmId;
    }

    @Id
    @Column(name = "Product_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name ="Product_ID", insertable =false,updatable = false,referencedColumnName = "Product_ID")
    })
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "SmallFirm_ID",insertable = false,updatable = false,referencedColumnName = "SmallFirm_ID")

            })
    public SmallFirms getSmallFirm() {
        return smallFirm;
    }

    public void setSmallFirm(SmallFirms smallFirm) {
        this.smallFirm = smallFirm;
    }

    @Basic
    @Column(name = "Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Time_Required")
    public Timestamp getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(Timestamp timeRequired) {
        this.timeRequired = timeRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSmallfirm that = (ProductSmallfirm) o;

        if (smallFirmId != that.smallFirmId) return false;
        if (productId != that.productId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (timeRequired != null ? !timeRequired.equals(that.timeRequired) : that.timeRequired != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smallFirmId;
        result = 31 * result + productId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (timeRequired != null ? timeRequired.hashCode() : 0);
        return result;
    }
}
