package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.User;
import utils.JpaUtil;

public class UserDAO {
	private EntityManager em;

	public UserDAO() {
		this.em = JpaUtil.getEntityManager();
	}

	public User create(User entity) throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ THÊM MỚI DỮ LIỆU VÀO DB
			this.em.persist(entity);
			this.em.flush();
			// Kết thúc transaction
			this.em.getTransaction().commit();
			// commit thành công return entity

			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			// commit thất bại trả về null
			throw e;
		}
	}
	public List<User> all() {
		String jpql = "SELECT obj FROM User obj";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		return query.getResultList();

	}
	public void delete(User entity) throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ xoa DỮ LIỆU VÀO DB
			this.em.remove(entity);
			// Kết thúc transaction
			this.em.getTransaction().commit();
			// commit thành công return entity
			System.out.println(entity);

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;

		}
	}

	public void update(User entity) throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ xoa DỮ LIỆU VÀO DB
			this.em.merge(entity);
			// Kết thúc transaction
			this.em.getTransaction().commit();
			// commit thành công return entity
			System.out.println(entity);

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;

		}
	}

	
	public User findById(int id) {
		
		return this.em.find(User.class, id);
		
	}
	
	
	public User findByEmail(String email) {
		String jpql = "SELECT obj FROM User obj"
				+ " WHERE obj.email = :email";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
}
