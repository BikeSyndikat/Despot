package org.ifbma.legacy.despot.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.ifbma.legacy.despot.entities.Workorder;
import org.ifbma.legacy.despot.jsf.util.JsfUtil;
import org.ifbma.legacy.despot.jsf.util.PaginationHelper;
import org.ifbma.legacy.despot.jsfbeans.WorkorderFacade;

@Named("workorderController")
@SessionScoped
public class WorkorderController implements Serializable {

    static int PAGE_SIZE = 10;

    private Workorder current;
    private DataModel items = null;
    @EJB
    WorkorderFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public WorkorderController() {
    }

    public Workorder getSelected() {
        if (current == null) {
            current = new Workorder();
            selectedItemIndex = -1;
        }
        return current;
    }

    @PostConstruct
    public void initialize() {
        int pageSize = Integer.parseInt(ResourceBundle.getBundle("/Bundle")
                .getString("Workorder_Pagesize"));
        if (pageSize > 0) {
            PAGE_SIZE = pageSize;
        }
    }

    private WorkorderFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(PAGE_SIZE) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(
                            new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Workorder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Workorder();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
                    .getString("WorkorderCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
                    .getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Workorder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
                    .getString("WorkorderUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
                    .getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Workorder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
                    .getString("WorkorderDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
                    .getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(
                    new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    /**
     * Return items as List, as c:forEach can not cope with DataModel and all
     * the other collection tags can not build pm:view.
     * <p/>
     * As the List should correspond to DataModel, it has to follow the
     * rebuilding pattern. So it calls getItems resulting in the query being
     * put on the em twice.
     * @return
     */
    public List<Workorder> getItemsAsList() {
        getItems();
        int start = getPagination().getPageFirstItem();
        int end = getPagination().getPageFirstItem() + getPagination().getPageSize();
        return getFacade().findRange(new int[]{start, end});
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    public void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Workorder.class)
    public static class WorkorderControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WorkorderController controller = (WorkorderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "workorderController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Workorder) {
                Workorder o = (Workorder) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object
                        + " is of type " + object.getClass().getName()
                        + "; expected type: " + Workorder.class.getName());
            }
        }

    }

}
