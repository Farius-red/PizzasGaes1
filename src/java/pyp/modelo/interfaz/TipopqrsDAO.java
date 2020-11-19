/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Tipopqrs;
import pyp.modelo.DAO.ITipopqrsDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class TipopqrsDAO extends AbstractDAO<Tipopqrs> implements ITipopqrsDAO {

    public TipopqrsDAO() {
        super(Tipopqrs.class);
    }
    
}
