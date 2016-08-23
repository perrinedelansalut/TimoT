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
import vol.model.Passager;

@Repository
@Transactional
public class PassagerDaoJpa implements PassagerDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public Passager find(Integer id) {
		return em.find(Passager.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Passager> findAll() {
		Query query = em.createQuery("select c from Passager c");
		return query.getResultList();
	}

	@Override
	public void create(Passager obj) {
		em.persist(obj);
	}

	@Override
	public Passager update(Passager obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Passager obj) {
		em.remove(em.merge(obj));
}
	
}