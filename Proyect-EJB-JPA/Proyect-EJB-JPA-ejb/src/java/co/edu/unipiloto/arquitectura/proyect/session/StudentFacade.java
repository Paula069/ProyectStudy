/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyect.session;

import co.edu.unipiloto.arquitectura.proyect.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "Proyect-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public boolean addStudent(Student student) {
        Student prexistent =getStudent(student.getStudentid());
        if(prexistent == null) {
            em.persist(student);
            return true;
        }
        return false;      
    }

    @Override
    public boolean editStudent(Student student) {
        Student prexistent =getStudent(student.getStudentid());
        if(prexistent != null) {
            em.merge(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int codigoEstudiante) {
        Student estudiante = getStudent(codigoEstudiante);
        if(estudiante!=null){
            em.remove(estudiante);
            return true;
        }
        return false;
    }

    @Override
    public Student getStudent(int codigoEstudiante) {
        return em.find(Student.class, codigoEstudiante);
    }

    @Override
    public List<Student> getAllStudents() {
        return findAll();
    }
}
    