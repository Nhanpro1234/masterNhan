package cafe.bo;

import java.util.List;

import cafe.bean.sanPham;
import cafe.dao.sanPhamDaoJDBC;

public class sanPhamBoJDBC implements sanPhamBo {
	
	private sanPhamDaoJDBC sanPhamDao;

	public sanPhamBoJDBC() {
		sanPhamDao = new sanPhamDaoJDBC();
	}
	
	@Override
	public List<sanPham> get() {
		// TODO Auto-generated method stub
		return sanPhamDao.get();
	}

	@Override
	public List<sanPham> get(String maSP) {
		// TODO Auto-generated method stub
		return sanPhamDao.get(maSP);
	}

	@Override
	public String add(sanPham data) {
		// TODO Auto-generated method stub
		return sanPhamDao.add(data);
	}

	@Override
	public String update(sanPham data) {
		// TODO Auto-generated method stub
		return sanPhamDao.update(data);
	}

	@Override
	public String delete(String maSP) {
		// TODO Auto-generated method stub
		return sanPhamDao.delete(maSP);
	}

}
