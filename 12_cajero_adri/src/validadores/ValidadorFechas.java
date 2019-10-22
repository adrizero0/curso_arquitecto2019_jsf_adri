package validadores;

import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vFechas")
public class ValidadorFechas implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		Date fFin=(Date)arg2;
		Date fIni=(Date)((UIInput)arg1.findComponent("fecha1")).getValue();
		if(fIni.compareTo(fFin)>0) {
			throw new ValidatorException(new FacesMessage("La fecha de fin debe ser posterior a fecha inicio"));
		}
	}
}