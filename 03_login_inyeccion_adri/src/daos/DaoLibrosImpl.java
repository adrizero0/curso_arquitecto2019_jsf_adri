package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Libro;
import model.Tema;

@Stateless
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;

	@Override
	public List<Libro> obtenerLibros() {
		TypedQuery<Libro> tq=em.createNamedQuery("Libro.findAll",Libro.class);
		return tq.getResultList();
	}

	@Override
	public List<Libro> obtenerLibroTema(int idTema) {
		Tema t=em.find(Tema.class, idTema);
		return t.getLibros();
	}
}
