package vol.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import vol.model.Aeroport;
import vol.model.AeroportVille;
import vol.model.Vol;

@Repository
@Transactional
public class AeroportVilleDaoJpa implements AeroportVilleDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public AeroportVille find(Long id) {
		return em.find(AeroportVille.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<AeroportVille> findAll() {
		Query query = em.createQuery("select c from AeroportVille c");
		return query.getResultList();
	}

	@Override
	public void create(AeroportVille obj) {
		em.persist(obj);
	}

	@Override
	public AeroportVille update(AeroportVille obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(AeroportVille obj) {
		em.remove(em.merge(obj));
}
	
}




