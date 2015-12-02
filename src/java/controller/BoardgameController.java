/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Boardgame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Image;

/**
 *
 * @author rrotaru
 */
@ManagedBean
public class BoardgameController {
    
    @PersistenceUnit(unitName = "BoardGameIndex2PU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{boardgame}")
    private Boardgame boardgame;

    public String saveBoardgame() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.persist(boardgame);
            userTransaction.commit();
            em.close();
            returnValue = "confirmationSaved";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public List getMatchingBoardgames() {
        List<Boardgame> boardgames = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select b from Boardgame b where b.name like :name";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("name", boardgame.getName() + "%");
            boardgames = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardgames;
    }

    /**
     * @return the boardgame
     */
    public Boardgame getBoardgame() {
        return boardgame;
    }

    /**
     * @param boardgame the boardgame to set
     */
    public void setBoardgame(Boardgame boardgame) {
        this.boardgame = boardgame;
    }
    
    public String deleteBoardgame(Integer id) {
        System.out.println("#################" + id.toString());
        String returnValue = "error";
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Boardgame boardgame = em.find(Boardgame.class, id);
            em.remove(boardgame);
            em.getTransaction().commit();
            em.close();
            returnValue = "confirmationDeleted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
