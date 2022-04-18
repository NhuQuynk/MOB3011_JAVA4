package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManagerFactory getFactory() { // Tạo ra đối tượng factory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DEMO");
		return factory;
	}

	public static EntityManager getEntityManager() {
		EntityManager em = JpaUtil.getFactory().createEntityManager();
		return em;
	}
}
