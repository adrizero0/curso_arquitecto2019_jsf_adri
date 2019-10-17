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
	@EJB
	DaoPedidos daoPedidos;
	
	Pedido pedido;
	@PostConstruct	
	public void inicio() {
		pedido= new Pedido();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String alta() {
		daoPedidos.guardarPedido(pedido);;
		return "menu";
	}

}
