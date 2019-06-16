package cafe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.*;

import cafe.bean.taiKhoan;
import cafe.bo.nhanVienBo;
import cafe.bo.nhanVienBoJDBC;
import cafe.bo.taiKhoanBoJDBC;
import javafx.scene.image.Image;

import java.awt.*;

public class _dangNhap extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField valueUser;
	private JPasswordField valuePass;
	private JButton btnLogin;
	private cafe.bo.taiKhoanBo taiKhoanBo = new taiKhoanBoJDBC();;
	public static String online;
	private JLabel lblNewLabel;
	private JButton exit;
	private JLabel valueVesion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_dangNhap frame = new _dangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public _dangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 405);
		setLocationRelativeTo(null);
		setUndecorated(true);
		//setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		valueUser = new JTextField();
		valueUser.setForeground(Color.WHITE);
		valueUser.setOpaque(false);
		valueUser.setBorder(null);
		valueUser.setBounds(217, 143, 191, 31);
		contentPane.add(valueUser);
		valueUser.setText("admin");
		valueUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valueUser.setColumns(10);
		
		valuePass = new JPasswordField();
		valuePass.setForeground(Color.WHITE);
		valuePass.setOpaque(false);
		valuePass.setBorder(null);
		valuePass.setBounds(217, 200, 191, 29);
		contentPane.add(valuePass);
		valuePass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valuePass.setColumns(10);
		
		btnLogin = new JButton("Truy cập");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\login.png"));
		btnLogin.setBounds(287, 240, 151, 31);
		contentPane.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		exit = new JButton("");
		exit.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\cancel.png"));
		exit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exit.setBounds(213, 240, 64, 31);
		contentPane.add(exit);
		
		valueVesion = new JLabel("Version: 1.0.0.0");
		valueVesion.setHorizontalAlignment(SwingConstants.RIGHT);
		valueVesion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		valueVesion.setBounds(10, 383, 629, 21);
		valueVesion.setForeground(Color.WHITE);
		contentPane.add(valueVesion);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NHANPC2000\\eclipse-workspace\\MVC_Swing\\image\\cafe-login.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 404);
		contentPane.add(lblNewLabel);
		
		btnLogin.addActionListener(this);
		
		
		btnLogin.addKeyListener(this);
		valuePass.addKeyListener(this);
		valueUser.addKeyListener(this);
		exit.addActionListener(this);
		
		
		isAdmin();
	}

	
	
	public void login() {
		try {
			if(taiKhoanBo.isDangNhap(this.valueUser.getText(), String.valueOf(this.valuePass.getPassword()))) {
				_manHinhChinh _manHinhChinh = new _manHinhChinh(this.valueUser.getText());
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai @@");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 404 - Exit");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin) {
			login();
		}
		
		if(e.getSource() == exit) {
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			login();
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void isAdmin() {
		if(!taiKhoanBo.isTaiKhoan("admin")) {
			taiKhoanBo.add(new taiKhoan("admin", "", ""));
		}
	}
}
