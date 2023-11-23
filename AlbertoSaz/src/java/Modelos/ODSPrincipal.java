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
@Table(name = "ODSPrincipal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ODSPrincipal.findAll", query = "SELECT o FROM ODSPrincipal o")
    , @NamedQuery(name = "ODSPrincipal.findByCodOds", query = "SELECT o FROM ODSPrincipal o WHERE o.codOds = :codOds")
    , @NamedQuery(name = "ODSPrincipal.findByNomOds", query = "SELECT o FROM ODSPrincipal o WHERE o.nomOds = :nomOds")})
public class ODSPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_ods")
    private Integer codOds;
    @Size(max = 50)
    @Column(name = "nom_ods")
    private String nomOds;

    public ODSPrincipal() {
    }

    public ODSPrincipal(Integer codOds) {
        this.codOds = codOds;
    }

    public Integer getCodOds() {
        return codOds;
    }

    public void setCodOds(Integer codOds) {
        this.codOds = codOds;
    }

    public String getNomOds() {
        return nomOds;
    }

    public void setNomOds(String nomOds) {
        this.nomOds = nomOds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOds != null ? codOds.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ODSPrincipal)) {
            return false;
        }
        ODSPrincipal other = (ODSPrincipal) object;
        if ((this.codOds == null && other.codOds != null) || (this.codOds != null && !this.codOds.equals(other.codOds))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ODSPrincipal[ codOds=" + codOds + " ]";
    }
    
}
