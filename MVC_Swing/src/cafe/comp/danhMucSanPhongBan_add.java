package cafe.comp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import cafe.bean.khuVuc;
import cafe.bean.loaiBangGia;
import cafe.bean.sanPhongBan;
import cafe.bo.khuVucBo;
import cafe.bo.khuVucBoJDBC;
import cafe.bo.loaiBangGiaBo;
import cafe.bo.loaiBangGiaBoJDBC;
import cafe.bo.sanPhongBanBo;
import cafe.bo.sanPhongBanBoJDBC;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class danhMucSanPhongBan_add extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel banPhong;
	private JPanel banPhong2;
	private JPanel panel_2;
	private JButton close;
	private JButton saveClose;
	private JButton save;
	private JComboBox valueKhuVuc;
	private JLabel lblBngGi;
	private JComboBox valueBangGia;
	private JLabel lblMBnMi;
	private JTextField valueSoBan;
	private JButton addKhuVuc;
	private JButton addBangGia;
	private sanPhongBanBo sanPhongBanBo = new sanPhongBanBoJDBC();
	private khuVucBo khuVucBo = new khuVucBoJDBC();
	private danhMucSanPhongBan danhMucSanPhongBan;
	private loaiBangGiaBo loaiBangGiaBo = new loaiBangGiaBoJDBC(); 

	/**
	 * Create the frame.
	 */
	public danhMucSanPhongBan_add(danhMucSanPhongBan danhMucSanPhongBan) {
		this.danhMucSanPhongBan = danhMucSanPhongBan;
		
		setTitle("Bàn phòng");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 503, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);

		banPhong = new JPanel();
		contentPane.add(banPhong, BorderLayout.CENTER);
		banPhong.setLayout(new BorderLayout(0, 0));
		
		banPhong2 = new JPanel();
		banPhong2.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		banPhong.add(banPhong2);
		banPhong2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khu vực");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 66, 113, 27);
		banPhong2.add(lblNewLabel);
		
		valueKhuVuc = new JComboBox();
		valueKhuVuc.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueKhuVuc.setBounds(133, 66, 248, 27);
		banPhong2.add(valueKhuVuc);
		
		lblBngGi = new JLabel("Bảng giá");
		lblBngGi.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblBngGi.setBounds(10, 105, 113, 27);
		banPhong2.add(lblBngGi);
		
		valueBangGia = new JComboBox();
		valueBangGia.addItem("BG_1: Bảng giá ngoài trời");
		valueBangGia.addItem("BG_2: Bảng giá trong nhà");
		valueBangGia.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueBangGia.setBounds(133, 105, 248, 27);
		banPhong2.add(valueBangGia);
		
		lblMBnMi = new JLabel("Mã bàn mới");
		lblMBnMi.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMBnMi.setBounds(10, 28, 113, 27);
		banPhong2.add(lblMBnMi);
		
		
		valueSoBan = new JTextField();
		valueSoBan.setEditable(false);
		valueSoBan.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueSoBan.setBounds(133, 28, 287, 25);
		banPhong2.add(valueSoBan);
		valueSoBan.setColumns(10);
		
		addKhuVuc = new JButton("");
		addKhuVuc.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\them-danh-muc.png"));
		addKhuVuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addKhuVuc.setBounds(386, 66, 34, 27);
		banPhong2.add(addKhuVuc);
		
		addBangGia = new JButton("");
		addBangGia.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\them-danh-muc.png"));
		addBangGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addBangGia.setBounds(386, 104, 34, 27);
		banPhong2.add(addBangGia);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		banPhong.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		save = new JButton("Lưu");
		save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(save);
		
		saveClose = new JButton("Lưu & đóng");
		saveClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(saveClose);
		
		close = new JButton("Đóng");
		close.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(close);
		
		
		loadAll();
		
		
		close.addActionListener(this);
		saveClose.addActionListener(this);
		save.addActionListener(this);
		addBangGia.addActionListener(this);
		addKhuVuc.addActionListener(this);
	}
	
	public void loadAll() {
		Integer BS = 0;
		String maBs = "";
		String last = sanPhongBanBo.getLast();
		if(last.equals("null")) {
			maBs = "BS_1";
			BS = 1;
		}else {
			String[] a = last.split("_");
			maBs = "BS_" + (Integer.valueOf(a[1]) + 1);
		}
		valueSoBan.setText(maBs+": Bàn số " + BS);
		
		valueKhuVuc.removeAllItems();
		List<khuVuc> rrr = khuVucBo.getByAll();
		Collections.sort(rrr, new khuVuc());
		for (khuVuc data : rrr) {
			valueKhuVuc.addItem(data.getMaKV()+": "+data.getTenKV());
		}
		
		valueBangGia.removeAllItems();
		List<loaiBangGia> rrr2 = loaiBangGiaBo.get();
		Collections.sort(rrr2, new loaiBangGia());
		for (loaiBangGia data : rrr2) {
			valueBangGia.addItem(data.getMaBG()+": "+data.getTenBG());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			add();
			danhMucSanPhongBan.load_add();
		}
		
		if(e.getSource() == saveClose) {
			add();
			this.dispose();
			danhMucSanPhongBan.load_add();
		}
		
		loadAll();
	}
	
	public void add() {
		if(valueSoBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn nhập thiếu dữ liệu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String getSb = valueSoBan.getText();
		String[] resultSb = getSb.split(":");
		
		String getKv = (String)valueKhuVuc.getSelectedItem();
		String[] resultKv = getKv.split(":");

		String getBg = (String)valueBangGia.getSelectedItem();
		String[] resultBg = getBg.split(":");	
		
		String resultData = sanPhongBanBo.add(new sanPhongBan(resultSb[0], resultKv[0], resultBg[0]));
		JOptionPane.showMessageDialog(null, resultData);
	}
}
