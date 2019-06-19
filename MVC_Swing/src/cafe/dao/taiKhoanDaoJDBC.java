package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cafe.bean.taiKhoan;

public class taiKhoanDaoJDBC implements taiKhoanDao{

	@Override
	public ArrayList<taiKhoan> get() {
		ArrayList<taiKhoan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `tai_khoan`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new taiKhoan(r.getString("taiKhoan"), r.getString("matKhau"), r.getString("maNV")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public ArrayList<taiKhoan> get(String taiKhoan) {
		ArrayList<taiKhoan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `tai_khoan` where taiKhoan = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan);
			
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new taiKhoan(r.getString("taiKhoan"), r.getString("matKhau"), r.getString("maNV")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(taiKhoan taiKhoan) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `tai_khoan`(`taiKhoan`, `matKhau`, `maNV`) VALUES (?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan.getTaiKhoan());
			s.setString(2, taiKhoan.getMatKhau());
			s.setString(3, taiKhoan.getMaNV());
			
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
	public String update(taiKhoan taiKhoan) {
		
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `tai_khoan` SET `matKhau`= ?,`maNV`= ? WHERE `taiKhoan`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan.getMatKhau() == "" ? "" : taiKhoan.getMatKhau());
			s.setString(2, taiKhoan.getMaNV());
			s.setString(3, taiKhoan.getTaiKhoan());
			
			
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
	public String delete(String taiKhoan) {
		if(isTaiKhoan(taiKhoan) == false) {
			return "Tài khoản không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `tai_khoan` where `taiKhoan` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan);
			
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
	public boolean isTaiKhoan(String taiKhoan) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `tai_khoan` Where `taiKhoan` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan);
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

	@Override
	public boolean isDangNhap(String taiKhoan, String matKhau) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `tai_khoan` Where `taiKhoan` = ? and `matKhau` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, taiKhoan);
			s.setString(2, matKhau);
			
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
