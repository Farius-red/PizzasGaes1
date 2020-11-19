
package pyp.modelo.converters;

import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pyp.modelo.DAO.IRolDAO;
import pyp.modelo.entidades.Rol;

@FacesConverter(forClass = Rol.class)
public class RolConverter implements Converter {

    private IRolDAO rolDAO;

    public RolConverter() {
        rolDAO = CDI.current().select(IRolDAO.class).get();
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if(value != null){
           try {
               Integer id = Integer.valueOf(value);
               return rolDAO.find(id);
           } catch (NumberFormatException numberFormatException) {
           }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
        if(obj != null && obj instanceof Rol){
        Rol rol = (Rol) obj;
        return rol.getId().toString();
        }
        return "";
    }
    
}
