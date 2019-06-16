package cafe.comp;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cafe.bean.donViTinh;
import cafe.bean.khuVuc;
import cafe.bo.donViTinhBo;
import cafe.bo.donViTinhBoJDBC;
import cafe.bo.khuVucBoJDBC;

public class danhMucDonViTinh extends JPanel implements ActionListener, MouseListener {
	private JPanel danhMuc2_1;
	private JPanel danhMuc2_2;
	private JPanel danhMuc2_1_1;
	private JPanel danhMuc2_1_2;
	private JPanel danhMuc2_1_1_1;
	private JPanel danhMuc2_1_1_2;
	private JLabel label;
	private JButton close;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton reload;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dm;
	private danhMuc danhMuc;
	private JLabel lblNewLabel;
	private donViTinhBo donViTinhBo;

	/**
	 * Create the panel.
	 */
	public danhMucDonViTinh(danhMuc danhMuc) {
		this.danhMuc = danhMuc;
		setBackground(SystemColor.activeCaption);
		setLayout(new BorderLayout(0, 0));
		
		danhMuc2_1 = new JPanel();
		danhMuc2_1.setBackground(SystemColor.activeCaption);
		add(danhMuc2_1, BorderLayout.NORTH);
		danhMuc2_1.setLayout(new BoxLayout(danhMuc2_1, BoxLayout.Y_AXIS));
		
		danhMuc2_1_1 = new JPanel();
		danhMuc2_1_1.setBackground(SystemColor.activeCaption);
		danhMuc2_1.add(danhMuc2_1_1);
		danhMuc2_1_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		danhMuc2_1_1_1 = new JPanel();
		FlowLayout fl_danhMuc2_1_1_1 = (FlowLayout) danhMuc2_1_1_1.getLayout();
		fl_danhMuc2_1_1_1.setAlignment(FlowLayout.LEFT);
		danhMuc2_1_1.add(danhMuc2_1_1_1);
		
		lblNewLabel = new JLabel("BÀN - PHÒNG");
		danhMuc2_1_1_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		danhMuc2_1_1_2 = new JPanel();
		FlowLayout fl_danhMuc2_1_1_2 = (FlowLayout) danhMuc2_1_1_2.getLayout();
		fl_danhMuc2_1_1_2.setAlignment(FlowLayout.RIGHT);
		danhMuc2_1_1.add(danhMuc2_1_1_2);
		
		close = new JButton();
		close.addActionListener(this);
		close.setFont(new Font("Tahoma", Font.PLAIN, 15));
		close.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\close.png"));
		danhMuc2_1_1_2.add(close);
		
		danhMuc2_1_2 = new JPanel();
		danhMuc2_1_2.setBackground(SystemColor.activeCaption);
		FlowLayout fl_danhMuc2_1_2 = (FlowLayout) danhMuc2_1_2.getLayout();
		fl_danhMuc2_1_2.setAlignment(FlowLayout.LEFT);
		danhMuc2_1.add(danhMuc2_1_2);
		
		add = new JButton();
		add.addActionListener(this);
		add.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\them-danh-muc.png"));
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		danhMuc2_1_2.add(add);
		
		edit = new JButton();
		edit.addActionListener(this);
		edit.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\chinh-sua-danh-muc.png"));
		edit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		danhMuc2_1_2.add(edit);
		
		delete = new JButton();
		delete.addActionListener(this);
		delete.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\xoa-danh-muc.png"));
		delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		danhMuc2_1_2.add(delete);
		
		reload = new JButton();
		reload.addActionListener(this);
		reload.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\tai-lai-danh-muc.png"));
		reload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		danhMuc2_1_2.add(reload);
		
		danhMuc2_2 = new JPanel();
		danhMuc2_2.setBackground(SystemColor.activeCaption);
		add(danhMuc2_2, BorderLayout.CENTER);
		
		
		danhMuc2_2.setLayout(new BoxLayout(danhMuc2_2, BoxLayout.Y_AXIS));
		
		donViTinhBo = new donViTinhBoJDBC();

		dm = new DefaultTableModel();
		dm.addColumn("Mã đơn vị tính");
		dm.addColumn("Tên đơn vị tính");
		dm.addColumn("Mặc định");
		loadKhuVuc(dm);
		table = new JTable(dm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		danhMuc2_2.add(scrollPane);
		

	}
	
	public void loadKhuVuc(DefaultTableModel dm) {
		dm.setRowCount(0);
		List<donViTinh> resultt = donViTinhBo.get();
		Collections.sort(resultt, new donViTinh());
		
		for(donViTinh data : resultt) {
			Vector<String> vec = new Vector<>();
			vec.add(String.valueOf(data.getMaDVT()));
			vec.add(String.valueOf(data.getTenDVT()));
			vec.add(String.valueOf(data.getMacDinh() == 1 ? "Có" : "Không"));
			dm.addRow(vec);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			danhMuc.getSplitDanhMuc().setRightComponent(new JPanel());
		}
		
		if(e.getSource() == edit) {
			int row = table.getSelectedRow();
			if(row != -1) {
				danhMucDonViTinh_edit danhMucDonViTinh_edit = new danhMucDonViTinh_edit(this, table.getValueAt(row, 0).toString());
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == reload) {
			loadKhuVuc(dm);
		}
		
		if(e.getSource() == add) {
			danhMucDonViTinh_add danhMucDonViTinh_add = new danhMucDonViTinh_add(this);
			
			
		}
		
		if(e.getSource() == delete) {
			int row = table.getSelectedRow();
			String maDVT = table.getValueAt(row, 0).toString();
			donViTinhBo.delete(maDVT);
		}
		
		loadKhuVuc(dm);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void load_add() {
		loadKhuVuc(dm);
	}

}
