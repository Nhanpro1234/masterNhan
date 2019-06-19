package cafe.bo;

import java.util.List;

import cafe.bean.loaiBangGia;
import cafe.dao.loaiBangGiaDao;
import cafe.dao.loaiBangGiaDaoJDBC;

public class loaiBangGiaBoJDBC implements loaiBangGiaBo {

	private loaiBangGiaDao loaiBangGiaDao;
	
	public loaiBangGiaBoJDBC() {
		loaiBangGiaDao = new loaiBangGiaDaoJDBC();
	}
	
	@Override
	public List<loaiBangGia> get() {
		return loaiBangGiaDao.get();
	}

	@Override
	public List<loaiBangGia> get(String maBG) {
		return loaiBangGiaDao.get(maBG);
	}

	@Override
	public String add(loaiBangGia loaiBangGia) {
		return loaiBangGiaDao.add(loaiBangGia);
	}

	@Override
	public String update(loaiBangGia loaiBangGia) {
		return loaiBangGiaDao.update(loaiBangGia);
	}

	@Override
	public String delete(String maBG) {
		return loaiBangGiaDao.delete(maBG);
	}

	@Override
	public String getLast() {
		return loaiBangGiaDao.getLast();
	}

	@Override
	public boolean isMaBG(String maBG) {
		return loaiBangGiaDao.isMaBG(maBG);
	}

}
