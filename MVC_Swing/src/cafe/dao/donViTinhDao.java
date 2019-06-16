package cafe.dao;

import java.util.List;

import cafe.bean.donViTinh;;

public interface donViTinhDao {
	public List<donViTinh> get();
	public List<donViTinh> get(String maDVT);
	public boolean isMaDVT(String maDVT);
	public String add(donViTinh donViTinh);
	public String update(donViTinh donViTinh);
	public String delete(String maDVT);
}
