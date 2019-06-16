package cafe.bean;

import java.util.Comparator;

public class sanPhongBan implements Comparator<sanPhongBan>{
	private String soBan;
	private String maKV;
	private String maBG;
	public sanPhongBan() {
		super();
	}
	public String getSoBan() {
		return soBan;
	}
	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}
	public String getMaKV() {
		return maKV;
	}
	public void setMaKV(String maKV) {
		this.maKV = maKV;
	}
	public String getMaBG() {
		return maBG;
	}
	public void setMaBG(String maBG) {
		this.maBG = maBG;
	}
	public sanPhongBan(String soBan, String maKV, String maBG) {
		super();
		this.soBan = soBan;
		this.maKV = maKV;
		this.maBG = maBG;
	}
	@Override
	public String toString() {
		return "sanPhongBan [soBan=" + soBan + ", maKV=" + maKV + ", maBG=" + maBG + "]";
	}
	
	@Override
	public int compare(sanPhongBan o1, sanPhongBan o2) {
		String[] a = o1.getSoBan().split("_");
		String[] b = o2.getSoBan().split("_");
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
