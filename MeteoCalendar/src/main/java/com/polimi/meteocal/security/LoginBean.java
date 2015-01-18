/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.security;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miter_000
 */
@Named(value = "loginBean")
@Stateless

public class LoginBean {

 
  private static Logger log = Logger.getLogger(LoginBean.class.getName());

  private String username;
  private String password;

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
    public String login () {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        try {
            
           
             request.login(this.username, this.password);
             
             //Principal principal = request.getUserPrincipal();             
             //System.out.println("LOGGED IN SUCCESSFULLY " + principal);
             
             
            } catch (ServletException e) {
      
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Failed","Login Failed"));        
            log.log(Level.SEVERE,"Login Failed");
            
            return "login_failure";
          }    
        
        
        return "login_success";
  }
    
    
    
    
    
    public String logout() {
        // Notice the redirect syntax. The forward slash means start at
        // the root of the web application.
        String destination = "logout_success";

        // FacesContext provides access to other container managed objects,
        // such as the HttpServletRequest object, which is needed to perform
        // the logout operation.
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = 
                (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            // added May 12, 2014
            HttpSession session = request.getSession();
            session.invalidate();
            
            // this does not invalidate the session but does null out the user Principle
            request.logout();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            context.addMessage(null, new FacesMessage("Logout failed."));
            System.out.println("PROBLEM: User cannot logout");
            destination = "logout_failure";
        }

        return destination; // go to destination
    }
    
}
