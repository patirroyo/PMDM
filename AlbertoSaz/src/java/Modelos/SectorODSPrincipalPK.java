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

/**
 *
 * @author alberto
 */
@Embeddable
public class SectorODSPrincipalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sector")
    private int codSector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ods_pral")
    private int odsPral;

    public SectorODSPrincipalPK() {
    }

    public SectorODSPrincipalPK(int codSector, int odsPral) {
        this.codSector = codSector;
        this.odsPral = odsPral;
    }

    public int getCodSector() {
        return codSector;
    }

    public void setCodSector(int codSector) {
        this.codSector = codSector;
    }

    public int getOdsPral() {
        return odsPral;
    }

    public void setOdsPral(int odsPral) {
        this.odsPral = odsPral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codSector;
        hash += (int) odsPral;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorODSPrincipalPK)) {
            return false;
        }
        SectorODSPrincipalPK other = (SectorODSPrincipalPK) object;
        if (this.codSector != other.codSector) {
            return false;
        }
        if (this.odsPral != other.odsPral) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.SectorODSPrincipalPK[ codSector=" + codSector + ", odsPral=" + odsPral + " ]";
    }
    
}
