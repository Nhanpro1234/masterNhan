package cafe.bo;

import java.util.List;

import cafe.bean.bangGia;
import cafe.dao.bangGiaDaoJDBC;

public class bangGiaBoJDBC implements bangGiaBo {

	private bangGiaDaoJDBC bangGiaDao;
	
	public bangGiaBoJDBC() {
		bangGiaDao = new bangGiaDaoJDBC();
	}
	
	@Override
	public List<bangGia> get() {
		// TODO Auto-generated method stub
		return bangGiaDao.get();
	}

	@Override
	public List<bangGia> get(int id) {
		// TODO Auto-generated method stub
		return bangGiaDao.get(id);
	}

	@Override
	public String add(bangGia data) {
		// TODO Auto-generated method stub
		return bangGiaDao.add(data);
	}

	@Override
	public String update(bangGia data) {
		// TODO Auto-generated method stub
		return bangGiaDao.update(data);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return bangGiaDao.delete(id);
	}

	@Override
	public String deleteByMaSP(String maSP) {
		// TODO Auto-generated method stub
		return bangGiaDao.deleteByMaSP(maSP);
	}

}
