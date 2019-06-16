package cafe.dao;

import java.util.ArrayList;

import cafe.bean.loaiBangGia;

public interface loaiBangGiaDao {
	public ArrayList<loaiBangGia> get();
	public ArrayList<loaiBangGia> get(String maBG);
	public String add(loaiBangGia loaiBangGia);
	public String update(loaiBangGia loaiBangGia);
	public String delete(String maBG);
	public String getLast();
	public boolean isMaBG(String maBG);
}
