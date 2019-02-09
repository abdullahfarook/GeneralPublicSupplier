package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
public class Factories {
    private int factoryId;
    private String factoryName;
    private Collection<PurchaseOrder> purchaseOrder;
    private String factoryContractorName;
    private String factoryNo;
    private String factoryCity;
    private String factoryLocation;
    private String factoryMajor;

    @Id
    @Column(name = "Factory_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factories")
    public Collection<PurchaseOrder> getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(Collection<PurchaseOrder> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Basic
    @Column(name = "Factory_Name")
    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Basic
    @Column(name = "Factory_Contractor_Name")
    public String getFactoryContractorName() {
        return factoryContractorName;
    }

    public void setFactoryContractorName(String factoryContractorName) {
        this.factoryContractorName = factoryContractorName;
    }

    @Basic
    @Column(name = "Factory_No")
    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    @Basic
    @Column(name = "Factory_City")
    public String getFactoryCity() {
        return factoryCity;
    }

    public void setFactoryCity(String factoryCity) {
        this.factoryCity = factoryCity;
    }

    @Basic
    @Column(name = "Factory_Location")
    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    @Basic
    @Column(name = "Factory_Major")
    public String getFactoryMajor() {
        return factoryMajor;
    }

    public void setFactoryMajor(String factoryMajor) {
        this.factoryMajor = factoryMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factories factories = (Factories) o;

        if (factoryId != factories.factoryId) return false;
        if (factoryName != null ? !factoryName.equals(factories.factoryName) : factories.factoryName != null)
            return false;
        if (factoryContractorName != null ? !factoryContractorName.equals(factories.factoryContractorName) : factories.factoryContractorName != null)
            return false;
        if (factoryNo != null ? !factoryNo.equals(factories.factoryNo) : factories.factoryNo != null) return false;
        if (factoryCity != null ? !factoryCity.equals(factories.factoryCity) : factories.factoryCity != null)
            return false;
        if (factoryLocation != null ? !factoryLocation.equals(factories.factoryLocation) : factories.factoryLocation != null)
            return false;
        if (factoryMajor != null ? !factoryMajor.equals(factories.factoryMajor) : factories.factoryMajor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = factoryId;
        result = 31 * result + (factoryName != null ? factoryName.hashCode() : 0);
        result = 31 * result + (factoryContractorName != null ? factoryContractorName.hashCode() : 0);
        result = 31 * result + (factoryNo != null ? factoryNo.hashCode() : 0);
        result = 31 * result + (factoryCity != null ? factoryCity.hashCode() : 0);
        result = 31 * result + (factoryLocation != null ? factoryLocation.hashCode() : 0);
        result = 31 * result + (factoryMajor != null ? factoryMajor.hashCode() : 0);
        return result;
    }
}
