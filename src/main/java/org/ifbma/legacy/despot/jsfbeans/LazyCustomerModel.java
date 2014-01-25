package org.ifbma.legacy.despot.jsfbeans;

import java.util.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.ifbma.legacy.despot.entities.LegacyCustomer;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named(value = "lazyCustomerModel")
public class LazyCustomerModel extends LazyDataModel<LegacyCustomer> {

    private static final Logger LOG = Logger.getLogger(LazyCustomerModel.class.getName());

    @EJB
    CustomerFacade datasource = null;

    public LazyCustomerModel() {
    }

    @PostConstruct
    public void init() {
        LOG.info("@PostConstruct LazyCustomerModel.");
        this.setRowCount(getCount(new HashMap<String, String>()));
    }

    @Override
    public LegacyCustomer getRowData(String rowKey) {
        return datasource.find(Integer.parseInt(rowKey));
    }

    @Override
    public Object getRowKey(LegacyCustomer entity) {
        return entity.getId();
    }

    @Override
    public List<LegacyCustomer> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, String> filters) {

        List<LegacyCustomer> data = datasource.findRange(
                new int[]{first, first + pageSize}, sortField, sortOrder,
                getExplodedFilters(filters));

        this.setRowCount(getCount(filters));
        return data;
    }

    int getCount(Map<String, String> filters) {
        final int count = datasource.count(getExplodedFilters(filters));
        return count;
    }

    /**
     * Helper method to explode the filter entry 'globalFilter' from
     * primefaces to the entries to be filtered by. As it turns out, the
     * primefaces page does not call the load function with the filter
     * columns, values and search modes set in the jsf page. This is a
     * workaround to remedy at least the columns to be searched.
     * <p/>
     * @param filters
     * @return
     */
    private Map<String, String> getExplodedFilters(Map<String, String> filters) {
        Map<String, String> explodedFilter = new HashMap<String, String>();
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            if (filter.getKey().equals("globalFilter")) {
                explodedFilter.put("kuerzel", filter.getValue());
                explodedFilter.put("firmierung1", filter.getValue());
                explodedFilter.put("strasse", filter.getValue());
                explodedFilter.put("kundennummer", filter.getValue());
            } else {
                explodedFilter.put(filter.getKey(), filter.getValue());
            }
        }
        return explodedFilter;
    }
}
