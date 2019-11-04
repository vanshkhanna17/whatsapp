package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Group;
import model.User;

public class GroupDao {
	
	private EntityManagerFactory entityManagerFactory;

	public void create(Group s) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
	}

	public List<Group> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<Group> groups= em.createQuery("select s from Group s", Group.class).getResultList();

		return groups;
	}

//	public User find(String id) {
//		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();
//
//		EntityManager em = entityManagerFactory.createEntityManager();
//		
//		User s = em.find(User.class, id);
//		
//		return s;
//	}
	
	public Group find(String str) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Group g = em.createQuery("select s from Group s where s.gname= :name", Group.class).setParameter("name", str).getSingleResult();
		
		return g;
	}
	public void update(Group s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(s);
		
		em.getTransaction().commit();
		
	}
	
	public void delete(Group s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(s);
		
		em.getTransaction().commit();
	}
}

