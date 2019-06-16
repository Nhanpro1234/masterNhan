package cafe.bo;

import java.util.List;

import cafe.bean.sanPhongBan;

public interface sanPhongBanBo {
	public List<sanPhongBan> get();
	public List<sanPhongBan> get(String soBan);
	public String add(sanPhongBan data);
	public String update(sanPhongBan data);
	public String delete(String soBan);
	public boolean isBan(String soBan);
	public String getLast();
}
