package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoCliente;
import daos.DaoVentas;
import model.Venta;

@ManagedBean
@RequestScoped
public class VentasBean {
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	@EJB
	DaoVentas daoVentas;
	@EJB
	DaoCliente daoClientes;
	
	private List<Venta> ventas;

	@PostConstruct
	public void inicio() {
		int idCliente=daoClientes
				.getCliente(loginBean.getUsuario(), loginBean.getPassword())
				.getIdCliente();
		ventas=daoVentas.recuperarVentasCliente(idCliente);
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
	
	
}
