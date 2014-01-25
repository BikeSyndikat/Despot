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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "consignment", catalog = "despot", schema = "public")
// FIXME: Insert index creation here:
// CREATE INDEX key_consignment_scheduled ON consignment USING btree (scheduled);
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consignment.findAll", query = "SELECT c FROM Consignment c"),
    @NamedQuery(name = "Consignment.findImportant", query = "SELECT c FROM Consignment c ORDER BY c.scheduled DESC"),
    @NamedQuery(name = "Consignment.findById", query = "SELECT c FROM Consignment c WHERE c.id = :id"),
    @NamedQuery(name = "Consignment.findByPrice", query = "SELECT c FROM Consignment c WHERE c.price = :price"),
    @NamedQuery(name = "Consignment.findByCreated", query = "SELECT c FROM Consignment c WHERE c.created = :created"),
    @NamedQuery(name = "Consignment.findByComment", query = "SELECT c FROM Consignment c WHERE c.comment = :comment"),
    @NamedQuery(name = "Consignment.findByModified", query = "SELECT c FROM Consignment c WHERE c.modified = :modified"),
    @NamedQuery(name = "Consignment.findBillable", query = "SELECT c FROM Consignment c WHERE c.scheduled > :startDate AND c.scheduled < :endDate AND c.status = :status"),
    @NamedQuery(name = "Consignment.findByScheduled", query = "SELECT c FROM Consignment c WHERE c.scheduled = :scheduled")})
public class Consignment implements Serializable {

    private static final long serialVersionUID = 4670564536573687371L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull // FIXME
    @Column(name = "price", nullable = false)
    private double price;
    @Basic(optional = true)
    @NotNull // FIXME
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
    @Size(max = 128) // FIXME
    @Column(name = "comment", length = 128)
    private String comment;
    @Basic(optional = true)
    @NotNull // FIXME
    @Column(name = "modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = new Date();
    @Column(name = "scheduled")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduled;
    @JoinColumn(name = "rider", referencedColumnName = "id")
    @ManyToOne
    private Rider rider;
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ConsignmentStatus status;
    @JoinColumn(name = "pickup", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Address pickup;
    @JoinColumn(name = "delivery", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Address delivery;
    @JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public Consignment() {
    }

    public Consignment(Integer id) {
        this.id = id;
    }

    public Consignment(Integer id, double price, Date created, Date modified) {
        this.id = id;
        this.price = price;
        this.created = created;
        this.modified = modified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.modified = new Date();
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

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
        this.modified = new Date();
    }

    @XmlJavaTypeAdapter(EntityShortener.class)
    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
        this.modified = new Date();
    }

    @XmlJavaTypeAdapter(EntityShortener.class)
    public ConsignmentStatus getStatus() {
        return status;
    }

    public void setStatus(ConsignmentStatus status) {
        this.status = status;
        this.modified = new Date();
    }

    public Address getPickup() {
        return pickup;
    }

    public void setPickup(Address pickup) {
        this.pickup = pickup;
        this.modified = new Date();
    }

    @XmlJavaTypeAdapter(EntityShortener.class)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.modified = new Date();
    }

    @XmlJavaTypeAdapter(EntityShortener.class)
    public Address getDelivery() {
        return delivery;
    }

    public void setDelivery(Address delivery) {
        this.delivery = delivery;
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
        if (!(object instanceof Consignment)) {
            return false;
        }
        Consignment other = (Consignment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ifbma.entity.Consignment[ id=" + id + " ]";
    }
}
