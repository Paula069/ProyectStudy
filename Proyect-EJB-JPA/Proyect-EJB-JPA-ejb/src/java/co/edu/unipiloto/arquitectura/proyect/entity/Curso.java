package co.edu.unipiloto.arquitectura.proyect.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodigo", query = "SELECT c FROM Curso c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Curso.findByNombreCurso", query = "SELECT c FROM Curso c WHERE c.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "Curso.findByNumeroCreditos", query = "SELECT c FROM Curso c WHERE c.numeroCreditos = :numeroCreditos"),
    @NamedQuery(name = "Curso.findByLevelyear", query = "SELECT c FROM Curso c WHERE c.levelyear = :levelyear"),
    @NamedQuery(name = "Curso.findByNumeroEstudiantesAdmitidos", query = "SELECT c FROM Curso c WHERE c.numeroEstudiantesAdmitidos = :numeroEstudiantesAdmitidos")})

public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;

    @Size(max = 50)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;

    @Column(name = "NUMERO_CREDITOS")
    private Integer numeroCreditos;

    @Size(max = 50)
    @Column(name = "LEVELYEAR")
    private String levelyear;

    @Column(name = "NUMERO_ESTUDIANTES_ADMITIDOS")
    private Integer numeroEstudiantesAdmitidos;

    @ManyToMany(mappedBy = "cursoCollection")
    private Collection<Student> studentCollection;

    public Curso() {
    }

    public Curso(Integer codigo, String nombreCurso, Integer numeroCreditos, String levelyear, Integer numeroEstudiantesAdmitidos) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.numeroCreditos = numeroCreditos;
        this.levelyear = levelyear;
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getLevelyear() {
        return levelyear;
    }

    public void setLevelyear(String levelyear) {
        this.levelyear = levelyear;
    }

    public Integer getNumeroEstudiantesAdmitidos() {
        return numeroEstudiantesAdmitidos;
    }

    public void setNumeroEstudiantesAdmitidos(Integer numeroEstudiantesAdmitidos) {
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        return (this.codigo != null || other.codigo == null) && (this.codigo == null || this.codigo.equals(other.codigo));
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.proyect.entity.Curso[ codigo=" + codigo + " ]";
    }
}
