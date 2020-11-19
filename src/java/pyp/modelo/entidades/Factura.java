/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @GAES 5
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByPrecioUnitario", query = "SELECT f FROM Factura f WHERE f.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")
    , @NamedQuery(name = "Factura.findByPrecioTotal", query = "SELECT f FROM Factura f WHERE f.precioTotal = :precioTotal")
    , @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_Unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Iva")
    private int iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_total")
    private double precioTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinTable(name = "metodo_de_pago_has_factura", joinColumns = {
        @JoinColumn(name = "factura", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "metodoDePago", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<MetodoDePago> metodosDePago;
    @JoinTable(name = "cajero_has_factura", joinColumns = {
        @JoinColumn(name = "Factura", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Cajero", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Cajero> cajeros;
    @JoinTable(name = "factura_has_producto", joinColumns = {
        @JoinColumn(name = "factura", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "producto", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Producto> productos;
    @JoinColumn(name = "pedidos", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedidos;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Date fecha, double precioUnitario, int iva, double precioTotal, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<MetodoDePago> getMetodosDePago() {
        return metodosDePago;
    }

    public void setMetodosDePago(List<MetodoDePago> metodosDePago) {
        this.metodosDePago = metodosDePago;
    }

    public List<Cajero> getCajeros() {
        return cajeros;
    }

    public void setCajeros(List<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pyp.modelo.entidades.Factura[ id=" + id + " ]";
    }
    
}
