/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miter_000
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdLocation", query = "SELECT l FROM Location l WHERE l.idLocation = :idLocation"),
    @NamedQuery(name = "Location.findByStreetName", query = "SELECT l FROM Location l WHERE l.streetName = :streetName"),
    @NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocation")
    private Integer idLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "StreetName")
    private String streetName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "City")
    private String city;
    @Lob
    @Size(max = 65535)
    @Column(name = "Latitude")
    private String latitude;
    @Lob
    @Size(max = 65535)
    @Column(name = "Longitude")
    private String longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationidLocation")
    private Collection<Event> eventCollection;

    public Location() {
    }

    public Location(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Integer idLocation, String streetName, String city) {
        this.idLocation = idLocation;
        this.streetName = streetName;
        this.city = city;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.polimi.meteocal.entities.Location[ idLocation=" + idLocation + " ]";
    }
    
}
