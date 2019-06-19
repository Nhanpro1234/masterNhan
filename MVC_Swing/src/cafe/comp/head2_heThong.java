package cafe.comp;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cafe.view.DangNhap;
import cafe.view.ManHinhChinh;

public class Head2_heThong extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDanhMuc,btnTuyChon,btnSanPham,btnKhachHang,btnNhanVien,btnMatKhau,btnDangXuat;
	public String user;
	public ManHinhChinh _manHinhChinh;

	public Head2_heThong(String user, ManHinhChinh _manHinhChinh) {
		setBackground(SystemColor.activeCaption);
		setBounds(0, 47, 1360, 106);
		this.user = user;
		this._manHinhChinh = _manHinhChinh;
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		btnDanhMuc = new JButton("Danh mục");
		btnDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDanhMuc.setIcon(new ImageIcon("image/danh-muc.png"));
		btnDanhMuc.setHorizontalTextPosition(JButton.CENTER);
		btnDanhMuc.setVerticalTextPosition(JButton.BOTTOM);
		add(btnDanhMuc);


		btnDanhMuc.addActionListener(this);

		btnTuyChon = new JButton("Tùy chọn");
		btnTuyChon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTuyChon.setIcon(new ImageIcon("image/tuy-chon.png"));
		btnTuyChon.setHorizontalTextPosition(JButton.CENTER);
		btnTuyChon.setVerticalTextPosition(JButton.BOTTOM);
		add(btnTuyChon);
		btnTuyChon.addActionListener(this);

		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSanPham.setIcon(new ImageIcon("image/san-pham.png"));
		btnSanPham.setHorizontalTextPosition(JButton.CENTER);
		btnSanPham.setVerticalTextPosition(JButton.BOTTOM);
		add(btnSanPham);
		btnSanPham.addActionListener(this);

		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKhachHang.setIcon(new ImageIcon("image/khach-hang.png"));
		btnKhachHang.setHorizontalTextPosition(JButton.CENTER);
		btnKhachHang.setVerticalTextPosition(JButton.BOTTOM);
		add(btnKhachHang);
		btnKhachHang.addActionListener(this);

		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNhanVien.setIcon(new ImageIcon("image/nhan-vien.png"));
		btnNhanVien.setHorizontalTextPosition(JButton.CENTER);
		btnNhanVien.setVerticalTextPosition(JButton.BOTTOM);
		add(btnNhanVien);
		btnNhanVien.addActionListener(this);

		btnMatKhau = new JButton("Mật khẩu");
		btnMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMatKhau.setIcon(new ImageIcon("image/mat-khau.png"));
		btnMatKhau.setHorizontalTextPosition(JButton.CENTER);
		btnMatKhau.setVerticalTextPosition(JButton.BOTTOM);
		add(btnMatKhau);
		btnMatKhau.addActionListener(this);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDangXuat.setIcon(new ImageIcon("image/dang-xuat.png"));
		btnDangXuat.setHorizontalTextPosition(JButton.CENTER);
		btnDangXuat.setVerticalTextPosition(JButton.BOTTOM);
		add(btnDangXuat);
		btnDangXuat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMatKhau) {
			DoiMatKhau _doiMatKhau = new DoiMatKhau(user, this);
			_doiMatKhau.setVisible(true);
		}

		if(e.getSource() == btnDangXuat) {
			DangNhap dn = new DangNhap();
			dn.setVisible(true);
			_manHinhChinh.dispose();
		}

		if(e.getSource() == btnDanhMuc) {
			if(checkTabs("Danh mục")) {
				return;
			}
			
			DanhMuc danhMuc = new DanhMuc(_manHinhChinh);
			_manHinhChinh.getTabbedPane().add("Danh mục", danhMuc);
			
			showJtabbedPane();
		}
		
		if(e.getSource() == btnSanPham) {
			if(checkTabs("Sản phẩm")) {
				return;
			}
			SanPham sanPham = new SanPham(_manHinhChinh);
			_manHinhChinh.getTabbedPane().add("Sản phẩm", sanPham);
			
			showJtabbedPane();
		}
		
	}
	
	public boolean checkTabs(String title) {
		int count = _manHinhChinh.getTabbedPane().getTabCount();
		
		for (int i = 0; i < count; i++) {
			if(title.equals(_manHinhChinh.getTabbedPane().getTitleAt(i))) {
				_manHinhChinh.getTabbedPane().setSelectedIndex(i);
				return true;
			}
		}
		
		return false;
	}
	
	public void showJtabbedPane() {
		_manHinhChinh.getTabbedPane().setSelectedIndex(_manHinhChinh.getTabbedPane().getTabCount() - 1);
	}


}
