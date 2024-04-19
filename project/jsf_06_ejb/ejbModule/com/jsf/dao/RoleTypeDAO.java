package com.jsf.dao;
import java.util.List;
import java.util.Map;
import com.jsf.entities.RoleType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class RoleTypeDAO {
	private final static String UNIT_NAME = "jsfcourse-skPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(RoleType roletype) {
		em.persist(roletype);
	}

	public RoleType merge(RoleType roletype) {
		return em.merge(roletype);
	}

	public void remove(RoleType roletype) {
		em.remove(em.merge(roletype));
	}

	public RoleType find(Object id) {
		return em.find(RoleType.class, id);
	}
}

	