package cafe.dao;

import java.util.ArrayList;

import cafe.bean.nhanVien;

public interface nhanVienDao {
	public ArrayList<nhanVien> get();
	public ArrayList<nhanVien> get(String maNV);
	public String add(nhanVien nhanVien);
	public String update(nhanVien nhanVien);
	public String delete(String maNV);
	public String getLast();
	public boolean isMaNV(String maNV);
}
