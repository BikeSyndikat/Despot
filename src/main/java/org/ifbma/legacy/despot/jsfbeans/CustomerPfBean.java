package org.ifbma.legacy.despot.jsfbeans;

import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.ifbma.legacy.despot.entities.Customer;

/**
 * Jsf bean for primefaces. Uses its own lazy data model and paging and does
 * not always need to operate on data model array structures.
 * <p/>
 * @author norbert
 */
@ManagedBean(name = "customers")
@SessionScoped
public class CustomerPfBean implements Serializable {

    @EJB
    CustomerFacade facade;
    @Inject
    LazyCustomerModel model;

    private List<Customer> filteredItems = null;
    private Customer selectedCustomer = null;

    public CustomerPfBean() {
    }

    public List<Customer> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<Customer> filteredItems) {
        this.filteredItems = filteredItems;
    }

    public void setModel(LazyCustomerModel model) {
        this.model = model;
    }

    public LazyCustomerModel getModel() {
        return model;
    }

    public Integer getCount() {
        if (filteredItems != null) {
            return filteredItems.size();
        } else {
            return model.getCount(new HashMap<String, String>());
        }
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

}
