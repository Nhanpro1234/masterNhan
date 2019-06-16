package cafe.comp;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import cafe.bean.nhomHang;
import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;
import cafe.view._manHinhChinh;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class sanPham extends JPanel implements ActionListener, MouseListener {
	private JPanel sanPham1;
	private JSplitPane splitSanPham;
	private DefaultTableModel dm;
	private _manHinhChinh _manHinhChinh;
	
	private JPanel sanPham2;
	private JTree tree;
	private JTable table;
	private nhomHangBo nhomHangBo; 

	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JPanel panel;
	private JTextField valuePath;
	
	private DefaultMutableTreeNode DefaultMutableTreeNode;
	/**
	 * Create the panel.
	 */
	
	public sanPham(_manHinhChinh _manHinhChinh) {
		this._manHinhChinh = _manHinhChinh;
		setLayout(new BorderLayout(0, 0));
		
		add(new sanPhamHead(this), BorderLayout.NORTH); // north
		
		splitSanPham = new JSplitPane();
		splitSanPham.setDividerLocation(250);
		add(splitSanPham, BorderLayout.CENTER);
		

		
		
		sanPham1 = new JPanel();
		sanPham1.setBackground(Color.WHITE);
		sanPham1.setLayout(new BorderLayout(0, 0));
		
		nhomHangBo = new nhomHangBoJDBC();
		
		root = new DefaultMutableTreeNode("Hàng hóa sản phẩm dịch vụ");
		tree = new JTree(root);
		model = (DefaultTreeModel) tree.getModel();
		loadTree();
		tree.addMouseListener(this);
		
		sanPham1.add(tree, BorderLayout.NORTH);
		
		sanPham2 = new JPanel();
		sanPham2.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		sanPham2.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		valuePath = new JTextField();
		valuePath.setEditable(false);
		valuePath.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(valuePath);
		valuePath.setColumns(10);
		
		table = new JTable();
		sanPham2.add(table, BorderLayout.CENTER);

		splitSanPham.setLeftComponent(sanPham1);
		splitSanPham.setRightComponent(sanPham2);
		
	}
	
	public void loadTree() {
		delTree();
		
		deQui(DefaultMutableTreeNode, null);
		
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}
	
	private void deQui(DefaultMutableTreeNode oke, String maNhom) {
		List<nhomHang> dataNH = nhomHangBo.get();
		Collections.sort(dataNH, new nhomHang());
		
		for(nhomHang data : dataNH) {
			if(maNhom == null && data.getMaCha() == null) {
				oke = new DefaultMutableTreeNode(data.getMaNhom()+": "+data.getTenNhom());
				root.add(oke);
				deQui(oke, data.getMaNhom());
			}
			
			if(data.getMaCha() != null) {
				if(data.getMaCha().equals(maNhom)) {
					DefaultMutableTreeNode oke2 = new DefaultMutableTreeNode(data.getMaNhom()+": "+data.getTenNhom());
					oke.add(oke2);
					deQui(oke2, data.getMaNhom());
				}
			}
		}
	}
	
	public void delTree() {
		root.removeAllChildren();
		model.reload();
	}

	public JSplitPane getSplitDanhMuc() {
		return splitSanPham;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tree) {
			try {
				String data = tree.getSelectionPath().getLastPathComponent().toString();
				valuePath.setText(tree.getSelectionPath().toString().replaceAll(",", " /"));
				JOptionPane.showMessageDialog(null, data);
			} catch (Exception e2) {
				
			}
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
	
	public _manHinhChinh get_manHinhChinh() {
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
