import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainFrame implements ActionListener {
	
	static JFrame frame;
	JPanel westpanel,northpanel,southpanel,centrepanel;
	JButton model,enquiry,update,displayAll,delete,help,logout;
	
	MainFrame(){
	
	

	frame=new JFrame("EV-Bikes Showroom");
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
	frame.setIconImage(icon.getImage());
	frame.setLayout(null);
	
	frame.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			int val=JOptionPane.showConfirmDialog(frame,"Do You want to Close this Session ?","QuestionMessage",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(val==0)
			{
				login l=new login();
				l.create_login();
	            frame.setVisible(false);
			}
		}
	});
	
	Font font=new Font("Copperplate Gothic Bold",Font.PLAIN,30);
	Font fontt=new Font("",Font.BOLD,17);
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	/*System.out.println("height"+d.height);
	System.out.println("widht"+d.width);*/

	
			ImageIcon LogoIcon=new ImageIcon("C:/project_img/logo.png");
			final Image logoicon=LogoIcon.getImage();
			westpanel=new JPanel(){
				protected void paintComponent(Graphics g){
					super.paintComponent(g);
					g.drawImage(logoicon,90, 15, this);
				}
			};
			westpanel.setBounds(0, 0, 350, 1030);		
			westpanel.setBackground(Color.decode("#a8642a"));
			westpanel.setLayout(null);
			westpanel.setVisible(true);
		//	westpanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			frame.add(westpanel);
			
			ImageIcon modelicon=new ImageIcon("C:/project_img/model.png");
			model=new JButton("Model                 ",modelicon);
			model.setBorder(null);
			model.setBackground(Color.decode("#a8642a"));
			model.setBounds(0, 180, 350, 80);
			model.setFont(font);
			model.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Model_tab app = new Model_tab();
		            app.createAndShowGUI();
		            frame.setVisible(false);
		           
				}
			});
			westpanel.add(model); 
			
			ImageIcon enquiryicon=new ImageIcon("C:/project_img/enquiry.png");
			enquiry=new JButton(" Enquiry Form",enquiryicon);
			enquiry.setBorder(null);
			enquiry.setBackground(Color.decode("#a8642a"));
			enquiry.setBounds(0, 260, 350, 80);
			enquiry.setFont(font);
			enquiry.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Enquiry_form a1=new Enquiry_form();
					a1.create_Enquiry_form();
					frame.setVisible(false);
		           
				}
			});
 
 			westpanel.add(enquiry);
 
		
			ImageIcon updateicon=new ImageIcon("C:/project_img/update.png");
			update=new JButton(" Update               ",updateicon);
			update.setBorder(null);
			update.setBackground(Color.decode("#a8642a"));
			update.setBounds(0,340, 350, 80);
			update.setFont(font);
			update.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Update_form a1=new Update_form ();
					a1.create_Update_form ();
					frame.setVisible(false);
		           
				}
			});
			westpanel.add(update);
			
			ImageIcon displayAllicon=new ImageIcon("C:/project_img/list.png");
			displayAll=new JButton(" Display All      ",displayAllicon);
			displayAll.setBorder(null);
			displayAll.setBackground(Color.decode("#a8642a"));
			displayAll.setBounds(0,410, 350, 80);
			displayAll.setFont(font);
			displayAll.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DisplayAll a5 = new DisplayAll();
		            a5.create_DisplayAll();
		
		           
				}
			});
			westpanel.add(displayAll);
			
			ImageIcon deleteicon=new ImageIcon("C:/project_img/delete.png");
			delete=new JButton(" Delete                 ",deleteicon);
			delete.setBorder(null);
			delete.setBackground(Color.decode("#a8642a"));
			delete.setBounds(0,480, 350, 80);
			delete.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Delete_form a4 = new Delete_form();
		            a4.create_Delete_form();
		            frame.setVisible(false);
		           
				}
			});
			delete.setFont(font);
			
			westpanel.add(delete);
			
			
			ImageIcon helpicon=new ImageIcon("C:/project_img/help.png");
			help=new JButton(" Help                     ",helpicon);
			help.setBorder(null);
			help.setBackground(Color.decode("#a8642a"));
			help.setBounds(0,550, 350, 80);
			help.setFont(font);
			help.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Help_tab a6 = new Help_tab();
		            a6.create_Help_tab();
		            frame.setVisible(false);
		           
				}
			});
			westpanel.add(help);
			
			ImageIcon logouticon=new ImageIcon("C:/project_img/logout.png");
			logout=new JButton(" Logout                 ",logouticon);
			logout.setBorder(null);
			logout.setBackground(Color.decode("#a8642a"));
			logout.setBounds(0,910, 350, 80);
			logout.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int val=JOptionPane.showConfirmDialog(frame,"Do You Want To LOGOUT ?","QuestionMessage",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(val==0)
					{
						login l=new login();
						l.create_login();
			            frame.setVisible(false);
					}
		           
				}
			});
			logout.setFont(font);
			
			westpanel.add(logout);
			
			
			ImageIcon BannerIcon=new ImageIcon("C:/project_img/banner.png");
			final Image bannericon=BannerIcon.getImage();
			northpanel=new JPanel(){
				protected void paintComponent(Graphics g){
					super.paintComponent(g);
					g.drawImage(bannericon,130,0 , this);
				}
			};
			northpanel.setBounds(350, 0,d.width, 170);
			northpanel.setBackground(Color.decode("#f6923d"));
			//northpanel.setBorder(BorderFactory.createLineBorder(Color.black,5));
			northpanel.setLayout(null);
			northpanel.setVisible(true);
			frame.add(northpanel);
			
			final String copyright="Copyright  2023  Designed  By  MRND  Labs";
			southpanel=new JPanel(){
				protected void paintComponent(Graphics g){
					super.paintComponent(g);
					g.drawString(copyright,50, 30);
				}
			};
			southpanel.setBounds(0, 1030,d.width,d.height );		
			southpanel.setBackground(Color.decode("#000"));
			southpanel.setLayout(null);
			southpanel.setVisible(true);
			frame.add(southpanel);
			
			ImageIcon gifIcon=new ImageIcon("C:/project_img/test.jpg");
			final Image Gificon=gifIcon.getImage();
			centrepanel=new JPanel(){
				protected void paintComponent(Graphics g){
					super.paintComponent(g);
					g.drawImage(Gificon,0,0 , this);
				}
			};
			centrepanel.setBounds(350,170, d.width,d.height);		
			centrepanel.setBackground(Color.decode("#ffd9b8"));
			centrepanel.setLayout(null);
			centrepanel.setVisible(true);
			//centrepanel.add(label);
			centrepanel.setBorder(BorderFactory.createLineBorder(Color.black,10));
			frame.add(centrepanel);
			
			
			
	
		//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			/*frame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					login l=new login();
					l.create_login();
					int val=JOptionPane.showConfirmDialog(frame,"By Pressing OK you will LOGOUT Automatically..","QuestionMessage",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(val==1)
					{
			            //MainFrame mf=new MainFrame();
					}
				}
			});*/
			
			//frame.setUndecorated(true);
			//frame.setAlwaysOnTop(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		MainFrame mf=new MainFrame();
		}



/*	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

*/


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
