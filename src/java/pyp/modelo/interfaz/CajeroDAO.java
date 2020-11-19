/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Cajero;
import pyp.modelo.DAO.ICajeroDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class CajeroDAO extends AbstractDAO<Cajero> implements ICajeroDAO {

    public CajeroDAO() {
        super(Cajero.class);
    }
    
}
