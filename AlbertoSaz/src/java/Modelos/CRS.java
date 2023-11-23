/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "CRSS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRS.findAll", query = "SELECT c FROM CRS c")
    , @NamedQuery(name = "CRS.findByCodCrs", query = "SELECT c FROM CRS c WHERE c.codCrs = :codCrs")
    , @NamedQuery(name = "CRS.findByNomCrs", query = "SELECT c FROM CRS c WHERE c.nomCrs = :nomCrs")
    , @NamedQuery(name = "CRS.findByNomcrsIngles", query = "SELECT c FROM CRS c WHERE c.nomcrsIngles = :nomcrsIngles")
    , @NamedQuery(name = "CRS.findByCodCadsub", query = "SELECT c FROM CRS c WHERE c.codCadsub = :codCadsub")})
public class CRS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_crs")
    private Integer codCrs;
    @Size(max = 100)
    @Column(name = "nom_crs")
    private String nomCrs;
    @Size(max = 100)
    @Column(name = "nom_crsIngles")
    private String nomcrsIngles;
    @Column(name = "cod_cadsub")
    private Integer codCadsub;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesESP")
    private String informacionesESP;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesING")
    private String informacionesING;

    public CRS() {
    }

    public CRS(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public Integer getCodCrs() {
        return codCrs;
    }

    public void setCodCrs(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public String getNomCrs() {
        return nomCrs;
    }

    public void setNomCrs(String nomCrs) {
        this.nomCrs = nomCrs;
    }

    public String getNomcrsIngles() {
        return nomcrsIngles;
    }

    public void setNomcrsIngles(String nomcrsIngles) {
        this.nomcrsIngles = nomcrsIngles;
    }

    public Integer getCodCadsub() {
        return codCadsub;
    }

    public void setCodCadsub(Integer codCadsub) {
        this.codCadsub = codCadsub;
    }

    public String getInformacionesESP() {
        return informacionesESP;
    }

    public void setInformacionesESP(String informacionesESP) {
        this.informacionesESP = informacionesESP;
    }

    public String getInformacionesING() {
        return informacionesING;
    }

    public void setInformacionesING(String informacionesING) {
        this.informacionesING = informacionesING;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCrs != null ? codCrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRS)) {
            return false;
        }
        CRS other = (CRS) object;
        if ((this.codCrs == null && other.codCrs != null) || (this.codCrs != null && !this.codCrs.equals(other.codCrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.CRS[ codCrs=" + codCrs + " ]";
    }
    
}
