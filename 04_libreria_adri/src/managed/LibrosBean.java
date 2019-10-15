package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@EJB
	DaoLibros daoLibros;
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;
	
	private List<Libro> libros;
	
	//POST CONSTRUCT SE USA PARA QUE UN METODO SE EJECUTE DESPUÉS DE QUE SE CREE EL OBJETO
	@PostConstruct
	public void init() {
		if(temasBean.getTemas()==0) {
			libros=daoLibros.obtenerLibros();
		}else {
			libros=daoLibros.obtenerLibroTema(temasBean.getIdTema());
		}
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Libro> getLibros() {
		libros=daoLibros.obtenerLibros();
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}	

}
