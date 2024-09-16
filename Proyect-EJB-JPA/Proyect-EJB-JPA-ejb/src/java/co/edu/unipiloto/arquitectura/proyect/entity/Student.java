package co.edu.unipiloto.arquitectura.proyect.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid"),
    // otros NamedQueries según sea necesario
})
public class Student implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentid;
    
    @Basic(optional = false)
    @Column(name = "firsname")
    private String firsname;
    
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "Student_Curso",
        joinColumns = @JoinColumn(name = "studentid"),
        inverseJoinColumns = @JoinColumn(name = "cursoid")
    )
    private Collection<Curso> cursoCollection;

    // Constructor, getters y setters

    public Student() {
    }

    public Student(Integer studentid, String firsname, String lastname, String email, Collection<Curso> cursoCollection) {
        this.studentid = studentid;
        this.firsname = firsname;
        this.lastname = lastname;
        this.email = email;
        this.cursoCollection = cursoCollection;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public String toString() {
        return "Student{" + "studentid=" + studentid + ", firsname=" + firsname + ", lastname=" + lastname + ", email=" + email + ", cursoCollection=" + cursoCollection + '}';
    }
    
    
}