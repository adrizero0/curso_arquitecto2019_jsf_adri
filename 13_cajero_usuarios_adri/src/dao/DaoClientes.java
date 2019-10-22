package dao;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {
	List <Cliente> findClienteByCuenta(int idCuenta);
	void saveCliente(Cliente cliente);
	void removeCliente(int dni);
	void updateCliente(Cliente cliente);
}
