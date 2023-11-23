/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "SedesResponsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SedeResponsable.findAll", query = "SELECT s FROM SedeResponsable s")
    , @NamedQuery(name = "SedeResponsable.findByCodSede", query = "SELECT s FROM SedeResponsable s WHERE s.sedeResponsablePK.codSede = :codSede")
    , @NamedQuery(name = "SedeResponsable.findByCodResponsable", query = "SELECT s FROM SedeResponsable s WHERE s.sedeResponsablePK.codResponsable = :codResponsable")
    , @NamedQuery(name = "SedeResponsable.findByFechaInicio", query = "SELECT s FROM SedeResponsable s WHERE s.sedeResponsablePK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "SedeResponsable.findByFechaFin", query = "SELECT s FROM SedeResponsable s WHERE s.fechaFin = :fechaFin")
    , @NamedQuery(name = "SedeResponsable.findByEmail", query = "SELECT s FROM SedeResponsable s WHERE s.email = :email")
    , @NamedQuery(name = "SedeResponsable.findByTelefono", query = "SELECT s FROM SedeResponsable s WHERE s.telefono = :telefono")})
public class SedeResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SedeResponsablePK sedeResponsablePK;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;

    public SedeResponsable() {
    }

    public SedeResponsable(SedeResponsablePK sedeResponsablePK) {
        this.sedeResponsablePK = sedeResponsablePK;
    }

    public SedeResponsable(String codSede, int codResponsable, Date fechaInicio) {
        this.sedeResponsablePK = new SedeResponsablePK(codSede, codResponsable, fechaInicio);
    }

    public SedeResponsablePK getSedeResponsablePK() {
        return sedeResponsablePK;
    }

    public void setSedeResponsablePK(SedeResponsablePK sedeResponsablePK) {
        this.sedeResponsablePK = sedeResponsablePK;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sedeResponsablePK != null ? sedeResponsablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SedeResponsable)) {
            return false;
        }
        SedeResponsable other = (SedeResponsable) object;
        if ((this.sedeResponsablePK == null && other.sedeResponsablePK != null) || (this.sedeResponsablePK != null && !this.sedeResponsablePK.equals(other.sedeResponsablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.SedeResponsable[ sedeResponsablePK=" + sedeResponsablePK + " ]";
    }
    
}
