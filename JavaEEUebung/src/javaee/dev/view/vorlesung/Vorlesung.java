package javaee.dev.view.vorlesung;

import javaee.dev.model.VorlesungHibernate;
import javaee.dev.service.VorlesungService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class Vorlesung {

	private static Logger logger = Logger.getLogger(Vorlesung.class);

	private VorlesungHibernate vorlesung;

	public Vorlesung() {
		logger.info("initialisiere Objekt Vorlesung");
		vorlesung = new VorlesungHibernate();
	}

	public String getBezeichnung() {
		return vorlesung.getLabel();
	}

	public void setBezeichnung(String bezeichnung) {
		vorlesung.setLabel(bezeichnung);
	}

	public String getDozent() {
		return vorlesung.getLecturer();
	}

	public void setDozent(String dozent) {
		vorlesung.setLecturer(dozent);
	}

	public Integer getTeilnehmerzahl() {
		return vorlesung.getMembers();
	}

	public void setTeilnehmerzahl(Integer teilnehmerzahl) {
		vorlesung.setMembers(teilnehmerzahl);
	}

	public boolean isAnmeldepflichtig() {
		return vorlesung.isRegistrationRequired();
	}

	public void setAnmeldepflichtig(boolean anmeldepflichtig) {
		vorlesung.setRegistrationRequired(anmeldepflichtig);
	}

	public boolean isWs() {
		return vorlesung.isWinterSemester();
	}

	public void setWs(boolean ws) {
		vorlesung.setWinterSemester(ws);
	}

	public Integer getJahr() {
		return vorlesung.getYear();
	}

	public void setJahr(Integer jahr) {
		vorlesung.setYear(jahr);
	}

	public void anmeldePflichtChanged(ValueChangeEvent event) {
		;
	}

	public void save(ActionEvent event) {
		logger.info("Versuche Vorlesung zu speichern...");
		VorlesungService service = new VorlesungService();
		if (vorlesung.getId() != null)
			service.updateVorlesung(vorlesung);
		else
			service.saveVorlesung(vorlesung);
	}
}
