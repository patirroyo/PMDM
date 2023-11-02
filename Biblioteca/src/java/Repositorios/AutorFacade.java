/*
 * Esto contiene métodos, funciones que utilizarán los controladores
 * para obtener datos
 */
package Repositorios;

import Modelos.Autor;
import Modelos.Premio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<Autor> autoresOrdenados(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Autor.findAllOrdered");
        return q.getResultList();
    }

    public List<Autor> autoresPorPremio(Premio premio){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("AutorPremio.findByPremio").setParameter("unPremio", premio);
        return q.getResultList();
    }
}
