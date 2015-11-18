/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patryk
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name = "BOARDGAMES", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boardgames.findAll", query = "SELECT b FROM Boardgames b"),
    @NamedQuery(name = "Boardgames.findById", query = "SELECT b FROM Boardgames b WHERE b.id = :id"),
    @NamedQuery(name = "Boardgames.findByName", query = "SELECT b FROM Boardgames b WHERE b.name = :name"),
    @NamedQuery(name = "Boardgames.findByMinplayers", query = "SELECT b FROM Boardgames b WHERE b.minplayers = :minplayers"),
    @NamedQuery(name = "Boardgames.findByMaxplayers", query = "SELECT b FROM Boardgames b WHERE b.maxplayers = :maxplayers"),
    @NamedQuery(name = "Boardgames.findByPublisher", query = "SELECT b FROM Boardgames b WHERE b.publisher = :publisher")})
public class Boardgames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINPLAYERS")
    private int minplayers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAXPLAYERS")
    private int maxplayers;
    @Size(max = 60)
    @Column(name = "PUBLISHER")
    private String publisher;

    public Boardgames() {
    }

    public Boardgames(Integer id) {
        this.id = id;
    }

    public Boardgames(Integer id, String name, int minplayers, int maxplayers) {
        this.id = id;
        this.name = name;
        this.minplayers = minplayers;
        this.maxplayers = maxplayers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinplayers() {
        return minplayers;
    }

    public void setMinplayers(int minplayers) {
        this.minplayers = minplayers;
    }

    public int getMaxplayers() {
        return maxplayers;
    }

    public void setMaxplayers(int maxplayers) {
        this.maxplayers = maxplayers;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boardgames)) {
            return false;
        }
        Boardgames other = (Boardgames) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Igotabigpackage.exe.Boardgames[ id=" + id + " ]";
    }
    
}
