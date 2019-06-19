package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cafe.bean.thaoTacSanPham;

public class thaoTacSanPhamDaoJDBC implements thaoTacSanPhamDao {

	@Override
	public List<thaoTacSanPham> get(String maNhom) {
		List<thaoTacSanPham> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}
	
		String sql = "SELECT san_pham.maSP as ma, san_pham.tenSP as ten, don_vi_tinh.tenDVT as dvt, GROUP_CONCAT(bang_gia.donGia separator ':') as donGia, GROUP_CONCAT(bang_gia.giam separator ':') as giam, GROUP_CONCAT(loai_bang_gia.tenBG separator ':') as tenBG FROM san_pham INNER JOIN don_vi_tinh ON san_pham.maDVT = don_vi_tinh.maDVT INNER JOIN bang_gia on san_pham.maSP = bang_gia.maSP INNER JOIN loai_bang_gia ON loai_bang_gia.maBG = bang_gia.maBG WHERE san_pham.maNhom = ? GROUP BY san_pham.maSP";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maNhom);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new thaoTacSanPham(r.getString("ma"),
											r.getString("ten"), 
											r.getString("dvt"),
											r.getString("donGia"), 
											r.getString("giam"), 
											r.getString("tenBG")));
			}
			Collections.sort(ress, new thaoTacSanPham());
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public List<thaoTacSanPham> get() {
		List<thaoTacSanPham> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT san_pham.maSP as ma, san_pham.tenSP as ten, don_vi_tinh.tenDVT as dvt, GROUP_CONCAT(bang_gia.donGia separator ':') as donGia, GROUP_CONCAT(bang_gia.giam separator ':') as giam, GROUP_CONCAT(loai_bang_gia.tenBG separator ':') as tenBG FROM san_pham INNER JOIN don_vi_tinh ON san_pham.maDVT = don_vi_tinh.maDVT INNER JOIN bang_gia on san_pham.maSP = bang_gia.maSP INNER JOIN loai_bang_gia ON loai_bang_gia.maBG = bang_gia.maBG GROUP BY san_pham.maSP";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new thaoTacSanPham(r.getString("ma"),
											r.getString("ten"), 
											r.getString("dvt"),
											r.getString("donGia"), 
											r.getString("giam"), 
											r.getString("tenBG")));
			}
			Collections.sort(ress, new thaoTacSanPham());
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}
	
	@Override
	public List<thaoTacSanPham> getByMaSP(String masP) {
		List<thaoTacSanPham> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT san_pham.maSP as ma, san_pham.tenSP as ten, don_vi_tinh.maDVT as dvt, GROUP_CONCAT(bang_gia.donGia separator ':') as donGia, GROUP_CONCAT(bang_gia.giam separator ':') as giam, GROUP_CONCAT(loai_bang_gia.tenBG separator ':') as tenBG FROM san_pham INNER JOIN don_vi_tinh ON san_pham.maDVT = don_vi_tinh.maDVT INNER JOIN bang_gia on san_pham.maSP = bang_gia.maSP INNER JOIN loai_bang_gia ON loai_bang_gia.maBG = bang_gia.maBG WHERE san_pham.maSP = ? GROUP BY san_pham.maSP";
				
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, masP);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new thaoTacSanPham(r.getString("ma"),
											r.getString("ten"), 
											r.getString("dvt"),
											r.getString("donGia"), 
											r.getString("giam"), 
											r.getString("tenBG")));
			}
			Collections.sort(ress, new thaoTacSanPham());
			return ress;
		} catch (Exception e) {
			
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

	@Override
	public boolean checSPvsBG(String maSP, String maBG) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `bang_gia` WHERE maSP = ? AND maBG = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maSP);
			s.setString(2, maBG);
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
	
	public static void main(String[] args) {
		thaoTacSanPhamDaoJDBC c = new thaoTacSanPhamDaoJDBC();
		System.err.println(c.checSPvsBG("SP_1", "BG_3"));
		System.err.println(c.addBangGia("SP_1", "BG_3"));
	}

	@Override
	public String addBangGia(String maSP, String maBG) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi sql";
		}

		String sql = "INSERT INTO `bang_gia`(`id`, `maSP`, `maBG`, `donGia`, `giam`) VALUES (null, ?, ?, 0, 0)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, maSP);
			s.setString(2, maBG);

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
	
	
	
	

}
