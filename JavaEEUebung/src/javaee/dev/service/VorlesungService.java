package javaee.dev.service;

import java.util.LinkedList;
import java.util.List;

import javaee.dev.model.HibernateUtil;
import javaee.dev.model.VorlesungHibernate;
import javaee.dev.view.vorlesung.Vorlesung;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VorlesungService {

	private Logger logger = Logger.getLogger(VorlesungService.class);

	public VorlesungService() {
	}

	public void saveVorlesung(VorlesungHibernate vorlesung) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(vorlesung);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public void updateVorlesung(VorlesungHibernate vorlesung) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.update(vorlesung);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public List<VorlesungHibernate> loadVorlesung() {
		Session session = null;
		try {
			logger.info("Lade alle Vorlesungen!");
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<VorlesungHibernate> vorlesungen = session.createCriteria(VorlesungHibernate.class).list();
			logger.info("Habe Vorlesungen erhalten! " + vorlesungen.size());
			tx.commit();
			return vorlesungen;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return new LinkedList<VorlesungHibernate>();
	}
}
