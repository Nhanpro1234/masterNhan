package cafe.bo;

import java.util.ArrayList;

import cafe.bean.boPhan;
import cafe.dao.boPhanDao;
import cafe.dao.boPhanDaoJDBC;

public class boPhanBoJDBC implements boPhanBo {
	
	private boPhanDao boPhanDao;
	
	public boPhanBoJDBC() {
		boPhanDao = new boPhanDaoJDBC();
	}

	@Override
	public ArrayList<boPhan> get() {
		// TODO Auto-generated method stub
		return boPhanDao.get();
	}

	@Override
	public ArrayList<boPhan> get(String maBP) {
		// TODO Auto-generated method stub
		return boPhanDao.get(maBP);
	}

	@Override
	public String add(boPhan boPhan) {
		// TODO Auto-generated method stub
		return boPhanDao.add(boPhan);
	}

	@Override
	public String update(boPhan boPhan) {
		// TODO Auto-generated method stub
		return boPhanDao.update(boPhan);
	}

	@Override
	public String delete(String maBP) {
		// TODO Auto-generated method stub
		return boPhanDao.delete(maBP);
	}

	@Override
	public boolean isMaBP(String maBP) {
		// TODO Auto-generated method stub
		return boPhanDao.isMaBP(maBP);
	}

	@Override
	public boolean isMaCha(String maCha) {
		// TODO Auto-generated method stub
		return boPhanDao.isMaCha(maCha);
	}

	@Override
	public String deleteByMaCha(String maCha) {
		// TODO Auto-generated method stub
		return boPhanDao.deleteByMaCha(maCha);
	}

}
