/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.DAO;

import javax.ejb.Local;
import pyp.modelo.entidades.Usuario;

/**
 *
 * @GAES 5
 */
@Local
public interface IUsuarioDAO extends DAO<Usuario> {
    
    Usuario findByEmailAndPassword(String email, String password);
}
