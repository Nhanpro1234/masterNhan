package cafe.bo;

import java.util.ArrayList;
import java.util.List;

import cafe.bean.nhanVien;
import cafe.dao.nhanVienDao;
import cafe.dao.nhanVienDaoJDBC;

public class nhanVienBoJDBC implements nhanVienBo {
	private nhanVienDao nhanVienDao;
	
	public nhanVienBoJDBC() {
		nhanVienDao = new nhanVienDaoJDBC();
	}
	
	@Override
	public ArrayList<nhanVien> get() {
		return nhanVienDao.get();
	}

	@Override
	public ArrayList<nhanVien> get(String maNV) {
		return nhanVienDao.get(maNV);
	}

	@Override
	public String add(nhanVien nhanVien) {
		return nhanVienDao.add(nhanVien);
	}

	@Override
	public String update(nhanVien nhanVien) {
		return nhanVienDao.update(nhanVien);
	}

	@Override
	public String delete(String maNV) {
		return nhanVienDao.delete(maNV);
	}

	@Override
	public String getLast() {
		return nhanVienDao.getLast();
	}

	@Override
	public boolean isMaNV(String maNV) {
		return nhanVienDao.isMaNV(maNV);
	}

	
}
