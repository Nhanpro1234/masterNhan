package cafe.comp;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cafe.view._manHinhChinh;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class danhMuc extends JPanel implements ActionListener, MouseListener {
	private JPanel danhMuc1;
	private JPanel danhMuc1_1;
	private JComboBox<String> timKiemDanhMuc;
	private JPanel danhMuc1_2;
	private JSplitPane splitDanhMuc;
	private DefaultTableModel dm;
	private List list;
	private _manHinhChinh _manHinhChinh;
	
	private danhMucKhuVuc danhMucKhuVuc;
	private danhMucSanPhongBan danhMucSanPhongBan;
	private danhMucLoaiBangGia danhMucLoaiBangGia;
	private danhMucDonViTinh danhMucDonViTinh;
	
	/**
	 * Create the panel.
	 */
	public danhMuc(_manHinhChinh _manHinhChinh) {
		this._manHinhChinh = _manHinhChinh;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		splitDanhMuc = new JSplitPane();
		splitDanhMuc.setDividerLocation(250);
		add(splitDanhMuc);
		
		danhMuc1 = new JPanel();
		splitDanhMuc.setLeftComponent(danhMuc1);
		danhMuc1.setBackground(SystemColor.inactiveCaption);
		danhMuc1.setLayout(new BorderLayout(0, 0));
		
		danhMuc1_1 = new JPanel();
		danhMuc1_1.setBackground(SystemColor.inactiveCaption);
		danhMuc1.add(danhMuc1_1, BorderLayout.NORTH);
		danhMuc1_1.setLayout(new BoxLayout(danhMuc1_1, BoxLayout.X_AXIS));
		
		timKiemDanhMuc = new JComboBox();
		timKiemDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timKiemDanhMuc.setModel(new DefaultComboBoxModel(new String[] {"Bàn phòng","Sản phẩm","Bảng giá"}));
		danhMuc1_1.add(timKiemDanhMuc);
		
		danhMuc1_2 = new JPanel();
		danhMuc1_2.setBackground(SystemColor.inactiveCaption);
		danhMuc1.add(danhMuc1_2, BorderLayout.CENTER);
		danhMuc1_2.setLayout(new BoxLayout(danhMuc1_2, BoxLayout.Y_AXIS));
		
		list = new List();
		list.add("Khu vực");
		list.add("Bàn phòng");
		list.setFont(new Font("Dialog", Font.PLAIN, 15));
		danhMuc1_2.add(list);
		
		
		// ándasd
		
		list.addMouseListener(this);
		timKiemDanhMuc.addActionListener(this);
		
		/*danhMucKhuVuc = new danhMucKhuVuc(_manHinhChinh);*/
		splitDanhMuc.setRightComponent(new JPanel());
		
	}

	public JSplitPane getSplitDanhMuc() {
		return splitDanhMuc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timKiemDanhMuc) {
			String obj = timKiemDanhMuc.getSelectedItem().toString();
			if(obj.equals("Bàn phòng")) {
				list.removeAll();
				list.add("Khu vực");
				list.add("Bàn phòng");
			}
			
			if(obj.equals("Bảng giá")) {
				list.removeAll();
				list.add("Bảng giá");
				list.add("Loại bảng giá");
			}
			
			if(obj.equals("Sản phẩm")) {
				list.removeAll();
				list.add("Nhóm sản phẩm");
				list.add("Loại sản phẩm");
				list.add("Đơn vị tính");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == list) {
			if(list.getSelectedIndex() == -1) {
				return;
			}
			
			if(list.getSelectedItem().equals("Khu vực")) {
				danhMucKhuVuc = new danhMucKhuVuc(this);
				splitDanhMuc.setRightComponent(danhMucKhuVuc);
			}
			if(list.getSelectedItem().equals("Bàn phòng")) {
				danhMucSanPhongBan = new danhMucSanPhongBan(this);
				splitDanhMuc.setRightComponent(danhMucSanPhongBan);
			}
			if(list.getSelectedItem().equals("Loại bảng giá")) {
				danhMucLoaiBangGia = new danhMucLoaiBangGia(this);
				splitDanhMuc.setRightComponent(danhMucLoaiBangGia);
			}
			if(list.getSelectedItem().equals("Đơn vị tính")) {
				danhMucDonViTinh = new danhMucDonViTinh(this);
				splitDanhMuc.setRightComponent(danhMucDonViTinh);
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
	

}
