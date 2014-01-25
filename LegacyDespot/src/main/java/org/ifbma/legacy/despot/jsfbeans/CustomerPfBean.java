package org.ifbma.legacy.despot.jsfbeans;

import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.ifbma.legacy.despot.entities.LegacyCustomer;

/**
 * Jsf bean for primefaces. Uses its own lazy data model and paging and does
 * not always need to operate on data model array structures.
 * <p/>
 * @author norbert
 */
@Named("customers")
@SessionScoped
public class CustomerPfBean implements Serializable {

    @EJB
    CustomerFacade facade;
    @Inject
    LazyCustomerModel model;

    private List<LegacyCustomer> filteredItems = null;
    private LegacyCustomer selectedCustomer = null;

    public CustomerPfBean() {
    }

    public List<LegacyCustomer> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<LegacyCustomer> filteredItems) {
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

    public LegacyCustomer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(LegacyCustomer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

}
