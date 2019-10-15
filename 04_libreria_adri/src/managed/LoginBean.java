package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daos.DaoClientes;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	@EJB
	DaoClientes dao;
	
	private String usuario;
	private String password;
	
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
		
	
	public String login() {
		if(!dao.autenticar(usuario, password)) {
			return "error";
		}else {
			return "menu";
		}
	}
}
