/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.TipoInsumo;
import pyp.modelo.DAO.ITipoInsumoDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class TipoInsumoDAO extends AbstractDAO<TipoInsumo> implements ITipoInsumoDAO {

    public TipoInsumoDAO() {
        super(TipoInsumo.class);
    }
    
}
