/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Administrador;
import pyp.modelo.DAO.IAdministradorDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class AdministradorDAO extends AbstractDAO<Administrador> implements IAdministradorDAO {

    public AdministradorDAO() {
        super(Administrador.class);
    }
    
}
