package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("ASM_JAVA4");  //nạp persistence.xml và tạo EntityManagerFactory
		
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em =JpaUtil.getFactory().createEntityManager();  //tạo EntityManagerFactory cb truy vấn csdl
		
		return em;
	}
	
	
	
}
