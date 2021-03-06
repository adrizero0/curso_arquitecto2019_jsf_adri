package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daos.DaoCliente;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	private String usuario;
	private String password;
	
	@EJB
	DaoCliente daoClientes;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/////////
	
	public String login() {
		if(daoClientes.autenticar(usuario, password)) {
			//recuperamos los libros para la vista
			//en el momento en que el usuario es autenticado
			//libros=daoLibros.obtenerLibros();
			return "menu";
		}else {
			return "error";
		}
	}
}
