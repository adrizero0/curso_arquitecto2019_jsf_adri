package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Pedido;

/**
 * Session Bean implementation class DaoPedidosImpl
 */
@Stateless
public class DaoPedidosImpl implements DaoPedidos {

    @PersistenceContext(unitName = "pedidosPU")
    EntityManager em;
	@Override
	public void altaPedido(Pedido pedido) {
		em.persist(pedido);
		
	}

	@Override
	public List<Pedido> recuperarPedidos() {
		//String jpql="Select p From Pedido p";
		//Query query=em.createQuery(jpql);
		Query query=em.createNamedQuery("Pedido.findAll");
		return (List<Pedido>)query.getResultList();
	}

	@Override
	public void eliminarPedido(int idPedido) {
		Pedido ped=recuperarPedidoPorId(idPedido);
		if(ped!=null) {
			em.remove(ped);
		}	
	}

	@Override
	public Pedido recuperarPedidoPorId(int id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		em.merge(pedido);	
	}

	@Override
	public List<String> recuperarCategorias() {
		/*List<Pedido> pedidos=recuperarPedidos();
		List<String> categorias=new ArrayList<>();
		for(Pedido p:pedidos) {
			categorias.add(p.getCategoria());
		}
		return categorias;*/
		
		/*String jpql2= "select p.producto,p.precio From Pedido p";
		TypedQuery<Object[]> tq2=em.createQuery(jpql2,Object[].class);
		List<Object[]> resultado=tq2.getResultList();*/
		
		String jpql="Select distinct(p.categoria) From Pedido p";
		TypedQuery<String> tq=em.createQuery(jpql,String.class);
		return tq.getResultList();
		
		
	}
	
	
	

}
