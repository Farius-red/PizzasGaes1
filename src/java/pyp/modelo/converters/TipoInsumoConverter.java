
package pyp.modelo.converters;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pyp.modelo.DAO.ITipoInsumoDAO;
import pyp.modelo.entidades.TipoInsumo;

@FacesConverter(forClass = TipoInsumo.class)
public class TipoInsumoConverter implements Converter {
    
    private ITipoInsumoDAO tiDAO;
    
    public TipoInsumoConverter(){
        tiDAO = CDI.current().select(ITipoInsumoDAO.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if(value != null){
           try {
               Integer id = Integer.valueOf(value);
               return tiDAO.find(id);
           } catch (NumberFormatException numberFormatException) {
           }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
        if(obj != null && obj instanceof TipoInsumo){
           TipoInsumo ti = (TipoInsumo) obj; 
           return ti.getId().toString();
        }
        return null;
    }
    
}
