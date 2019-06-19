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

public class BoPhanAdd extends JFrame implements ActionListener {

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
	private String maCha;
	private boPhanBo boPhanBo = new boPhanBoJDBC();

	/**
	 * Create the frame.
	 */
	public BoPhanAdd(NhanVien NhanVien) {
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
		
		lblNewLabel = new JLabel("Tên mới");
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
	 * Get mã nhóm để làm mã cha @@ :V :V :V :V
	 */
	public void load() {
		String data = NhanVien.getTree().getSelectionPath().getLastPathComponent().toString();
		path.setText(data);
		
		if(path.getText().equals("Bộ phận")) {
			maCha = null;
		}else {
			String[] get_maNhom = path.getText().split(":");
			maCha = get_maNhom[0];
		}
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
		
		List<boPhan> list = boPhanBo.get();
		Collections.sort(list, new boPhan());
		
		String maBP = null;
		if(list.isEmpty()) {
			maBP = "BP_1";
		}else {
			String[] getMaBP = list.get(list.size() - 1).getMaBP().split("_");
			
			maBP = getMaBP[0] + "_" + (Integer.parseInt(getMaBP[1]) + 1);
		}
		
		String msg = boPhanBo.add(new boPhan(maBP, this.maCha, tenBP.getText()));
		JOptionPane.showMessageDialog(null, msg);
		
		NhanVien.loadTree();
		
		if(type == 1) {
			this.dispose();
		}
	}
	
}
