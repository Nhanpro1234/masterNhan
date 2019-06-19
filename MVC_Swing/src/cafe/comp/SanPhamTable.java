package cafe.comp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cafe.bean.loaiBangGia;
import cafe.bean.thaoTacSanPham;
import cafe.bo.bangGiaBo;
import cafe.bo.bangGiaBoJDBC;
import cafe.bo.loaiBangGiaBo;
import cafe.bo.loaiBangGiaBoJDBC;
import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;
import cafe.bo.sanPhamBo;
import cafe.bo.sanPhamBoJDBC;
import cafe.dao.thaoTacSanPhamDao;
import cafe.dao.thaoTacSanPhamDaoJDBC;
import common.grouptable.ColumnGroup;
import common.grouptable.JCustomTable;
import javax.swing.ScrollPaneConstants;

public class SanPhamTable extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SanPham sanPham;
	private JPanel footer;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton dongBo;
	private loaiBangGiaBo loaiBangGiaBo = new loaiBangGiaBoJDBC();
	private bangGiaBo bangGiaBo = new bangGiaBoJDBC();
	private sanPhamBo sanPhamBo = new sanPhamBoJDBC();
	private thaoTacSanPhamDao thaoTacSanPhamDao = new thaoTacSanPhamDaoJDBC();
	private nhomHangBo nhomHangBo = new nhomHangBoJDBC();
	private DefaultTableModel model;
	private JCustomTable JTableCS;

	private String maNhom;
	private JPanel midder;
	private JPanel header;
	private JTextField pathTree;

	public SanPhamTable(SanPham sanPham, String maNhom, String path) {
		this.maNhom = maNhom;
		this.sanPham = sanPham;
		setLayout(new BorderLayout(0, 0));

		header = new JPanel();
		add(header, BorderLayout.NORTH);
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		pathTree = new JTextField();
		pathTree.setText(path);
		pathTree.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pathTree.setEditable(false);
		header.add(pathTree);
		pathTree.setColumns(10);

		midder = new JPanel();
		add(midder, BorderLayout.CENTER);
		midder.setLayout(new BoxLayout(midder, BoxLayout.Y_AXIS));

		JTableCS = new JCustomTable(model);
		JScrollPane scrollPane = new JScrollPane(JTableCS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		midder.add(scrollPane);

		footer = new JPanel();
		add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));

		dongBo = new JButton("Đồng bộ");
		dongBo.addActionListener(this);
		dongBo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		footer.add(dongBo);

		add = new JButton("Thêm");
		add.addActionListener(this);
		add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		footer.add(add);

		edit = new JButton("Sửa");
		edit.addActionListener(this);
		edit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		footer.add(edit);

		delete = new JButton("Xóa");
		delete.addActionListener(this);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		footer.add(delete);

		load();
	}

	/**
	 * Hàm nay dùng để load lại khi tạo mới lại JPane hoặc muốn đồng bộ
	 */
	public void load() {
		autoAddColumForSP();
		addColumnJTable();
		addDataJTable();
		maNhomCuoiCung();
	}

	public void autoAddColumForSP() {
		List<thaoTacSanPham> result = null;

		if(this.maNhom.equals("Hàng hóa sản phẩm dịch vụ")) {
			result = thaoTacSanPhamDao.get();
		}else {
			String[] split = this.maNhom.split(":");
			result = thaoTacSanPhamDao.get(split[0]);
		}

		for (thaoTacSanPham thaoTacSanPham : result) {
			for (loaiBangGia loaiBangGia : loaiBangGiaBo.get()) {
				if(!thaoTacSanPhamDao.checSPvsBG(thaoTacSanPham.getMa(), loaiBangGia.getMaBG())) {
					thaoTacSanPhamDao.addBangGia(thaoTacSanPham.getMa(), loaiBangGia.getMaBG());
				}
			}
		}
	}

	/**
	 * Hàm này dùng để thêm dữ liệu vào trong Jtable
	 */
	public void addDataJTable() {
		int stt = 1;
		List<thaoTacSanPham> result = null;

		if(this.maNhom.equals("Hàng hóa sản phẩm dịch vụ")) {
			result = thaoTacSanPhamDao.get();
		}else {
			String[] split = this.maNhom.split(":");
			result = thaoTacSanPhamDao.get(split[0]);
		}

		for (thaoTacSanPham thaoTacSanPham : result) {
			Vector<String> vectorSanPham = new Vector<>();
			vectorSanPham.add(String.valueOf(stt));
			vectorSanPham.add(thaoTacSanPham.getMa());
			vectorSanPham.add(thaoTacSanPham.getTen());
			vectorSanPham.add(thaoTacSanPham.getDvt());
			String[] donGia = thaoTacSanPham.getDonGia().split(":");
			String[] giam = thaoTacSanPham.getGiam().split(":");
			for (int i = 0; i < donGia.length; i++) {
				vectorSanPham.add(donGia[i]);
				vectorSanPham.add(giam[i]);
			}

			stt++;
			model.addRow(vectorSanPham);
		}
	}

	/**
	 * Hàm này dùng để thêm cột vào JTable, tự động co giản khi có nhiều khu vực với bảng giá khác nhau
	 */
	public void addColumnJTable() {
		JTableCS.removeAll();

		model  = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		model.addColumn("#");
		model.addColumn("Mã");
		model.addColumn("Tên");
		model.addColumn("ĐVT");

		for (@SuppressWarnings("unused") loaiBangGia d : loaiBangGiaBo.get()) {
			model.addColumn("Đơn giá");
			model.addColumn("Giảm");
		}

		JTableCS.setModel(model);
		JTableCS.getColumn("#").setMaxWidth(30);
		JTableCS.getColumn("Mã").setPreferredWidth(10);
		JTableCS.getColumn("Tên").setPreferredWidth(20);
		JTableCS.getColumn("ĐVT").setPreferredWidth(10);

		for (@SuppressWarnings("unused") loaiBangGia d : loaiBangGiaBo.get()) {
			JTableCS.getColumn("Đơn giá").setPreferredWidth(20);
			JTableCS.getColumn("Giảm").setPreferredWidth(20);
		}

		ColumnGroup[] chungTuColumnGroup = new ColumnGroup[loaiBangGiaBo.get().size()];
		for (int i = 0; i < chungTuColumnGroup.length; i++) {
			chungTuColumnGroup[i] = new ColumnGroup(loaiBangGiaBo.get().get(i).getTenBG());
		}
		
		int dem = 0;
		for (int i = 4; i < JTableCS.getColumnCount(); i=i+2) {
			chungTuColumnGroup[dem].add(JTableCS.getColumn(i));
			chungTuColumnGroup[dem].add(JTableCS.getColumn(i+1));
			JTableCS.addColumnGroup(chungTuColumnGroup[dem]);
			dem++;
		}
		
	}


	/**
	 * Kiểm tra nó có phải là mã nhóm cuối cùng hay không. Điều kiện nó không phải mã nhóm không phải là mã cha của 
	 * nhóm nào hết mới được tác động thêm....
	 */
	public void maNhomCuoiCung() {
		if(this.maNhom.equals("Hàng hóa sản phẩm dịch vụ")) {
			footer.setVisible(false);
		}else {
			String[] split1 = this.maNhom.split(":");
			if(!nhomHangBo.isMaCha(split1[0])) {
				footer.setVisible(true);
			}else {
				footer.setVisible(false);
			}
		}
	}

	/**
	 * Hàm này dùng để gọi một JFrame khác để thực hiện thao tác thêm sản phẩm
	 * Đầu vào chỉ là một this của class chính
	 */
	public void themSanPham() {
		if(sanPham.getTree().getSelectionPath() == null) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}

		SanPhamTableAdd sanPhamTableAdd = new SanPhamTableAdd(sanPham);
		sanPhamTableAdd.setVisible(true);
	}

	/**
	 * Hàm này dùng để xóa sản phần, nếu nhấn nút xóa mà dữ liệu không thay đổi thì chắc chắn 100% dữ liệu đã được
	 * phát sinh trong lúc sử dụng, nên không thể xóa được !
	 */
	public void xoaSanPham() {
		int row = JTableCS.getSelectedRow();
		if(row != -1) {
			String maSP = model.getValueAt(row, 1).toString();
			bangGiaBo.deleteByMaSP(maSP);
			sanPhamBo.delete(maSP);
			load();
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Hàm này dùng để sửa sản phẩm
	 */
	public void suaSanPham() {
		int row = JTableCS.getSelectedRow();
		if(row != -1) {
			SanPhamTableEdit sanPhamTableEdit = new SanPhamTableEdit(sanPham, model.getValueAt(row, 1).toString());
			sanPhamTableEdit.setVisible(true);
			load();
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			themSanPham();
		}

		if(e.getSource() == dongBo) {
			load();
		}

		if(e.getSource() == delete) {
			xoaSanPham();
		}

		if(e.getSource() == edit) {
			suaSanPham();
		}
	}


}
