package managed;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;
@ManagedBean
@RequestScoped
public class AltaBean {
	private Pedido pedido;
	@EJB
	DaoPedidos daoPedidos;
	@PostConstruct
	public void inicio() {
		pedido=new Pedido();
	}
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	///
	public String alta() {
		daoPedidos.altaPedido(pedido);
		return "menu";
	}
}
