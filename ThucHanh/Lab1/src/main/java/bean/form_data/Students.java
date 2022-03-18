package bean.form_data;

public class Students {
	private String maSv;
	private String hoTen;
	private int gioiTinh;
	private int chuyenNganh;
	private String sdt;
	private String email;
	private String thoiGian;
	public Students() {
		super();
	}
	public Students(String maSv, String hoTen, int gioiTinh, int chuyenNganh, String sdt, String email,
			String thoiGian) {
		super();
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.chuyenNganh = chuyenNganh;
		this.sdt = sdt;
		this.email = email;
		this.thoiGian = thoiGian;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(int chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	
}
