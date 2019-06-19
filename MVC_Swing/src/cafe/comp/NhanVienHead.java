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

import cafe.bo.boPhanBo;
import cafe.bo.boPhanBoJDBC;
import cafe.bo.nhomHangBo;
import cafe.bo.nhomHangBoJDBC;

public class NhanVienHead extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addBP;
	private JButton editBP;
	private JButton deleteBP;
	private JLabel label;
	private JButton chuyenSP;
	private JButton xoaNV;
	private JButton dongBo;
	private NhanVien nhanVien;
	private boPhanBo boPhanBo = new boPhanBoJDBC();
	private JLabel lblNewLabel;
	private JButton close;
	
	public NhanVienHead(NhanVien NhanVien) {
		this.nhanVien = NhanVien;
		
		FlowLayout fl_headSP = (FlowLayout) getLayout();
		fl_headSP.setAlignment(FlowLayout.LEFT);
		
		addBP = new JButton("Thêm BP");
		addBP.addActionListener(this);
		
		dongBo = new JButton("Đồng bộ");
		dongBo.addActionListener(this);
		dongBo.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(dongBo);
		addBP.setIcon(new ImageIcon("image\\spAdd.png"));
		addBP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(addBP);
		
		editBP = new JButton("Sửa BP");
		editBP.addActionListener(this);
		editBP.setIcon(new ImageIcon("image\\spEdit.png"));
		editBP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(editBP);
		
		deleteBP = new JButton("Xóa BP");
		deleteBP.addActionListener(this);
		deleteBP.setIcon(new ImageIcon("image\\spDelete.png"));
		deleteBP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(deleteBP);
		
		label = new JLabel("|");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(label);
		
		chuyenSP = new JButton("Chuyển NV");
		chuyenSP.addActionListener(this);
		chuyenSP.setIcon(new ImageIcon("image\\transfer.png"));
		chuyenSP.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(chuyenSP);
		
		xoaNV = new JButton("Xóa NV");
		xoaNV.addActionListener(this);
		xoaNV.setIcon(new ImageIcon("image\\close.png"));
		xoaNV.setFont(new Font("Dialog", Font.PLAIN, 12));
		add(xoaNV);
		
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
		if(e.getSource() == addBP) {
			try {
				BoPhanAdd boPhanAdd = new BoPhanAdd(nhanVien);
				boPhanAdd.setVisible(true);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn cột nào để thêm vào");
			}
		}
		
		if(e.getSource() == dongBo) {
			nhanVien.loadTree();
		}
		
		if(e.getSource() == deleteBP) {
			if(nhanVien.getTree().getSelectionPath() == null) {
				return;
			}
			
			String[] data = nhanVien.getTree().getSelectionPath().getLastPathComponent().toString().split(":");
			if(!boPhanBo.isMaBP(data[0])) {
				JOptionPane.showMessageDialog(null, "Mã bộ phận không tồn tại !!");
				return;
			}
			
			boPhanBo.deleteByMaCha(data[0]);
			JOptionPane.showMessageDialog(null, boPhanBo.delete(data[0]));
			nhanVien.loadTree();
		}
		
		if(e.getSource() == editBP) {
			if(nhanVien.getTree().getSelectionPath() == null ||  nhanVien.getTree().getSelectionPath().getLastPathComponent().toString().equals("Bộ phận")) {
				return;
			}
			
			BoPhanEdit BoPhanEdit = new BoPhanEdit(nhanVien);
			BoPhanEdit.setVisible(true);
		}
		
		if(e.getSource() == close) {
			nhanVien.get_manHinhChinh().getTabbedPane().remove(nhanVien.get_manHinhChinh().getTabbedPane().getSelectedComponent());
		}
	}

}
