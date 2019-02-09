package Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sunny on 1/24/2016.
 */
public class SmallfirmMachinesPK implements Serializable {
    private int smallFirmId;
    private String machines;

    @Column(name = "SmallFirm_ID")
    @Id
    public int getSmallFirmId() {
        return smallFirmId;
    }

    public void setSmallFirmId(int smallFirmId) {
        this.smallFirmId = smallFirmId;
    }

    @Column(name = "Machines")
    @Id
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

        SmallfirmMachinesPK that = (SmallfirmMachinesPK) o;

        if (smallFirmId != that.smallFirmId) return false;
        return !(machines != null ? !machines.equals(that.machines) : that.machines != null);

    }

    @Override
    public int hashCode() {
        int result = smallFirmId;
        result = 31 * result + (machines != null ? machines.hashCode() : 0);
        return result;
    }
}
