package org.ifbma.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "billrun", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billrun.findAll", query = "SELECT b FROM Billrun b"),
    @NamedQuery(name = "Billrun.findById", query = "SELECT b FROM Billrun b WHERE b.id = :id"),
    @NamedQuery(name = "Billrun.findByStartdate", query = "SELECT b FROM Billrun b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Billrun.findByEnddate", query = "SELECT b FROM Billrun b WHERE b.enddate = :enddate"),
    @NamedQuery(name = "Billrun.findByStatus", query = "SELECT b FROM Billrun b WHERE b.status = :status")})
public class Billrun implements Serializable {

    private static final long serialVersionUID = -8585934013292930558L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    public Billrun() {
    }

    public Billrun(Integer id) {
        this.id = id;
    }

    public Billrun(Integer id, Date startdate, Date enddate, int status) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        if (!(object instanceof Billrun)) {
            return false;
        }
        Billrun other = (Billrun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ifbma.entity.Billrun[ id=" + id + " ]";
    }
}
