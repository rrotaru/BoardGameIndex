/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author robertrotaru
 */
@Stateless
public class BoardgamesFacade extends AbstractFacade<Boardgames> {
    @PersistenceContext(unitName = "BoardGameIndexPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoardgamesFacade() {
        super(Boardgames.class);
    }
    
}
