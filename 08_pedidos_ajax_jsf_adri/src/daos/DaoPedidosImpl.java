package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Pedido;

@Stateless
public class DaoPedidosImpl implements DaoPedidos {
	@PersistenceContext(unitName = "almacenPU")
	EntityManager em;

	@Override
	public void guardarPedido(Pedido p) {
		em.persist(p);		
	}

	@Override
	public List<Pedido> recuperarPedidos() {
		TypedQuery<Pedido> qr=em.createNamedQuery("Pedido.findAll",Pedido.class);
		return qr.getResultList();
	}

	@Override
	public void eliminarPedido(int idPedido) {
		Pedido p=em.find(Pedido.class, idPedido);
		em.remove(p);
	}

	@Override
	public List<String> recuperarCategorias() {
		TypedQuery<String> qr=em.createNamedQuery("Pedido.findCategory",String.class);
		return qr.getResultList();
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		em.merge(pedido);
	}

	@Override
	public Pedido recuperarPedido(int idPedido) {
		return em.find(Pedido.class, idPedido);		
	}
}
