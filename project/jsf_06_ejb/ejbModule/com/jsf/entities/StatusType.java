package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the status_type database table.
 * 
 */
@Entity
@Table(name="status_type")
@NamedQuery(name="StatusType.findAll", query="SELECT s FROM StatusType s")
public class StatusType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_status")
	private Integer idStatus;

	private String name;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="statusType")
	private List<Report> reports;

	public StatusType() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setStatusType(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setStatusType(null);

		return report;
	}

}