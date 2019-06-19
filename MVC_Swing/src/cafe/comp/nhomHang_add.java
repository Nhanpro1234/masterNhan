package cafe.comp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cafe.bean.loaiNhomHang;
import cafe.bean.nhomHang;
import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;

public class NhomHang_add extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tenNhom;
	private JLabel label;
	private JComboBox<String> loaiNhom;
	private JButton close;
	private JButton saveClose;
	private SanPham sanPham;
	private JButton save;
	private JTextField path;
	private String maCha;
	private nhomHangBo nhomHangBo = new nhomHangBoJDBC();

	/**
	 * Create the frame.
	 */
	public NhomHang_add(SanPham sanPham) {
		this.sanPham = sanPham;
		setTitle("Nhóm dữ liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 345, 209);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = 	new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 52, 79, 27);
		contentPane.add(lblNewLabel);
		
		tenNhom = new JTextField();
		tenNhom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tenNhom.setBounds(93, 52, 234, 27);
		contentPane.add(tenNhom);
		tenNhom.setColumns(10);
		
		label = new JLabel("Loại");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(10, 90, 79, 27);
		contentPane.add(label);
		
		loaiNhom = new JComboBox<String>();
		loaiNhom.setModel(new DefaultComboBoxModel(loaiNhomHang.values()));
		loaiNhom.setFont(new Font("Dialog", Font.PLAIN, 15));
		loaiNhom.setBounds(93, 90, 234, 27);
		contentPane.add(loaiNhom);
		
		close = new JButton("Đóng");
		close.setFont(new Font("Tahoma", Font.PLAIN, 15));
		close.setBounds(10, 142, 88, 27);
		contentPane.add(close);
		
		saveClose = new JButton("Lưu & đóng");
		saveClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saveClose.setBounds(115, 142, 114, 27);
		contentPane.add(saveClose);
		
		save = new JButton("Lưu");
		save.setFont(new Font("Tahoma", Font.PLAIN, 15));
		save.setBounds(239, 142, 88, 27);
		contentPane.add(save);
		
		path = new JTextField();
		path.setEditable(false);
		path.setFont(new Font("Tahoma", Font.PLAIN, 17));
		path.setColumns(10);
		path.setBounds(10, 11, 317, 27);
		contentPane.add(path);
		
		close.addActionListener(this);	
		
		save.addActionListener(this);
		saveClose.addActionListener(this);
		loaiNhom.addKeyListener(this);
		tenNhom.addKeyListener(this);
		
		
		load();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			this.dispose();
		}
		
		if(e.getSource() == saveClose) {
			add(1);
		}
		
		if(e.getSource() == save) {
			add(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			add(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	/**
	 * Hàm dùng để thêm nhóm
	 * @param type = 0 thoát + save, = 1 chỉ save
	 */
	public void add(int type) {
		if(path.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Lỗi đầu vào");
			return;
		}
		
		int LoaiNhomHang = loaiNhomHang.valueOf(loaiNhom.getSelectedItem().toString()).getLoaiNhom();
		
		String TenNhomHang = tenNhom.getText();
		
		List<nhomHang> result = nhomHangBo.get();
		Collections.sort(result, new nhomHang());
		
		String getMaNhom = result.get(result.size() - 1).getMaNhom();
		
		String[] getMaNhom2 = getMaNhom.split("_");
		
		String maNhom = getMaNhom2[0] + "_" + (Integer.parseInt(getMaNhom2[1]) + 1);
		
		String msg = nhomHangBo.add(new nhomHang(maNhom, maCha, TenNhomHang, LoaiNhomHang));
		
		JOptionPane.showMessageDialog(null, msg);
		
		sanPham.loadTree();
		
		if(type == 1) {
			this.dispose();
		}
	}
	
	/**
	 * Dòng để đồng bộ và lấy đường dẫn của mã nhóm làm mã cha của nhón đó
	 */
	public void load() {
		String data = sanPham.getTree().getSelectionPath().getLastPathComponent().toString();
		path.setText(data);
		
		if(path.getText().equals("Hàng hóa sản phẩm dịch vụ")) {
			maCha = null;
		}else {
			String[] get_maNhom = path.getText().split(":");
			
			maCha = get_maNhom[0];
		}
	}
}
