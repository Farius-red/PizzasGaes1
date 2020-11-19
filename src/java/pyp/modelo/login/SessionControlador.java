package pyp.modelo.login;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import pyp.modelo.DAO.IUsuarioDAO;
import pyp.modelo.entidades.Usuario;
import pyp.modelo.util.MessageUtil;

@Named(value = "sessionControlador")
@SessionScoped
public class SessionControlador implements Serializable {

    @EJB
    private IUsuarioDAO uDAO;
    private String email;
    private String password;
    private Usuario user;

    public SessionControlador() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String startSession() {
        
        if (email != null && email.trim().length() > 0 
                && password != null && password.trim().length() > 0) {
            user = uDAO.findByEmailAndPassword(email, password);
            if(user != null){
                return "/Inventario/PerfilAdministrador.xhtml?faces-redirect=true";
            }else{
               MessageUtil.sendInfo(null, "Datos Incorrectos", "Verifique sus datos y vuelva a intentarlo", Boolean.FALSE); 
            }
        }else{
            MessageUtil.sendInfo(null, "Datos Obligatorios", "Debe diligenciar todos los campos", Boolean.FALSE);
        }
        return "";
    }
    public boolean isStartSession(){
        return user != null;
    }
    public void validarSesion() throws IOException{
        if(!isStartSession()){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath()+"/Usuario/InicioSesion.xhtml");
        }
    }

}
