/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "ProyectosCRS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoCRS.findAll", query = "SELECT p FROM ProyectoCRS p")
    , @NamedQuery(name = "ProyectoCRS.findByCodProyecto", query = "SELECT p FROM ProyectoCRS p WHERE p.proyectoCRSPK.codProyecto = :codProyecto")
    , @NamedQuery(name = "ProyectoCRS.findByCrs", query = "SELECT p FROM ProyectoCRS p WHERE p.proyectoCRSPK.crs = :crs")})
public class ProyectoCRS implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoCRSPK proyectoCRSPK;

    public ProyectoCRS() {
    }

    public ProyectoCRS(ProyectoCRSPK proyectoCRSPK) {
        this.proyectoCRSPK = proyectoCRSPK;
    }

    public ProyectoCRS(String codProyecto, int crs) {
        this.proyectoCRSPK = new ProyectoCRSPK(codProyecto, crs);
    }

    public ProyectoCRSPK getProyectoCRSPK() {
        return proyectoCRSPK;
    }

    public void setProyectoCRSPK(ProyectoCRSPK proyectoCRSPK) {
        this.proyectoCRSPK = proyectoCRSPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoCRSPK != null ? proyectoCRSPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoCRS)) {
            return false;
        }
        ProyectoCRS other = (ProyectoCRS) object;
        if ((this.proyectoCRSPK == null && other.proyectoCRSPK != null) || (this.proyectoCRSPK != null && !this.proyectoCRSPK.equals(other.proyectoCRSPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ProyectoCRS[ proyectoCRSPK=" + proyectoCRSPK + " ]";
    }
    
}
