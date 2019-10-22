package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Movimiento;

@Stateless
public class DaoMovimientosImpl implements DaoMovimientos {
	@PersistenceContext(unitName = "cajeroPU")
	EntityManager em;

   @Override
	public List<Movimiento> obtenerMovimientosPorFecha(int idCuenta, Date fecha1, Date fecha2) {
	   Query qr=em.createNamedQuery("Movimiento.findByDateRange");
	   qr.setParameter(1, idCuenta);
	   qr.setParameter(2, fecha1);
	   qr.setParameter(3, fecha2);
	   return qr.getResultList();
	   
	   // POR DEFECTO COGE SOLO FECHA, EL TIMESTAMP SE USA PARA QUE COJA FECHA Y HORA
	   //(2,fecha1,TemporalType.TIMESTAMP);
	}

}
