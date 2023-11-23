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
@Table(name = "SectoresODSPrincipal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectorODSPrincipal.findAll", query = "SELECT s FROM SectorODSPrincipal s")
    , @NamedQuery(name = "SectorODSPrincipal.findByCodSector", query = "SELECT s FROM SectorODSPrincipal s WHERE s.sectorODSPrincipalPK.codSector = :codSector")
    , @NamedQuery(name = "SectorODSPrincipal.findByOdsPral", query = "SELECT s FROM SectorODSPrincipal s WHERE s.sectorODSPrincipalPK.odsPral = :odsPral")})
public class SectorODSPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectorODSPrincipalPK sectorODSPrincipalPK;

    public SectorODSPrincipal() {
    }

    public SectorODSPrincipal(SectorODSPrincipalPK sectorODSPrincipalPK) {
        this.sectorODSPrincipalPK = sectorODSPrincipalPK;
    }

    public SectorODSPrincipal(int codSector, int odsPral) {
        this.sectorODSPrincipalPK = new SectorODSPrincipalPK(codSector, odsPral);
    }

    public SectorODSPrincipalPK getSectorODSPrincipalPK() {
        return sectorODSPrincipalPK;
    }

    public void setSectorODSPrincipalPK(SectorODSPrincipalPK sectorODSPrincipalPK) {
        this.sectorODSPrincipalPK = sectorODSPrincipalPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectorODSPrincipalPK != null ? sectorODSPrincipalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorODSPrincipal)) {
            return false;
        }
        SectorODSPrincipal other = (SectorODSPrincipal) object;
        if ((this.sectorODSPrincipalPK == null && other.sectorODSPrincipalPK != null) || (this.sectorODSPrincipalPK != null && !this.sectorODSPrincipalPK.equals(other.sectorODSPrincipalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.SectorODSPrincipal[ sectorODSPrincipalPK=" + sectorODSPrincipalPK + " ]";
    }
    
}
