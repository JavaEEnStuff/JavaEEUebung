package javaee.dev;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class Vorlesung {

	private String bezeichnung;
	private String dozent;
	private Integer teilnehmerzahl;
	private boolean anmeldepflichtig;
	private boolean ws;
	private Integer jahr;

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
