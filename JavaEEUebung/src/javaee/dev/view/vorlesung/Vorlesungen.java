package javaee.dev.view.vorlesung;

import java.util.List;

import javaee.dev.service.VorlesungService;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class Vorlesungen {

	private List<Vorlesung> allLectures;

	public void loadVorlesungen(ComponentSystemEvent event) {
		logger.info("Lade alle Vorlesungen");
		VorlesungService service = new VorlesungService();
		allLectures = service.loadVorlesung();
	}

	private static final Logger logger = Logger.getLogger(Vorlesungen.class);

	public List<Vorlesung> getAllLectures() {
		return allLectures;
	}

	public void setAllLectures() {
		// mach nix
	}
}
