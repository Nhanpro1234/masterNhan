package cafe.comp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cafe.bean.sanPhongBan;
import cafe.bo.khuVucBo;
import cafe.bo.khuVucBoJDBC;
import cafe.bo.loaiBangGiaBo;
import cafe.bo.loaiBangGiaBoJDBC;
import cafe.bo.sanPhongBanBo;
import cafe.bo.sanPhongBanBoJDBC;

public class DanhMucSanPhongBan extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel danhMuc2_1;
	private JPanel danhMuc2_2;
	private JPanel danhMuc2_1_1;
	private JPanel danhMuc2_1_2;
	private JPanel danhMuc2_1_1_1;
	private JPanel danhMuc2_1_1_2;
	private JButton close;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton reload;
	private JTable table;
	private sanPhongBanBo sanPhongBanBo;
	private DefaultTableModel dm;
	private DanhMuc danhMuc;
	private JLabel lblNewLabel;
	private khuVucBo khuVucBo;

	/**
	 * Create the panel.
	 */
	public DanhMucSanPhongBan(DanhMuc danhMuc) {
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
		
		lblNewLabel = new JLabel("Bàn phòng");
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
		
		sanPhongBanBo = new sanPhongBanBoJDBC();
		khuVucBo = new khuVucBoJDBC();
		
		dm = new DefaultTableModel(){

		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		dm.addColumn("Mã bàn");
		dm.addColumn("Tên bàn");
		dm.addColumn("Khu vực");
		dm.addColumn("Bảng giá");
		loadSanPhongBan(dm);
		table = new JTable(dm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		danhMuc2_2.add(scrollPane);

	}
	
	public void load_add() {
		loadSanPhongBan(dm);
	}

	public void loadSanPhongBan(DefaultTableModel dm) {
		dm.setRowCount(0);
		int i = 1;
		List<sanPhongBan> resultt = sanPhongBanBo.get();
		
		Collections.sort(resultt, new sanPhongBan());
		
		for(sanPhongBan data : resultt) {
			Vector<String> vec = new Vector<>();
			vec.add(String.valueOf(data.getSoBan()));
			vec.add(String.valueOf("Bàn số " + i));
			
			vec.add(khuVucBo.getByMaKV(data.getMaKV()).get(0).getTenKV());
			loaiBangGiaBo loaiBangGiaBo = new loaiBangGiaBoJDBC();
			vec.add(loaiBangGiaBo.get(data.getMaBG()).get(0).getTenBG());
			dm.addRow(vec);
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			//danhMuc.getSplitDanhMuc().setRightComponent(new JPanel());
			danhMuc.get_manHinhChinh().getTabbedPane().remove(danhMuc.get_manHinhChinh().getTabbedPane().getSelectedComponent());
		}
		
		if(e.getSource() == edit) {
			int row = table.getSelectedRow();
			if(row != -1) {
				String maSPB = table.getValueAt(row, 0).toString();
				new DanhMucSanPhongBanEdit(this, maSPB);
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == reload) {
			loadSanPhongBan(dm);
		}
		
		if(e.getSource() == add) {
			DanhMucSanPhongBanAdd danhMucSanPhongBan_add = new DanhMucSanPhongBanAdd(this);
			danhMucSanPhongBan_add.setVisible(true);
		}
		
		if(e.getSource() == delete) {
			int row = table.getSelectedRow();
			if(row != -1) {
				String maKV = table.getValueAt(row, 0).toString();
				JOptionPane.showMessageDialog(null, sanPhongBanBo.delete(maKV));
				loadSanPhongBan(dm);
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
	
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
