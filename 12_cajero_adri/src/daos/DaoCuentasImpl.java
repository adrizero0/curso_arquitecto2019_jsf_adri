package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Cuenta;


@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	@PersistenceContext(unitName = "cajeroPU")
	EntityManager em;
	
	@Override
	public List<Cuenta> obtenerCuentas() {
		TypedQuery<Cuenta> tq=em.createNamedQuery("Cuenta.findAll",Cuenta.class);
		return tq.getResultList();
	}
}
