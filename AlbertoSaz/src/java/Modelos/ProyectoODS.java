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
@Table(name = "ProyectosODS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoODS.findAll", query = "SELECT p FROM ProyectoODS p")
    , @NamedQuery(name = "ProyectoODS.findByCodProyecto", query = "SELECT p FROM ProyectoODS p WHERE p.proyectoODSPK.codProyecto = :codProyecto")
    , @NamedQuery(name = "ProyectoODS.findByOds", query = "SELECT p FROM ProyectoODS p WHERE p.proyectoODSPK.ods = :ods")})
public class ProyectoODS implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoODSPK proyectoODSPK;

    public ProyectoODS() {
    }

    public ProyectoODS(ProyectoODSPK proyectoODSPK) {
        this.proyectoODSPK = proyectoODSPK;
    }

    public ProyectoODS(String codProyecto, int ods) {
        this.proyectoODSPK = new ProyectoODSPK(codProyecto, ods);
    }

    public ProyectoODSPK getProyectoODSPK() {
        return proyectoODSPK;
    }

    public void setProyectoODSPK(ProyectoODSPK proyectoODSPK) {
        this.proyectoODSPK = proyectoODSPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoODSPK != null ? proyectoODSPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoODS)) {
            return false;
        }
        ProyectoODS other = (ProyectoODS) object;
        if ((this.proyectoODSPK == null && other.proyectoODSPK != null) || (this.proyectoODSPK != null && !this.proyectoODSPK.equals(other.proyectoODSPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ProyectoODS[ proyectoODSPK=" + proyectoODSPK + " ]";
    }
    
}
