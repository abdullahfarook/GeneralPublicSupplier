package Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
public class ProductSmallfirmPK implements Serializable {
    private int smallFirmId;
    private int productId;

    @Column(name = "SmallFirm_ID")
    public int getSmallFirmId() {
        return smallFirmId;
    }

    public void setSmallFirmId(int smallFirmId) {
        this.smallFirmId = smallFirmId;
    }

    @Column(name = "Product_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSmallfirmPK that = (ProductSmallfirmPK) o;

        if (smallFirmId != that.smallFirmId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smallFirmId;
        result = 31 * result + productId;
        return result;
    }
}
