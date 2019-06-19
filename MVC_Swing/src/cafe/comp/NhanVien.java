package cafe.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import cafe.bean.boPhan;
import cafe.bo.boPhanBo;
import cafe.bo.boPhanBoJDBC;
import cafe.view.ManHinhChinh;

public class NhanVien extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel nhanVien;
	private JSplitPane splitNhanVien;
	private ManHinhChinh _manHinhChinh;
	private JPanel sanPham2;
	private JTree tree;
	private boPhanBo boPhanBo = new boPhanBoJDBC(); 
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JPanel sanPham2_2;
	private JTextField valuePath;
	private DefaultMutableTreeNode DefaultMutableTreeNode;

	/**
	 * Create the panel.
	 */

	public NhanVien(ManHinhChinh _manHinhChinh) {
		this._manHinhChinh = _manHinhChinh;
		setLayout(new BorderLayout(0, 0));

		add(new NhanVienHead(this), BorderLayout.NORTH); // north

		splitNhanVien = new JSplitPane();
		splitNhanVien.setDividerLocation(250);
		add(splitNhanVien, BorderLayout.CENTER);

		nhanVien = new JPanel();
		nhanVien.setBackground(Color.WHITE);
		nhanVien.setLayout(new BorderLayout(0, 0));

		root = new DefaultMutableTreeNode("Bộ phận");
		tree = new JTree(root);
		tree.addMouseListener(this);
		model = (DefaultTreeModel) tree.getModel();
		loadTree();

		nhanVien.add(tree, BorderLayout.NORTH);

		sanPham2 = new JPanel();
		sanPham2.setLayout(new BorderLayout(0, 0));

		sanPham2_2 = new JPanel();
		sanPham2.add(sanPham2_2, BorderLayout.NORTH);
		sanPham2_2.setLayout(new BoxLayout(sanPham2_2, BoxLayout.X_AXIS));

		valuePath = new JTextField();
		valuePath.setEditable(false);
		valuePath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sanPham2_2.add(valuePath);
		valuePath.setColumns(10);

		splitNhanVien.setLeftComponent(nhanVien);
		splitNhanVien.setRightComponent(new JPanel());

	}

	/**
	 * Hàm này dùng để đồng bộ lại dữ liệu mới khi có sự thêm nhóm hay bất kỳ điều gì đó
	 */
	public void loadTree() {
		delTree();

		deQui(DefaultMutableTreeNode, null);

		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	/**
	 * Hàm này được dùng để tạo ra cây thư mục
	 * @param defaultMutableTreeNode là cái thêm vào thư mục
	 * @param maNhom mặc định lúc đầu đưa vô là null và điều kiện là null để tránh chạy vô tận @@
	 * nếu không là null thì lần sau thì nó sẽ gọi lại mã nhóm
	 * thì nó sẽ chạy lại if đầu mà không chạy ra cái if thứ 2
	 */
	private void deQui(DefaultMutableTreeNode defaultMutableTreeNode, String maNhom) {
		List<boPhan> BP = boPhanBo.get();
		Collections.sort(BP, new boPhan());

		for(boPhan data : BP) {
			if(maNhom == null && data.getMaCha() == null) {
				defaultMutableTreeNode = new DefaultMutableTreeNode(data.getMaBP()+": "+data.getTenBP());
				root.add(defaultMutableTreeNode);
				deQui(defaultMutableTreeNode, data.getMaBP());
			}

			if(data.getMaCha() != null) {
				if(data.getMaCha().equals(maNhom)) {
					DefaultMutableTreeNode oke2 = new DefaultMutableTreeNode(data.getMaBP()+": "+data.getTenBP());
					defaultMutableTreeNode.add(oke2);
					deQui(oke2, data.getMaBP());
				}
			}
		}
	}

	/**
	 * Hàm này dùng để lấy đường dẫn tới cái nhóm đó
	 */
	public void getPathTree() {
		if(tree.getSelectionPath() != null) {
			//String data = tree.getSelectionPath().getLastPathComponent().toString();
			//splitSanPham.setRightComponent(new SanPhamTable(this, data, tree.getSelectionPath().toString().replaceAll(",", " /")));
		}
	}

	/**
	 * Hàm này dùng để xóa tất Children trong Jtree
	 */
	public void delTree() {
		root.removeAllChildren();
		model.reload();
	}

	public JSplitPane getSplitDanhMuc() {
		return splitNhanVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tree) {
			getPathTree();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public ManHinhChinh get_manHinhChinh() {
		return _manHinhChinh;
	}

	public JTree getTree() {
		return tree;
	}

	public DefaultMutableTreeNode getRoot() {
		return root;
	}

	public DefaultTreeModel getModel() {
		return model;
	}

}
