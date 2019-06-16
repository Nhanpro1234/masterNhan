package cafe.bean;

public class taiKhoan {
	private String taiKhoan;
	private String matKhau;
	private String maNV;
	public taiKhoan() {
		super();
	}
	public taiKhoan(String taiKhoan, String matKhau, String maNV) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	@Override
	public String toString() {
		return "taiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", maNV=" + maNV + "]";
	}
}
