package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cafe.bean.boPhan;
import cafe.bean.nhomHang;

public class boPhanDaoJDBC implements boPhanDao {

	@Override
	public ArrayList<boPhan> get() {
		ArrayList<boPhan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `bo_phan`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new boPhan(r.getString("maBP"), r.getString("maCha"), r.getString("tenBP")));
			}
			return ress;
		} catch (Exception e) {
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public ArrayList<boPhan> get(String maBP) {
		ArrayList<boPhan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `bo_phan` where maBP = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBP);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new boPhan(r.getString("maBP"), r.getString("maCha"), r.getString("tenBP")));
			}
			return ress;
		} catch (Exception e) {
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(boPhan boPhan) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `bo_phan` VALUES (?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, boPhan.getMaBP());
			s.setString(2, boPhan.getMaCha());
			s.setString(3, boPhan.getTenBP());
			
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
	public String update(boPhan boPhan) {
		if(isMaBP(boPhan.getMaBP()) == false) {
			return "Nhóm hàng không tồn tại";
		}

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `bo_phan` SET `maCha`= ?,`tenBP`= ? WHERE `maBP`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, boPhan.getMaCha());
			s.setString(2, boPhan.getTenBP());
			s.setString(3, boPhan.getMaBP());
			
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
	public String delete(String maBP) {
		if(isMaBP(maBP) == false) {
			return "Nhóm hàng không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `bo_phan` where `maBP` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBP);
			
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
	public boolean isMaBP(String maBP) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `bo_phan` Where `maBP` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBP);
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
	public boolean isMaCha(String maCha) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `bo_phan` Where `maCha` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maCha);
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
	public String deleteByMaCha(String maCha) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `bo_phan` where `maCha` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maCha);
			
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

}
