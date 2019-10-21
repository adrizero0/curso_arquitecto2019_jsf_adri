package managed;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Movimiento;

@ManagedBean
@RequestScoped
public class GestionBean {
	@EJB
	DaoCuentas daoCuentas;
	
	@EJB
	DaoMovimientos daoMovimientos;
	
	private List<Cuenta> cuentas;
	private List<Movimiento> movimientos;
	private Date fecha1;
	private Date fecha2;
	private int cuentaSel;
	
	@PostConstruct
	public void inicio() {
		cuentas=daoCuentas.obtenerCuentas();
	}
	
	public List<Movimiento> buscarMovimientos() {
		movimientos=daoMovimientos.obtenerMovimientosPorFecha(cuentaSel, fecha1, fecha2);
		return movimientos;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public Date getFecha1() {
		return fecha1;
	}
	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}
	public Date getFecha2() {
		return fecha2;
	}
	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}
	public int getCuentaSel() {
		return cuentaSel;
	}
	public void setCuentaSel(int cuentaSel) {
		this.cuentaSel = cuentaSel;
	}
}
