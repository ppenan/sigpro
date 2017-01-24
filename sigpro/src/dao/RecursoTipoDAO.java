package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pojo.RecursoTipo;
import pojo.RectipoPropiedad;
import utilities.CHibernateSession;
import utilities.CLogger;

public class RecursoTipoDAO {

	public static List<RecursoTipo> getRecursoTipos(){
		List<RecursoTipo> ret = new ArrayList<RecursoTipo>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<RecursoTipo> criteria = builder.createQuery(RecursoTipo.class);
			Root<RecursoTipo> root = criteria.from(RecursoTipo.class);
			criteria.select( root ).where(builder.equal(root.get("estado"),1));
			ret = session.createQuery( criteria ).getResultList();
		}
		catch(Throwable e){
			CLogger.write("1", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
		

	
	public static RecursoTipo getRecursoTipoPorId(int id){
		Session session = CHibernateSession.getSessionFactory().openSession();
		RecursoTipo ret = null;
		try{
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<RecursoTipo> criteria = builder.createQuery(RecursoTipo.class);
			Root<RecursoTipo> root = criteria.from(RecursoTipo.class);
			criteria.select( root );
			criteria.where( builder.and(builder.equal( root.get("id"), id ),builder.equal(root.get("estado"), 1)));
			ret = session.createQuery( criteria ).getSingleResult();
		}
		catch(Throwable e){
			CLogger.write("2", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static boolean guardarRecursoTipo(RecursoTipo recursotipo){
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(recursotipo);
			session.flush();
			
			if(recursotipo.getRectipoPropiedads()!=null){
				for (RectipoPropiedad propiedad : recursotipo.getRectipoPropiedads()){
					session.saveOrUpdate(propiedad);	
				}
			}
			session.flush();
			
			session.getTransaction().commit();
			ret = true;
		}
		catch(Throwable e){
			CLogger.write("3", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	
	
	
	
	public static boolean eliminarRecursoTipo(RecursoTipo recursoTipo){
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			
			recursoTipo.setEstado(0);
			session.beginTransaction();
			session.update(recursoTipo);
			session.getTransaction().commit();
			ret = true;
		}
		catch(Throwable e){
			CLogger.write("6",RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	
	
	public static boolean eliminarTotalRecursoTipo(RecursoTipo recursoTipo){
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(recursoTipo);
			session.getTransaction().commit();
			ret = true;
		}
		catch(Throwable e){
			CLogger.write("5", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	
	public static List<RecursoTipo> getRecursoTiposPagina(int pagina, int numerorecursostipo){
		List<RecursoTipo> ret = new ArrayList<RecursoTipo>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			Query<RecursoTipo> criteria = session.createQuery("SELECT c FROM RecursoTipo c WHERE estado = 1",RecursoTipo.class);
			criteria.setFirstResult(((pagina-1)*(numerorecursostipo)));
			criteria.setMaxResults(numerorecursostipo);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("6", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static Long getTotalRecursoTipo(){
		Long ret=0L;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			Query<Long> conteo = session.createQuery("SELECT count(c.id) FROM RecursoTipo c WHERE c.estado=1",Long.class);
			ret = conteo.getSingleResult();
		}
		catch(Throwable e){
			CLogger.write("7", RecursoTipoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
}
