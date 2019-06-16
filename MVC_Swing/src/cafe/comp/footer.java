package cafe.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import cafe.view._dangNhap;
import java.awt.FlowLayout;

public class footer extends JPanel {

	private JLabel textUserUse;
	private JLabel valueUserUse;
	private JLabel valueThoiGian;
	private JPanel footer1;
	private JPanel footer1_1;
	private JPanel footer1_2;
	
	/**
	 * Create the panel.
	 */
	public footer(String user) {
		setBackground(new Color(135, 206, 250));
		in(user);
	}
	
	public void in(String user) {
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(Color.black);
		
		footer1 = new JPanel();
		footer1.setBackground(new Color(135, 206, 250));
		add(footer1);
		footer1.setLayout(new GridLayout(1, 2, 0, 0));
		
		footer1_1 = new JPanel();
		footer1_1.setBackground(new Color(135, 206, 250));
		FlowLayout flowLayout = (FlowLayout) footer1_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		footer1.add(footer1_1);
		textUserUse = new JLabel("Tài khoản:");
		footer1_1.add(textUserUse);
		textUserUse.setBackground(Color.PINK);
		textUserUse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		valueUserUse = new JLabel(user);
		footer1_1.add(valueUserUse);
		valueUserUse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		footer1_2 = new JPanel();
		footer1_2.setBackground(new Color(135, 206, 250));
		FlowLayout flowLayout_1 = (FlowLayout) footer1_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		footer1.add(footer1_2);
		
		valueThoiGian = new JLabel("admin");
		footer1_2.add(valueThoiGian);
		valueThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		Timer timer = new Timer(1000, new java.awt.event.ActionListener()
		{
		    public void actionPerformed(java.awt.event.ActionEvent e)
		    {
		    	Date myDate = new Date();
		    	valueThoiGian.setText(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(myDate).toString());
		    }
		});
		timer.start();
	}
}
