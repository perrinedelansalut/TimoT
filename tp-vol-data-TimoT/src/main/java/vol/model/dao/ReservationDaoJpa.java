package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.model.Escale;
import vol.model.EscaleId;
import vol.model.Reservation;

@Repository
@Transactional
public class ReservationDaoJpa implements ReservationDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public Reservation find(Integer id) {
		return em.find(Reservation.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Reservation> findAll() {
		Query query = em.createQuery("select c from Reservation c");
		return query.getResultList();
	}

	@Override
	public void create(Reservation obj) {
		em.persist(obj);
	}

	@Override
	public Reservation update(Reservation obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Reservation obj) {
		em.remove(em.merge(obj));
}
	
}