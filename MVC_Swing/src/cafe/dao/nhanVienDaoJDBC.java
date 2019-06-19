package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cafe.bean.nhanVien;



public class nhanVienDaoJDBC implements nhanVienDao {

	@Override
	public ArrayList<nhanVien> get() {
		ArrayList<nhanVien> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `nhan_vien`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new nhanVien(
						r.getString("maNV"), r.getString("maBP"), 
						r.getString("hoTen"), r.getString("dienThoai"), 
						r.getString("diaChi"), r.getString("maSoThue"), 
						r.getInt("isKeToan"), r.getInt("isThuNgan")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public ArrayList<nhanVien> get(String maNV) {
		ArrayList<nhanVien> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `nhan_vien` where maNV = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNV);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new nhanVien(
						r.getString("maNV"), r.getString("maBP"), 
						r.getString("hoTen"), r.getString("dienThoai"), 
						r.getString("diaChi"), r.getString("maSoThue"), 
						r.getInt("isKeToan"), r.getInt("isThuNgan")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(nhanVien nhanVien) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `nhan_vien` (`maNV`, `maBP`, `hoTen`, `diaChi`, `dienThoai`, `maSoThue`, `isKeToan`, `isThuNgan`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, nhanVien.getMaNV());
			s.setString(2, nhanVien.getMaBP() == "" ? "null" : nhanVien.getMaBP());
			s.setString(3, nhanVien.getHoTen() == "" ? "null" : nhanVien.getHoTen());
			s.setString(4, nhanVien.getDiaChi() == "" ? "null" : nhanVien.getDiaChi());
			s.setString(5, nhanVien.getDienThoai() == "" ? "null" : nhanVien.getDienThoai());
			s.setString(6, nhanVien.getMaSoThue() == "" ? "null" : nhanVien.getMaSoThue());
			s.setInt(7, nhanVien.getIsKeToan());
			s.setInt(8, nhanVien.getIsThuNgan());
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Thêm thành công";
			}
			
		} catch (Exception e) {
			
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		
		return "Thêm thất bại";
	}

	@Override
	public String update(nhanVien nhanVien) {
		if(isMaNV(nhanVien.getMaNV()) == false) {
			return "Nhân viên không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `nhan_vien` SET"
				+ "`maBP`= ?,`hoTen`=?"
				+ ",`diaChi`=?,`dienThoai`=?"
				+ ",`maSoThue`=?,`isKeToan`=?,`isThuNgan`=?"
				+ " WHERE  `maNV`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, nhanVien.getMaBP() == "" ? "null" : nhanVien.getMaBP());
			s.setString(2, nhanVien.getHoTen() == "" ? "null" : nhanVien.getHoTen());
			s.setString(3, nhanVien.getDiaChi() == "" ? "null" : nhanVien.getDiaChi());
			s.setString(4, nhanVien.getDienThoai() == "" ? "null" : nhanVien.getDienThoai());
			s.setString(5, nhanVien.getMaSoThue() == "" ? "null" : nhanVien.getMaSoThue());
			s.setInt(6, nhanVien.getIsKeToan());
			s.setInt(7, nhanVien.getIsThuNgan());
			s.setString(8, nhanVien.getMaNV());
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Cập nhật thành công";
			}
		} catch (Exception e) {
			
			return "Lỗi exception";
		}finally {
			dataBase.disconect(conn);
		}
		return "Cập nhật không thành công";
	}

	@Override
	public String delete(String maNV) {
		if(isMaNV(maNV) == false) {
			return "Nhân viên không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `nhan_vien` where `maNV` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNV);
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Xóa thành công";
			}
			
		} catch (Exception e) {
			
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		return "Xóa thất bại";
	}

	@Override
	public String getLast() {
		List<nhanVien> resultt = this.get();
		Collections.sort(resultt, new nhanVien());
		
		return resultt.get(resultt.size() - 1).getMaNV();
	}

	@Override
	public boolean isMaNV(String maNV) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `nhan_vien` Where `maNV` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNV);
			ResultSet result = s.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch (Exception e) {
			
			return false;
		} finally {
			dataBase.disconect(conn);
		}
		return false;
	}
	
	
}
