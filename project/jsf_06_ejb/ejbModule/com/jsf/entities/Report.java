package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Date;

/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_report", unique = true, nullable = false)
	private Integer idReport;

	@Lob
	private String comment;

	private Double cost;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_repair")
	private Date dateOfRepair;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_report")
	private Date dateOfReport;

	@Lob
	private String description;

	private String model;

	private String name;

	private String phone;

	private String surname;

	//bi-directional many-to-one association to DeviceType
	@ManyToOne
	@JoinColumn(name="id_device")
	private DeviceType deviceType;

	//bi-directional many-to-one association to RepairType
	@ManyToOne
	@JoinColumn(name="id_repair")
	private RepairType repairType;

	//bi-directional many-to-one association to StatusType
	@ManyToOne
	@JoinColumn(name="id_status")
	private StatusType statusType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Report() {
	}

	public Integer getIdReport() {
		return this.idReport;
	}

	public void setIdReport(Integer idReport) {
		this.idReport = idReport;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getDateOfRepair() {
		return this.dateOfRepair;
	}

	public void setDateOfRepair(Date dateOfRepair) {
		this.dateOfRepair = dateOfRepair;
	}

	public Date getDateOfReport() {
		return this.dateOfReport;
	}

	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public DeviceType getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public RepairType getRepairType() {
		return this.repairType;
	}

	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}

	public StatusType getStatusType() {
		return this.statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}