package pyp.modelo.converters;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pyp.modelo.DAO.IAuxCocinaDAO;
import pyp.modelo.entidades.AuxCocina;

@FacesConverter(forClass = AuxCocina.class)
public class AuxCocinaConverter implements Converter {
    
    private IAuxCocinaDAO auxDAO;
    
    public AuxCocinaConverter(){
        auxDAO = CDI.current().select(IAuxCocinaDAO.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            try {
                Integer id = Integer.valueOf(value);
                return auxDAO.find(id);
            }catch (NumberFormatException numberFormatException){
                
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
        if (obj != null && obj instanceof AuxCocina) {
            AuxCocina aux = (AuxCocina) obj;
            return aux.getId().toString();

        }
        return null;
    }

}
