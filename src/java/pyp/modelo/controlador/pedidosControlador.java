
package pyp.modelo.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import pyp.modelo.DAO.IPedidoDAO;
import pyp.modelo.entidades.Pedido;


@Named(value = "pedidosControlador")
@ViewScoped
public class pedidosControlador implements Serializable{

    @EJB
    private IPedidoDAO pedidosDAO;
    private List<Pedido> pedidos;
    private Pedido pedidoSeleccionado; 
    
    public pedidosControlador() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Pedido> getPedidos() {
        if (pedidos == null || pedidos.isEmpty()) {
            pedidos = pedidosDAO.findAll();
        }
        return pedidos;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }
     public void seleccionarPedido(Pedido pedidos) {
        System.out.println("Se ha seleccionado un Pedido");
        System.out.println(pedidos);
        this.pedidoSeleccionado = pedidos;

    }
    
    
}
