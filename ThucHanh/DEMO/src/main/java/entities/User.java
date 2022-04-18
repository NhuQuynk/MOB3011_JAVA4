package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String hoTen;
	
	private String diaChi;
	
	private String sdt;

	private String email;

	private String password;

	@OneToMany(mappedBy = "user") // user đc khai báo ở Category entities
	private List<Category> categories ;


	public User() {
	}
	
	


	public User(int id, String hoTen, String diaChi, String sdt, String email, String password) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.password = password;
	}




	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}




	public List<Category> getCategories() {
		return categories;
	}




	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}