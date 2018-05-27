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
@Table(name = "lecturas", catalog = "sensor_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lectura.findAll", query = "SELECT l FROM Lectura l")
    , @NamedQuery(name = "Lectura.findById", query = "SELECT l FROM Lectura l WHERE l.id = :id")
    , @NamedQuery(name = "Lectura.findByMedida", query = "SELECT l FROM Lectura l WHERE l.medida = :medida")
    , @NamedQuery(name = "Lectura.findByUnidadMedida", query = "SELECT l FROM Lectura l WHERE l.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Lectura.findBySensorId", query = "SELECT l FROM Lectura l WHERE l.sensorId = :sensorId")
    , @NamedQuery(name = "Lectura.findByRegDate", query = "SELECT l FROM Lectura l WHERE l.regDate = :regDate")})
public class Lectura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "medida")
    private String medida;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "reg_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    public Lectura() {
    }

    public Lectura(Integer id) {
        this.id = id;
    }

    public Lectura(Integer id, String medida, String unidadMedida, int sensorId) {
        this.id = id;
        this.medida = medida;
        this.unidadMedida = unidadMedida;
        this.sensorId = sensorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
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
        if (!(object instanceof Lectura)) {
            return false;
        }
        Lectura other = (Lectura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.easynotes.model.Lectura[ id=" + id + " ]";
    }
    
}
