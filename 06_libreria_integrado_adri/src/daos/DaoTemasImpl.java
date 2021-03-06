package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Tema;

/**
 * Session Bean implementation class DaoTemasImpl
 */
@Stateless
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	@Override
	public List<Tema> obtenerTemas() {
		TypedQuery<Tema> tp=em.createNamedQuery("Tema.findAll",Tema.class);
		return tp.getResultList();
	}

    

}
