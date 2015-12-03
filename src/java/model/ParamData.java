/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author robertrotaru
 */
@ManagedBean
@SessionScoped
public class ParamData implements Serializable {
    private String field = "name";
    private String searchText = "";

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
    public String getSearchText() {
        return searchText;
    }
    
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
