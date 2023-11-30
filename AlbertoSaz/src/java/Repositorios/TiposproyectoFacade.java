/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Tiposproyecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alberto
 */
@Stateless
public class TiposproyectoFacade extends AbstractFacade<Tiposproyecto> {

    @PersistenceContext(unitName = "AlbertoSazPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposproyectoFacade() {
        super(Tiposproyecto.class);
    }
    
}
