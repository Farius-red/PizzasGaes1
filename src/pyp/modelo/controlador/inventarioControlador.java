/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pyp.modelo.util.MessageUtil;

/**
 *
 * @author Gaes5
 */
@Named(value = "inventarioControlador")
@ViewScoped
public class inventarioControlador implements Serializable {

    @EJB
    private IInsumoDAO iDAO;
    private List<Insumo> insumos;
    private Insumo insumoSeleccionado;
    private Insumo NuevoInsumo;

    /**
     * Creates a new instance of inventarioControlador
     */
    public inventarioControlador() {
    }

    @PostConstruct
    public void init() {
        NuevoInsumo = new Insumo();
    }

    public List<Insumo> getInsumos() {
        if (insumos == null || insumos.isEmpty()) {
            insumos = iDAO.findAll();
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
        return NuevoInsumo;
    }

    public void setNuevoInsumo(Insumo NuevoInsumo) {
        this.NuevoInsumo = NuevoInsumo;
    }

    public void seleccionarInsumo(Insumo insu) {
        System.out.println("Se ha seleccionado el insumo");
        System.out.println(insu);
        this.insumoSeleccionado = insu;
    }

    public void registrar() {
        
        try {
            System.out.println("Tipo de Insumo: " + NuevoInsumo.getTipoInsumo());
            System.out.println("Nombre: " + NuevoInsumo.getNombre());
            System.out.println("Fecha: " + NuevoInsumo.getFechaIngreso());
            System.out.println("Fecha de vencimiento: " + NuevoInsumo.getFechaVencimiento());
            NuevoInsumo.setId(iDAO.count()+1);
            NuevoInsumo.setEstado(Short.valueOf("1"));
            iDAO.create(NuevoInsumo);
            
        } catch (NumberFormatException ex) {
            
        }

    }
}
