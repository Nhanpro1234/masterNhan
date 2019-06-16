package cafe.dao;

import java.util.ArrayList;

import cafe.bean.taiKhoan;

public interface taiKhoanDao {
	public ArrayList<taiKhoan> get();
	public ArrayList<taiKhoan> get(String taiKhoan);
	public String add(taiKhoan taiKhoan);
	public String update(taiKhoan taiKhoan);
	public String delete(String taiKhoan);
	public boolean isTaiKhoan(String taiKhoan);
	public boolean isDangNhap(String taiKhoan, String matKhau);
}
