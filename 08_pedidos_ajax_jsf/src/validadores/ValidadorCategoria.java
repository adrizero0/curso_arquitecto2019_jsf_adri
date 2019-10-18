package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vCat")
public class ValidadorCategoria implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		//EL OBJECT ES EL VALOR QUE HA METIDO EL USUARIO
		
		String valor=(String) arg2;
		
		if(!valor.startsWith("9")) {
			//SI NO CUMPLE CON EL CRITERIO, PROVOCAR UNA EXCEPCION
			ResourceBundle res=arg0.getApplication().getResourceBundle(arg0, "mens");
			
			//FORMA FACIL
			//throw new ValidatorException(new FacesMessage("Categoría no válida"));
			
			throw new ValidatorException(new FacesMessage(res.getString("error.categoria")));
		}
	}
}
