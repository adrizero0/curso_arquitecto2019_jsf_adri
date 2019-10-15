package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {
	@EJB
	DaoClientes dao;	
	
	Cliente cliente;	

	public RegistroBean() {		
		cliente=new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String registro() {
		dao.registrar(cliente);		
		return "login";
	}
}
