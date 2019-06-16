package cafe.bo;

import java.util.List;

import cafe.bean.donViTinh;
import cafe.dao.donViTinhDao;
import cafe.dao.donViTinhDaoJDBC;

public class donViTinhBoJDBC implements donViTinhBo {

	private donViTinhDao donViTinhDao;
	
	public donViTinhBoJDBC() {
		donViTinhDao = new donViTinhDaoJDBC();
	}
	
	@Override
	public List<donViTinh> get() {
		return donViTinhDao.get();
	}

	@Override
	public List<donViTinh> get(String maDVT) {
		return donViTinhDao.get(maDVT);
	}

	@Override
	public boolean isMaDVT(String maDVT) {
		return donViTinhDao.isMaDVT(maDVT);
	}

	@Override
	public String add(donViTinh donViTinh) {
		return donViTinhDao.add(donViTinh);
	}

	@Override
	public String update(donViTinh donViTinh) {
		return donViTinhDao.update(donViTinh);
	}

	@Override
	public String delete(String maDVT) {
		return donViTinhDao.delete(maDVT);
	}

}
