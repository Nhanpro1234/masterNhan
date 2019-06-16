package cafe.dao;

import java.util.ArrayList;

import cafe.bean.khuVuc;
import cafe.bean.sanPhongBan;

public interface khuVucDao {
	public ArrayList<khuVuc> getByAll();
	public ArrayList<khuVuc> getByMaKV(String data);
	public boolean add(khuVuc khuVuc);
	public String update(String maKV, String tenKV);
	public String delete(String maKV);
	public String getByLast();
	public boolean isMaKV(String maKV);
}