package cafe.dao;

import java.util.List;

import cafe.bean.bangGia;;

public interface bangGiaDao {
	public List<bangGia> get();
	public List<bangGia> get(int id);
	public String add(bangGia data);
	public String update(bangGia data);
	public String delete(int id);
	public String deleteByMaSP(String maSP);
}
