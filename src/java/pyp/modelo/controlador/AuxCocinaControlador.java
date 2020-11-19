/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.modelo.controlador;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import pyp.modelo.DAO.IAuxCocinaDAO;
import pyp.modelo.entidades.AuxCocina;

/**
 *
 * @author PC
 */
@Named(value = "auxCocinaControlador")
@ViewScoped
public class AuxCocinaControlador implements Serializable {
    
        @EJB
        private IAuxCocinaDAO auxDAO;
        private List<AuxCocina> AuxCocina; 
        
    public AuxCocinaControlador() {
    }

    public List<AuxCocina> getAuxCocina() {
        if(AuxCocina == null || AuxCocina.isEmpty()){
            AuxCocina = auxDAO.findAll();
        }
        return AuxCocina;
    }
    
}
