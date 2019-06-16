package cafe.bean;

import java.util.Comparator;

public class loaiBangGia implements Comparator<loaiBangGia> {
	private String maBG;
	private String tenBG;
	private int macDinh;
	public loaiBangGia() {
		super();
	}
	public loaiBangGia(String maBG, String tenBG, int macDinh) {
		super();
		this.maBG = maBG;
		this.tenBG = tenBG;
		this.macDinh = macDinh;
	}
	public String getMaBG() {
		return maBG;
	}
	public void setMaBG(String maBG) {
		this.maBG = maBG;
	}
	public String getTenBG() {
		return tenBG;
	}
	public void setTenBG(String tenBG) {
		this.tenBG = tenBG;
	}
	public int getMacDinh() {
		return macDinh;
	}
	public void setMacDinh(int macDinh) {
		this.macDinh = macDinh;
	}
	@Override
	public int compare(loaiBangGia o1, loaiBangGia o2) {
		String[] a = o1.getMaBG().split("_");
		String[] b = o2.getMaBG().split("_");
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
	@Override
	public String toString() {
		return "loaiBangGia [maBG=" + maBG + ", tenBG=" + tenBG + ", macDinh=" + macDinh + "]";
	}
}
