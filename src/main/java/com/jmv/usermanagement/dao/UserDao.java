package com.jmv.usermanagement.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import com.jmv.usermanagement.model.User;
import com.jmv.usermanagement.util.HibernateUtil;

/**
 * CRUD database operations
 * @author Kayumba JMV
 */
public class UserDao {

	/**
	 * Save User
	 * @param user
	 */
	public void saveUser(User user) {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * Update User
	 * @param user
	 */
	public void updateUser(User user) {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * Delete User
	 * @param id
	 */
	public void deleteUser(int id) {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();

			User user = em.find(User.class, id);
			if (user != null) {
				em.remove(user);
				System.out.println("User is deleted");
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * Get User By ID
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = null;
		User user = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			user = em.find(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return user;
	}

	/**
	 * Get all Users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = null;
		List<User> listOfUser = null;

		try {
			transaction = em.getTransaction();
			transaction.begin();
			listOfUser = em.createQuery("FROM User").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return listOfUser;
	}
}
