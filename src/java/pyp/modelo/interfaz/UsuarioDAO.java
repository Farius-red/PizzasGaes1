/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import pyp.modelo.entidades.Usuario;
import pyp.modelo.DAO.IUsuarioDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario> implements IUsuarioDAO {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByEmailAndPassword(String email, String password) {
        try{
        TypedQuery<Usuario> q = getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.email=:email AND u.contraseña=:pass", Usuario.class);
        q.setParameter("email", email);
        q.setParameter("pass", password);
        return q.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
