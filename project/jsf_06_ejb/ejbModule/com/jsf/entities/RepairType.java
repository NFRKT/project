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
 * The persistent class for the repair_type database table.
 * 
 */
@Entity
@Table(name="repair_type")
@NamedQuery(name="RepairType.findAll", query="SELECT r FROM RepairType r")
public class RepairType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_repair")
	private Integer idRepair;

	private String name;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="repairType")
	private List<Report> reports;

	public RepairType() {
	}

	public int getIdRepair() {
		return this.idRepair;
	}

	public void setIdRepair(int idRepair) {
		this.idRepair = idRepair;
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
		report.setRepairType(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setRepairType(null);

		return report;
	}

}