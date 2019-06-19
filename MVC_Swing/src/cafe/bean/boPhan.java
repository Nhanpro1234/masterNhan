package cafe.bean;

import java.util.Comparator;

public class boPhan implements Comparator<boPhan> {
	private String maBP;
	private String maCha;
	private String tenBP;
	public boPhan() {
		super();
	}
	public boPhan(String maBP, String maCha, String tenBP) {
		super();
		this.maBP = maBP;
		this.maCha = maCha;
		this.tenBP = tenBP;
	}
	public String getMaBP() {
		return maBP;
	}
	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}
	public String getMaCha() {
		return maCha;
	}
	public void setMaCha(String maCha) {
		this.maCha = maCha;
	}
	public String getTenBP() {
		return tenBP;
	}
	public void setTenBP(String tenBP) {
		this.tenBP = tenBP;
	}
	@Override
	public String toString() {
		return "boPhan [maBP=" + maBP + ", maCha=" + maCha + ", tenBP=" + tenBP + "]";
	}
	@Override
	public int compare(boPhan o1, boPhan o2) {
		String[] a = o1.getMaBP().split("_");
		String[] b = o2.getMaBP().split("_");
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
