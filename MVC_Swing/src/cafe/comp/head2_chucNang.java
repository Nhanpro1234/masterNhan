package cafe.comp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cafe.view.ManHinhChinh;

public class Head2_chucNang extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnMauIn,btnMayIn,btnSoDo,btnDatBan,btnDoanhThu,btnThuChi,btnPhieuThu,btnPhieuChi,btnHoaDon;
	public String user;

	public Head2_chucNang(String user, ManHinhChinh _manHinhChinh) {
		setBackground(SystemColor.activeCaption);
		setBounds(0, 47, 1360, 106);
		this.user = user;
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnMauIn = new JButton("Mẫu in");
		btnMauIn.setForeground(new Color(0, 0, 0));
		btnMauIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMauIn.setIcon(new ImageIcon("image/mau-in.png"));
		btnMauIn.setHorizontalTextPosition(JButton.CENTER);
		btnMauIn.setVerticalTextPosition(JButton.BOTTOM);
		add(btnMauIn);

		btnMayIn = new JButton("Máy in");
		btnMayIn.setForeground(new Color(0, 0, 0));
		btnMayIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMayIn.setIcon(new ImageIcon("image/may-in.png"));
		btnMayIn.setHorizontalTextPosition(JButton.CENTER);
		btnMayIn.setVerticalTextPosition(JButton.BOTTOM);
		add(btnMayIn);

		btnSoDo = new JButton("Sơ đồ");
		btnSoDo.setForeground(new Color(0, 0, 0));
		btnSoDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSoDo.setIcon(new ImageIcon("image/so-do.png"));
		btnSoDo.setHorizontalTextPosition(JButton.CENTER);
		btnSoDo.setVerticalTextPosition(JButton.BOTTOM);
		add(btnSoDo);

		btnDatBan = new JButton("Đặt bàn");
		btnDatBan.setForeground(new Color(0, 0, 0));
		btnDatBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDatBan.setIcon(new ImageIcon("image/dat-ban.png"));
		btnDatBan.setHorizontalTextPosition(JButton.CENTER);
		btnDatBan.setVerticalTextPosition(JButton.BOTTOM);
		add(btnDatBan);

		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setForeground(new Color(0, 0, 0));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHoaDon.setIcon(new ImageIcon("image/hoa-don.png"));
		btnHoaDon.setHorizontalTextPosition(JButton.CENTER);
		btnHoaDon.setVerticalTextPosition(JButton.BOTTOM);
		add(btnHoaDon);

		btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setForeground(new Color(0, 0, 0));
		btnDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoanhThu.setIcon(new ImageIcon("image/doanh-thu.png"));
		btnDoanhThu.setHorizontalTextPosition(JButton.CENTER);
		btnDoanhThu.setVerticalTextPosition(JButton.BOTTOM);
		add(btnDoanhThu);

		btnThuChi = new JButton("Thu chi");
		btnThuChi.setForeground(new Color(0, 0, 0));
		btnThuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThuChi.setIcon(new ImageIcon("image/thu-chi.png"));
		btnThuChi.setHorizontalTextPosition(JButton.CENTER);
		btnThuChi.setVerticalTextPosition(JButton.BOTTOM);
		add(btnThuChi);

		btnPhieuThu = new JButton("Phiếu thu");
		btnPhieuThu.setForeground(new Color(0, 0, 0));
		btnPhieuThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPhieuThu.setIcon(new ImageIcon("image/phieu-thu.png"));
		btnPhieuThu.setHorizontalTextPosition(JButton.CENTER);
		btnPhieuThu.setVerticalTextPosition(JButton.BOTTOM);
		add(btnPhieuThu);

		btnPhieuChi = new JButton("Phiếu chi");
		btnPhieuChi.setForeground(new Color(0, 0, 0));
		btnPhieuChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPhieuChi.setIcon(new ImageIcon("image/phieu-chi.png"));
		btnPhieuChi.setHorizontalTextPosition(JButton.CENTER);
		btnPhieuChi.setVerticalTextPosition(JButton.BOTTOM);
		add(btnPhieuChi);

	}

}
