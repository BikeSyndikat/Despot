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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "bill", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByStartdate", query = "SELECT b FROM Bill b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Bill.findByEnddate", query = "SELECT b FROM Bill b WHERE b.enddate = :enddate"),
    @NamedQuery(name = "Bill.findByAmountDue", query = "SELECT b FROM Bill b WHERE b.amountDue = :amountDue"),
    @NamedQuery(name = "Bill.findByBillType", query = "SELECT b FROM Bill b WHERE b.billType = :billType")
})
public class Bill implements Serializable {

    private static final long serialVersionUID = -7340101207746747253L;
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
    @Column(name = "amount_due", nullable = false)
    private double amountDue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_type", nullable = false)
    private int billType;
    @JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, Date startdate, Date enddate, double amountDue, int billType) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.amountDue = amountDue;
        this.billType = billType;
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

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.customer.getComment() + " " + this.enddate.toString();
    }
}
