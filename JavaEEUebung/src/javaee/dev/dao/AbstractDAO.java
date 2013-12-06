package javaee.dev.dao;

import java.util.ArrayList;
import java.util.List;

import javaee.dev.model.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

public abstract class AbstractDAO<T extends Object> {

	public void delete(T sight) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			if (sight != null) {
				session.delete(sight);
				session.flush();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * Sucht eine Sehensw�rdigkeit anhand ihres Prim�rschl�ssels aus der
	 * Datenbank.
	 * 
	 * @param id
	 *            Der Prim�rschl�ssel der zu suchenden Sehensw�rdigkeit.
	 * @return Die gefundene Sehensw�rdigkeit oder null.
	 */
	public T get(int id) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			T sight = (T) session.get(getHibernateClass(), id);
			session.getTransaction().commit();
			return sight;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	protected abstract Class getHibernateClass();

	/**
	 * Gibt alle Sehensw�rdigkeiten als Liste aus der Datenbank zur�ck.
	 * 
	 * @return Alle Sehensw�rdigkeiten.
	 */
	public List<T> getList() {
		Session session = null;
		List<T> resultList;
		String queryString = "SELECT s FROM SightHibernateImpl s";

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery(queryString);
			resultList = (ArrayList<T>) q.list();
			session.getTransaction().commit();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * Sucht alle Sehensw�rdigkeiten aus der Datenbank, deren Name dem
	 * Suchstring entspricht.
	 * 
	 * @param searchString
	 *            Der Suchstring.
	 * @return Alle passenden Sehensw�rdigkeiten.
	 */
	public List<T> getList(String searchString) {
		Session session = null;
		List<T> resultList;
		String queryString = "SELECT s FROM SightHibernateImpl s where s.sightName like ?";

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery(queryString);
			q.setString(0, "%" + searchString + "%");
			resultList = (ArrayList<T>) q.list();
			session.getTransaction().commit();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * Speichert eine Sehensw�rdigkeit in der Datenbank. Diese Methode erkennt
	 * selbstst�ndig, ob ein Objekt neu in die Datenbank eingef�gt oder dort
	 * aktualisiert werden muss.
	 * 
	 * @param sight
	 *            Die zu speichernde Sehensw�rdigkeit.
	 */
	public void save(T sight) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(sight);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
