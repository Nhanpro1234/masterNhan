package cafe.comp;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class head extends JPanel {

	private JButton btnHeThong, btnChucNang, btnTroGiup;
	
	public head() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnHeThong = new JButton("Hệ thống");
		btnHeThong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnHeThong);

		btnChucNang = new JButton("Chức năng");
		btnChucNang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnChucNang);

		btnTroGiup = new JButton("Trợ giúp");
		btnTroGiup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnTroGiup);
	}

	public JButton getBtnHeThong() {
		return btnHeThong;
	}

	public JButton getBtnChucNang() {
		return btnChucNang;
	}

	public JButton getBtnTroGiup() {
		return btnTroGiup;
	}

}
