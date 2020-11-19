/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Despacho;
import pyp.modelo.DAO.IDespachoDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class DespachoDAO extends AbstractDAO<Despacho> implements IDespachoDAO {

    public DespachoDAO() {
        super(Despacho.class);
    }
    
}
