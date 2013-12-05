package javaee.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vorlesung")
public class VorlesungHibernate {

	public VorlesungHibernate() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String lecturer;
	private Integer members;
	private boolean registrationRequired;
	private boolean hoursPerWeek;
	private Integer year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}

	public boolean isRegistrationRequired() {
		return registrationRequired;
	}

	public void setRegistrationRequired(boolean registrationRequired) {
		this.registrationRequired = registrationRequired;
	}

	public boolean isHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(boolean hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "VorlesungHibernate [id=" + id + ", lecturer=" + lecturer
				+ ", members=" + members + ", registrationRequired="
				+ registrationRequired + ", hoursPerWeek=" + hoursPerWeek
				+ ", year=" + year + "]";
	}

}
