/*
 * Esto contiene métodos, funciones que utilizarán los controladores
 * para obtener datos
 */
package Repositorios;

import Modelos.Autor;
import Modelos.AutorPremio;
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

    public List<AutorPremio> autoresPorPremio(Premio premio){
        em = getEntityManager();
        Query q;
        //q = em.createNamedQuery("AutorPremio.findByPremio").setParameter("unPremio", premio);
        if (premio != null)
            q = em.createNamedQuery("AutorPremio.findByCodPremio").setParameter("codPremio", premio.getCodPremio());
        else
            q = em.createNamedQuery("AutorPremio.findByCodPremio").setParameter("codPremio", 3);//por defecto el 3 que es el primero (premio Cervantes)
        return q.getResultList();
    }
}
