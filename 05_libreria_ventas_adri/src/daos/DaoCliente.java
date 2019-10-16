package daos;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoCliente {
	boolean autenticar(String user, String pass);

	void registrar(Cliente c);
	
	Cliente getCliente(String user, String pass);
}
