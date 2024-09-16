
package co.edu.unipiloto.arquitectura.proyect.session;

import co.edu.unipiloto.arquitectura.proyect.entity.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andre
 */
@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();
    
    boolean addStudent(Student student);

    boolean editStudent(Student student);

    boolean deleteStudent(int codigoEstudiante);

    Student getStudent(int codigoEstudiante);

    List<Student> getAllStudents();
    
}
