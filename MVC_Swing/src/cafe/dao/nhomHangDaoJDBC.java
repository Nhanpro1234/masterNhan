package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cafe.bean.nhomHang;

public class nhomHangDaoJDBC implements nhomHangDao {
	
	@Override
	public ArrayList<nhomHang> get() {
		ArrayList<nhomHang> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `nhom_hang`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new nhomHang(r.getString("maNhom"), r.getString("maCha"), r.getString("tenNhom"), r.getInt("loaiNhom")));
			}
			return ress;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public ArrayList<nhomHang> get(String maNH) {
		ArrayList<nhomHang> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `nhom_hang` where maNhom = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNH);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new nhomHang(r.getString("maNhom"), r.getString("maCha"), r.getString("tenNhom"), r.getInt("loaiNhom")));
			}
			return ress;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(nhomHang nhomHang) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `nhom_hang`(`maNhom`, `maCha`, `tenNhom`, `loaiNhom`) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, nhomHang.getMaNhom());
			s.setString(2, nhomHang.getMaCha());
			s.setString(3, nhomHang.getTenNhom());
			s.setInt(4, nhomHang.getLoaiNhom());
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Thêm thành công";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		
		return "Thêm thất bại";
	}

	@Override
	public String update(nhomHang nhomHang) {
		if(isMaNH(nhomHang.getMaNhom()) == false) {
			return "Nhóm hàng không tồn tại";
		}

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `nhom_hang` SET `maCha`= ?,`tenNhom`= ?,`loaiNhom`= ? WHERE `maNhom` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, nhomHang.getMaCha());
			s.setString(2, nhomHang.getTenNhom());
			s.setInt(3, nhomHang.getLoaiNhom());
			s.setString(4, nhomHang.getMaNhom());

			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Cập nhật thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Lỗi exception";
		}finally {
			dataBase.disconect(conn);
		}
		return "Cập nhật không thành công";
	}

	@Override
	public String delete(String maNH) {
		if(isMaNH(maNH) == false) {
			return "Nhóm hàng không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `nhom_hang` where `maNhom` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNH);
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Xóa thành công";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		return "Xóa thất bại";
	}

	@Override
	public boolean isMaNH(String maNH) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `nhom_hang` Where `maNhom` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNH);
			ResultSet result = s.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			dataBase.disconect(conn);
		}
		return false;
	}

	@Override
	public String deleteByMaCha(String maCha) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `nhom_hang` where `maCha` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maCha);
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Xóa thành công";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		return "Xóa thất bại";
	}

}
