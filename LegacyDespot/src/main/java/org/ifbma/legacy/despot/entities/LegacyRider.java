package org.ifbma.legacy.despot.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rider.findAll", query = "SELECT r FROM Rider r"),
    @NamedQuery(name = "Rider.findById", query = "SELECT r FROM Rider r WHERE r.id = :id"),
    @NamedQuery(name = "Rider.findByRiderNumber", query = "SELECT r FROM Rider r WHERE r.riderNumber = :riderNumber"),
    @NamedQuery(name = "Rider.findByAnzahltouren", query = "SELECT r FROM Rider r WHERE r.anzahltouren = :anzahltouren"),
    @NamedQuery(name = "Rider.findByLetztetour", query = "SELECT r FROM Rider r WHERE r.letztetour = :letztetour"),
    @NamedQuery(name = "Rider.findByFullName", query = "SELECT r FROM Rider r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "Rider.findByStatus", query = "SELECT r FROM Rider r WHERE r.status = :status")})
public class LegacyRider implements Serializable {

    private static final long serialVersionUID = 2L;

    /**
     * The following annotations where composed after consulting
     * {@link http://stackoverflow.com/questions/11825643}.
     * <p/>
     */
    @Id
    @SequenceGenerator(name = "rider_id_seq", sequenceName = "rider_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "rider_id_seq")
    @Column(updatable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rider_number")
    private int riderNumber;
    @Basic(optional = false)
    @NotNull
    private int anzahltouren;
    @Temporal(TemporalType.DATE)
    private Date letztetour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 63)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    private int status;

    public LegacyRider() {
    }

    public LegacyRider(Integer id) {
        this.id = id;
    }

    public LegacyRider(Integer id, int riderNumber, int anzahltouren, String fullName, int status) {
        this.id = id;
        this.riderNumber = riderNumber;
        this.anzahltouren = anzahltouren;
        this.fullName = fullName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRiderNumber() {
        return riderNumber;
    }

    public void setRiderNumber(int riderNumber) {
        this.riderNumber = riderNumber;
    }

    public int getAnzahltouren() {
        return anzahltouren;
    }

    public void setAnzahltouren(int anzahltouren) {
        this.anzahltouren = anzahltouren;
    }

    public Date getLetztetour() {
        return letztetour;
    }

    public void setLetztetour(Date letztetour) {
        this.letztetour = letztetour;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegacyRider)) {
            return false;
        }
        LegacyRider other = (LegacyRider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ifbma.legacy.despot.entities.Rider[ id=" + id + " ]";
    }

}
