package com.jsf.dao;
import java.util.List;
import java.util.Map;
import com.jsf.entities.DeviceType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class DeviceTypeDAO {
	private final static String UNIT_NAME = "jsfcourse-skPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(DeviceType devicetype) {
		em.persist(devicetype);
	}

	public DeviceType merge(DeviceType devicetype) {
		return em.merge(devicetype);
	}

	public void remove(DeviceType devicetype) {
		em.remove(em.merge(devicetype));
	}

	public DeviceType find(Object id) {
		return em.find(DeviceType.class, id);
	}
}

	