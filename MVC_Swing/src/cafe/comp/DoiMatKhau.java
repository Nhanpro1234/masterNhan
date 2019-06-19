package cafe.comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import cafe.bean.taiKhoan;
import cafe.bo.taiKhoanBoJDBC;

public class DoiMatKhau extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel textPassNew;
	private JLabel textPassOld;
	private JLabel textPassReNew;
	private JTextField valueUser;
	private JPasswordField valuePassOld;
	private JPasswordField valueRePassNew;
	private JPasswordField valuePassNew;
	private JButton btnHuy;
	private JButton btnDongY;
	private taiKhoanBoJDBC taiKhoanBo = new taiKhoanBoJDBC();
	private Head2_heThong Head2_heThong;

	public DoiMatKhau(String user,Head2_heThong Head2_heThong) {
		this.Head2_heThong = Head2_heThong;
		setTitle("Đổi mật khẩu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 378, 219);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		valueUser = new JTextField(user);
		valueUser.setVisible(false);
		valueUser.setBounds(5, 82, 352, 29);
		valueUser.setEditable(false);
		valueUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(valueUser);
		valueUser.setColumns(10);

		textPassOld = new JLabel("Mật khẩu cũ ( * )");
		textPassOld.setBounds(5, 11, 176, 29);
		textPassOld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textPassOld);

		valuePassOld = new JPasswordField();
		valuePassOld.setBounds(181, 11, 176, 29);
		valuePassOld.requestFocus();
		valuePassOld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(valuePassOld);
		valuePassOld.setColumns(10);

		textPassNew = new JLabel("Mật khẩu mới ( * )");
		textPassNew.setBounds(5, 58, 176, 29);
		textPassNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textPassNew);

		valuePassNew = new JPasswordField();
		valuePassNew.setBounds(181, 58, 176, 29);
		valuePassNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valuePassNew.setColumns(10);
		contentPane.add(valuePassNew);

		textPassReNew = new JLabel("Nhập lại mật khẩu mới ( * )");
		textPassReNew.setBounds(5, 105, 176, 29);
		textPassReNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textPassReNew);

		valueRePassNew = new JPasswordField();
		valueRePassNew.setBounds(181, 105, 176, 29);
		valueRePassNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(valueRePassNew);
		valueRePassNew.setColumns(10);

		btnHuy = new JButton("");
		btnHuy.setBounds(181, 145, 82, 29);
		btnHuy.setIcon(new ImageIcon("image\\cancel.png"));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnHuy);

		btnDongY = new JButton("");
		btnDongY.setBounds(275, 145, 82, 29);
		btnDongY.setIcon(new ImageIcon("image\\confirm.png"));
		btnDongY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnDongY);

		btnHuy.addActionListener(this);
		btnDongY.addActionListener(this);

		valueRePassNew.addKeyListener(this);
		valuePassNew.addKeyListener(this);
		valuePassOld.addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHuy) {
			Head2_heThong.setEnabled(true);
			this.dispose();
		}

		if(e.getSource() == btnDongY){
			changePass();
		}
	}

	/**
	 * Hà dùng để kiểm tra mật khẩu cũ và đổi mật khẩu nếu thông tin trên nhập đúng
	 */
	public void changePass() {
		if(!valueUser.getText().equals("")) {
			if(String.valueOf(valueRePassNew.getPassword()).equals(String.valueOf(valuePassNew.getPassword()))) {
				if(taiKhoanBo.isDangNhap(valueUser.getText(), String.valueOf(valuePassOld.getPassword()))) {
					JOptionPane.showMessageDialog(null, taiKhoanBo.update(new taiKhoan(valueUser.getText(), String.valueOf(valuePassNew.getPassword()), "")));
				}else {
					JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không đúng", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Lỗi user trống", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			changePass();
		}
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
