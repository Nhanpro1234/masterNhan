package cafe.bo;

import java.util.ArrayList;

import cafe.bean.taiKhoan;
import cafe.dao.taiKhoanDaoJDBC;

public class taiKhoanBoJDBC implements taiKhoanBo {
	private cafe.dao.taiKhoanDao taiKhoanDao;
	
	public taiKhoanBoJDBC() {
		taiKhoanDao = new taiKhoanDaoJDBC();
	}

	@Override
	public ArrayList<taiKhoan> get() {
		return taiKhoanDao.get();
	}

	@Override
	public ArrayList<taiKhoan> get(String taiKhoan) {
		return taiKhoanDao.get(taiKhoan);
	}

	@Override
	public String add(taiKhoan taiKhoan) {
		return taiKhoanDao.add(taiKhoan);
	}

	@Override
	public String update(taiKhoan taiKhoan) {
		return taiKhoanDao.update(taiKhoan);
	}

	@Override
	public String delete(String taiKhoan) {
		return taiKhoanDao.delete(taiKhoan);
	}

	@Override
	public boolean isTaiKhoan(String taiKhoan) {
		return taiKhoanDao.isTaiKhoan(taiKhoan);
	}

	@Override
	public boolean isDangNhap(String taiKhoan, String matKhau) {
		return taiKhoanDao.isDangNhap(taiKhoan, matKhau);
	}

}
