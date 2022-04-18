package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.User;
import utils.JpaUtil;

public class UserDAO {
	private EntityManager em ;
	public UserDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	public User create(User entity) throws Exception {
		try {
//			Bắt đầu transaction
			this.em.getTransaction().begin(); //transaction lấy ra hàm truy vấn
//			Thêm mới đối tượng
			this.em.persist(entity);
			this.em.flush();  // đồng bộ dữ liệu các object của jpa 
//			kết thúc transaction
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}
	public List<User> all(){
		String jpql = "SELECT obj FROM User obj";    //User ở entities
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		//query.getResultList();  //Lấy ra danh sách kết quả
		//query.getSingleResult();  //Lấy ra 1 bản ghi
		return query.getResultList();
	}
//	Xóa
	public void delete(User entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);    //this.em.merge: update
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();;
		}
	}
	
	public void update(User entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity)  ;  //this.em.merge: update
			this.em.getTransaction().commit();
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
				+ " WHERE email = :email";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
}
