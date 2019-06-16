package cafe.bean;

import java.util.Comparator;

public class nhanVien implements Comparator<nhanVien> {
	private String maNV;
	private String maBP;
	private String hoTen;
	private String dienThoai;
	private String diaChi;
	private String maSoThue;
	private int isKeToan;
	private int isThuNgan;
	
	

	public nhanVien() {
		super();
	}


	public nhanVien(String maNV, String maBP, String hoTen, String dienThoai, String diaChi, String maSoThue, int isKeToan,
			int isThuNgan) {
		super();
		this.maNV = maNV;
		this.maBP = maBP;
		this.hoTen = hoTen;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.maSoThue = maSoThue;
		this.isKeToan = isKeToan;
		this.isThuNgan = isThuNgan;
	}

	

	public String getMaNV() {
		return maNV;
	}



	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}



	public String getMaBP() {
		return maBP;
	}



	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public String getDienThoai() {
		return dienThoai;
	}



	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}



	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getMaSoThue() {
		return maSoThue;
	}



	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}



	public int getIsKeToan() {
		return isKeToan;
	}



	public void setIsKeToan(int isKeToan) {
		this.isKeToan = isKeToan;
	}



	public int getIsThuNgan() {
		return isThuNgan;
	}



	public void setIsThuNgan(int isThuNgan) {
		this.isThuNgan = isThuNgan;
	}



	@Override
	public int compare(nhanVien o1, nhanVien o2) {
		String[] a = o1.getMaNV().split("_");
		String[] b = o2.getMaNV().split("_");
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
		return "nhanVien [maNV=" + maNV + ", maBP=" + maBP + ", hoTen=" + hoTen + ", dienThoai=" + dienThoai
				+ ", diaChi=" + diaChi + ", maSoThue=" + maSoThue + ", isKeToan=" + isKeToan + ", isThuNgan="
				+ isThuNgan + "]";
	}
	
	
}
