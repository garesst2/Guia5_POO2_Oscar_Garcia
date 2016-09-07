/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "pers_hist", catalog = "control", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersHist.findAll", query = "SELECT p FROM PersHist p"),
    @NamedQuery(name = "PersHist.findByCodiPersHist", query = "SELECT p FROM PersHist p WHERE p.codiPersHist = :codiPersHist"),
    @NamedQuery(name = "PersHist.findByNombPers", query = "SELECT p FROM PersHist p WHERE p.nombPers = :nombPers"),
    @NamedQuery(name = "PersHist.findByApelPers", query = "SELECT p FROM PersHist p WHERE p.apelPers = :apelPers"),
    @NamedQuery(name = "PersHist.findByCodiUbicGeog", query = "SELECT p FROM PersHist p WHERE p.codiUbicGeog = :codiUbicGeog"),
    @NamedQuery(name = "PersHist.findByFechAlta", query = "SELECT p FROM PersHist p WHERE p.fechAlta = :fechAlta"),
    @NamedQuery(name = "PersHist.findByFechBaja", query = "SELECT p FROM PersHist p WHERE p.fechBaja = :fechBaja")})
public class PersHist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_PERS_HIST")
    private Long codiPersHist;
    @Size(max = 255)
    @Column(name = "NOMB_PERS")
    private String nombPers;
    @Size(max = 255)
    @Column(name = "APEL_PERS")
    private String apelPers;
    @Lob
    @Column(name = "FOTO_PERS")
    private byte[] fotoPers;
    @Column(name = "CODI_UBIC_GEOG")
    private BigInteger codiUbicGeog;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_TIPO_PERS", referencedColumnName = "CODI_TIPO_PERS")
    @ManyToOne
    private TipoPers codiTipoPers;
    @JoinColumn(name = "CODI_PERS", referencedColumnName = "CODI_PERS")
    @ManyToOne
    private Pers codiPers;
    @OneToMany(mappedBy = "codiPers")
    private Collection<Visi> visiCollection;

    public PersHist() {
    }

    public PersHist(Long codiPersHist) {
        this.codiPersHist = codiPersHist;
    }

    public Long getCodiPersHist() {
        return codiPersHist;
    }

    public void setCodiPersHist(Long codiPersHist) {
        this.codiPersHist = codiPersHist;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public byte[] getFotoPers() {
        return fotoPers;
    }

    public void setFotoPers(byte[] fotoPers) {
        this.fotoPers = fotoPers;
    }

    public BigInteger getCodiUbicGeog() {
        return codiUbicGeog;
    }

    public void setCodiUbicGeog(BigInteger codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
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

    public TipoPers getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(TipoPers codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public Pers getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(Pers codiPers) {
        this.codiPers = codiPers;
    }

    @XmlTransient
    public Collection<Visi> getVisiCollection() {
        return visiCollection;
    }

    public void setVisiCollection(Collection<Visi> visiCollection) {
        this.visiCollection = visiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPersHist != null ? codiPersHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersHist)) {
            return false;
        }
        PersHist other = (PersHist) object;
        if ((this.codiPersHist == null && other.codiPersHist != null) || (this.codiPersHist != null && !this.codiPersHist.equals(other.codiPersHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.PersHist[ codiPersHist=" + codiPersHist + " ]";
    }
    
}
