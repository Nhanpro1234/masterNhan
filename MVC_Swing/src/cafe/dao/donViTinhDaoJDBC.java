package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cafe.bean.donViTinh;

public class donViTinhDaoJDBC implements donViTinhDao{

	@Override
	public List<donViTinh> get() {
		ArrayList<donViTinh> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `don_vi_tinh`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new donViTinh(r.getString("maDVT"), r.getString("tenDVT"), r.getInt("macDinh")));
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
	public List<donViTinh> get(String maDVT) {
		ArrayList<donViTinh> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `don_vi_tinh` where maDVT = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maDVT);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new donViTinh(r.getString("maDVT"), r.getString("tenDVT"), r.getInt("macDinh")));
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
	public boolean isMaDVT(String maDVT) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `don_vi_tinh` Where `maDVT` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maDVT);
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
	public String add(donViTinh donViTinh) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi kết nối sql";
		}
		
		String sql = "INSERT INTO `don_vi_tinh`(`maDVT`, `tenDVT`, `macDinh`) VALUES (?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, donViTinh.getMaDVT());
			s.setString(2, donViTinh.getTenDVT());
			s.setInt(3, donViTinh.getMacDinh());
			
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
	public String update(donViTinh donViTinh) {
		if(isMaDVT(donViTinh.getMaDVT()) == false) {
			return "Đơn vị tính không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "UPDATE `don_vi_tinh` SET `macDinh`= ?, `tenDVT`= ? WHERE `maDVT`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, donViTinh.getMacDinh());
			s.setString(2, donViTinh.getTenDVT());
			s.setString(3, donViTinh.getMaDVT());
			
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
	public String delete(String maDVT) {
		if(isMaDVT(maDVT) == false) {
			return "Đơn vị tính không tồn tại";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi kết nối >> SQL <<";
		}
		String sql = "DELETE FROM `don_vi_tinh` where `maDVT` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maDVT);
			
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
