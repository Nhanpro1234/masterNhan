package cafe.bean;

public enum loaiNhomHang {
	Hàng_hóa(1),Nguyên_liệu(2), Sản_phẩm_chế(3), Dịch_vụ_tính_theo_giờ(4);
	
	private int loaiNhom;

	public int getLoaiNhom() {
		return loaiNhom;
	}

	public void setLoaiNhom(int loaiNhom) {
		this.loaiNhom = loaiNhom;
	}

	private loaiNhomHang(int loaiNhom) {
		this.loaiNhom = loaiNhom;
	}
	
}
