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
@Table(name = "rider", catalog = "despot", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nick"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rider.findAll", query = "SELECT r FROM Rider r"),
    @NamedQuery(name = "Rider.findById", query = "SELECT r FROM Rider r WHERE r.id = :id"),
    @NamedQuery(name = "Rider.findByLastName", query = "SELECT r FROM Rider r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Rider.findByNick", query = "SELECT r FROM Rider r WHERE r.nick = :nick"),
    @NamedQuery(name = "Rider.findByFirstName", query = "SELECT r FROM Rider r WHERE r.firstName = :firstName")})
public class Rider extends ShortableElement implements Serializable {

    private static final long serialVersionUID = -3953121622058297028L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "last_name", length = 64)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "nick", nullable = false, length = 32)
    private String nick;
    @Column(name = "first_name", length = 64)
    private String firstName;
    @OneToMany(mappedBy = "rider")
    private Collection<Consignment> consignmentCollection;

    public Rider() {
    }

    public Rider(Integer id) {
        this.id = id;
    }

    public Rider(Integer id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        if (!(object instanceof Rider)) {
            return false;
        }
        Rider other = (Rider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nick + " (" + id + ") ";
    }

    @Override
    public String getClazz() {
        return null;
    }
}
