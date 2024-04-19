package com.jsf.dao;
import java.util.List;
import java.util.Map;
import com.jsf.entities.RepairType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class RepairTypeDAO {
	private final static String UNIT_NAME = "jsfcourse-skPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(RepairType repairtype) {
		em.persist(repairtype);
	}

	public RepairType merge(RepairType repairtype) {
		return em.merge(repairtype);
	}

	public void remove(RepairType repairtype) {
		em.remove(em.merge(repairtype));
	}

	public RepairType find(Object id) {
		return em.find(RepairType.class, id);
	}
}

	