package javaee.dev.view.vorlesung;

import javaee.dev.model.HibernateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Session;

@ManagedBean
@SessionScoped
public class Vorlesung {

	private String bezeichnung;
	private String dozent;
	private Integer teilnehmerzahl;
	private boolean anmeldepflichtig;
	private boolean ws;
	private Integer jahr;
	
	public Vorlesung() {
		Test test = new Test();
		saveSight(test);
	}
	
	public static void saveSight(Test test) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(test);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getDozent() {
		return dozent;
	}

	public void setDozent(String dozent) {
		this.dozent = dozent;
	}

	public Integer getTeilnehmerzahl() {
		return teilnehmerzahl;
	}

	public void setTeilnehmerzahl(Integer teilnehmerzahl) {
		this.teilnehmerzahl = teilnehmerzahl;
	}

	public boolean isAnmeldepflichtig() {
		return anmeldepflichtig;
	}

	public void setAnmeldepflichtig(boolean anmeldepflichtig) {
		this.anmeldepflichtig = anmeldepflichtig;
	}

	public boolean isWs() {
		return ws;
	}

	public void setWs(boolean ws) {
		this.ws = ws;
	}

	public Integer getJahr() {
		return jahr;
	}

	public void setJahr(Integer jahr) {
		this.jahr = jahr;
	}

	@Override
	public String toString() {
		return "Vorlesung [bezeichnung=" + bezeichnung + ", dozent=" + dozent
				+ ", teilnehmerzahl=" + teilnehmerzahl + ", ws=" + ws
				+ ", jahr=" + jahr + "]";
	}

	public void anmeldePflichtChanged(ValueChangeEvent event) {
		;
	}
}
