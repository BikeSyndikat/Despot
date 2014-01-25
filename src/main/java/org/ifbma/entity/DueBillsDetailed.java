package org.ifbma.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "due_bills_detailed", catalog = "despot", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DueBillsDetailed.findAll", query = "SELECT d FROM DueBillsDetailed d"),
    @NamedQuery(name = "DueBillsDetailed.findById", query = "SELECT d FROM DueBillsDetailed d WHERE d.id = :id"),
    @NamedQuery(name = "DueBillsDetailed.findByCustomer", query = "SELECT d FROM DueBillsDetailed d WHERE d.customer = :customer"),
    @NamedQuery(name = "DueBillsDetailed.findByPickup", query = "SELECT d FROM DueBillsDetailed d WHERE d.pickup = :pickup"),
    @NamedQuery(name = "DueBillsDetailed.findByDelivery", query = "SELECT d FROM DueBillsDetailed d WHERE d.delivery = :delivery"),
    @NamedQuery(name = "DueBillsDetailed.findByComment", query = "SELECT d FROM DueBillsDetailed d WHERE d.comment = :comment"),
    @NamedQuery(name = "DueBillsDetailed.findByStatus", query = "SELECT d FROM DueBillsDetailed d WHERE d.status = :status"),
    @NamedQuery(name = "DueBillsDetailed.findByPrice", query = "SELECT d FROM DueBillsDetailed d WHERE d.price = :price")})
public class DueBillsDetailed implements Serializable {

    private static final long serialVersionUID = 7303246367270857484L;
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "customer")
    private Integer customer;
    @Column(name = "pickup")
    private Integer pickup;
    @Column(name = "delivery")
    private Integer delivery;
    @Size(max = 128)
    @Column(name = "comment", length = 128)
    private String comment;
    @Column(name = "status")
    private Integer status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 17, scale = 17)
    private Double price;

    public DueBillsDetailed() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
