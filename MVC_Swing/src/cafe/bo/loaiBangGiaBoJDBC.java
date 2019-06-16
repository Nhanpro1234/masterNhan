package cafe.bo;

import java.util.ArrayList;

import cafe.bean.loaiBangGia;
import cafe.dao.loaiBangGiaDaoJDBC;
import cafe.dao.loaiBangGiaDao;

public class loaiBangGiaBoJDBC implements loaiBangGiaBo {

	private loaiBangGiaDao loaiBangGiaDao;
	
	public loaiBangGiaBoJDBC() {
		loaiBangGiaDao = new loaiBangGiaDaoJDBC();
	}
	
	@Override
	public ArrayList<loaiBangGia> get() {
		return loaiBangGiaDao.get();
	}

	@Override
	public ArrayList<loaiBangGia> get(String maBG) {
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
