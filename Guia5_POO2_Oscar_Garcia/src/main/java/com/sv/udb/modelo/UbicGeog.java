/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author Laboratorio
 */
@Entity
@Table(name = "ubic_geog", catalog = "control", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UbicGeog.findAll", query = "SELECT u FROM UbicGeog u"),
    @NamedQuery(name = "UbicGeog.findByCodiUbicGeog", query = "SELECT u FROM UbicGeog u WHERE u.codiUbicGeog = :codiUbicGeog"),
    @NamedQuery(name = "UbicGeog.findByNombUbicGeog", query = "SELECT u FROM UbicGeog u WHERE u.nombUbicGeog = :nombUbicGeog"),
    @NamedQuery(name = "UbicGeog.findByFechAlta", query = "SELECT u FROM UbicGeog u WHERE u.fechAlta = :fechAlta"),
    @NamedQuery(name = "UbicGeog.findByFechBaja", query = "SELECT u FROM UbicGeog u WHERE u.fechBaja = :fechBaja")})
public class UbicGeog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_UBIC_GEOG")
    private Long codiUbicGeog;
    @Size(max = 200)
    @Column(name = "NOMB_UBIC_GEOG")
    private String nombUbicGeog;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @OneToMany(mappedBy = "codiUbicGeog")
    private Collection<UnidOrga> unidOrgaCollection;
    @OneToMany(mappedBy = "codiUbicGeogSupe")
    private Collection<UbicGeog> ubicGeogCollection;
    @JoinColumn(name = "CODI_UBIC_GEOG_SUPE", referencedColumnName = "CODI_UBIC_GEOG")
    @ManyToOne
    private UbicGeog codiUbicGeogSupe;

    public UbicGeog() {
    }

    public UbicGeog(Long codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
    }

    public Long getCodiUbicGeog() {
        return codiUbicGeog;
    }

    public void setCodiUbicGeog(Long codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
    }

    public String getNombUbicGeog() {
        return nombUbicGeog;
    }

    public void setNombUbicGeog(String nombUbicGeog) {
        this.nombUbicGeog = nombUbicGeog;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFechBaja() {
        return fechBaja;
    }

    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    public byte[] getEsta() {
        return esta;
    }

    public void setEsta(byte[] esta) {
        this.esta = esta;
    }

    @XmlTransient
    public Collection<UnidOrga> getUnidOrgaCollection() {
        return unidOrgaCollection;
    }

    public void setUnidOrgaCollection(Collection<UnidOrga> unidOrgaCollection) {
        this.unidOrgaCollection = unidOrgaCollection;
    }

    @XmlTransient
    public Collection<UbicGeog> getUbicGeogCollection() {
        return ubicGeogCollection;
    }

    public void setUbicGeogCollection(Collection<UbicGeog> ubicGeogCollection) {
        this.ubicGeogCollection = ubicGeogCollection;
    }

    public UbicGeog getCodiUbicGeogSupe() {
        return codiUbicGeogSupe;
    }

    public void setCodiUbicGeogSupe(UbicGeog codiUbicGeogSupe) {
        this.codiUbicGeogSupe = codiUbicGeogSupe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUbicGeog != null ? codiUbicGeog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicGeog)) {
            return false;
        }
        UbicGeog other = (UbicGeog) object;
        if ((this.codiUbicGeog == null && other.codiUbicGeog != null) || (this.codiUbicGeog != null && !this.codiUbicGeog.equals(other.codiUbicGeog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.UbicGeog[ codiUbicGeog=" + codiUbicGeog + " ]";
    }
    
}
