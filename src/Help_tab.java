import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Help_tab implements ActionListener {
	
	static JFrame f;
	JLabel l,l1,mlabel,dlabel,dAlabel,ulabel,elabel;
	TextArea minfo,einfo,uinfo,dAinfo,dinfo;
	JButton contact;
	JPanel p,helpPanel,mp,dp,dAp,up,ep;
	
	
	void create_Help_tab(){
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		f=new JFrame();
		f.setLayout(null);
		ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
		f.setIconImage(icon.getImage());
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setAlwaysOnTop(true);
		f.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			//f1.setVisible(false);
    			MainFrame.frame.setVisible(true);
    			f.dispose();
    		}
    	});
		
		Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
		Font titlefont=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
		Font btnfont=new Font("Copperplate Gothic Bold",Font.PLAIN,20);
		Font infofont=new Font("",Font.HANGING_BASELINE,20);
		
		
		ImageIcon Icon1=new ImageIcon("C:/project_img/c1.png");
		final Image icon1=Icon1.getImage();
		ImageIcon Icon2=new ImageIcon("C:/project_img/c2.png");
		final Image icon2=Icon2.getImage();
		helpPanel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(icon1,50, 100, this);
				g.drawImage(icon2,1650, 50, this);
			}
		};
		helpPanel.setBounds(0, 0,d.width, d.height);		
		helpPanel.setBackground(Color.decode("#8FE0D5"));
		helpPanel.setLayout(null);
		helpPanel.setBorder(BorderFactory.createLineBorder(Color.black, 8));
		helpPanel.setVisible(true);
		f.add(helpPanel);
		

		l=new JLabel("Support Services");
		l.setBounds(720, 0,500,200);
		l.setFont(bigfont);		
		helpPanel.add(l);
		
		l1=new JLabel("Need Some Help?");
		l1.setBounds(840,70,500,200);
		l1.setFont(titlefont);		
		helpPanel.add(l1);
		
		contact=new JButton(" Contact US ");
		contact.setBounds(860,260,200,50);
		contact.setFont(btnfont);
		contact.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Contact_Us con=new Contact_Us();
				
				f.dispose();
				
			}
		});
		helpPanel.add(contact);
		
		
		
		
		

		ImageIcon mpIcon=new ImageIcon("C:/project_img/modelh.png");
		final Image mpicon=mpIcon.getImage();
		mp=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(mpicon,125, 15, this);
			}
		};
		//mp=new JPanel();
		mp.setBounds(10, 400, 350, 550);
		mp.setBackground(Color.decode("#ffffff"));
		mp.setLayout(null);
		mp.setVisible(true);
		
		mlabel=new JLabel("Model");
		mlabel.setBounds(130,130, 400, 30);
		mlabel.setFont(titlefont);
		mp.add(mlabel);
		
		minfo=new TextArea("\n   Write \n   Detailed Model");
		minfo.setBounds(-10,170,360,400);
		minfo.setEditable(false);
		minfo.setFont(infofont);
		mp.add(minfo);
		mp.setBorder(BorderFactory.createLineBorder(Color.black,5));
		helpPanel.add(mp);
		
		ImageIcon epIcon=new ImageIcon("C:/project_img/enquiryh.png");
		final Image epicon=epIcon.getImage();
		ep=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(epicon,125, 15, this);
			}
		};
		//ep=new JPanel();
		ep.setBounds(400, 400, 350, 550);
		ep.setBackground(Color.decode("#ffffff"));
		ep.setLayout(null);
		ep.setVisible(true);
		
		elabel=new JLabel("Enquiry_Form");
		elabel.setBounds(80,130, 400, 30);
		elabel.setFont(titlefont);
		ep.add(elabel);
		
		einfo=new TextArea("\n   Write \n   Detailed Enquiry");
		einfo.setBounds(-10,170,360,400);
		einfo.setEditable(false);
		einfo.setFont(infofont);
		ep.add(einfo);
		ep.setBorder(BorderFactory.createLineBorder(Color.black,5));
		helpPanel.add(ep);
		
		ImageIcon upIcon=new ImageIcon("C:/project_img/updateh.png");
		final Image upicon=upIcon.getImage();
		up=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(upicon,125, 15, this);
			}
		};
		//up=new JPanel();
		up.setBounds(785, 400, 350, 550);
		up.setBackground(Color.decode("#ffffff"));
		up.setLayout(null);
		up.setVisible(true);
		
		ulabel=new JLabel("Update");
		ulabel.setBounds(130,130, 400, 30);
		ulabel.setFont(titlefont);
		up.add(ulabel);
		
		uinfo=new TextArea("\n   Write \n   Detailed update");
		uinfo.setBounds(-10,170,360,400);
		uinfo.setEditable(false);
		uinfo.setFont(infofont);
		up.add(uinfo);
		up.setBorder(BorderFactory.createLineBorder(Color.black,5));
		helpPanel.add(up);
		
		ImageIcon dApIcon=new ImageIcon("C:/project_img/displayallh.png");
		final Image dApicon=dApIcon.getImage();
		dAp=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(dApicon,125, 15, this);
			}
		};
		//dAp=new JPanel();
		dAp.setBounds(1170, 400, 350, 550);
		dAp.setBackground(Color.decode("#ffffff"));
		dAp.setLayout(null);
		dAp.setVisible(true);
		
		dAlabel=new JLabel("Display All");
		dAlabel.setBounds(100,130, 400, 30);
		dAlabel.setFont(titlefont);
		dAp.add(dAlabel);
		
		dAinfo=new TextArea("\n   Write \n   Detailed DeleteAll");
		dAinfo.setBounds(-10,170,360,400);
		dAinfo.setEditable(false);
		dAinfo.setFont(infofont);
		dAp.add(dAinfo);
		dAp.setBorder(BorderFactory.createLineBorder(Color.black,5));
		helpPanel.add(dAp);
//		
		ImageIcon dpIcon=new ImageIcon("C:/project_img/deleteh.png");
		final Image dpicon=dpIcon.getImage();
		dp=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(dpicon,125, 15, this);
			}
		};
		//dp=new JPanel();
		dp.setBounds(1560, 400, 350, 550);
		dp.setBackground(Color.decode("#ffffff"));
		dp.setLayout(null);
		dp.setVisible(true);
		
		dlabel=new JLabel("Delete");
		dlabel.setBounds(130,130, 400, 30);
		dlabel.setFont(titlefont);
		dp.add(dlabel);
		
		dinfo=new TextArea("\n   Write \n   Detailed delete");
		dinfo.setBounds(-10,170,360,400);
		dinfo.setEditable(false);
		dinfo.setFont(infofont);
		dp.add(dinfo);
		dp.setBorder(BorderFactory.createLineBorder(Color.black,5));
		helpPanel.add(dp);
		
		
		
		
		
		
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//f.dispose();
		f.setVisible(true);
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Help_tab();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
