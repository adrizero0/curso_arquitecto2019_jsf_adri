package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="movimientos")
@NamedQueries({
	@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Cliente m"),
	@NamedQuery(name="Movimiento.findByDateRange", query="SELECT m FROM Movimiento m WHERE m.cuenta.numeroCuenta=?1 AND m.fecha BETWEEN ?2 AND ?3")
})
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;

	private double cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String operacion;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="idCuenta",referencedColumnName = "numeroCuenta")
	private Cuenta cuenta;

	public Movimiento() {
	}

	public Movimiento(int idMovimiento, double cantidad, Date fecha, String operacion, Cuenta cuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}