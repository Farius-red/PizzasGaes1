/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.AuxCocina;
import pyp.modelo.DAO.IAuxCocinaDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class AuxCocinaDAO extends AbstractDAO<AuxCocina> implements IAuxCocinaDAO {

    public AuxCocinaDAO() {
        super(AuxCocina.class);
    }
    
}
