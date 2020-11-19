package pyp.modelo.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import pyp.modelo.DAO.IInsumoDAO;
import pyp.modelo.entidades.Insumo;

/**
 *
 * @author PC
 */
@Named(value = "inventarioControlador")
@ViewScoped
public class inventarioControlador implements Serializable {

    @EJB

    private IInsumoDAO IDAO;
    private List<Insumo> insumos;
    private Insumo insumoSeleccionado;
    private Insumo nuevoInsumo;

    public inventarioControlador() {
    }

    @PostConstruct
    public void init() {
        nuevoInsumo = new Insumo();

    }

    public List<Insumo> getInsumos() {
        if (insumos == null || insumos.isEmpty()) {
            insumos = IDAO.findAll();
        }
        return insumos;
    }

    public Insumo getInsumoSeleccionado() {
        return insumoSeleccionado;
    }

    public void setInsumoSeleccionado(Insumo insumoSeleccionado) {
        this.insumoSeleccionado = insumoSeleccionado;
    }

    public Insumo getNuevoInsumo() {
        return nuevoInsumo;
    }

    public void setNuevoInsumo(Insumo nuevoInsumo) {
        this.nuevoInsumo = nuevoInsumo;
    }

    public void seleccionarInsumo(Insumo i) {
        System.out.println("Se ha seleccionado el insumo");
        System.out.println(i);
        this.insumoSeleccionado = i;
    }

    public void registrar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try{
        System.out.println("Id: " + nuevoInsumo.getId());
        System.out.println("Tipo de Insumo: " + nuevoInsumo.getTipoInsumo());
        System.out.println("Auxiliar de Cocina: " + nuevoInsumo.getAuxCocina());
        System.out.println("Fecha de Ingreso: " + nuevoInsumo.getFechaIngreso());
        System.out.println("Fecha de Ingreso: " + nuevoInsumo.getFechaIngreso());
        System.out.println("Fecha de Vencimiento: " + nuevoInsumo.getFechaVencimiento());
        System.out.println("Nombre: " + nuevoInsumo.getNombre());
        System.out.println("Descripcion: " + nuevoInsumo.getDescripcion());
        System.out.println("Cantidad: " + nuevoInsumo.getCantidad());
        System.out.println("Estado: " + nuevoInsumo.getEstado());
        nuevoInsumo.setEstado(Short.valueOf("1"));
        IDAO.create(nuevoInsumo);

    }catch(Exception ex){
        
    }
    }

}
