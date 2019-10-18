package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;
@ManagedBean
@RequestScoped
public class PedidosBean {
	
	private Pedido pedidoEditar;
	private List<Pedido> pedidos;
	@EJB
	DaoPedidos daoPedidos;
	@PostConstruct
	public void inicio() {
		pedidos=daoPedidos.recuperarPedidos();
	}
	
	public Pedido getPedidoEditar() {
		return pedidoEditar;
	}

	public void setPedidoEditar(Pedido pedidoEditar) {
		this.pedidoEditar = pedidoEditar;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	//
	public void eliminarPedido(int idPedido) {
		daoPedidos.eliminarPedido(idPedido);
		//pedidos=daoPedidos.recuperarPedidos();
		pedidos.removeIf(p->p.getIdPedido()==idPedido);
	}
	public String editarPedido(int idPedido) {
		pedidoEditar=daoPedidos.recuperarPedidoPorId(idPedido);
		return "editar";
	}
}
