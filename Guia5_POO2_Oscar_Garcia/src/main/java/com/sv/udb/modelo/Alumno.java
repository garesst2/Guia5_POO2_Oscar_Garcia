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
@Table(name = "pers", catalog = "control", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pers.findAll", query = "SELECT p FROM Pers p"),
    @NamedQuery(name = "Pers.findByCodiPers", query = "SELECT p FROM Pers p WHERE p.codiPers = :codiPers"),
    @NamedQuery(name = "Pers.findByNombPers", query = "SELECT p FROM Pers p WHERE p.nombPers = :nombPers"),
    @NamedQuery(name = "Pers.findByApelPers", query = "SELECT p FROM Pers p WHERE p.apelPers = :apelPers"),
    @NamedQuery(name = "Pers.findByGenePers", query = "SELECT p FROM Pers p WHERE p.genePers = :genePers"),
    @NamedQuery(name = "Pers.findByFechNaciPers", query = "SELECT p FROM Pers p WHERE p.fechNaciPers = :fechNaciPers"),
    @NamedQuery(name = "Pers.findByDuiPers", query = "SELECT p FROM Pers p WHERE p.duiPers = :duiPers"),
    @NamedQuery(name = "Pers.findByNitPers", query = "SELECT p FROM Pers p WHERE p.nitPers = :nitPers"),
    @NamedQuery(name = "Pers.findByTipoSangPers", query = "SELECT p FROM Pers p WHERE p.tipoSangPers = :tipoSangPers"),
    @NamedQuery(name = "Pers.findByCodiUbicGeog", query = "SELECT p FROM Pers p WHERE p.codiUbicGeog = :codiUbicGeog"),
    @NamedQuery(name = "Pers.findByFechAlta", query = "SELECT p FROM Pers p WHERE p.fechAlta = :fechAlta"),
    @NamedQuery(name = "Pers.findByFechBaja", query = "SELECT p FROM Pers p WHERE p.fechBaja = :fechBaja")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_PERS")
    private Long codiPers;
    @Size(max = 255)
    @Column(name = "NOMB_PERS")
    private String nombPers;
    @Size(max = 255)
    @Column(name = "APEL_PERS")
    private String apelPers;
    @Lob
    @Column(name = "FOTO_PERS")
    private byte[] fotoPers;
    @Column(name = "GENE_PERS")
    private Character genePers;
    @Column(name = "FECH_NACI_PERS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechNaciPers;
    @Size(max = 50)
    @Column(name = "DUI_PERS")
    private String duiPers;
    @Size(max = 50)
    @Column(name = "NIT_PERS")
    private String nitPers;
    @Size(max = 50)
    @Column(name = "TIPO_SANG_PERS")
    private String tipoSangPers;
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
    @OneToMany(mappedBy = "codiPers")
    private Collection<PersHist> persHistCollection;
    @OneToMany(mappedBy = "codiPers")
    private Collection<Usua> usuaCollection;
    @JoinColumn(name = "CODI_TIPO_PERS", referencedColumnName = "CODI_TIPO_PERS")
    @ManyToOne
    private TipoPers codiTipoPers;

    public Alumno() {
    }

    public Alumno(Long codiPers) {
        this.codiPers = codiPers;
    }

    public Long getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(Long codiPers) {
        this.codiPers = codiPers;
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

    public Character getGenePers() {
        return genePers;
    }

    public void setGenePers(Character genePers) {
        this.genePers = genePers;
    }

    public Date getFechNaciPers() {
        return fechNaciPers;
    }

    public void setFechNaciPers(Date fechNaciPers) {
        this.fechNaciPers = fechNaciPers;
    }

    public String getDuiPers() {
        return duiPers;
    }

    public void setDuiPers(String duiPers) {
        this.duiPers = duiPers;
    }

    public String getNitPers() {
        return nitPers;
    }

    public void setNitPers(String nitPers) {
        this.nitPers = nitPers;
    }

    public String getTipoSangPers() {
        return tipoSangPers;
    }

    public void setTipoSangPers(String tipoSangPers) {
        this.tipoSangPers = tipoSangPers;
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

    @XmlTransient
    public Collection<PersHist> getPersHistCollection() {
        return persHistCollection;
    }

    public void setPersHistCollection(Collection<PersHist> persHistCollection) {
        this.persHistCollection = persHistCollection;
    }

    @XmlTransient
    public Collection<Usua> getUsuaCollection() {
        return usuaCollection;
    }

    public void setUsuaCollection(Collection<Usua> usuaCollection) {
        this.usuaCollection = usuaCollection;
    }

    public TipoPers getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(TipoPers codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiPers != null ? codiPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codiPers == null && other.codiPers != null) || (this.codiPers != null && !this.codiPers.equals(other.codiPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Pers[ codiPers=" + codiPers + " ]";
    }
    
}
