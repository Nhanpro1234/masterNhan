package cafe.dao;

import java.util.List;

import cafe.bean.loaiBangGia;

public interface loaiBangGiaDao {
	public List<loaiBangGia> get();
	public List<loaiBangGia> get(String maBG);
	public String add(loaiBangGia loaiBangGia);
	public String update(loaiBangGia loaiBangGia);
	public String delete(String maBG);
	public String getLast();
	public boolean isMaBG(String maBG);
}
