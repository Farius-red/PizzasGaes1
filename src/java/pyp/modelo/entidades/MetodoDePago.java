/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @GAES 5
 */
@Entity
@Table(name = "metodo_de_pago")
@NamedQueries({
    @NamedQuery(name = "MetodoDePago.findAll", query = "SELECT m FROM MetodoDePago m")
    , @NamedQuery(name = "MetodoDePago.findById", query = "SELECT m FROM MetodoDePago m WHERE m.id = :id")
    , @NamedQuery(name = "MetodoDePago.findByNombre", query = "SELECT m FROM MetodoDePago m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MetodoDePago.findByEstado", query = "SELECT m FROM MetodoDePago m WHERE m.estado = :estado")})
public class MetodoDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Integer estado;
    @JoinTable(name = "metodo_de_pago_has_factura", joinColumns = {
        @JoinColumn(name = "metodoDePago", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "factura", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Factura> facturas;

    public MetodoDePago() {
    }

    public MetodoDePago(Integer id) {
        this.id = id;
    }

    public MetodoDePago(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
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
        if (!(object instanceof MetodoDePago)) {
            return false;
        }
        MetodoDePago other = (MetodoDePago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pyp.modelo.entidades.MetodoDePago[ id=" + id + " ]";
    }
    
}
