package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Tema;


@Stateless
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public List<Tema> obtenerTemas() {
		TypedQuery<Tema> tq=em.createNamedQuery("Tema.findAll",Tema.class);
		return tq.getResultList();
	}


}
