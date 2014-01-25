package org.ifbma.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "due_bills_summed", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DueBillsSummed.findAll", query = "SELECT d FROM DueBillsSummed d"),
    @NamedQuery(name = "DueBillsSummed.findByCount", query = "SELECT d FROM DueBillsSummed d WHERE d.count = :count"),
    @NamedQuery(name = "DueBillsSummed.findByCustomer", query = "SELECT d FROM DueBillsSummed d WHERE d.customer = :customer"),
    @NamedQuery(name = "DueBillsSummed.findBySum", query = "SELECT d FROM DueBillsSummed d WHERE d.sum = :sum")})
public class DueBillsSummed implements Serializable {

    private static final long serialVersionUID = -3655991437788788923L;
    @Column(name = "count")
    private BigInteger count;
    @Column(name = "customer")
    @Id
    private Integer customer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sum", precision = 17, scale = 17)
    private Double sum;

    public DueBillsSummed() {
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
