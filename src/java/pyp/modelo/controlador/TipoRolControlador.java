
package pyp.modelo.controlador;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pyp.modelo.DAO.IRolDAO;
import pyp.modelo.entidades.Rol;

@Named(value = "tipoRolControlador")
@RequestScoped
public class TipoRolControlador {
    
    @EJB
    private IRolDAO rolDAO;
    private List<Rol> roles;
    public TipoRolControlador() {
    }

    public List<Rol> getRoles() {
        if(roles == null || roles.isEmpty()){
            roles = rolDAO.findAll();
        }
        return roles;
    }
    
    
}
