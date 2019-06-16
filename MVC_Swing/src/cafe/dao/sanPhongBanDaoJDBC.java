package cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cafe.bean.khuVuc;
import cafe.bean.nhanVien;
import cafe.bean.sanPhongBan;

public class sanPhongBanDaoJDBC implements sanPhongBanDao {

	@Override
	public List<sanPhongBan> get() {
		List<sanPhongBan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `san_ban_phong`";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new sanPhongBan(r.getString("soBan"), r.getString("maKV"), r.getString("maBG")));
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
	public String add(sanPhongBan data) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null) {
			return "Lỗi sql";
		}

		String sql = "INSERT INTO `san_ban_phong`(`soBan`, `maKV`, `maBG`) VALUES (?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getSoBan());
			s.setString(2, data.getMaKV());
			s.setString(3, data.getMaBG());

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
	public String update(sanPhongBan data) {
		if(!isBan(data.getSoBan())) {
			return "Không tồn tại bàn này";
		}
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "UPDATE `san_ban_phong` SET `maKV`= ?,`maBG`= ? WHERE `soBan`= ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, data.getMaKV());
			s.setString(2, data.getMaBG());
			s.setString(3, data.getSoBan());

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
		return "Cập nhật thất bại";
	}

	@Override
	public String delete(String soBan) {
		if(!isBan(soBan)) {
			return "Không tồn tại bàn này";
		}
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return "Lỗi sql";
		}
		String sql = "DELETE FROM `san_ban_phong` Where `soBan` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, soBan);

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
		return "Xóa không thành công";
	}

	@Override
	public boolean isBan(String soBan) {
		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return false;
		}
		String sql = "SELECT * FROM `san_ban_phong` Where `soBan` = ?";
		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, soBan);
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
	public String getLast() {
		List<sanPhongBan> resultt = this.get();
		Collections.sort(resultt, new sanPhongBan());

		return resultt.get(resultt.size() - 1).getSoBan();
	}

	@Override
	public List<sanPhongBan> get(String soBan) {
		List<sanPhongBan> ress = new ArrayList<>();

		dataBase dataBase = new dataBase();
		Connection conn = dataBase.conn();
		if(conn == null){
			return ress;
		}

		String sql = "SELECT * FROM `san_ban_phong` where soBan = ?";

		try {
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, soBan);
			ResultSet r = s.executeQuery();
			while(r.next()) {
				ress.add(new sanPhongBan(r.getString("soBan"), r.getString("maKV"), r.getString("maBG")));
			}
			return ress;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dataBase.disconect(conn);
		}
		return ress;
	}

/*
	public static void main(String[] args) {
		sanPhongBanDaoJDBC c = new sanPhongBanDaoJDBC();
		
		System.err.println(c.getLast());
		
	}*/

}
