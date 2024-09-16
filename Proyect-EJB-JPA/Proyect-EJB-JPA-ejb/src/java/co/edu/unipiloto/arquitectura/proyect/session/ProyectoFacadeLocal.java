package co.edu.unipiloto.arquitectura.proyect.session;

import co.edu.unipiloto.arquitectura.proyect.entity.Proyecto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProyectoFacadeLocal {

    void create(Proyecto proyecto);

    void edit(Proyecto proyecto);

    void remove(Proyecto proyecto);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int[] range);

    int count();
    
    boolean addProyect(Proyecto proyecto);

    boolean editProyect(Proyecto proyecto);

    boolean deleteProyect(Integer proyectoid);

    Proyecto getProyect(Integer proyectoid);

    List<Proyecto> getAllProyects();
}
