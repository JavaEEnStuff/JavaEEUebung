package java.ee.dev;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Vorlesung {

	private String bezeichnung;
	private String dozent;
	private Integer teilnehmerzahl;
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
}
