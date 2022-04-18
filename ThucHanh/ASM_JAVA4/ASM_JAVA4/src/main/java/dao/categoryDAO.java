package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Category;
import utils.JpaUtil;

public class categoryDAO {
	private EntityManager em;

	public categoryDAO() {
		this.em = JpaUtil.getEntityManager();
	}

	public Category create(Category entity)throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ THÊM MỚI DỮ LIỆU VÀO DB
			this.em.persist(entity);
			this.em.flush();
            //Kết thúc transaction
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
	public List<Category> all() {
		String jpql = "SELECT obj FROM Category obj";
		TypedQuery<Category> query= this.em.createQuery(jpql,Category.class);
		return query.getResultList();
		
	}
	public void delete(Category entity)throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ xoa DỮ LIỆU VÀO DB
			this.em.remove(entity);
            //Kết thúc transaction
			this.em.getTransaction().commit();
			// commit thành công return entity
			System.out.println(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
			
		}
	}
	public void update(Category entity)throws Exception {
		try {
			// Bắt đầu transation
			this.em.getTransaction().begin();
			// GỌI HÀM PERSIST ĐỂ xoa DỮ LIỆU VÀO DB
			this.em.merge(entity);
            //Kết thúc transaction
			this.em.getTransaction().commit();
			// commit thành công return entity
			System.out.println(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
			
		}
	}
	public Category findById(int id) {
		return this.em.find(Category.class,id);
	}
	public List<Category> allIDtoTen(int id){
		
		String jpql = "SELECT obj FROM Category obj WHERE obj.id ="+id;
		TypedQuery<Category> query = this.em.createQuery(jpql,Category.class);
		return query.getResultList();
		
	}

}
