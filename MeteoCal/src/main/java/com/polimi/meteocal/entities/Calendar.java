/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miter_000
 */
@Entity
@Table(name = "calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findByIdCalendar", query = "SELECT c FROM Calendar c WHERE c.idCalendar = :idCalendar"),
    @NamedQuery(name = "Calendar.findByName", query = "SELECT c FROM Calendar c WHERE c.name = :name"),
    @NamedQuery(name = "Calendar.findByVisibility", query = "SELECT c FROM Calendar c WHERE c.visibility = :visibility"),
    @NamedQuery(name = "Calendar.findByCreatedAt", query = "SELECT c FROM Calendar c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Calendar.findByUpdatedAt", query = "SELECT c FROM Calendar c WHERE c.updatedAt = :updatedAt")})
public class Calendar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalendar")
    private Integer idCalendar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visibility")
    private boolean visibility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UpdatedAt")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @JoinTable(name = "joinevent", joinColumns = {
        @JoinColumn(name = "CreatedBy", referencedColumnName = "User_idUser")}, inverseJoinColumns = {
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")})
    @ManyToMany
    private Collection<Event> eventCollection;
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User useridUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private Collection<Event> eventCollection1;

    public Calendar() {
    }

    public Calendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    public Calendar(Integer idCalendar, String name, boolean visibility, Date createdAt, Date updatedAt) {
        this.idCalendar = idCalendar;
        this.name = name;
        this.visibility = visibility;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    public User getUseridUser() {
        return useridUser;
    }

    public void setUseridUser(User useridUser) {
        this.useridUser = useridUser;
    }

    @XmlTransient
    public Collection<Event> getEventCollection1() {
        return eventCollection1;
    }

    public void setEventCollection1(Collection<Event> eventCollection1) {
        this.eventCollection1 = eventCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendar != null ? idCalendar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.idCalendar == null && other.idCalendar != null) || (this.idCalendar != null && !this.idCalendar.equals(other.idCalendar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polimi.meteocal.entities.Calendar[ idCalendar=" + idCalendar + " ]";
    }
    
}
