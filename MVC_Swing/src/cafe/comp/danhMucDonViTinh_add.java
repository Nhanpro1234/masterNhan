package cafe.comp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import cafe.bean.donViTinh;
import cafe.bo.donViTinhBo;
import cafe.bo.donViTinhBoJDBC;

public class DanhMucDonViTinh_add extends JFrame implements ActionListener{

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
	private JTextField valueMaDVT;
	
	private DanhMucDonViTinh danhMucDonViTinh;
	private JCheckBox valueMacDinh;
	private JTextField valueTenDVT;
	
	private donViTinhBo donViTinhBo = new donViTinhBoJDBC();

	/**
	 * Create the frame.
	 */
	public DanhMucDonViTinh_add(DanhMucDonViTinh danhMucDonViTinh) {
		this.danhMucDonViTinh = danhMucDonViTinh;
		
		setTitle("Đơn vị tính");
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
		
		JLabel lblNewLabel = new JLabel("Tên đơn vị tính");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 66, 101, 27);
		banPhong2.add(lblNewLabel);
		
		lblMBnMi = new JLabel("Mã mới ( viết chữ liền không dấu )");
		lblMBnMi.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMBnMi.setBounds(10, 28, 227, 27);
		banPhong2.add(lblMBnMi);
		
		
		valueMaDVT = new JTextField();
		valueMaDVT.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueMaDVT.setBounds(237, 28, 183, 25);
		banPhong2.add(valueMaDVT);
		valueMaDVT.setColumns(10);
		
		valueMacDinh = new JCheckBox("Mặc định");
		valueMacDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valueMacDinh.setBounds(335, 109, 85, 23);
		banPhong2.add(valueMacDinh);
		
		valueTenDVT = new JTextField();
		valueTenDVT.setFont(new Font("Dialog", Font.PLAIN, 15));
		valueTenDVT.setColumns(10);
		valueTenDVT.setBounds(121, 66, 299, 25);
		banPhong2.add(valueTenDVT);
		
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
		
		
		close.addActionListener(this);
		saveClose.addActionListener(this);
		save.addActionListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			add();
		}
		
		if(e.getSource() == saveClose) {
			add();
			this.dispose();
		}
		
		if(e.getSource() == close) {
			this.dispose();
		}
		
		danhMucDonViTinh.load_add();
	}
	
	public boolean checkRegexDVT() {
		String reGex = valueMaDVT.getText().toUpperCase();
		return reGex.matches("[A-Z]+");
	}
	
	public void add() {
		if(valueTenDVT.getText().equals("") || valueMaDVT.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn nhập thiếu dữ liệu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(checkRegexDVT()) {
			if(donViTinhBo.isMaDVT(valueMaDVT.getText())) {
				JOptionPane.showMessageDialog(null, "Mã này đã tồn tại ( hãy thử lại )", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}else {
				String result = donViTinhBo.add(new donViTinh(valueMaDVT.getText().toUpperCase(), valueTenDVT.getText(), valueMacDinh.isSelected() ? 1 : 0));
				JOptionPane.showMessageDialog(null, result, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Sai định dạng mã đơn vị tính", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
		}
	}
}
