package cafe.comp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cafe.bean.bangGia;
import cafe.bean.donViTinh;
import cafe.bean.loaiBangGia;
import cafe.bean.sanPham;
import cafe.bo.bangGiaBo;
import cafe.bo.bangGiaBoJDBC;
import cafe.bo.donViTinhBo;
import cafe.bo.donViTinhBoJDBC;
import cafe.bo.loaiBangGiaBo;
import cafe.bo.loaiBangGiaBoJDBC;
import cafe.bo.sanPhamBo;
import cafe.bo.sanPhamBoJDBC;

public class SanPhamTableAdd extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label1;
	private JTextField maSP;
	private JTextField tenSP;
	private JLabel lblTnSnPhm;
	private JLabel lblnVTnh;
	private JComboBox<String> dvt;
	private JButton save;
	private JButton saveClose;
	private JLabel lblNhmSnPhm;
	private JTextField nhomSP;
	private bangGiaBo bangGiaBo = new bangGiaBoJDBC();
	private donViTinhBo donViTinhBo = new donViTinhBoJDBC();
	private loaiBangGiaBo loaiBangGiaBo = new loaiBangGiaBoJDBC();
	private sanPhamBo sanPhamBo = new sanPhamBoJDBC();
	
	
	private JTable table;
	private JTable table2;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	
	private SanPham SanPham;
	private JLabel lblNewLabel;
	

	/**
	 * Create the frame.
	 */
	public SanPhamTableAdd(SanPham SanPham) {
		this.SanPham = SanPham;
		setTitle("Thêm sản phẩm");
		setResizable(false);
		setBounds(100, 100, 713, 383);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("Mã");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label1.setBounds(10, 11, 79, 21);
		contentPane.add(label1);
		
		maSP = new JTextField();
		maSP.setEditable(false);
		maSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maSP.setBounds(104, 11, 238, 21);
		contentPane.add(maSP);
		maSP.setColumns(10);
		
		tenSP = new JTextField();
		tenSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tenSP.setColumns(10);
		tenSP.setBounds(104, 43, 238, 21);
		contentPane.add(tenSP);
		
		lblTnSnPhm = new JLabel("Tên");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTnSnPhm.setBounds(10, 43, 79, 21);
		contentPane.add(lblTnSnPhm);
		
		lblnVTnh = new JLabel("Đơn vị tính");
		lblnVTnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnVTnh.setBounds(352, 43, 79, 21);
		contentPane.add(lblnVTnh);
		
		lblNhmSnPhm = new JLabel("Nhóm");
		lblNhmSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNhmSnPhm.setBounds(356, 11, 79, 21);
		contentPane.add(lblNhmSnPhm);
		
		nhomSP = new JTextField();
		nhomSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nhomSP.setEditable(false);
		nhomSP.setColumns(10);
		nhomSP.setBounds(450, 11, 238, 21);
		contentPane.add(nhomSP);
		
		dvt = new JComboBox<String>();
		dvt.setBounds(450, 44, 238, 20);
		contentPane.add(dvt);
		
		JTableDonGia();
		JTableGiamGia();
		
		save = new JButton("Lưu");
		save.addActionListener(this);
		
		save.setFont(new Font("Tahoma", Font.PLAIN, 13));
		save.setBounds(10, 310, 117, 33);
		contentPane.add(save);
		
		saveClose = new JButton("Lưu và đóng");
		saveClose.addActionListener(this);
		saveClose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		saveClose.setBounds(137, 310, 117, 33);
		contentPane.add(saveClose);
		
		lblNewLabel = new JLabel("* Nhấn đúp chuột vào ô xanh để chỉnh sửa dữ liệu và nhấn enter");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(264, 310, 424, 33);
		contentPane.add(lblNewLabel);
		
		load();
	}
	
	/**
	 * Hàm này dùng để thêm vào bảng các mục đơn giá có nhiều giá khác nhau cho từng sản phẩn
	 */
	public void JTableDonGia() {
		model = new DefaultTableModel();
		for (loaiBangGia d : loaiBangGiaBo.get()) {
			model.addColumn("Đơn giá - " + d.getTenBG());
		}
		table = new JTable(model);
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		Vector<String> vec = new Vector<>();
		for (loaiBangGia d : loaiBangGiaBo.get()) {
			table.getColumn("Đơn giá - " + d.getTenBG()).setPreferredWidth(20);
			vec.add("0");
		}
		model.addRow(vec);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JScrollPane donGiaTable = new JScrollPane(table);
		donGiaTable.setBounds(10, 75, 678, 97);
		contentPane.add(donGiaTable);
	}
	
	/**
	 * Hàm này dùng để thêm vào bảng các mục giảm giá có nhiều giá khác nhau cho từng sản phẩn
	 */
	public void JTableGiamGia() {
		model2 = new DefaultTableModel();
		for (loaiBangGia d : loaiBangGiaBo.get()) {
			model2.addColumn("Giảm - " + d.getTenBG());
		}
		
		table2 = new JTable(model2);
		table2.setRowHeight(30);
		Vector<String> vec2 = new Vector<>();
		for (loaiBangGia d : loaiBangGiaBo.get()) {
			table2.getColumn("Giảm - " + d.getTenBG()).setPreferredWidth(20);
			vec2.add("0");
		}
		model2.addRow(vec2);
		table2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table2.getTableHeader().setReorderingAllowed(false);
		JScrollPane tableGiam = new JScrollPane(table2);
		tableGiam.setBounds(10, 190, 678, 97);
		contentPane.add(tableGiam);
	}
	
	/**
	 * Hàm này dùng để khi gọi JFrame lên để tự động lấy mã sản phẩm tiếp theo, lấy danh sách đơn vị tính,
	 * Và tự đồng bộ lại để lấy mã sản phẩm mới ...
	 */
	public void load() {
		List<sanPham> sp = sanPhamBo.get();
		Collections.sort(sp, new sanPham());
		
		if(sp.isEmpty()) {
			maSP.setText("SP_1");
		}else {
			String[] split = sp.get(sp.size() - 1).getMaSP().split("_");
			maSP.setText("SP_" + (Integer.valueOf(split[1]) + 1));
		}
		
		String data = SanPham.getTree().getSelectionPath().getLastPathComponent().toString();
		nhomSP.setText(data);
		
		for (donViTinh d : donViTinhBo.get()) {
			dvt.addItem(d.getMaDVT()+": "+d.getTenDVT());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			add(0);
		}
		
		if(e.getSource() == saveClose) {
			add(1);
		}
	}
	
	/**
	 * Hàm dùng để lưu
	 * @param type = 1 thêm và tắt, = 0 là chỉ thêm không tắt
	 */
	public void add(int type) {
		if(tenSP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên");
			return;
		}
		
		String[] nhom = nhomSP.getText().split(":");
		String[] donViTinh = dvt.getSelectedItem().toString().split(":");
		
		
		sanPhamBo.add(new sanPham(maSP.getText(), nhom[0], tenSP.getText(), donViTinh[0], 0, 0, 1));
		
		for (int i = 0; i < model.getColumnCount(); i++) {
			bangGiaBo.add(new bangGia(1, maSP.getText(), loaiBangGiaBo.get().get(i).getMaBG(),Float.parseFloat(table.getModel().getValueAt(0, i).toString()),Float.parseFloat(table2.getModel().getValueAt(0, i).toString())));
		}
		
		SanPham.getPathTree();

		if(type == 1) {
			this.dispose();
		}
		load();
	}

}
