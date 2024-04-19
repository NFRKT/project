package com.jsf.dao;
import java.util.List;
import java.util.Map;
import com.jsf.entities.StatusType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class StatusTypeDAO {
	private final static String UNIT_NAME = "jsfcourse-skPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(StatusType statustype) {
		em.persist(statustype);
	}

	public StatusType merge(StatusType statustype) {
		return em.merge(statustype);
	}

	public void remove(StatusType statustype) {
		em.remove(em.merge(statustype));
	}

	public StatusType find(Object id) {
		return em.find(StatusType.class, id);
	}
}

	