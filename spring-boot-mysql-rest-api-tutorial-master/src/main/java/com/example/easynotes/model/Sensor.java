/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.easynotes.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macbook
 */
@Entity
@Table(name = "sensores", catalog = "sensor_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s")
    , @NamedQuery(name = "Sensor.findById", query = "SELECT s FROM Sensor s WHERE s.id = :id")
    , @NamedQuery(name = "Sensor.findByDescripcion", query = "SELECT s FROM Sensor s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Sensor.findByTipo", query = "SELECT s FROM Sensor s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Sensor.findByUbicacion", query = "SELECT s FROM Sensor s WHERE s.ubicacion = :ubicacion")
    , @NamedQuery(name = "Sensor.findByRegDate", query = "SELECT s FROM Sensor s WHERE s.regDate = :regDate")})
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 500)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "reg_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    public Sensor() {
    }

    public Sensor(Integer id) {
        this.id = id;
    }

    public Sensor(Integer id, String descripcion, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.easynotes.model.Sensor[ id=" + id + " ]";
    }
    
}
