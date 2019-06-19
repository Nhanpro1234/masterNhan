package cafe.comp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import cafe.bean.loaiBangGia;
import cafe.bo.loaiBangGiaBo;
import cafe.bo.loaiBangGiaBoJDBC;

public class DanhMucLoaiBangGia_edit extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel banPhong;
	private JPanel banPhong2;
	private JPanel panel_2;
	private JButton close;
	private JButton saveClose;
	private JButton save;
	private JLabel lblMBnMi;
	private JTextField valueMaBG;
	
	private DanhMucLoaiBangGia danhMucLoaiBangGia;
	private loaiBangGiaBo loaiBangGiaBo = new loaiBangGiaBoJDBC(); 
	private JCheckBox valueMacDinh;
	private JTextField valueTenBG;

	/**
	 * Create the frame.
	 */
	public DanhMucLoaiBangGia_edit(DanhMucLoaiBangGia danhMucLoaiBangGia, String maBG) {
		this.danhMucLoaiBangGia = danhMucLoaiBangGia;
		
		setTitle("Bảng giá");
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
		
		JLabel lblNewLabel = new JLabel("Tên mới");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 66, 113, 27);
		banPhong2.add(lblNewLabel);
		
		lblMBnMi = new JLabel("Mã");
		lblMBnMi.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMBnMi.setBounds(10, 28, 113, 27);
		banPhong2.add(lblMBnMi);
		
		
		valueMaBG = new JTextField();
		valueMaBG.setText(maBG);
		valueMaBG.setEditable(false);
		valueMaBG.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueMaBG.setBounds(133, 28, 287, 25);
		banPhong2.add(valueMaBG);
		valueMaBG.setColumns(10);
		
		valueMacDinh = new JCheckBox("Mặc định");
		valueMacDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valueMacDinh.setBounds(133, 107, 287, 23);
		banPhong2.add(valueMacDinh);
		
		valueTenBG = new JTextField();
		valueTenBG.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueTenBG.setColumns(10);
		valueTenBG.setBounds(133, 66, 287, 25);
		banPhong2.add(valueTenBG);
		
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
		
		
		load();
		
		
		close.addActionListener(this);
		saveClose.addActionListener(this);
		save.addActionListener(this);
		valueMacDinh.addActionListener(this);
		setVisible(true);
		
		valueMacDinh.addItemListener(this);
	}
	
	/**
	 * Hàm dùng để đông bộ
	 */
	public void load() {
		List<loaiBangGia> resultt = loaiBangGiaBo.get(valueMaBG.getText());
		
		valueMacDinh.setSelected(resultt.get(0).getMacDinh() == 1 ? true : false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			update();
		}
		
		if(e.getSource() == saveClose) {
			update();
			this.dispose();
		}
		
		if(e.getSource() == close) {
			this.dispose();
		}
		
		danhMucLoaiBangGia.load_add();
		load();
	}
	
	public void update() {
		if(valueMaBG.getText().equals("") || valueTenBG.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn nhập thiếu dữ liệu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String resultData = loaiBangGiaBo.update(new loaiBangGia(valueMaBG.getText(), valueTenBG.getText(), valueMacDinh.isSelected() ? 1 : 0));
		JOptionPane.showMessageDialog(null, resultData);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == valueMacDinh) {
			
		}
	}
}
