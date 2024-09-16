package co.edu.unipiloto.arquitectura.proyect.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByProyectoid", query = "SELECT p FROM Proyecto p WHERE p.proyectoid = :proyectoid"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByDescription", query = "SELECT p FROM Proyecto p WHERE p.description = :description"),
    @NamedQuery(name = "Proyecto.findByLocalidad", query = "SELECT p FROM Proyecto p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyecto.findByPresupuesto", query = "SELECT p FROM Proyecto p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "Proyecto.findByNumeroHabitantes", query = "SELECT p FROM Proyecto p WHERE p.numeroHabitantes = :numeroHabitantes")
})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTOID")
    private Integer proyectoid;
    @Size(max = 100)
    @Column(name = "NOMBRE_PROYECTO")
    private String nombreProyecto;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "PRESUPUESTO")
    private BigDecimal presupuesto;
    @Column(name = "NUMERO_HABITANTES")
    private Integer numeroHabitantes;

    public Proyecto() {
    }

    public Proyecto(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public Proyecto(Integer proyectoid, String nombreProyecto, String description, String localidad, BigDecimal presupuesto, Integer numeroHabitantes) {
        this.proyectoid = proyectoid;
        this.nombreProyecto = nombreProyecto;
        this.description = description;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.numeroHabitantes = numeroHabitantes;
    }

    public Proyecto(Integer id, String nombre, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(Integer numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoid != null ? proyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        return !((this.proyectoid == null && other.proyectoid != null) || (this.proyectoid != null && !this.proyectoid.equals(other.proyectoid)));
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.proyect.entity.Proyecto[ proyectoid=" + proyectoid + " ]";
    }
}
