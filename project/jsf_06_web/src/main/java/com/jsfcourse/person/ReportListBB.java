package com.jsfcourse.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;

import com.jsf.dao.ReportDAO;
import com.jsf.entities.Report;

@Named
@RequestScoped
public class ReportListBB {
	private static final String PAGE_PERSON_EDIT = "reportEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String idReport;
	
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	ReportDAO reportDAO;
		
	public String getIdReport() {
		return idReport;
	}

	public void setIdReporte(String idReport) {
		this.idReport = idReport;
	}
	
	public List<Report> getFullList(){
		return reportDAO.getFullList();
	}

	public List<Report> getList(){
		List<Report> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (idReport != null && idReport.length() > 0){
			searchParams.put("idReport", idReport);
		}
		
		//2. Get list
		list = reportDAO.getList(searchParams,idReport);
		return list;
	}

	public String newReport(){
		Report report = new Report();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("report", report);
		
		//2. Pass object through flash	
		flash.put("report", report);
		
		return PAGE_PERSON_EDIT;
	}

	public String editReport(Report report){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("report", report);
		
		//2. Pass object through flash 
		flash.put("report", report);
		
		return PAGE_PERSON_EDIT;
	}

	public String deleteReport(Report report){
		reportDAO.remove(report);
		return PAGE_STAY_AT_THE_SAME;
	}
}
