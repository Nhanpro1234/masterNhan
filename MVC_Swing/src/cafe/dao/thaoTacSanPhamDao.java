package cafe.dao;

import java.util.*;

import cafe.bean.thaoTacSanPham;

public interface thaoTacSanPhamDao {
	public List<thaoTacSanPham> get();
	public List<thaoTacSanPham> get(String maNhom);
	public List<thaoTacSanPham> getByMaSP(String masP);
	public boolean checSPvsBG(String maSP, String maBG);
	public String addBangGia(String maSP, String maBG);
}
