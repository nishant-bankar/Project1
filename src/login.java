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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login implements ActionListener{
	
	static JFrame f=new JFrame("Login Page");;
	JLabel l1,l2,i1,i2;
	JTextField t1;
	JPasswordField t2;
	JButton login,cancel;
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	Font font=new Font("Copperplate Gothic Bold",Font.PLAIN,30);
	Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
	Font fontt=new Font("",Font.BOLD,17);
	Font fonts=new Font("Copperplate Gothic Bold",Font.BOLD,17);

	public void create_login()
	{
		//System.out.println("width:"+d.width+"\nheight:"+d.height);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
		f.setIconImage(icon.getImage());
		f.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			System.exit(0);
    		}
    	});
	
		ImageIcon BannerIcon=new ImageIcon("C:/project_img/login2.jpg");
		final Image bannericon=BannerIcon.getImage();
		
		JPanel p=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(bannericon,0,0 , this);
				//g.drawImage(uicon,500,100,this);
			}
		};
		p.setBounds(0,0,d.width,d.height);		
		p.setBackground(Color.decode("#8FE0D5"));
		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(Color.white, 50));
		p.setVisible(true);
		
		
		l1=new JLabel("UserName  :");
		l1.setBounds(710,510,250,35);
		l1.setForeground(Color.WHITE);
		l1.setFont(font);
		p.add(l1);
		
		t1=new JTextField();
		t1.setBounds(930,510,250,40);
		t1.addActionListener(this);
		t1.setFont(fontt);
		p.add(t1);
		
		l2=new JLabel("Password  :");
		l2.setBounds(710,590,250,35);
		l2.setFont(font);
		l2.setForeground(Color.WHITE);
		p.add(l2);
		
		t2=new JPasswordField();
		t2.setBounds(930,590,250,40);
		t2.addActionListener(this);
		t2.setFont(fontt);
		p.add(t2);
		
		login =new JButton("Login");
		login.setBounds(790,670,130,40);
		login.addActionListener(this);
		login.setFont(fonts);
		p.add(login);
		
		cancel =new JButton("Cancel");
		cancel.setBounds(980,670,130,40);
		cancel.addActionListener(this);
		cancel.setFont(fonts);
		p.add(cancel);
		
	
	
	f.add(p);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login l=new login();
		l.create_login();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login)
		{
			
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(f,"Mandatory Fields are invalid...","MessageBox",JOptionPane.ERROR_MESSAGE);
			}
			else{
					if(t1.getText().equals("admin"))
					{
							if(t2.getText().equals("admin@123"))
							{
								MainFrame m=new MainFrame();
								f.setVisible(false);
							}
							else
							{
								t2.setText("");
								JOptionPane.showMessageDialog(f,"Invalid Password","message",JOptionPane.ERROR_MESSAGE);
							}	
						
					}else if(t1.getText().equals("staff"))
					{
						if(t2.getText().equals("staff@123"))
						{
							MainFrame m=new MainFrame();
							f.dispose();
						}
						else
						{
							t2.setText("");
							JOptionPane.showMessageDialog(f,"Invalid Password","message",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						t1.setText("");
						t2.setText("");
						JOptionPane.showMessageDialog(f,"Invalid Username","message",JOptionPane.ERROR_MESSAGE);
					}
				}
		}
		else if(e.getSource()==cancel){
			int val=JOptionPane.showConfirmDialog(f,"Do You Want To Close ?","QuestionMessage",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(val==0)
			{
				//MainFrame mf=new MainFrame();
				f.dispose();
			}
		}
		
	}

}
