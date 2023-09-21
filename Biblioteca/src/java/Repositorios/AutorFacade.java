/*
 * Esto contiene métodos, funciones que utilizarán los controladores
 * para obtener datos
 */
package Repositorios;

import Modelos.Autor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alberto
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorFacade() {
        super(Autor.class);
    }
    
}
