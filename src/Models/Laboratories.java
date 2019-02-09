package Models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Collection;

/**
 * Created by Sunny on 1/24/2016.
 */
@Entity
public class Laboratories {
    private int laboratoryId;
    private String laboratoryName;
    private String laboratoryCity;
    private String laboratoryState;
    private String laboratoryLocation;
    private Byte[] sampleReport;
    private Collection<Sample> samples;

    @Id
    @Column(name = "Laboratory_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "laboratorie")
    public Collection<Sample> getSamples() {
        return samples;
    }

    public void setSamples(Collection<Sample> samples) {
        this.samples = samples;
    }

    @Basic
    @Column(name = "Laboratory_Name")
    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    @Basic
    @Column(name = "Laboratory_City")
    public String getLaboratoryCity() {
        return laboratoryCity;
    }

    public void setLaboratoryCity(String laboratoryCity) {
        this.laboratoryCity = laboratoryCity;
    }

    @Basic
    @Column(name = "Laboratory_State")
    public String getLaboratoryState() {
        return laboratoryState;
    }

    public void setLaboratoryState(String laboratoryState) {
        this.laboratoryState = laboratoryState;
    }

    @Basic
    @Column(name = "Laboratory_Location")
    public String getLaboratoryLocation() {
        return laboratoryLocation;
    }

    public void setLaboratoryLocation(String laboratoryLocation) {
        this.laboratoryLocation = laboratoryLocation;
    }

    @Lob
    @Basic
    @Column(name = "Sample_Report")
    public Byte[] getSampleReport() {
        return sampleReport;
    }

    public void setSampleReport(Byte[] sampleReport) {
        this.sampleReport = sampleReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laboratories that = (Laboratories) o;

        if (laboratoryId != that.laboratoryId) return false;
        if (laboratoryName != null ? !laboratoryName.equals(that.laboratoryName) : that.laboratoryName != null)
            return false;
        if (laboratoryCity != null ? !laboratoryCity.equals(that.laboratoryCity) : that.laboratoryCity != null)
            return false;
        if (laboratoryState != null ? !laboratoryState.equals(that.laboratoryState) : that.laboratoryState != null)
            return false;
        if (laboratoryLocation != null ? !laboratoryLocation.equals(that.laboratoryLocation) : that.laboratoryLocation != null)
            return false;
        if (sampleReport != null ? !sampleReport.equals(that.sampleReport) : that.sampleReport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = laboratoryId;
        result = 31 * result + (laboratoryName != null ? laboratoryName.hashCode() : 0);
        result = 31 * result + (laboratoryCity != null ? laboratoryCity.hashCode() : 0);
        result = 31 * result + (laboratoryState != null ? laboratoryState.hashCode() : 0);
        result = 31 * result + (laboratoryLocation != null ? laboratoryLocation.hashCode() : 0);
        result = 31 * result + (sampleReport != null ? sampleReport.hashCode() : 0);
        return result;
    }
}
