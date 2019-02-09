package Models;

import javax.persistence.*;

/**
 * Created by Sunny on 1/24/2016.
 */
@Entity
@Table(name = "SMALLFIRM_MACHINES", schema = "dbo", catalog = "ProjectDB")
@IdClass(SmallfirmMachinesPK.class)
public class SmallfirmMachines {
    private int smallFirmId;
    private String machines;
    private SmallFirms smallFirm;

    @Id
    @Column(name = "SmallFirm_ID")
    public int getSmallFirmId() {
        return smallFirmId;
    }

    public void setSmallFirmId(int smallFirmId) {
        this.smallFirmId = smallFirmId;
    }

    @ManyToOne
    @JoinColumn(name = "SmallFirm_ID",insertable = false,updatable = false)
    public SmallFirms getSmallFirm() {
        return smallFirm;
    }

    public void setSmallFirm(SmallFirms smallFirm) {
        this.smallFirm = smallFirm;
    }

    @Id
    @Column(name = "Machines")
    public String getMachines() {
        return machines;
    }

    public void setMachines(String machines) {
        this.machines = machines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallfirmMachines that = (SmallfirmMachines) o;

        if (smallFirmId != that.smallFirmId) return false;
        if (machines != null ? !machines.equals(that.machines) : that.machines != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smallFirmId;
        result = 31 * result + (machines != null ? machines.hashCode() : 0);
        return result;
    }
}
