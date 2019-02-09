package Models;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@IdClass(SamplePK.class)
public class Sample {
    private int orderId;
    private int laboratoryId;
    private String sampleDetails;
    private Blob picture;
    private Laboratories laboratorie;
    private PurchaseOrder purchaseOrder;

    @Id
    @Column(name = "Order_ID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "Laboratory_ID")
    public int getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Laboratory_ID",insertable = false,updatable = false,referencedColumnName = "Laboratory_ID")
    })
    public Laboratories getLaboratorie() {
        return laboratorie;
    }

    public void setLaboratorie(Laboratories laboratorie) {
        this.laboratorie = laboratorie;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Order_ID",insertable = false,updatable = false,referencedColumnName = "Order_ID")
    })
    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Basic
    @Column(name = "Sample_Details")
    public String getSampleDetails() {
        return sampleDetails;
    }

    public void setSampleDetails(String sampleDetails) {
        this.sampleDetails = sampleDetails;
    }

    @Lob
    @Basic
    @Column(name = "picture")
    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sample sample = (Sample) o;

        if (orderId != sample.orderId) return false;
        if (laboratoryId != sample.laboratoryId) return false;
        if (sampleDetails != null ? !sampleDetails.equals(sample.sampleDetails) : sample.sampleDetails != null)
            return false;
        if (picture != null ? !picture.equals(sample.picture) : sample.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + laboratoryId;
        result = 31 * result + (sampleDetails != null ? sampleDetails.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
