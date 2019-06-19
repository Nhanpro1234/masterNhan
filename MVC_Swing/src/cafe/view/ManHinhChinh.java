package cafe.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import cafe.comp.Footer;
import cafe.comp.HeadAll;
import cafe.comp.SanPham;

public class ManHinhChinh extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Footer footer;
	private HeadAll headAll;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public ManHinhChinh(String SESSION_LOGIN) {
		setAutoRequestFocus(false);
		setTitle("BÀN LÀM VIỆC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		footer = new Footer(SESSION_LOGIN);
		headAll = new HeadAll(SESSION_LOGIN, this);


		contentPane.add(headAll, BorderLayout.NORTH);
		contentPane.add(footer, BorderLayout.SOUTH);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		SanPham sanPham = new SanPham(this);
		tabbedPane.addTab("Sản phẩm", sanPham);
		//tabbedPane.addTab("New tab ( X )", null, panel, null);

		setVisible(true);
	}


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

}
