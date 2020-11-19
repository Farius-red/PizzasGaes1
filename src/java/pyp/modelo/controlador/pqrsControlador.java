package pyp.modelo.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import pyp.modelo.DAO.IPqrsDAO;
import pyp.modelo.entidades.Pqrs;

@Named(value = "pqrsControlador")
@ViewScoped
public class pqrsControlador implements Serializable {

    @EJB
    private IPqrsDAO pqrsDAO;
    private List<Pqrs> Pqrs;
    private Pqrs pqrsSeleccionada;

    public pqrsControlador() {
    }

    @PostConstruct
    public void init() {
    }

    public List<Pqrs> getPqrs() {
        if (Pqrs == null || Pqrs.isEmpty()) {
            Pqrs = pqrsDAO.findAll();
        }
        return Pqrs;
    }

    public Pqrs getPqrsSeleccionada() {
        return pqrsSeleccionada;
    }

    public void setPqrsSeleccionada(Pqrs pqrsSeleccionada) {
        this.pqrsSeleccionada = pqrsSeleccionada;
    }

    public void seleccionarPqrs(Pqrs pqrs) {
        System.out.println("Se ha seleccionado una PQRS");
        System.out.println(pqrs);
        this.pqrsSeleccionada = pqrs;

    }

}
