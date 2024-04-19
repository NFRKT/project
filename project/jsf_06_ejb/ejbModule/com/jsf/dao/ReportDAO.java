package com.jsf.dao;
import java.util.List;
import java.util.Map;
import com.jsf.entities.Report;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class ReportDAO {
	private final static String UNIT_NAME = "jsfcourse-skPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(Report report) {
		em.persist(report);
	}

	public Report merge(Report report) {
		return em.merge(report);
	}

	public void remove(Report report) {
		em.remove(em.merge(report));
	}

	public Report find(Object id) {
		return em.find(Report.class, id);
	}

	public List<Report> getFullList() {
		
		List<Report> list = null;
		
		
		Query query = em.createQuery("select r from Report r");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Report> getList(Map<String, Object> searchParams) {
		List<Report> list = null;

		// 1. Build query string with parameters
		String select = "select r ";
		String from = "from Report r ";
		String where = "";
		String orderby = "order by r.surname asc";

		// search for surname
		String surname = (String) searchParams.get("surname");
		if (surname != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "r.surname like :surname ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (surname != null) {
			query.setParameter("surname", surname+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of report objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return list;
	}
}
