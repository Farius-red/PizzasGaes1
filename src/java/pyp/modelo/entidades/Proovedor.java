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
@Table(name = "proovedor")
@NamedQueries({
    @NamedQuery(name = "Proovedor.findAll", query = "SELECT p FROM Proovedor p")
    , @NamedQuery(name = "Proovedor.findById", query = "SELECT p FROM Proovedor p WHERE p.id = :id")
    , @NamedQuery(name = "Proovedor.findByNombre", query = "SELECT p FROM Proovedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proovedor.findByTipoDocumento", query = "SELECT p FROM Proovedor p WHERE p.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Proovedor.findByDocumento", query = "SELECT p FROM Proovedor p WHERE p.documento = :documento")
    , @NamedQuery(name = "Proovedor.findByEstado", query = "SELECT p FROM Proovedor p WHERE p.estado = :estado")})
public class Proovedor implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private int documento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinTable(name = "insumo_has_proovedor", joinColumns = {
        @JoinColumn(name = "proveedor", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "insumo", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Insumo> insumos;

    public Proovedor() {
    }

    public Proovedor(Integer id) {
        this.id = id;
    }

    public Proovedor(Integer id, String nombre, String tipoDocumento, int documento, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.estado = estado;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
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
        if (!(object instanceof Proovedor)) {
            return false;
        }
        Proovedor other = (Proovedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pyp.modelo.entidades.Proovedor[ id=" + id + " ]";
    }
    
}
