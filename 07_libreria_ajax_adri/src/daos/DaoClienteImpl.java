package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Cliente;

/**
 * Session Bean implementation class DaoClienteImpl
 */
@Stateless
public class DaoClienteImpl implements DaoCliente {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public boolean autenticar(String user, String pass) {
		
		Query qr=em.createNamedQuery("Cliente.findByUserAndPwd");
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		return qr.getResultList().size()>0;
	}

	@Override
	public void registrar(Cliente c) {
		em.persist(c);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Cliente getCliente(String user, String pass) {
		//Query qr=em.createNamedQuery("Cliente.findByUserAndPwd");
		TypedQuery<Cliente> qr=em.createNamedQuery("Cliente.findByUserAndPwd",Cliente.class);
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		List<Cliente> clientes=qr.getResultList();
		return qr.getResultList().size()>0?(Cliente)clientes.get(0):null;
	}
    

}
