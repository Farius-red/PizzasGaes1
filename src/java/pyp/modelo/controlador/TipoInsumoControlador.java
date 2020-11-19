
package pyp.modelo.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import pyp.modelo.DAO.ITipoInsumoDAO;
import pyp.modelo.entidades.TipoInsumo;

@Named(value = "tipoInsumoControlador")
@ViewScoped
public class TipoInsumoControlador implements Serializable {
    
    @EJB
    private ITipoInsumoDAO tiDAO;
    private List<TipoInsumo> tiposInsumo;
    
            
    public TipoInsumoControlador() {
    } 
    
    @PostConstruct
    public void init(){
        
    }

    public List<TipoInsumo> getTiposInsumo() {
        if(tiposInsumo == null || tiposInsumo.isEmpty()){
            tiposInsumo = tiDAO.findAll();
        }
        return tiposInsumo;
    }
  
    
}
