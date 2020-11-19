/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.interfaz;

import javax.ejb.Stateless;
import pyp.modelo.entidades.Producto;
import pyp.modelo.DAO.IProductoDAO;

/**
 *
 * @Gaes 5
 */
@Stateless
public class ProductoDAO extends AbstractDAO<Producto> implements IProductoDAO {

    public ProductoDAO() {
        super(Producto.class);
    }
    
}
