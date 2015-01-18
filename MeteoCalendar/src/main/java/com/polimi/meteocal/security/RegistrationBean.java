/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.security;

import com.polimi.meteocal.entities.User;
import com.polimi.meteocal.session.UserFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author miter_000
 */
@Named(value = "registrationBean")
@Stateless

public class RegistrationBean {

    
    private static Logger log = Logger.getLogger(LoginBean.class.getName());
     
    @EJB
    private UserFacade um;   
       
    private User user;
    
    
    public UserFacade getUm() {
        return um;
    }

    public void setUm(UserFacade um) {
        this.um = um;
    }
    
   
      
    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
        
   
    
    
    
    public String register(){
             
        um.save(user); //write to the database
                       
        return "register";
       // return "/users/home?faces-redirect=true";
    }
    
         
}
