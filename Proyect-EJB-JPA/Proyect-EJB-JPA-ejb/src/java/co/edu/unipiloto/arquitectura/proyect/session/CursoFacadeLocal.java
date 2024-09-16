
package co.edu.unipiloto.arquitectura.proyect.session;

import co.edu.unipiloto.arquitectura.proyect.entity.Curso;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CursoFacadeLocal {

    void create(Curso curso);

    void edit(Curso curso);

    void remove(Curso curso);

    Curso find(Object id);

    List<Curso> findAll();

    List<Curso> findRange(int[] range);

    int count();
    
    boolean addCurso(Curso curso);

    boolean editCurso(Curso curso);

    boolean deleteCurso(Integer codigo);

    Curso getCurso(Integer codigo);

    List<Curso> getAllCursos();

   

}