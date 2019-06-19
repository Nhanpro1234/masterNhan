package cafe.comp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Midder extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel danhSachBan;
	private JButton banSo1;
	private JPanel khuVuc1;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;

	/**
	 * Create the frame.
	 */
	public Midder() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		danhSachBan = new JPanel();
		
		add(danhSachBan);
		danhSachBan.setLayout(new GridLayout(1, 2, 0, 0));
		
		khuVuc1 = new JPanel();
		khuVuc1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Khu v\u1EF1c b\u00ECnh th\u01B0\u1EDDng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		danhSachBan.add(khuVuc1);
		khuVuc1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		banSo1 = new JButton("Bàn số 1");
		khuVuc1.add(banSo1);
		banSo1.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		banSo1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		banSo1.setHorizontalTextPosition(JButton.CENTER);
		banSo1.setVerticalTextPosition(JButton.BOTTOM);
		
		button_5 = new JButton("Bàn số 1");
		button_5.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button_5);
		
		button_4 = new JButton("Bàn số 1");
		button_4.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button_4);
		
		button_3 = new JButton("Bàn số 1");
		button_3.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button_3);
		
		button_2 = new JButton("Bàn số 1");
		button_2.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button_2);
		
		button_1 = new JButton("Bàn số 1");
		button_1.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button_1);
		
		button = new JButton("Bàn số 1");
		button.setIcon(new ImageIcon("image\\coffee-not-use.png"));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		khuVuc1.add(button);
		
		panel = new JPanel();
		danhSachBan.add(panel);
	}

}
