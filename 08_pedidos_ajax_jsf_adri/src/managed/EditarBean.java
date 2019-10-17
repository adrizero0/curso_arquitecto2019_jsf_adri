package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;

@ManagedBean
@RequestScoped
public class EditarBean {
	@ManagedProperty("#{pedidosBean}")
	PedidosBean pedidosBean;
	
	@EJB
	DaoPedidos daoPedidos;
	
	List<String> categorias;
	Pedido pedido;
	int idPedido;
	
	public PedidosBean getPedidosBean() {
		return pedidosBean;
	}
	public void setPedidosBean(PedidosBean pedidosBean) {
		this.pedidosBean = pedidosBean;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	@PostConstruct
	public int inicio(int idPedido) {
		categorias=daoPedidos.recuperarCategorias();
		pedido=pedidosBean.daoPedidos.recuperarPedido(idPedido);
		return idPedido;
	}	
	public String actualizar() {
		daoPedidos.actualizarPedido(idPedido);
		return "pedidos";
	}
}
