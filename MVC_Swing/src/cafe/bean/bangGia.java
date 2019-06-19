package cafe.bean;

import java.util.Comparator;

public class bangGia implements Comparator<bangGia> {
	private int id;
	private String maSP;
	private String maBG;
	private float donGia;
	private float giam;
	public bangGia() {
		super();
	}
	public bangGia(int id, String maSP, String maBG, float donGia, float giam) {
		super();
		this.id = id;
		this.maSP = maSP;
		this.maBG = maBG;
		this.donGia = donGia;
		this.giam = giam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getMaBG() {
		return maBG;
	}
	public void setMaBG(String maBG) {
		this.maBG = maBG;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getGiam() {
		return giam;
	}
	public void setGiam(float giam) {
		this.giam = giam;
	}
	@Override
	public String toString() {
		return "bangGia [id=" + id + ", maSP=" + maSP + ", maBG=" + maBG + ", donGia=" + donGia + ", giam=" + giam
				+ "]";
	}
	@Override
	public int compare(bangGia o1, bangGia o2) {
		Integer c = o1.getId();
		Integer d = o2.getId();
		if(c > d) {
			return 1;
		}else if(c < d) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
