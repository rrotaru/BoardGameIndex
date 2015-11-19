/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author rrotaru
 */
@ManagedBean
@Entity
public class Boardgame implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer minPlayers;
    private Integer maxPlayers;
    private String publisher;

    /**
     * Creates a new instance of Boardgame
     */
    public Boardgame() {
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the MinPlayers
     */
    public Integer getMinPlayers() {
        return minPlayers;
    }

    /**
     * @param minPlayers the MinPlayers to set
     */
    public void setLastName(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * @return the MaxPlayers
     */
    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * @param maxPlayers the MaxPlayers to set
     */
    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * @return the Publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the Publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
