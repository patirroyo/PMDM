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
@Table(name = "Subsectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subsector.findAll", query = "SELECT s FROM Subsector s")
    , @NamedQuery(name = "Subsector.findByCodSubsector", query = "SELECT s FROM Subsector s WHERE s.codSubsector = :codSubsector")
    , @NamedQuery(name = "Subsector.findByNomSubsector", query = "SELECT s FROM Subsector s WHERE s.nomSubsector = :nomSubsector")
    , @NamedQuery(name = "Subsector.findByCodSector", query = "SELECT s FROM Subsector s WHERE s.codSector = :codSector")})
public class Subsector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_subsector")
    private Integer codSubsector;
    @Size(max = 100)
    @Column(name = "nom_subsector")
    private String nomSubsector;
    @Column(name = "cod_sector")
    private Integer codSector;

    public Subsector() {
    }

    public Subsector(Integer codSubsector) {
        this.codSubsector = codSubsector;
    }

    public Integer getCodSubsector() {
        return codSubsector;
    }

    public void setCodSubsector(Integer codSubsector) {
        this.codSubsector = codSubsector;
    }

    public String getNomSubsector() {
        return nomSubsector;
    }

    public void setNomSubsector(String nomSubsector) {
        this.nomSubsector = nomSubsector;
    }

    public Integer getCodSector() {
        return codSector;
    }

    public void setCodSector(Integer codSector) {
        this.codSector = codSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubsector != null ? codSubsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subsector)) {
            return false;
        }
        Subsector other = (Subsector) object;
        if ((this.codSubsector == null && other.codSubsector != null) || (this.codSubsector != null && !this.codSubsector.equals(other.codSubsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Subsector[ codSubsector=" + codSubsector + " ]";
    }
    
}
