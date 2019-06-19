package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cafe.bean.khuVuc;

public class khuVucDaoJDBC implements khuVucDao {

	@Override
	public ArrayList<khuVuc> getByAll() {
		ArrayList<khuVuc> ress = new ArrayList<>();
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}
		
		String sql = "SELECT * FROM `khu_vuc`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new khuVuc(r.getString("maKV"), r.getString("tenKV")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public ArrayList<khuVuc> getByMaKV(String maKV) {
		ArrayList<khuVuc> ress = new ArrayList<>();
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}
		
		String sql = "SELECT * FROM `khu_vuc` where maKV = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maKV);
			
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new khuVuc(r.getString("maKV"), r.getString("tenKV")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public boolean add(khuVuc data) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return false;
		}
		
		String sql = "INSERT INTO `khu_vuc`(`maKV`, `tenKV`) VALUES (?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getMaKV());
			s.setString(2, data.getTenKV());
			
			int check = s.executeUpdate();
			if(check > 0) {
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
	public String update(String maKV, String tenKV) {
		if(!isMaKV(maKV)) {
			return "Mã khu vực không tồn tại";
		}
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `khu_vuc` SET `tenKV` = ? WHERE maKV = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, tenKV);
			s.setString(2, maKV);
			
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
	public String delete(String maKV) {
		if(isMaKV(maKV) == false) {
			return "Mã khu vực không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `khu_vuc` where `maKV` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maKV);
			
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
	public String getByLast() {
		List<khuVuc> resultt = this.getByAll();
		Collections.sort(resultt, new khuVuc());
		
		return resultt.get(resultt.size() - 1).getMaKV();
	}

	@Override
	public boolean isMaKV(String maKV) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `khu_vuc` Where `maKV` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maKV);
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
