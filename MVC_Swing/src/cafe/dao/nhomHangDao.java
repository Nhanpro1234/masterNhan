package cafe.dao;

import java.util.ArrayList;

import cafe.bean.nhomHang;


public interface nhomHangDao {
	public ArrayList<nhomHang> get();
	public ArrayList<nhomHang> get(String maNH);
	public String add(nhomHang nhomHang);
	public String update(nhomHang nhomHang);
	public String delete(String maNH);
	public boolean isMaNH(String maNH);
	public boolean isMaCha(String maCha);
	public String deleteByMaCha(String maCha);
}
