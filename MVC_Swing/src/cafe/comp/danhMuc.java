package cafe.comp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import cafe.view.ManHinhChinh;

public class DanhMuc extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel danhMuc1;
	private JPanel danhMuc1_1;
	private JPanel danhMuc1_2;
	private JSplitPane splitDanhMuc;
	private List list;
	private ManHinhChinh _manHinhChinh;
	
	private DanhMucKhuVuc danhMucKhuVuc;
	private DanhMucSanPhongBan danhMucSanPhongBan;
	private DanhMucLoaiBangGia danhMucLoaiBangGia;
	private DanhMucDonViTinh danhMucDonViTinh;
	
	/**
	 * Create the panel.
	 */
	public DanhMuc(ManHinhChinh _manHinhChinh) {
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
		
		danhMuc1_2 = new JPanel();
		danhMuc1_2.setBackground(SystemColor.inactiveCaption);
		danhMuc1.add(danhMuc1_2, BorderLayout.CENTER);
		danhMuc1_2.setLayout(new BoxLayout(danhMuc1_2, BoxLayout.Y_AXIS));
		
		list = new List();
		list.add("Khu vực");
		list.add("Bàn phòng");
		list.add("Loại bảng giá");
		list.add("Đơn vị tính");
		list.setFont(new Font("Dialog", Font.PLAIN, 15));
		danhMuc1_2.add(list);
		
		list.addMouseListener(this);
		
		splitDanhMuc.setRightComponent(new JPanel());
		splitDanhMuc.setResizeWeight(0.5);
	}

	public JSplitPane getSplitDanhMuc() {
		return splitDanhMuc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public ManHinhChinh get_manHinhChinh() {
		return _manHinhChinh;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == list) {
			if(list.getSelectedIndex() == -1) {
				return;
			}
			
			if(list.getSelectedItem().equals("Khu vực")) {
				danhMucKhuVuc = new DanhMucKhuVuc(this);
				splitDanhMuc.setRightComponent(danhMucKhuVuc);
			}
			if(list.getSelectedItem().equals("Bàn phòng")) {
				danhMucSanPhongBan = new DanhMucSanPhongBan(this);
				splitDanhMuc.setRightComponent(danhMucSanPhongBan);
			}
			if(list.getSelectedItem().equals("Loại bảng giá")) {
				danhMucLoaiBangGia = new DanhMucLoaiBangGia(this);
				splitDanhMuc.setRightComponent(danhMucLoaiBangGia);
			}
			if(list.getSelectedItem().equals("Đơn vị tính")) {
				danhMucDonViTinh = new DanhMucDonViTinh(this);
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
	

}
