package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cafe.bean.khuVuc;
import cafe.bean.loaiBangGia;

public class loaiBangGiaDaoJDBC implements loaiBangGiaDao {
	@Override
	public ArrayList<loaiBangGia> get() {
		ArrayList<loaiBangGia> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `loai_bang_gia`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new loaiBangGia(r.getString("maBG"), r.getString("tenBG"), r.getInt("macDinh")));
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
	public ArrayList<loaiBangGia> get(String maBG) {
		ArrayList<loaiBangGia> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `loai_bang_gia` where maBG = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBG);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new loaiBangGia(r.getString("maBG"), r.getString("tenBG"), r.getInt("macDinh")));
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
	public String add(loaiBangGia loaiBangGia) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `loai_bang_gia`(`maBG`, `tenBG`, `macDinh`) VALUES (?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, loaiBangGia.getMaBG());
			s.setString(2, loaiBangGia.getTenBG());
			s.setInt(3, loaiBangGia.getMacDinh());
			
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
	public String update(loaiBangGia loaiBangGia) {
		if(isMaBG(loaiBangGia.getMaBG()) == false) {
			return "Bảng giá không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `loai_bang_gia` SET `tenBG`= ?,`macDinh`= ? WHERE `maBG`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, loaiBangGia.getTenBG());
			s.setInt(2, loaiBangGia.getMacDinh());
			s.setString(3, loaiBangGia.getMaBG());
			
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
	public String delete(String maBG) {
		if(isMaBG( maBG) == false) {
			return "Bảng giá không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `loai_bang_gia` where `maBG` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBG);
			
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
	public String getLast() {
		List<loaiBangGia> resultt = this.get();
		Collections.sort(resultt, new loaiBangGia());
		
		return resultt.get(resultt.size() - 1).getMaBG();
	}

	@Override
	public boolean isMaBG(String maBG) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `loai_bang_gia` Where `maBG` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maBG);
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
	

}
