
package co.edu.unipiloto.arquitectura.proyect.session;

import co.edu.unipiloto.arquitectura.proyect.entity.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> implements ProyectoFacadeLocal {

    @PersistenceContext(unitName = "Proyect-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    @Override
    public boolean addProyect(Proyecto proyecto) {
        Proyecto prexistente = getProyect(proyecto.getProyectoid());
        if(prexistente == null){
            em.persist(proyecto);
            return true;
        }
        return false;
    }

    @Override
    public boolean editProyect(Proyecto proyecto) {
        Proyecto prexistente = getProyect(proyecto.getProyectoid());
        if(prexistente != null){
            em.merge(proyecto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProyect(Integer proyectoid) {
        Proyecto prexistente = getProyect(proyectoid);
        if(prexistente != null){
            em.remove(prexistente);
            return true;
        }
        return false;
    }

    @Override
    public Proyecto getProyect(Integer proyectoid) {
        return em.find(Proyecto.class, proyectoid);
    }

    @Override
    public List<Proyecto> getAllProyects() {
        return findAll();
    }
}
