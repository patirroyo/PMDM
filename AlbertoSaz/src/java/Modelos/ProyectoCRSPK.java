/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alberto
 */
@Embeddable
public class ProyectoCRSPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cod_proyecto")
    private String codProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crs")
    private int crs;

    public ProyectoCRSPK() {
    }

    public ProyectoCRSPK(String codProyecto, int crs) {
        this.codProyecto = codProyecto;
        this.crs = crs;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public int getCrs() {
        return crs;
    }

    public void setCrs(int crs) {
        this.crs = crs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProyecto != null ? codProyecto.hashCode() : 0);
        hash += (int) crs;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoCRSPK)) {
            return false;
        }
        ProyectoCRSPK other = (ProyectoCRSPK) object;
        if ((this.codProyecto == null && other.codProyecto != null) || (this.codProyecto != null && !this.codProyecto.equals(other.codProyecto))) {
            return false;
        }
        if (this.crs != other.crs) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ProyectoCRSPK[ codProyecto=" + codProyecto + ", crs=" + crs + " ]";
    }
    
}
