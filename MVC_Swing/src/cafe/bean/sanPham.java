package cafe.bean;

import java.util.Comparator;

public class sanPham implements Comparator<sanPham> {
	private String maSP;
	private String maNhom;
	private String tenSP;
	private String maDVT;
	private float SLDK;
	private float GTDK;
	private int isMenu;
	public sanPham() {
		super();
	}
	public sanPham(String maSP, String maNhom, String tenSP, String maDVT, float sLDK, float gTDK, int isMenu) {
		super();
		this.maSP = maSP;
		this.maNhom = maNhom;
		this.tenSP = tenSP;
		this.maDVT = maDVT;
		SLDK = sLDK;
		GTDK = gTDK;
		this.isMenu = isMenu;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}
	public float getSLDK() {
		return SLDK;
	}
	public void setSLDK(float sLDK) {
		SLDK = sLDK;
	}
	public float getGTDK() {
		return GTDK;
	}
	public void setGTDK(float gTDK) {
		GTDK = gTDK;
	}
	public int getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}
	@Override
	public String toString() {
		return "sanPham [maSP=" + maSP + ", maNhom=" + maNhom + ", tenSP=" + tenSP + ", maDVT=" + maDVT + ", SLDK="
				+ SLDK + ", GTDK=" + GTDK + ", isMenu=" + isMenu + "]";
	}
	@Override
	public int compare(sanPham o1, sanPham o2) {
		String[] a = o1.getMaSP().split("_");
		String[] b = o2.getMaSP().split("_");
		Integer c = Integer.parseInt(a[1]);
		Integer d = Integer.parseInt(b[1]);
		if(c > d) {
			return 1;
		}else if(c < d) {
			return -1;
		}else {
			return 0;
		}
	}	
}
