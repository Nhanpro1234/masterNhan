package cafe.comp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cafe.bean.boPhan;
import cafe.bo.boPhanBo;
import cafe.bo.boPhanBoJDBC;

public class BoPhanEdit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField path;
	private JLabel lblNewLabel;
	private JTextField tenBP;
	private JButton close;
	private JButton saveClose;
	private JButton save;
	private NhanVien NhanVien;
	private String maBP;
	private String maCha;
	private boPhanBo boPhanBo = new boPhanBoJDBC();

	/**
	 * Create the frame.
	 */
	public BoPhanEdit(NhanVien NhanVien) {
		this.NhanVien = NhanVien;
		setTitle("Thêm bộ phận");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 376, 172);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		path = new JTextField();
		path.setEditable(false);
		path.setFont(new Font("Tahoma", Font.PLAIN, 14));
		path.setBounds(10, 11, 341, 29);
		contentPane.add(path);
		path.setColumns(10);
		
		lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 51, 63, 29);
		contentPane.add(lblNewLabel);
		
		tenBP = new JTextField();
		tenBP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenBP.setBounds(83, 51, 268, 29);
		contentPane.add(tenBP);
		tenBP.setColumns(10);
		
		close = new JButton("Đóng");
		close.addActionListener(this);
		close.setFont(new Font("Tahoma", Font.PLAIN, 13));
		close.setBounds(10, 91, 107, 35);
		contentPane.add(close);
		
		saveClose = new JButton("Thêm & đóng");
		saveClose.addActionListener(this);
		saveClose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		saveClose.setBounds(127, 91, 107, 35);
		contentPane.add(saveClose);
		
		save = new JButton("Thêm");
		save.addActionListener(this);
		save.setFont(new Font("Tahoma", Font.PLAIN, 13));
		save.setBounds(244, 91, 107, 35);
		contentPane.add(save);
		
		load();
	}
	
	/**
	 * Get mã nhóm + cha để sửa tên @@
	 */
	public void load() {
		path.setText(NhanVien.getTree().getSelectionPath().getLastPathComponent().toString());
		String[] data = NhanVien.getTree().getSelectionPath().getLastPathComponent().toString().split(":");
		this.maBP = data[0];
		
		List<boPhan> list = boPhanBo.get(this.maBP);
		this.maCha = list.get(0).getMaCha();
		tenBP.setText(list.get(0).getTenBP());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			add(0);
		}
		
		if(e.getSource() == saveClose) {
			add(1);
		}
		
		if(e.getSource() == close) {
			this.dispose();
		}
	}
	
	public void add(int type) {
		if(path.getText().equals("") || tenBP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Thiếu dữ liệu");
			return;
		}
		
		String msg = boPhanBo.update(new boPhan(this.maBP, this.maCha, tenBP.getText()));
		JOptionPane.showMessageDialog(null, msg);
		
		NhanVien.loadTree();
		
		if(type == 1) {
			this.dispose();
		}
		
		load();
	}
	
}
