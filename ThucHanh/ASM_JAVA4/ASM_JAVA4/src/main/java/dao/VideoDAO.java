package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.websocket.Session;

import entities.Video;
import utils.JpaUtil;

public class VideoDAO {
	private EntityManager em;
	public VideoDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	public Video create(Video entity) throws Exception {
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
	public List<Video> all() {
		String jpql = "SELECT obj FROM Video obj";
		TypedQuery<Video> query = this.em.createQuery(jpql, Video.class);
		return query.getResultList();

	}

	public void delete(Video entity) throws Exception {
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
	public void update(Video entity) throws Exception {
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
	public Video findById(int id) {
		return this.em.find(Video.class, id);
	}

}
