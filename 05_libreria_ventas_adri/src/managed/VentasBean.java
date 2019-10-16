package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoVentas;
import model.Cliente;
import model.Venta;

@ManagedBean
@RequestScoped
public class VentasBean {
	@EJB
	DaoVentas daoVentas;
	
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	
	private List<Venta> ventas;
	
	@PostConstruct
	public void init() {		
		ventas=(List<Venta>)daoVentas.recuperarVentasCliente
				((loginBean.daoClientes.getCliente(loginBean.getUsuario(), loginBean.getPassword()).getIdCliente()));		
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
