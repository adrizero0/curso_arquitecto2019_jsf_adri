package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCliente;
import model.Cliente;

@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {
	Cliente cliente;
	@EJB
	DaoCliente daoClientes;
	public RegistroBean() {
		cliente=new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String registrar() {
		daoClientes.registrar(cliente);
		return "login";
	}
	
}
