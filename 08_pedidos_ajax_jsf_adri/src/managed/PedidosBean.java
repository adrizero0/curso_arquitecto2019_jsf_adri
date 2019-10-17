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
	@EJB
	DaoPedidos daoPedidos;
	
	List<Pedido> pedidos;
	int idPedido;

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	@PostConstruct
	public void inicio() {
		pedidos=daoPedidos.recuperarPedidos();
	}
	public void eliminar() {
		daoPedidos.eliminarPedido(idPedido);
		pedidos=daoPedidos.recuperarPedidos();
	}

}
