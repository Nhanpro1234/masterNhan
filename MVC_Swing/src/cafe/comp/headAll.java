package cafe.comp;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import cafe.view.ManHinhChinh;

public class HeadAll extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Head head;
	private Head2 head2;
	private Head2_macDinh head2_macDinh;
	private Head2_chucNang head2_chucNang;
	private Head2_heThong head2_heThong;
	
	final static String MD = "md";
	final static String CN = "cn";
	final static String HT = "ht";
	
	public HeadAll(String user, ManHinhChinh _manHinhChinh) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		head = new Head();
		head2 = new Head2();
		add(head);
		add(head2);
		
		head2_macDinh = new Head2_macDinh(user, _manHinhChinh);
		head2_chucNang = new Head2_chucNang(user, _manHinhChinh);
		head2_heThong = new Head2_heThong(user, _manHinhChinh);
		
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
