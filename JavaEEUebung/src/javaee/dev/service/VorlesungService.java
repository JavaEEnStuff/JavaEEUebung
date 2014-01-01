package javaee.dev.service;

import javaee.dev.model.HibernateUtil;
import javaee.dev.model.VorlesungHibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;

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
}
