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
@Table(name = "address", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll",
            query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById",
            query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByZip",
            query = "SELECT a FROM Address a WHERE a.zip = :zip"),
    @NamedQuery(name = "Address.findByStreet",
            query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findByProvince",
            query = "SELECT a FROM Address a WHERE a.province = :province"),
    @NamedQuery(name = "Address.findByNumber",
            query = "SELECT a FROM Address a WHERE a.number = :number"),
    @NamedQuery(name = "Address.findByLine1",
            query = "SELECT a FROM Address a WHERE a.line1 = :line1"),
    @NamedQuery(name = "Address.findByAdditionalDetail",
            query = "SELECT a FROM Address a WHERE a.additionalDetail = :additionalDetail"),
    @NamedQuery(name = "Address.findByLine2",
            query = "SELECT a FROM Address a WHERE a.line2 = :line2"),
    @NamedQuery(name = "Address.findByCountry",
            query = "SELECT a FROM Address a WHERE a.country = :country"),
    @NamedQuery(name = "Address.findByCity",
            query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Addres.search",
            query = "select a from address a where a.fullTextRepresentation LIKE :fullTextRepresentation")
})
public class Address extends ShortableElement implements Serializable {

    private static final long serialVersionUID = 169282787682739780L;
    @Id
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "zip", length = 8)
    private String zip;
    @Column(name = "street", length = 64)
    private String street;
    @Column(name = "province", length = 64)
    private String province;
    @Column(name = "number", length = 16)
    private String number;
    @Column(name = "line_1", length = 64)
    private String line1;
    @Column(name = "additional_detail", length = 32)
    private String additionalDetail;
    @Column(name = "line_2", length = 64)
    private String line2;
    @Basic(optional = false)
    @Column(name = "country", nullable = false, length = 64)
    private String country;
    @Column(name = "city", length = 64)
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pickup")
    private Collection<Consignment> consignmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private Collection<Consignment> consignmentCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Collection<Customer> customerCollection;
    @Column(name = "full_text_representation")
    private String fullTextRepresentation;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String country) {
        this.id = id;
        this.country = country;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getAdditionalDetail() {
        return additionalDetail;
    }

    public void setAdditionalDetail(String additionalDetail) {
        this.additionalDetail = additionalDetail;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Consignment> getConsignmentCollection() {
        return consignmentCollection;
    }

    public void setConsignmentCollection(Collection<Consignment> consignmentCollection) {
        this.consignmentCollection = consignmentCollection;
    }

    @XmlTransient
    public Collection<Consignment> getConsignmentCollection1() {
        return consignmentCollection1;
    }

    public void setConsignmentCollection1(Collection<Consignment> consignmentCollection1) {
        this.consignmentCollection1 = consignmentCollection1;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public String getFullTextRepresentation() {
        return fullTextRepresentation;
    }

    public void setFullTextRepresentation(String fullTextRepresentation) {
        this.fullTextRepresentation = fullTextRepresentation;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return line1;
    }

    @Override
    public String getClazz() {
        return null;
    }

    public String getFormattedAddress() {
        final String lf = "\n";
        return line1 + lf + line2 + lf + additionalDetail + lf
                + street + " " + number + lf
                + zip + " " + city
                + country + ", " + province;
    }
}
