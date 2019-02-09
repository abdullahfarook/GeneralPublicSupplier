package Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sunny on 1/24/2016.
 */
public class SamplePK implements Serializable {
    private int orderId;
    private int laboratoryId;

    @Column(name = "Order_ID")
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "Laboratory_ID")
    @Id
    public int getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamplePK samplePK = (SamplePK) o;

        if (orderId != samplePK.orderId) return false;
        if (laboratoryId != samplePK.laboratoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + laboratoryId;
        return result;
    }
}
