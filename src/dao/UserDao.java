package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.User;

public class UserDao {

	private EntityManagerFactory entityManagerFactory;

	public void create(User s) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
	}

	public List<User> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<User> users= em.createQuery("select s from User s", User.class).getResultList();

		return users;
	}

	public User findi(String id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		User s = em.find(User.class, id);
		
		return s;
	}
	
	public User find(String str) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		User u = em.createQuery("select s from User s where s.email= :name", User.class).setParameter("name", str).getSingleResult();
		
		return u;
	}
	public void update(User s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(s);
		
		em.getTransaction().commit();
		
	}
	
	public void delete(User s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(s);
		
		em.getTransaction().commit();
	}
}
