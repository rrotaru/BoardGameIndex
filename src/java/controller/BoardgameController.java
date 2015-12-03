/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Boardgame;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Image;
import model.ParamData;

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
    @ManagedProperty(value = "#{paramData}")
    private ParamData paramData;

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
    
    public String createBoardgame() {
        return "";
        
    }
    
    public String updateBoardgame() {
        return "";
    }
    
    public String deleteBoardgame() {
        System.out.println("################# " + boardgame.getId() + boardgame.getName());
        String returnValue = "error";
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            userTransaction.begin();
            Boardgame b = em.find(Boardgame.class, boardgame.getId());
            setBoardgame(b);
            em.remove(boardgame);
            userTransaction.commit();
            em.close();
            returnValue = "confirmationDeleted";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public List getMatchingBoardgames() {
        List<Boardgame> boardgames = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if (paramData.getSearchText() != null && paramData.getSearchText().length() > 0) {
            try {
                String selectSQL = "select b from Boardgame b where UPPER(b."+paramData.getField()+") like UPPER(:field)";
                Query selectQuery = entityManager.createQuery(selectSQL);
                selectQuery.setParameter("field", paramData.getSearchText() + "%");
                boardgames = selectQuery.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
    
    public ParamData getParamData() {
        return paramData;
    }
    public void setParamData(ParamData paramData) {
        this.paramData = paramData;
    }
    public Boardgame findBoardgame() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select b from Boardgame b where UPPER(b.name) = UPPER(:name)";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("name", boardgame.getName());
            setBoardgame(entityManager.find(Boardgame.class, ((Boardgame) selectQuery.getSingleResult()).getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getBoardgame();
    }
    
    public void changeField() {
    }
}
