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
	private JLabel label;
	private JButton chuyenSP;
	private JButton xoaSP;
	private JButton dongBo;
	private SanPham sanPham;
	
	private nhomHangBo nhomHangBo = new nhomHangBoJDBC();
	private JLabel lblNewLabel;
	private JButton close;;
	
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
		
		lblNewLabel = new JLabel("|");
		add(lblNewLabel);
		
		close = new JButton("Đóng cửa sổ");
		close.addActionListener(this);
		close.setIcon(new ImageIcon("image\\close.png"));
		close.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(close);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addNhom) {
			try {
				NhomHangAdd nhomHang_add = new NhomHangAdd(sanPham);
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
			if(!nhomHangBo.isMaNH(data[0])) {
				JOptionPane.showMessageDialog(null, "Mã bộ phận không tồn tại !!");
				return;
			}
			
			nhomHangBo.deleteByMaCha(data[0]);
			JOptionPane.showMessageDialog(null, nhomHangBo.delete(data[0]));
			sanPham.loadTree();
		}
		
		if(e.getSource() == editNhom) {
			if(sanPham.getTree().getSelectionPath() == null || sanPham.getTree().getSelectionPath().getLastPathComponent().toString().equals("Hàng hóa sản phẩm dịch vụ")) {
				return;
			}
			
			NhomHangEdit nhomHang_edit = new NhomHangEdit(sanPham);
			nhomHang_edit.setVisible(true);
		}
		
		if(e.getSource() == close) {
			sanPham.get_manHinhChinh().getTabbedPane().remove(sanPham.get_manHinhChinh().getTabbedPane().getSelectedComponent());
		}
	}

}
