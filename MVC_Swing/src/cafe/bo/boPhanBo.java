package cafe.bo;

import java.util.ArrayList;

import cafe.bean.boPhan;

public interface boPhanBo {
	public ArrayList<boPhan> get();
	public ArrayList<boPhan> get(String maBP);
	public String add(boPhan boPhan);
	public String update(boPhan boPhan);
	public String delete(String maBP);
	public boolean isMaBP(String maBP);
	public boolean isMaCha(String maCha);
	public String deleteByMaCha(String maCha);
}
