package cafe.bo;

import java.util.ArrayList;

import cafe.bean.khuVuc;
import cafe.dao.khuVucDao;
import cafe.dao.khuVucDaoJDBC;

public class khuVucBoJDBC implements khuVucBo {

	private khuVucDao khuVucDao;
	
	public khuVucBoJDBC() {
		khuVucDao = new khuVucDaoJDBC();
	}
	
	@Override
	public ArrayList<khuVuc> getByAll() {
		return khuVucDao.getByAll();
	}

	@Override
	public ArrayList<khuVuc> getByMaKV(String data) {
		return khuVucDao.getByMaKV(data);
	}

	@Override
	public String update(String maKV, String tenKV) {
		return khuVucDao.update(maKV, tenKV);
	}

	@Override
	public String delete(String maKV) {
		return khuVucDao.delete(maKV);
	}

	@Override
	public String getByLast() {
		return khuVucDao.getByLast();
	}

	@Override
	public boolean isMaKV(String maKV) {
		return khuVucDao.isMaKV(maKV);
	}

	@Override
	public boolean add(khuVuc khuVuc) {
		return khuVucDao.add(khuVuc);
	}
}
