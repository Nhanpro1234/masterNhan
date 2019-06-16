package cafe.comp;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import cafe.view._manHinhChinh;

public class headAll extends JPanel implements ActionListener{

	private head head;
	private head2 head2;
	private head2_macDinh head2_macDinh;
	private head2_chucNang head2_chucNang;
	private head2_heThong head2_heThong;
	
	final static String MD = "md";
	final static String CN = "cn";
	final static String HT = "ht";
	
	public headAll(String user, _manHinhChinh _manHinhChinh) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		head = new head();
		head2 = new head2();
		add(head);
		add(head2);
		
		head2_macDinh = new head2_macDinh(user, _manHinhChinh);
		head2_chucNang = new head2_chucNang(user, _manHinhChinh);
		head2_heThong = new head2_heThong(user, _manHinhChinh);
		
		head2.add(head2_macDinh, MD);
		head2.add(head2_chucNang, CN);
		head2.add(head2_heThong, HT);

		head.getBtnChucNang().addActionListener(this);
		head.getBtnHeThong().addActionListener(this);
		head.getBtnTroGiup().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == head.getBtnChucNang()) {
			CardLayout cl = (CardLayout)head2.getLayout();
			cl.show(head2, CN);
		}
		
		if(e.getSource() == head.getBtnHeThong()) {
			CardLayout cl = (CardLayout)head2.getLayout();
			cl.show(head2, HT);
		}
		
		if(e.getSource() == head.getBtnTroGiup()) {
			CardLayout cl = (CardLayout)head2.getLayout();
			cl.show(head2, MD);
		}
	}
	

}
