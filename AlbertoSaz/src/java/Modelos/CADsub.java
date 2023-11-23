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
@Table(name = "CADSsub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CADsub.findAll", query = "SELECT c FROM CADsub c")
    , @NamedQuery(name = "CADsub.findByCodSubcad", query = "SELECT c FROM CADsub c WHERE c.codSubcad = :codSubcad")
    , @NamedQuery(name = "CADsub.findByNomSubcad", query = "SELECT c FROM CADsub c WHERE c.nomSubcad = :nomSubcad")
    , @NamedQuery(name = "CADsub.findByNomsubcadING", query = "SELECT c FROM CADsub c WHERE c.nomsubcadING = :nomsubcadING")
    , @NamedQuery(name = "CADsub.findByCodCad", query = "SELECT c FROM CADsub c WHERE c.codCad = :codCad")})
public class CADsub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_subcad")
    private Integer codSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcad")
    private String nomSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcadING")
    private String nomsubcadING;
    @Column(name = "cod_cad")
    private Integer codCad;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionESP")
    private String informacionESP;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionING")
    private String informacionING;

    public CADsub() {
    }

    public CADsub(Integer codSubcad) {
        this.codSubcad = codSubcad;
    }

    public Integer getCodSubcad() {
        return codSubcad;
    }

    public void setCodSubcad(Integer codSubcad) {
        this.codSubcad = codSubcad;
    }

    public String getNomSubcad() {
        return nomSubcad;
    }

    public void setNomSubcad(String nomSubcad) {
        this.nomSubcad = nomSubcad;
    }

    public String getNomsubcadING() {
        return nomsubcadING;
    }

    public void setNomsubcadING(String nomsubcadING) {
        this.nomsubcadING = nomsubcadING;
    }

    public Integer getCodCad() {
        return codCad;
    }

    public void setCodCad(Integer codCad) {
        this.codCad = codCad;
    }

    public String getInformacionESP() {
        return informacionESP;
    }

    public void setInformacionESP(String informacionESP) {
        this.informacionESP = informacionESP;
    }

    public String getInformacionING() {
        return informacionING;
    }

    public void setInformacionING(String informacionING) {
        this.informacionING = informacionING;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubcad != null ? codSubcad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CADsub)) {
            return false;
        }
        CADsub other = (CADsub) object;
        if ((this.codSubcad == null && other.codSubcad != null) || (this.codSubcad != null && !this.codSubcad.equals(other.codSubcad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.CADsub[ codSubcad=" + codSubcad + " ]";
    }
    
}
