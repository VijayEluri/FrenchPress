/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.steeplesoft.frenchpress.beans;

import com.steeplesoft.frenchpress.model.User;
import com.steeplesoft.frenchpress.service.UserService;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;

/**
 *
 * @author jdlee
 */
@Model
public class UserBean {
    @Inject
    UserService userService;
    private HtmlDataTable dataTable;
    private User user = new User();
    
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    public void loadUser() {
        user = userService.getUser(user.getId());
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String save() {
        userService.createUser(user);
        return "/admin/users/index?faces-redirect=true";
    }
    
    public String update() {
        userService.updateUser(user);
        return "/admin/users/index?faces-redirect=true";
    }
    
    public String delete() {
        userService.deleteUser(user);
        return null;
    }
}
