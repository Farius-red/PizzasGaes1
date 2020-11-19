/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Operario;
import pyp.modelo.DAO.IOperarioDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class OperarioDAO extends AbstractDAO<Operario> implements IOperarioDAO {

    public OperarioDAO() {
        super(Operario.class);
    }
    
}
