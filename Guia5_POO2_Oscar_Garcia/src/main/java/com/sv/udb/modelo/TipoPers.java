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
import javax.persistence.Lob;
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
@Table(name = "tipo_pers", catalog = "control", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPers.findAll", query = "SELECT t FROM TipoPers t"),
    @NamedQuery(name = "TipoPers.findByCodiTipoPers", query = "SELECT t FROM TipoPers t WHERE t.codiTipoPers = :codiTipoPers"),
    @NamedQuery(name = "TipoPers.findByNombTipoPers", query = "SELECT t FROM TipoPers t WHERE t.nombTipoPers = :nombTipoPers"),
    @NamedQuery(name = "TipoPers.findByFechAlta", query = "SELECT t FROM TipoPers t WHERE t.fechAlta = :fechAlta"),
    @NamedQuery(name = "TipoPers.findByFechBaja", query = "SELECT t FROM TipoPers t WHERE t.fechBaja = :fechBaja")})
public class TipoPers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_TIPO_PERS")
    private Long codiTipoPers;
    @Size(max = 150)
    @Column(name = "NOMB_TIPO_PERS")
    private String nombTipoPers;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @OneToMany(mappedBy = "codiTipoPers")
    private Collection<PersHist> persHistCollection;
    @OneToMany(mappedBy = "codiTipoPers")
    private Collection<Pers> persCollection;

    public TipoPers() {
    }

    public TipoPers(Long codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public Long getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(Long codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public String getNombTipoPers() {
        return nombTipoPers;
    }

    public void setNombTipoPers(String nombTipoPers) {
        this.nombTipoPers = nombTipoPers;
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
    public Collection<PersHist> getPersHistCollection() {
        return persHistCollection;
    }

    public void setPersHistCollection(Collection<PersHist> persHistCollection) {
        this.persHistCollection = persHistCollection;
    }

    @XmlTransient
    public Collection<Pers> getPersCollection() {
        return persCollection;
    }

    public void setPersCollection(Collection<Pers> persCollection) {
        this.persCollection = persCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiTipoPers != null ? codiTipoPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPers)) {
            return false;
        }
        TipoPers other = (TipoPers) object;
        if ((this.codiTipoPers == null && other.codiTipoPers != null) || (this.codiTipoPers != null && !this.codiTipoPers.equals(other.codiTipoPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.TipoPers[ codiTipoPers=" + codiTipoPers + " ]";
    }
    
}
