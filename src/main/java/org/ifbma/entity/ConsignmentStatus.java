package org.ifbma.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "consignment_status", catalog = "despot", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsignmentStatus.findAll", query = "SELECT c FROM ConsignmentStatus c"),
    @NamedQuery(name = "ConsignmentStatus.findById", query = "SELECT c FROM ConsignmentStatus c WHERE c.id = :id"),
    @NamedQuery(name = "ConsignmentStatus.findByName", query = "SELECT c FROM ConsignmentStatus c WHERE c.name = :name"),
    @NamedQuery(name = "ConsignmentStatus.findByComment", query = "SELECT c FROM ConsignmentStatus c WHERE c.comment = :comment")})
public class ConsignmentStatus extends ShortableElement implements Serializable {

    private static final long serialVersionUID = -3182131169663333902L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 16)
    private String name;
    @Column(name = "comment", length = 64)
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Consignment> consignmentCollection;

    public ConsignmentStatus() {
    }

    public ConsignmentStatus(Integer id) {
        this.id = id;
    }

    public ConsignmentStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<Consignment> getConsignmentCollection() {
        return consignmentCollection;
    }

    public void setConsignmentCollection(Collection<Consignment> consignmentCollection) {
        this.consignmentCollection = consignmentCollection;
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
        if (!(object instanceof ConsignmentStatus)) {
            return false;
        }
        ConsignmentStatus other = (ConsignmentStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + comment + ") ";
    }

    @Override
    @XmlTransient
    public String getClazz() {
        return null;
    }
}
