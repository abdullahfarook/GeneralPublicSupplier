package Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "SMALL_FIRMS", schema = "dbo", catalog = "ProjectDB")
public class SmallFirms {
    private int smallFirmId;
    private String smallFirmName;
    private String smallFirmContactorName;
    private String smallFirmNo;
    private String smallFirmCity;
    private String smallFirmState;
    private String smallFirmLocation;

    private Collection<ProductSmallfirm> productSmallfirm;
    private Collection<SmallfirmMachines> smallfirmMachines;

    @Id
    @Column(name = "SmallFirm_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSmallFirmId() {
        return smallFirmId;
    }

    public void setSmallFirmId(int smallFirmId) {
        this.smallFirmId = smallFirmId;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="smallFirm")
    public Collection<ProductSmallfirm> getProductSmallfirm() {
        return productSmallfirm;
    }

    public void setProductSmallfirm(Collection<ProductSmallfirm> productSmallfirm) {
        this.productSmallfirm = productSmallfirm;
    }


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "smallFirm")
    public Collection<SmallfirmMachines> getSmallfirmMachines() {
        return smallfirmMachines;
    }

    public void setSmallfirmMachines(Collection<SmallfirmMachines> smallfirmMachines) {
        this.smallfirmMachines = smallfirmMachines;
    }

    @Basic
    @Column(name = "SmallFirm_Name")
    public String getSmallFirmName() {
        return smallFirmName;
    }

    public void setSmallFirmName(String smallFirmName) {
        this.smallFirmName = smallFirmName;
    }

    @Basic
    @Column(name = "SmallFirm_Contactor_Name")
    public String getSmallFirmContactorName() {
        return smallFirmContactorName;
    }

    public void setSmallFirmContactorName(String smallFirmContactorName) {
        this.smallFirmContactorName = smallFirmContactorName;
    }

    @Basic
    @Column(name = "SmallFirm_NO")
    public String getSmallFirmNo() {
        return smallFirmNo;
    }

    public void setSmallFirmNo(String smallFirmNo) {
        this.smallFirmNo = smallFirmNo;
    }

    @Basic
    @Column(name = "SmallFirm_City")
    public String getSmallFirmCity() {
        return smallFirmCity;
    }

    public void setSmallFirmCity(String smallFirmCity) {
        this.smallFirmCity = smallFirmCity;
    }

    @Basic
    @Column(name = "SmallFirm_State")
    public String getSmallFirmState() {
        return smallFirmState;
    }

    public void setSmallFirmState(String smallFirmState) {
        this.smallFirmState = smallFirmState;
    }

    @Basic
    @Column(name = "SmallFirm_Location")
    public String getSmallFirmLocation() {
        return smallFirmLocation;
    }

    public void setSmallFirmLocation(String smallFirmLocation) {
        this.smallFirmLocation = smallFirmLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallFirms that = (SmallFirms) o;

        if (smallFirmId != that.smallFirmId) return false;
        if (smallFirmName != null ? !smallFirmName.equals(that.smallFirmName) : that.smallFirmName != null)
            return false;
        if (smallFirmContactorName != null ? !smallFirmContactorName.equals(that.smallFirmContactorName) : that.smallFirmContactorName != null)
            return false;
        if (smallFirmNo != null ? !smallFirmNo.equals(that.smallFirmNo) : that.smallFirmNo != null) return false;
        if (smallFirmCity != null ? !smallFirmCity.equals(that.smallFirmCity) : that.smallFirmCity != null)
            return false;
        if (smallFirmState != null ? !smallFirmState.equals(that.smallFirmState) : that.smallFirmState != null)
            return false;
        if (smallFirmLocation != null ? !smallFirmLocation.equals(that.smallFirmLocation) : that.smallFirmLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smallFirmId;
        result = 31 * result + (smallFirmName != null ? smallFirmName.hashCode() : 0);
        result = 31 * result + (smallFirmContactorName != null ? smallFirmContactorName.hashCode() : 0);
        result = 31 * result + (smallFirmNo != null ? smallFirmNo.hashCode() : 0);
        result = 31 * result + (smallFirmCity != null ? smallFirmCity.hashCode() : 0);
        result = 31 * result + (smallFirmState != null ? smallFirmState.hashCode() : 0);
        result = 31 * result + (smallFirmLocation != null ? smallFirmLocation.hashCode() : 0);
        return result;
    }
}
