/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author rrotaru
 */
@FacesValidator(value="urlValidator")
public class urlValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String url = (String)value;
        HtmlInputText htmlInputText = (HtmlInputText)component;
        if (!url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")){
            FacesMessage facesMessage =  new FacesMessage(htmlInputText.getLabel()+": url format is not valid");
            throw new ValidatorException(facesMessage);
        }
    }
}
