package dao.implementacionHibernate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;

import dao.interfaces.DaoMovimientos;
import dao.utilidades.HibernateUtil;
import model.Cuenta;
import model.Movimiento;


@Stateless
@LocalBean
public class DaoMovimientosImplHbt implements DaoMovimientos{

	@Override
	public List<Movimiento> findMovimientoByCuenta(int idCuenta) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Cuenta cuenta= sesion.get(Cuenta.class, idCuenta);
			if(cuenta!=null) {
				return cuenta.getMovimientos();
			}
		}
		return null;
	}

	@Override
	public void saveMovimiento(Movimiento m) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			sesion.save(m);
		}
	}
}
