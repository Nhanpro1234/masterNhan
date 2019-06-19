package cafe.bo;

import java.util.List;

import cafe.bean.sanPham;

public interface sanPhamBo {
	public List<sanPham> get();
	public List<sanPham> get(String maSP);
	public String add(sanPham data);
	public String update(sanPham data);
	public String delete(String maSP);
}
