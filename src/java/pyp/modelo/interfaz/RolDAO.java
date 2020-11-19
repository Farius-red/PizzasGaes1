/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Rol;
import pyp.modelo.DAO.IRolDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class RolDAO extends AbstractDAO<Rol> implements IRolDAO {

    public RolDAO() {
        super(Rol.class);
    }
    
}
