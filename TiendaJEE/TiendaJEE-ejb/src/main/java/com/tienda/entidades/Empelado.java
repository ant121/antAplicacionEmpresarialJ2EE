/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author antho
 */
@Entity
@Table(name = "empelado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empelado.findAll", query = "SELECT e FROM Empelado e")
    , @NamedQuery(name = "Empelado.findByCodigoEmpleado", query = "SELECT e FROM Empelado e WHERE e.codigoEmpleado = :codigoEmpleado")
    , @NamedQuery(name = "Empelado.findByCedula", query = "SELECT e FROM Empelado e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Empelado.findByNombre", query = "SELECT e FROM Empelado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empelado.findByApellido", query = "SELECT e FROM Empelado e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empelado.findByFechaNacimiento", query = "SELECT e FROM Empelado e WHERE e.fechaNacimiento = :fechaNacimiento")})
public class Empelado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_empleado")
    private Integer codigoEmpleado;
    @Size(max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "codigo_cargo", referencedColumnName = "codigo_cargo")
    @ManyToOne
    private Cargo codigoCargo;
    @JoinColumn(name = "codigo_estado_civil", referencedColumnName = "codigo_estado_civil")
    @ManyToOne
    private Estadocivil codigoEstadoCivil;

    public Empelado() {
    }

    public Empelado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cargo getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Cargo codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public Estadocivil getCodigoEstadoCivil() {
        return codigoEstadoCivil;
    }

    public void setCodigoEstadoCivil(Estadocivil codigoEstadoCivil) {
        this.codigoEstadoCivil = codigoEstadoCivil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpleado != null ? codigoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empelado)) {
            return false;
        }
        Empelado other = (Empelado) object;
        if ((this.codigoEmpleado == null && other.codigoEmpleado != null) || (this.codigoEmpleado != null && !this.codigoEmpleado.equals(other.codigoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.entidades.Empelado[ codigoEmpleado=" + codigoEmpleado + " ]";
    }
    
}
