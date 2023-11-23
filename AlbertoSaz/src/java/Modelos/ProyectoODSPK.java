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
public class ProyectoODSPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cod_proyecto")
    private String codProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ods")
    private int ods;

    public ProyectoODSPK() {
    }

    public ProyectoODSPK(String codProyecto, int ods) {
        this.codProyecto = codProyecto;
        this.ods = ods;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public int getOds() {
        return ods;
    }

    public void setOds(int ods) {
        this.ods = ods;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProyecto != null ? codProyecto.hashCode() : 0);
        hash += (int) ods;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoODSPK)) {
            return false;
        }
        ProyectoODSPK other = (ProyectoODSPK) object;
        if ((this.codProyecto == null && other.codProyecto != null) || (this.codProyecto != null && !this.codProyecto.equals(other.codProyecto))) {
            return false;
        }
        if (this.ods != other.ods) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ProyectoODSPK[ codProyecto=" + codProyecto + ", ods=" + ods + " ]";
    }
    
}
