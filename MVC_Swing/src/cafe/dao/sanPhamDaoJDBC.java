package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cafe.bean.sanPham;


public class sanPhamDaoJDBC implements sanPhamDao {
	
	@Override
	public List<sanPham> get() {
		List<sanPham> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `san_pham`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new sanPham(r.getString("maSP"), r.getString("maNhom"), r.getString("tenSP"), r.getString("maDVT"), r.getFloat("SLDK"), r.getFloat("GTDK"), r.getInt("isMenu")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public List<sanPham> get(String maSP) {
		List<sanPham> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `san_pham` where `maSP` = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maSP);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new sanPham(r.getString("maSP"), r.getString("maNhom"), r.getString("tenSP"),
						r.getString("maDVT"), r.getFloat("SLDK"), r.getFloat("GTDK"), r.getInt("isMenu")));
			}
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public String add(sanPham data) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi sql";
		}

		String sql = "INSERT INTO `san_pham` VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getMaSP());
			s.setString(2, data.getMaNhom());
			s.setString(3, data.getTenSP());
			s.setString(4, data.getMaDVT());
			s.setFloat(5, data.getSLDK());
			s.setFloat(6, data.getGTDK());
			s.setInt(7, data.getIsMenu());

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
	public String update(sanPham data) {
		if(get(data.getMaSP()).isEmpty()) {
			return "Không tồn tại sản phẩm này";
		}
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "UPDATE `san_pham` SET `maNhom`= ?,`tenSP`= ?,`maDVT`= ?,`SLDK`= ?,`GTDK`= ?,`isMenu`= ? WHERE `maSP`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getMaNhom());
			s.setString(2, data.getTenSP());
			s.setString(3, data.getMaDVT());
			s.setFloat(4, data.getSLDK());
			s.setFloat(5, data.getGTDK());
			s.setInt(6, data.getIsMenu());
			s.setString(7, data.getMaSP());
			
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
	public String delete(String maSP) {
		if(get(maSP).isEmpty()) {
			return "Không tồn tại sản phẩm này";
		}
		
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "DELETE FROM `san_pham` Where `maSP` = ?";
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
