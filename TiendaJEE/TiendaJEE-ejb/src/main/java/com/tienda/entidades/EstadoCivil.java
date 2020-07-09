/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author antho
 */
@Entity
@Table(name = "EstadoCivil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByCodigoEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.codigoEstadoCivil = :codigoEstadoCivil")
    , @NamedQuery(name = "EstadoCivil.findByNombre", query = "SELECT e FROM EstadoCivil e WHERE e.nombre = :nombre")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_estado_civil")
    private Integer codigoEstadoCivil;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "codigoEstadoCivil")
    private List<Empelado> empeladoList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer codigoEstadoCivil) {
        this.codigoEstadoCivil = codigoEstadoCivil;
    }

    public Integer getCodigoEstadoCivil() {
        return codigoEstadoCivil;
    }

    public void setCodigoEstadoCivil(Integer codigoEstadoCivil) {
        this.codigoEstadoCivil = codigoEstadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Empelado> getEmpeladoList() {
        return empeladoList;
    }

    public void setEmpeladoList(List<Empelado> empeladoList) {
        this.empeladoList = empeladoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstadoCivil != null ? codigoEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.codigoEstadoCivil == null && other.codigoEstadoCivil != null) || (this.codigoEstadoCivil != null && !this.codigoEstadoCivil.equals(other.codigoEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.entidades.EstadoCivil[ codigoEstadoCivil=" + codigoEstadoCivil + " ]";
    }
    
}
