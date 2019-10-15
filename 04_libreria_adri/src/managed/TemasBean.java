package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoTemas;
import model.Tema;

@ManagedBean(name="temasBean")
@RequestScoped
public class TemasBean {
	@EJB
	DaoTemas daoTemas;
	
	private List<Tema> temas;
	private int idTemaSel;
	
	@PostConstruct
	public void init() {		
		temas=daoTemas.obtenerTemas();		
	}	


	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}	

}
