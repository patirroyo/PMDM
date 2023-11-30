/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Socioslocales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alberto
 */
@Stateless
public class SocioslocalesFacade extends AbstractFacade<Socioslocales> {

    @PersistenceContext(unitName = "AlbertoSazPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SocioslocalesFacade() {
        super(Socioslocales.class);
    }
    
}
