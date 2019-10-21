package daos;

import java.util.List;

import javax.ejb.Local;

import model.Cuenta;

@Local
public interface DaoCuentas {
	List<Cuenta> obtenerCuentas();
}
