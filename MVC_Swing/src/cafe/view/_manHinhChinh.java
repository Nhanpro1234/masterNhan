package cafe.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import cafe.comp.*;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;

public class _manHinhChinh extends JFrame{

	private JPanel contentPane;
	private footer footer;
	private headAll headAll;
	private JTabbedPane tabbedPane;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public _manHinhChinh(String SESSION_LOGIN) {
		setAutoRequestFocus(false);
		setTitle("BÀN LÀM VIỆC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		footer = new footer(SESSION_LOGIN);
		headAll = new headAll(SESSION_LOGIN, this);


		contentPane.add(headAll, BorderLayout.NORTH);
		contentPane.add(footer, BorderLayout.SOUTH);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		//tabbedPane.addTab("New tab ( X )", null, panel, null);

		setVisible(true);
	}


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


}
