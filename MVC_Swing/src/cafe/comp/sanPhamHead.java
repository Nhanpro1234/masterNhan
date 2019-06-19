package cafe.comp;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;

public class SanPhamHead extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addNhom;
	private JButton editNhom;
	private JButton delete;
	private JButton capNhat;
	private JButton luuSP;
	private JLabel label;
	private JButton chuyenSP;
	private JButton xoaSP;
	
	private SanPham sanPham;
	private JButton dongBo;
	
	private nhomHangBo nhomHangBo = new nhomHangBoJDBC();;
	
	public SanPhamHead(SanPham sanPham) {
		this.sanPham = sanPham;
		
		FlowLayout fl_headSP = (FlowLayout) getLayout();
		fl_headSP.setAlignment(FlowLayout.LEFT);
		
		addNhom = new JButton("Thêm nhóm");
		addNhom.addActionListener(this);
		
		dongBo = new JButton("Đồng bộ");
		dongBo.addActionListener(this);
		dongBo.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(dongBo);
		addNhom.setIcon(new ImageIcon("image\\spAdd.png"));
		addNhom.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(addNhom);
		
		editNhom = new JButton("Sửa nhóm");
		editNhom.addActionListener(this);
		editNhom.setIcon(new ImageIcon("image\\spEdit.png"));
		editNhom.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(editNhom);
		
		delete = new JButton("Xóa nhóm");
		delete.addActionListener(this);
		delete.setIcon(new ImageIcon("image\\spDelete.png"));
		delete.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(delete);
		
		label = new JLabel("|");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(label);
		
		capNhat = new JButton("Cập nhật");
		capNhat.addActionListener(this);
		capNhat.setIcon(new ImageIcon("image\\tai-lai-danh-muc.png"));
		capNhat.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(capNhat);
		
		luuSP = new JButton("Lưu SP");
		luuSP.addActionListener(this);
		luuSP.setIcon(new ImageIcon("image\\save.png"));
		luuSP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(luuSP);
		
		chuyenSP = new JButton("Chuyển SP");
		chuyenSP.addActionListener(this);
		chuyenSP.setIcon(new ImageIcon("image\\transfer.png"));
		chuyenSP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(chuyenSP);
		
		xoaSP = new JButton("Xóa SP");
		xoaSP.addActionListener(this);
		xoaSP.setIcon(new ImageIcon("image\\close.png"));
		xoaSP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(xoaSP);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addNhom) {
			try {
				//String data = sanPham.getTree().getSelectionPath().getLastPathComponent().toString();
				NhomHang_add nhomHang_add = new NhomHang_add(sanPham);
				nhomHang_add.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột nào để thêm vào");
			}
		}
		
		if(e.getSource() == dongBo) {
			sanPham.loadTree();
		}
		
		if(e.getSource() == delete) {
			if(sanPham.getTree().getSelectionPath() == null) {
				return;
			}
			
			String[] data = sanPham.getTree().getSelectionPath().getLastPathComponent().toString().split(":");
			nhomHangBo.deleteByMaCha(data[0]);
			JOptionPane.showMessageDialog(null, nhomHangBo.delete(data[0]));
			sanPham.loadTree();
		}
		
		if(e.getSource() == editNhom) {
			if(sanPham.getTree().getSelectionPath() == null) {
				return;
			}
			
			NhomHang_edit nhomHang_edit = new NhomHang_edit(sanPham);
			nhomHang_edit.setVisible(true);
		}
	}

}
