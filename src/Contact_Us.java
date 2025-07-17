import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Contact_Us {
	
	Contact_Us(){
		
		final JFrame f;
		JLabel l,l1,addlabel,phonelabel,emaillabel;
		TextArea t1,t2,t3;
		JPanel contact,phone,email,address;
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
		Font titlefont=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
		Font btnfont=new Font("Copperplate Gothic Bold",Font.PLAIN,20);
		Font infofont=new Font("",Font.HANGING_BASELINE,10);
		
		f=new JFrame();
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setBounds(0,0, d.width, d.height);
		ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
		f.setIconImage(icon.getImage());
		f.setAlwaysOnTop(true);
		f.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			//f1.setVisible(false);
    			Help_tab.f.setVisible(true);
    			f.dispose();
    		}
    	});
		
		ImageIcon Icon1=new ImageIcon("C:/project_img/c1.png");
		final Image icon1=Icon1.getImage();
		ImageIcon Icon2=new ImageIcon("C:/project_img/c2.png");
		final Image icon2=Icon2.getImage();
		contact=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(icon1,50, 105, this);
				g.drawImage(icon2,1650, 50, this);
			}
		};
		contact.setBounds(0, 0,d.width, d.height);		
		contact.setBackground(Color.decode("#8FE0D5"));
		contact.setLayout(null);
		contact.setBorder(BorderFactory.createLineBorder(Color.black, 8));
		contact.setVisible(true);
		f.add(contact);
		
		l=new JLabel("Contact Us");
		l.setBounds(800, 0,500,200);
		l.setFont(bigfont);		
		contact.add(l);
		
		l1=new JLabel("Get in Touch");
		l1.setBounds(890,70,500,200);
		l1.setFont(btnfont);		
		contact.add(l1);
		
		
		ImageIcon addIcon=new ImageIcon("C:/project_img/address.png");
		final Image addicon=addIcon.getImage();
		address=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(addicon,130, 30, this);
			}
		};
		//address=new JPanel();
		address.setBounds(380, 300, 350, 600);
		address.setBackground(Color.decode("#ffffff"));
		address.setLayout(null);
		address.setVisible(true);
		
		addlabel=new JLabel("Address");
		addlabel.setBounds(110,150, 400, 30);
		addlabel.setFont(titlefont);
		address.add(addlabel);
		
		t1=new TextArea("\n   Write \n   Detailed Address");
		t1.setBounds(-10,200,400,630);
		t1.setEditable(false);
		t1.setFont(titlefont);
		address.add(t1);
		
		contact.add(address);
		
		
		ImageIcon phoneIcon=new ImageIcon("C:/project_img/phone.png");
		final Image phoneicon=phoneIcon.getImage();
		phone=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(phoneicon,105, 20, this);
			}
		};
		//address=new JPanel();
		phone.setBounds(790, 300, 350, 600);
		phone.setBackground(Color.decode("#ffffff"));
		phone.setLayout(null);
		phone.setVisible(true);
		
		phonelabel=new JLabel("Phone");
		phonelabel.setBounds(120,150, 400, 30);
		phonelabel.setFont(titlefont);
		phone.add(phonelabel);
		
		t2=new TextArea("\n   Write \n   Detailed Phone Number");
		t2.setBounds(-10,200,400,630);
		t2.setEditable(false);
		t2.setFont(titlefont);
		phone.add(t2);
		
		contact.add(phone);
		
		ImageIcon emailIcon=new ImageIcon("C:/project_img/email.png");
		final Image emailicon=emailIcon.getImage();
		email=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(emailicon,105, 10, this);
			}
		};
		//address=new JPanel();
		email.setBounds(1200, 300, 350, 600);
		email.setBackground(Color.decode("#ffffff"));
		email.setLayout(null);
		email.setVisible(true);
		
		emaillabel=new JLabel("E-mail");
		emaillabel.setBounds(130,150, 400, 30);
		emaillabel.setFont(titlefont);
		email.add(emaillabel);
		
		t3=new TextArea("\n   Write \n   Detailed Email");
		t3.setBounds(-10,200,400,630);
		t3.setEditable(false);
		t3.setFont(titlefont);
		email.add(t3);
		
		contact.add(email);
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		f.dispose();
		f.setVisible(true);
	}


}
