/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private String link;
    private String designer;
    private String artist;
    private String yearpublished;
    private String players;
    private String ages;
    private String playingtime;
    private String category;
    private String publisher;
    
    @OneToMany(mappedBy="boardgame",fetch=FetchType.EAGER)
    private List<Image> images;

    /**
     * Creates a new instance of Boardgame
     */
    public Boardgame() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    /**
     * @return the designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * @param designer the designer to set
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
     * @return the year
     */
    public String getYearPublished() {
        return yearpublished;
    }

    /**
     * @param year the year to set
     */
    public void setYearPublished(String yearpublished) {
        this.yearpublished = yearpublished;
    }

        /**
     * @return the players
     */
    public String getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(String players) {
        this.players = players;
    }

        /**
     * @return the ages
     */
    public String getAges() {
        return ages;
    }

    /**
     * @param ages the ages to set
     */
    public void setAges(String ages) {
        this.ages = ages;
    }

        /**
     * @return the playingtime
     */
    public String getPlayingTime() {
        return playingtime;
    }

    /**
     * @param playingtime the playingtime to set
     */
    public void setPlayingTime(String playingtime) {
        this.playingtime = playingtime;
    }

        /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
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
