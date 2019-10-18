package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.DaoPedidos;
import model.Pedido;
@ManagedBean
@ViewScoped
public class EditarBean {
	@EJB
	DaoPedidos daoPedidos;
	List<String> categorias;
	Pedido pedido;
	@ManagedProperty("#{pedidosBean!=null?pedidosBean:null}")
	PedidosBean pedidosBean;
	@PostConstruct
	public void inicio() {
		categorias=daoPedidos.recuperarCategorias();
		pedido=pedidosBean.getPedidoEditar();
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
	public PedidosBean getPedidosBean() {
		return pedidosBean;
	}
	public void setPedidosBean(PedidosBean pedidosBean) {
		this.pedidosBean = pedidosBean;
	}
	//
	public String actualizar() {
		daoPedidos.actualizarPedido(pedido);
		return "pedidos";
	}
}
