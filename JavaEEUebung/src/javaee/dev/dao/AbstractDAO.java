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
	 * Sucht eine Sehenswürdigkeit anhand ihres Primärschlüssels aus der
	 * Datenbank.
	 * 
	 * @param id
	 *            Der Primärschlüssel der zu suchenden Sehenswürdigkeit.
	 * @return Die gefundene Sehenswürdigkeit oder null.
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
	 * Gibt alle Sehenswürdigkeiten als Liste aus der Datenbank zurück.
	 * 
	 * @return Alle Sehenswürdigkeiten.
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
	 * Sucht alle Sehenswürdigkeiten aus der Datenbank, deren Name dem
	 * Suchstring entspricht.
	 * 
	 * @param searchString
	 *            Der Suchstring.
	 * @return Alle passenden Sehenswürdigkeiten.
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
	 * Speichert eine Sehenswürdigkeit in der Datenbank. Diese Methode erkennt
	 * selbstständig, ob ein Objekt neu in die Datenbank eingefügt oder dort
	 * aktualisiert werden muss.
	 * 
	 * @param sight
	 *            Die zu speichernde Sehenswürdigkeit.
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
