package cafe.bo;

import java.util.ArrayList;

import cafe.bean.nhomHang;
import cafe.dao.nhomHangDaoJDBC;
import cafe.dao.nhomHangDao;

public class nhomHangBoJDBC implements nhomHangBo {
	
	private nhomHangDao nhomHangDao;
	
	public nhomHangBoJDBC() {
		nhomHangDao = new nhomHangDaoJDBC();
	}

	@Override
	public ArrayList<nhomHang> get() {
		// TODO Auto-generated method stub
		return nhomHangDao.get();
	}

	@Override
	public ArrayList<nhomHang> get(String maNH) {
		// TODO Auto-generated method stub
		return nhomHangDao.get(maNH);
	}

	@Override
	public String add(nhomHang nhomHang) {
		// TODO Auto-generated method stub
		return nhomHangDao.add(nhomHang);
	}

	@Override
	public String update(nhomHang nhomHang) {
		// TODO Auto-generated method stub
		return nhomHangDao.update(nhomHang);
	}

	@Override
	public String delete(String maNH) {
		// TODO Auto-generated method stub
		return nhomHangDao.delete(maNH);
	}

	@Override
	public boolean isMaNH(String maNH) {
		// TODO Auto-generated method stub
		return nhomHangDao.isMaNH(maNH);
	}

	@Override
	public String deleteByMaCha(String maCha) {
		// TODO Auto-generated method stub
		return nhomHangDao.deleteByMaCha(maCha);
	}

}
