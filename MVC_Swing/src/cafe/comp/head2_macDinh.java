package cafe.comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import cafe.view.ManHinhChinh;

public class Head2_macDinh extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel macDinh1;
	private JLabel lblNewLabel;
	private JPanel macDinh2;
	private JPanel macDinh3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel macDinh2_1;
	private JPanel macDinh2_2;
	private JLabel lblNewLabel_3;
	private JDateChooser valueTuNgay;
	private JLabel lblNewLabel_4;
	private JDateChooser valueNgayDen;
	private JLabel lblNewLabel_5;
	private JComboBox<Object> valueKhachHang;
	private JRadioButton valueTiengAnh;
	private JRadioButton valueTiengViet;
	private JCheckBox valueXemTruoc;
	private JComboBox<Object> valueBangGia;
	private JComboBox<Object> valueThuNgan;
	private JComboBox<Object> valueNhanVien;

	private JPanel macDinh3_1;
	private JLabel label;
	/**
	 * Create the panel.
	 */
	public Head2_macDinh(String user, ManHinhChinh _manHinhChinh) {
		setBackground(SystemColor.activeCaption);
		setLayout(new GridLayout(0, 3, 0, 0));

		macDinh1 = new JPanel();
		macDinh1.setBorder(new TitledBorder(null, "Mặc định", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		macDinh1.setBackground(SystemColor.activeCaption);
		add(macDinh1);
		macDinh1.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel = new JLabel("BẢNG GIÁ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh1.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.activeCaption);

		valueBangGia = new JComboBox<Object>();
		macDinh1.add(valueBangGia);
		valueBangGia.setBackground(Color.WHITE);

		lblNewLabel_2 = new JLabel("NHÂN VIÊN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh1.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(SystemColor.activeCaption);

		valueNhanVien = new JComboBox<Object>();
		macDinh1.add(valueNhanVien);
		valueNhanVien.setBackground(Color.WHITE);

		lblNewLabel_1 = new JLabel("THU NGÂN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(SystemColor.activeCaption);

		valueThuNgan = new JComboBox<Object>();
		macDinh1.add(valueThuNgan);
		valueThuNgan.setBackground(Color.WHITE);

		macDinh2 = new JPanel();
		macDinh2.setBorder(new TitledBorder(null, "Báo cáo", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		macDinh2.setBackground(SystemColor.activeCaption);
		add(macDinh2);
		macDinh2.setLayout(new GridLayout(2, 0, 0, 0));

		macDinh2_1 = new JPanel();
		macDinh2_1.setBackground(SystemColor.activeCaption);
		macDinh2.add(macDinh2_1);

		lblNewLabel_3 = new JLabel("TỪ NGÀY");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBackground(SystemColor.activeCaption);

		valueTuNgay = new JDateChooser();
		valueTuNgay.setBackground(SystemColor.activeCaption);

		lblNewLabel_4 = new JLabel("ĐẾN NGÀY");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBackground(SystemColor.activeCaption);

		valueNgayDen = new JDateChooser();
		valueNgayDen.setBackground(SystemColor.activeCaption);
		macDinh2_1.setLayout(new BoxLayout(macDinh2_1, BoxLayout.X_AXIS));
		macDinh2_1.add(lblNewLabel_3);
		macDinh2_1.add(valueTuNgay);
		macDinh2_1.add(lblNewLabel_4);
		macDinh2_1.add(valueNgayDen);

		macDinh2_2 = new JPanel();
		macDinh2_2.setBackground(SystemColor.activeCaption);
		macDinh2.add(macDinh2_2);
		macDinh2_2.setLayout(new BoxLayout(macDinh2_2, BoxLayout.X_AXIS));

		lblNewLabel_5 = new JLabel("KHÁCH HÀNG");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBackground(SystemColor.activeCaption);
		macDinh2_2.add(lblNewLabel_5);

		valueKhachHang = new JComboBox<Object>();
		valueKhachHang.setBackground(Color.WHITE);
		macDinh2_2.add(valueKhachHang);

		macDinh3 = new JPanel();
		macDinh3.setBackground(SystemColor.activeCaption);
		add(macDinh3);

		ButtonGroup groupLangue = new ButtonGroup();
		macDinh3.setLayout(new GridLayout(0, 1, 0, 0));

		macDinh3_1 = new JPanel();
		macDinh3_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "In hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		macDinh3_1.setBackground(SystemColor.activeCaption);
		macDinh3.add(macDinh3_1);
		macDinh3_1.setLayout(new GridLayout(0, 2, 0, 0));
		valueTiengViet = new JRadioButton("TIẾNG VIỆT");
		valueTiengViet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh3_1.add(valueTiengViet);
		valueTiengViet.setBackground(SystemColor.activeCaption);
		groupLangue.add(valueTiengViet);

		valueTiengAnh = new JRadioButton("TIẾNG ANH");
		valueTiengAnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh3_1.add(valueTiengAnh);
		valueTiengAnh.setBackground(SystemColor.activeCaption);
		groupLangue.add(valueTiengAnh);

		valueXemTruoc = new JCheckBox("XEM TRƯỚC HÓA ĐƠN");
		valueXemTruoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		macDinh3_1.add(valueXemTruoc);
		valueXemTruoc.setBackground(SystemColor.activeCaption);

		label = new JLabel("");
		macDinh3_1.add(label);
	}

}
