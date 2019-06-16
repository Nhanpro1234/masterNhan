package cafe.comp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import cafe.bean.loaiNhomHang;
import cafe.bean.nhomHang;
import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class nhomHang_edit extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTnMi;
	private JTextField tenNhom;
	private JLabel lblNhm;
	private JComboBox<String> loaiNhom;
	private JButton save;
	private JButton saveClose;
	private JButton close;

	private sanPham sanPham;
	private nhomHangBo nhomHangBo = new nhomHangBoJDBC();
	private String maNhom;
	private String maCha;
	
	/**
	 * Create the frame.
	 */
	public nhomHang_edit(sanPham sanPham) {
		this.sanPham = sanPham;
		setTitle("Sửa nhóm");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 430, 201);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTnMi = new JLabel("Tên");
		lblTnMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnMi.setBounds(10, 11, 86, 26);
		contentPane.add(lblTnMi);
		
		tenNhom = new JTextField();
		tenNhom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenNhom.setColumns(10);
		tenNhom.setBounds(120, 11, 280, 26);
		contentPane.add(tenNhom);
		
		lblNhm = new JLabel("Loại");
		lblNhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhm.setBounds(10, 58, 86, 26);
		contentPane.add(lblNhm);
		
		loaiNhom = new JComboBox<String>();
		loaiNhom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loaiNhom.setBounds(120, 60, 280, 26);
		contentPane.add(loaiNhom);
		
		save = new JButton("Lưu");
		save.setFont(new Font("Tahoma", Font.PLAIN, 16));
		save.setBounds(307, 116, 93, 29);
		contentPane.add(save);
		
		saveClose = new JButton("Lưu & đóng");
		saveClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveClose.setBounds(140, 116, 142, 29);
		contentPane.add(saveClose);
		
		close = new JButton("Đóng");
		close.setFont(new Font("Tahoma", Font.PLAIN, 16));
		close.setBounds(10, 116, 93, 29);
		contentPane.add(close);
		
		close.addActionListener(this);
		save.addActionListener(this);
		saveClose.addActionListener(this);
	
		load();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			this.dispose();
		}
		
		if(e.getSource() == saveClose) {
			run();
			this.dispose();
		}
		
		if(e.getSource() == save) {
			run();
		}
		
		
	}
	
	public void load() {
		String[] data = sanPham.getTree().getSelectionPath().getLastPathComponent().toString().split(": ");
		this.maNhom = data[0];
		tenNhom.setText(data[1]);
		
		List<nhomHang> rrr = nhomHangBo.get(this.maNhom);
		this.maCha = rrr.get(0).getMaCha();
		
		if(rrr.get(0).getLoaiNhom() == 1) {
			loaiNhom.addItem("Hàng_hóa");
		}else if(rrr.get(0).getLoaiNhom() == 2) {
			loaiNhom.addItem("Nguyên_liệu");
		}else if(rrr.get(0).getLoaiNhom() == 3) {
			loaiNhom.addItem("Sản_phẩm_chế");
		}else {
			loaiNhom.addItem("Dịch_vụ_tính_theo_giờ");
		}
		
		ArrayList<String> dataLoai = new ArrayList<>();
		dataLoai.add("Hàng_hóa");
		dataLoai.add("Nguyên_liệu");
		dataLoai.add("Sản_phẩm_chế");
		dataLoai.add("Dịch_vụ_tính_theo_giờ");
		
		for(String dd : dataLoai) {
			if(!loaiNhom.getSelectedItem().equals(dd)) {
				loaiNhom.addItem(dd);
			}
		}
		
		
	}
	
	public void run() {
		int LoaiNhomHang = loaiNhomHang.valueOf(loaiNhom.getSelectedItem().toString()).getLoaiNhom();
		String d = nhomHangBo.update(new nhomHang(this.maNhom, this.maCha, tenNhom.getText(), LoaiNhomHang));
		JOptionPane.showMessageDialog(null, d);
		sanPham.loadTree();
	}
}
