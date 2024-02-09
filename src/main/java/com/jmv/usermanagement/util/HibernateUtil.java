package com.jmv.usermanagement.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * JPA based configuration
 */
public class HibernateUtil {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");

				return entityManagerFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entityManagerFactory;
	}
}
