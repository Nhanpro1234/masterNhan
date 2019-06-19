package cafe.bo;

import java.util.List;

import cafe.bean.sanPhongBan;
import cafe.dao.sanPhongBanDao;
import cafe.dao.sanPhongBanDaoJDBC;

public class sanPhongBanBoJDBC implements sanPhongBanBo {

	private sanPhongBanDao sanPhongBanDao;
	
	public sanPhongBanBoJDBC() {
		sanPhongBanDao = new sanPhongBanDaoJDBC();
	}
	
	@Override
	public List<sanPhongBan> get() {
		return sanPhongBanDao.get();
	}

	@Override
	public String add(sanPhongBan data) {
		return sanPhongBanDao.add(data);
	}

	@Override
	public String update(sanPhongBan data) {
		return sanPhongBanDao.update(data);
	}

	@Override
	public String delete(String soBan) {
		return sanPhongBanDao.delete(soBan);
	}

	@Override
	public boolean isBan(String soBan) {
		return sanPhongBanDao.isBan(soBan);
	}

	@Override
	public String getLast() {
		return sanPhongBanDao.getLast();
	}

	@Override
	public List<sanPhongBan> get(String soBan) {
		return sanPhongBanDao.get(soBan);
	}

}
