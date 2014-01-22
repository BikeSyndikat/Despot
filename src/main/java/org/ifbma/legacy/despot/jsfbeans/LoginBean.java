package org.ifbma.legacy.despot.jsfbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    public LoginBean() {
    }

    public String login() {
        FacesContext context = getContext();
        HttpServletRequest request = getRequest(context);

        try {
            request.login(this.username, this.password);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login failed."));
            return "login";
        }
        return "index";
    }

    public void logout() {
        FacesContext context = getContext();
        HttpServletRequest request = getRequest(context);
        try {
            request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteUser() {
        HttpServletRequest request = getRequest(getContext());
        return request.getRemoteUser();
    }

    public boolean isLoggedIn() {
        HttpServletRequest request = getRequest(getContext());
        return (request.getRemoteUser() != null);
    }

    private HttpServletRequest getRequest(FacesContext context) {
        HttpServletRequest request
                = (HttpServletRequest) context.getExternalContext().getRequest();
        return request;
    }

    private FacesContext getContext() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context;
    }
}
