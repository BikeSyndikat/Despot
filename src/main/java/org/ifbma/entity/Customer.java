package org.ifbma.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "customer", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findReservedCashEntry", query = "SELECT c FROM Customer c WHERE c.paymentstatus = -1"),
    @NamedQuery(name = "Customer.findByCreated", query = "SELECT c FROM Customer c WHERE c.created = :created"),
    @NamedQuery(name = "Customer.findByComment", query = "SELECT c FROM Customer c WHERE c.comment = :comment"),
    @NamedQuery(name = "Customer.findByModified", query = "SELECT c FROM Customer c WHERE c.modified = :modified"),
    @NamedQuery(name = "Customer.findByPaymentstatus", query = "SELECT c FROM Customer c WHERE c.paymentstatus = :paymentstatus")})
public class Customer extends ShortableElement implements Serializable {

    private static final long serialVersionUID = -8286608075867632307L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = true)
    @NotNull // FIXME
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
    @Size(max = 128)
    @Column(name = "comment", length = 128)
    private String comment;
    @Basic(optional = true)
    @NotNull // FIXME
    @Column(name = "modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = new Date();
    @Basic(optional = false)
    @NotNull // FIXME
    @Column(name = "paymentstatus", nullable = false)
    private int paymentstatus;
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Address address;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, Date created, Date modified, int paymentstatus) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.paymentstatus = paymentstatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
        this.modified = new Date();
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(int paymentstatus) {
        this.paymentstatus = paymentstatus;
        this.modified = new Date();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.modified = new Date();
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return comment + " (" + id + " )";
    }

    public String getFormattedAddress() {
        final String LF = "\n";
        return comment + LF + paymentstatus + LF + LF
                + " ==== " + address.getFormattedAddress();
    }

    @Override
    public String getClazz() {
        return null;
    }
}
