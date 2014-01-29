package javaee.dev.view.vorlesung;

import java.util.List;

import javaee.dev.model.VorlesungHibernate;
import javaee.dev.service.VorlesungService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class Vorlesungen {

	public Vorlesungen(){
	}

	public void loadVorlesungen(ComponentSystemEvent event) {
	}

	private static final Logger logger = Logger.getLogger(Vorlesungen.class);

	public List<VorlesungHibernate> getAllLectures() {
		logger.info("Lade alle Vorlesungen");
		VorlesungService service = new VorlesungService();
		return service.loadVorlesung();
	}

	public void setAllLectures() {
		// mach nix
	}
}
