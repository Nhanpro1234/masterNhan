package cafe.bo;

import java.util.ArrayList;

import cafe.bean.khuVuc;

public interface khuVucBo {
	public ArrayList<khuVuc> getByAll();
	public ArrayList<khuVuc> getByMaKV(String data);
	public boolean add(khuVuc khuVuc);
	public String update(String maKV, String tenKV);
	public String delete(String maKV);
	public String getByLast();
	public boolean isMaKV(String maKV);
}
