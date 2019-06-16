package cafe.bean;

import java.util.Comparator;

public class donViTinh implements Comparator<donViTinh> {
	private String maDVT;
	private String tenDVT;
	private int macDinh;
	public donViTinh() {
		super();
	}
	public donViTinh(String maDVT, String tenDVT, int macDinh) {
		super();
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
		this.macDinh = macDinh;
	}
	public String getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}
	public int getMacDinh() {
		return macDinh;
	}
	public void setMacDinh(int macDinh) {
		this.macDinh = macDinh;
	}
	public String getTenDVT() {
		return tenDVT;
	}
	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}
	@Override
	public String toString() {
		return "donViTinh [maDVT=" + maDVT + ", macDinh=" + macDinh + "]";
	}
	@Override
	public int compare(donViTinh o1, donViTinh o2) {
		if(o1.getMacDinh() > o2.getMacDinh()) {
			return -1;
		}else if(o1.getMacDinh() < o2.getMacDinh()) {
			return 1;
		}else {
			return 0;
		}
	}
}
