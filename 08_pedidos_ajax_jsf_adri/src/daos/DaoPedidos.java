package daos;

import java.util.List;

import javax.ejb.Local;

import model.Pedido;



@Local
public interface DaoPedidos {
	void guardarPedido(Pedido p);
	List<Pedido> recuperarPedidos();
	void eliminarPedido(int idPedido);
	List<String> recuperarCategorias();
	void actualizarPedido(int idPedido);
	Pedido recuperarPedido(int idPedido);
}
