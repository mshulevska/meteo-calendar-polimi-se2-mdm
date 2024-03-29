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
import javax.persistence.Lob;
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
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByIdEvent", query = "SELECT e FROM Event e WHERE e.idEvent = :idEvent"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByEventTime", query = "SELECT e FROM Event e WHERE e.eventTime = :eventTime"),
    @NamedQuery(name = "Event.findByVisibility", query = "SELECT e FROM Event e WHERE e.visibility = :visibility"),
    @NamedQuery(name = "Event.findByCreatedAt", query = "SELECT e FROM Event e WHERE e.createdAt = :createdAt"),
    @NamedQuery(name = "Event.findByUpdatedAt", query = "SELECT e FROM Event e WHERE e.updatedAt = :updatedAt")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvent")
    private Integer idEvent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visibility")
    private boolean visibility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "UpdatedAt")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @JoinTable(name = "joinevent", joinColumns = {
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")}, inverseJoinColumns = {
        @JoinColumn(name = "User_Email", referencedColumnName = "Email")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventidEvent")
    private Collection<Invitation> invitationCollection;
    @JoinColumn(name = "Location_idLocation", referencedColumnName = "idLocation")
    @ManyToOne(optional = false)
    private Location locationidLocation;
    @JoinColumn(name = "User_Email", referencedColumnName = "Email")
    @ManyToOne(optional = false)
    private User userEmail;

    public Event() {
    }

    public Event(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Event(Integer idEvent, String name, Date eventTime, boolean visibility, Date createdAt) {
        this.idEvent = idEvent;
        this.name = name;
        this.eventTime = eventTime;
        this.visibility = visibility;
        this.createdAt = createdAt;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Invitation> getInvitationCollection() {
        return invitationCollection;
    }

    public void setInvitationCollection(Collection<Invitation> invitationCollection) {
        this.invitationCollection = invitationCollection;
    }

    public Location getLocationidLocation() {
        return locationidLocation;
    }

    public void setLocationidLocation(Location locationidLocation) {
        this.locationidLocation = locationidLocation;
    }

    public User getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polimi.meteocal.entities.Event[ idEvent=" + idEvent + " ]";
    }
    
}
