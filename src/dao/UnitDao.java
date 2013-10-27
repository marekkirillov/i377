package dao;


import java.util.List;

import javax.persistence.*;

import util.JpaUtil;
import main.Unit;

public class UnitDao {

	public void save(Unit unit) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();
			if (unit.getId() == null) {
				em.persist(unit);
				
			} else {
				em.merge(unit);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public Unit findById(Long id) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			return em.find(Unit.class, id);
		} finally {
			em.close();
		}
	}

	public List<Unit> getAllUnits() {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			
			TypedQuery<Unit> query = em.createQuery("select u from Unit u ",
					Unit.class);
			
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<Unit> searchUnits(String partialName) {
		partialName = "%" + partialName + "%";
		partialName = partialName.toUpperCase();
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			TypedQuery<Unit> query = em.createQuery(
					"select u from Unit u where UPPER(u.name) like :name",
					Unit.class);
			query.setParameter("name", partialName);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void removeUnit(Integer unitId) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();
			Unit unit = em.find(Unit.class, 1L);
			if (unit != null)
				em.remove(unit);
			em.getTransaction().commit();

		} finally {
			em.close();
		}
	}

	public void removeAllEntries() {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();

			Query query = em
					.createNativeQuery("TRUNCATE SCHEMA public AND COMMIT");
			query.executeUpdate();
			em.getTransaction().commit();

		} finally {
			em.close();
		}
	}

}