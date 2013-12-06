package javaee.dev.dao;

import javaee.dev.model.VorlesungHibernate;

public class VorlesungDAO extends AbstractDAO<VorlesungHibernate> {

	@Override
	protected Class<VorlesungHibernate> getHibernateClass() {
		return VorlesungHibernate.class;
	}

}
