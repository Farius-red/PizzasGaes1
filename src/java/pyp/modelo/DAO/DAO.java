/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.DAO;

import java.util.List;

/**
 *
 * @GAES 5
 */
public interface DAO<E>  {
    
    void create(E administrador);

    void edit(E administrador);

    void remove(E administrador);

    E find(Object id);

    List<E> findAll();

    List<E> findRange(int[] range);

    int count();
}
