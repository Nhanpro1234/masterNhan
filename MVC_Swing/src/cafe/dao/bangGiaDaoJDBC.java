package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cafe.bean.bangGia;

public class bangGiaDaoJDBC implements bangGiaDao {

	@Override
	public List<bangGia> get() {
		List<bangGia> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `bang_gia`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new bangGia(r.getInt(0), r.getString(1), r.getString(2), r.getFloat(3), r.getFloat(4)));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public List<bangGia> get(int id) {
		List<bangGia> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `bang_gia` where id = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new bangGia(r.getInt(0), r.getString(1), r.getString(2), r.getFloat(3), r.getFloat(4)));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(bangGia data) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi sql";
		}

		String sql = "INSERT INTO `bang_gia` VALUES (null, ?, ?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getMaSP());
			s.setString(2, data.getMaBG());
			s.setFloat(3, data.getDonGia());
			s.setFloat(4, data.getGiam());
			
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
	public String update(bangGia data) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "UPDATE `bang_gia` SET `donGia`= ?,`giam`= ? WHERE `maSP`= ? and maBG = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setFloat(1, data.getDonGia());
			s.setFloat(2, data.getGiam());
			s.setString(3, data.getMaSP());
			s.setString(4, data.getMaBG());
			
			int check = s.executeUpdate();
			if(check > 0) {
				return "Cập nhật thành công";
			}
		} catch (Exception e) {
			
			return "Lỗi exception";
		}finally {
			dataBase.disconect(conn);
		}
		return "Cập nhật thất bại";
	}

	@Override
	public String delete(int id) {
		if(get(id).isEmpty()) {
			return "Không tồn tại sản phẩm này";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "DELETE FROM `bang_gia` Where `id` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, id);

			int check = s.executeUpdate();
			if(check > 0) {
				return "Xóa thành công";
			}

		} catch (Exception e) {
			
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		return "Xóa không thành công";
	}

	@Override
	public String deleteByMaSP(String maSP) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "DELETE FROM `bang_gia` Where `maSP` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maSP);

			int check = s.executeUpdate();
			if(check > 0) {
				return "Xóa thành công";
			}

		} catch (Exception e) {
			
			return "Lỗi exception";
		} finally {
			dataBase.disconect(conn);
		}
		return "Xóa không thành công";
	}

}
