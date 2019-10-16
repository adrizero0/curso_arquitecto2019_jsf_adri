package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import daos.DaoLibros;
import model.Libro;
import utilidades.Contexto;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@EJB
	DaoLibros daoLibros;
	
	
	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;
	
	private List<Libro> libros;
	@PostConstruct
	public void creado() {
		//Contexto.getRequest().getAttribute("temasBean");  --FALTARIA BUSCAR EL TEMASEL--
		if(temasBean.getTemaSel()==0) {
			libros=daoLibros.obtenerLibros();			
		}else {
			libros=daoLibros.obtenerLibrosTema(temasBean.getTemaSel());
		}
	}		
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public TemasBean getTemasBean() {
		return temasBean;
	}

	public void setTemasBean(TemasBean temasBean) {
		this.temasBean = temasBean;
	}	
	
	//controlador de acción
	public String finSesion() {
		Contexto.getSession().invalidate();
		return "login";
	}
	
}
