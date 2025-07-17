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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*<Applet width=800 height=800>*/

public class Enquiry_form implements ActionListener{
	
	JButton b1,b2,upload,cancel;
	JCheckBox c;
	JLabel l1,l2,l3,l4,l5,l6,budget,model,payment,heading;
	JTextField t1,t2,t3,t4,t6;
	TextArea t5;
	JRadioButton br1,br2,br3,mr1,mr2,pr1,pr2,pr3;
	ButtonGroup br,mr,pr;
	static JFrame f=new JFrame("Enquiry Form");
	//static String email;
	//static String status;
	
	Random ra=new Random();
    int id=ra.nextInt(1000);
//	static String rows[][]=new String[200][9];
	static int row=0;
	static int flag=0;
	//private static int id=DisplayAll.row+2;
    
    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	Font font=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
	Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
	Font fontt=new Font("",Font.BOLD,17);
	Font fonts=new Font("Copperplate Gothic Bold",Font.BOLD,17);
	Date cdate=new Date();  //date object to hold current date generated through Date()
	
	
  //SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM//yy HH:mm:ss");
  		//Create SimpleDateFormat object with desired date format 
  		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM//yy");  
  		String date=dateFormat.format(cdate); //Convert Date Object to String
  			public void create_Enquiry_form(){
				f.setLayout(null);
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				//f.setResizable(false);
				f.setLocationRelativeTo(null);
				ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
				f.setIconImage(icon.getImage());
				//f.setAlwaysOnTop(true);
				//f.setUndecorated(true);				
				f.addWindowListener(new WindowAdapter()
		    	{
		    		public void windowClosing(WindowEvent e)
		    		{
		    			MainFrame.frame.setVisible(true);
		    			f.dispose();
		    			//System.exit(0);
		    		}
		    	});
				
				ImageIcon BannerIcon=new ImageIcon("C:/project_img/bgimg2.jpg");
				final Image bannericon=BannerIcon.getImage();
				JPanel p=new JPanel(){
					protected void paintComponent(Graphics g){
						super.paintComponent(g);
						g.drawImage(bannericon,0,0 , this);
					}
				};
				p.setBounds(0,0,d.width,d.height);		
				p.setBackground(Color.decode("#8FE0D5"));
				p.setLayout(null);
				p.setBorder(BorderFactory.createLineBorder(Color.black, 5));
				p.setVisible(true);
				
				
				//budget Radio Button
				br1=new JRadioButton("50k-80k");
				br1.setBounds(300,490,150,40);
				br1.setFont(fontt);
				br1.setBackground(Color.white);

				br2=new JRadioButton("80k-1 Lakh");
				br2.setBounds(300,530,150,40);
				br2.setFont(fontt);
				br2.setBackground(Color.white);
				
				br3=new JRadioButton("1 Lakh & Above");
				br3.setBounds(300,570,150,40);
				br3.setFont(fontt);
				br3.setBackground(Color.white);

				br=new ButtonGroup();
				br.add(br1);
				br.add(br2);
				br.add(br3);
				
				//model speed Radio Button
				mr1=new JRadioButton("High Speed");
				mr1.setBounds(300,640,150,40);
				mr1.setFont(fontt);
				mr1.setBackground(Color.white);

				mr2=new JRadioButton("Low Speed");
				mr2.setBounds(300,680,150,40);
				mr2.setFont(fontt);
				mr2.setBackground(Color.white);
				
				mr=new ButtonGroup();
				mr.add(mr1);
				mr.add(mr2);
				
				//payment Method Radio Button
				pr1=new JRadioButton("Cash");
				pr1.setBounds(300,750,150,40);
				pr1.setFont(fontt);
				pr1.setBackground(Color.white);

				pr2=new JRadioButton("EMI");
				pr2.setBounds(300,790,150,40);
				pr2.setFont(fontt);
				pr2.setBackground(Color.white);
				
				pr3=new JRadioButton("Online");
				pr3.setBounds(300,830,150,40);
				pr3.setFont(fontt);
				pr3.setBackground(Color.white);
				
				pr=new ButtonGroup();
				pr.add(pr1);
				pr.add(pr2);
				pr.add(pr3);
				
				l6=new JLabel("DATE :");
				l6.setBounds(10,10,100,30);
				p.add(l6);
				
				t6=new JTextField(date);
				t6.setBounds(50,10,250,30);
				t6.setEditable(false);	
				p.add(t6);
				
				heading=new JLabel("Enquiry Form");
				heading.setBounds(980,30,500,50);
				heading.setFont(bigfont);
				p.add(heading);
				
				l1=new JLabel("ID                 :");
				l1.setBounds(130,80,170,30);
				l1.setFont(font);
				p.add(l1);
				
				l2=new JLabel("Name         :");
				l2.setBounds(130,150,170,30);
				l2.setFont(font);
				p.add(l2);
				
				l3=new JLabel("E-mail        :");
				l3.setBounds(130,220,170,30);
				l3.setFont(font);
				p.add(l3);
				
				l4=new JLabel("Mobile      :");
				l4.setBounds(130,290,170,30);
				l4.setFont(font);
				p.add(l4);
				
				l5=new JLabel("Address  :");
				l5.setBounds(130,360,170,30);
				l5.setFont(font);
				p.add(l5);
				
				budget=new JLabel("Budget     :");
				budget.setBounds(130,500,170,30);
				budget.setFont(font);
				p.add(budget);
				p.add(br1);
				p.add(br2);
				p.add(br3);
				
				model=new JLabel("Model       :");
				model.setBounds(130,640,170,30);
				model.setFont(font);
				p.add(model);
				p.add(model);
				p.add(mr1);
				p.add(mr2);
				
				payment=new JLabel("Payment  :");
				payment.setBounds(130,750,170,30);
				payment.setFont(font);
				p.add(payment);
				p.add(pr1);
				p.add(pr2);
				p.add(pr3);
				
				c=new JCheckBox("    Send a Brocher By E-mail");
				c.setFont(fonts);
				c.setBackground(Color.WHITE);
				c.setBounds(160,880,500,30);
				c.addActionListener(this);
				p.add(c);
				
				
				t1=new JTextField();
				t1.setText(""+id);
				t1.setEditable(false);
				t1.setFont(fontt);
				t1.setBounds(300,80,250,40);
				t1.addActionListener(this);
				p.add(t1);
				
				t2=new JTextField();
				t2.setBounds(300,150,250,40);
				t2.addActionListener(this);
				t2.setFont(fontt);
				p.add(t2);
				
				t3=new JTextField();
				t3.setBounds(300,220,250,40);
				
				t3.addActionListener(this);
				t3.setFont(fontt);
				p.add(t3);
				
				t4=new JTextField();
				t4.setBounds(300,290,250,40);
				t4.addActionListener(this);
				t4.setFont(fontt);
				p.add(t4);
				
				t5=new TextArea(" ",10,15);
				t5.setBounds(300,360,250,100);
				t5.setFont(fontt);
				p.add(t5);
				
				
				upload =new JButton("Upload");
				upload.setBounds(170,940,130,40);
				upload.addActionListener(this);
				upload.setEnabled(true);
				upload.setFont(fonts);
				p.add(upload);
				
				cancel =new JButton("Cancel");
				cancel.setBounds(360,940,130,40);
				cancel.addActionListener(this);
				cancel.setFont(fonts);
				p.add(cancel);
				
				f.add(p);
				//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//To get next sequence no as id unique value
		/*try{
			DBC db=new DBC();
			Connection conn=db.getConnection();
			
			String selectQuery="select * from entry";
			PreparedStatement preparedStatment;
			
			preparedStatment =conn.prepareStatement(selectQuery);
			
			ResultSet result=preparedStatment.executeQuery();
			
			if(!result.next())
				t1.setText(""+(Integer.parseInt(result.getString(1))+1));
			System.out.println(""+t1.getText());
		}
		catch(Exception ae){
			System.out.println(ae);
			
		}*/
		
	//	int flag=0;
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	     Pattern mobPattern = Pattern.compile("^[789]\\d{9}$");
		
	     Matcher emailMatcher = emailPattern.matcher(t3.getText());
	     Matcher mobMatcher = mobPattern.matcher(t4.getText());
		
	     if(c.isSelected())
	    	 flag=1;
	     
		if(e.getSource()==upload)
		{
		        
		        
			if(!mobMatcher.matches() || !emailMatcher.matches())
			{
				JOptionPane.showMessageDialog(f,"Mandatory Fields are invalid....... \n i.e. name/ Mobile No/ email","MessageBox",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int c=JOptionPane.showConfirmDialog(f,"Do Want to Add corresponding entry","QuestionMessage",JOptionPane.YES_NO_OPTION);
				if(c==0){
					try{
						DBC db=new DBC();
						Connection conn=db.getConnection();
						
						int id=Integer.parseInt(t1.getText());
						String name=t2.getText();
						String email=t3.getText();
						//String mob=t4.getText();
						String address=t5.getText();
						
						String budget="";
						if(br1.isSelected())
							budget=br1.getText();
						else if(br2.isSelected())
							budget=br2.getText();
						else if(br3.isSelected())
							budget=br3.getText();
						
						String model="";
						if(mr1.isSelected())
							model=mr1.getText();
						else if(mr2.isSelected())
							model=mr2.getText();
						
						String payment="";
						if(pr1.isSelected())
							payment=pr1.getText();
						else if(pr2.isSelected())
							payment=pr2.getText();
						else if(pr3.isSelected())
							payment=pr3.getText();
						
						String insertquery="insert into entry values(?,?,?,?,?,?,?,?,?)";
						PreparedStatement preparedStatement;
						
						preparedStatement=conn.prepareStatement(insertquery);
						preparedStatement.setString(1,id+"");
						preparedStatement.setString(2,name);
						preparedStatement.setString(3,email);
						preparedStatement.setString(4,t4.getText());
						preparedStatement.setString(5,address);
						preparedStatement.setString(6,budget);
						preparedStatement.setString(7,model);
						preparedStatement.setString(8,payment);
						preparedStatement.setString(9,t6.getText());
						
						
						preparedStatement.executeUpdate();
						
						
						if(flag==1 && emailMatcher.matches())
						{
					
							
							 String to=t3.getText();
						      String filename="C:\\project_img\\brochure.pdf";
						      
						      System.out.println("Email= "+to);
				
								SendAttachmentEmail.send(to,filename);
								
						/*      final String username = "projectsystem21@gmail.com";
						      final String password = "ujhrlmnhbgbosgyk";

						       Properties props = new Properties();
						       props.put("mail.smtp.auth", "true");
						       props.put("mail.smtp.starttls.enable", "true");
						       props.put("mail.smtp.host", "smtp.gmail.com");
						       props.put("mail.smtp.port", "25");

						      Session session = Session.getInstance(props,new javax.mail.Authenticator()
						      {
						            protected PasswordAuthentication getPasswordAuthentication()
						            {
						               return new PasswordAuthentication(username, password);
						            }
						       });

						      try
						      {
						         // Part one is Text Message
						         Message message = new MimeMessage(session);
						         message.setFrom(new InternetAddress(username));
						         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
						         message.setSubject("Testing Subject");

						         // Part two is attachment
						         BodyPart messageBodyPart = new MimeBodyPart();
						         messageBodyPart.setText("This is message body");

						         Multipart multipart = new MimeMultipart();
						         multipart.addBodyPart(messageBodyPart);

						         messageBodyPart = new MimeBodyPart();

						         DataSource source = new FileDataSource(filename);
						         messageBodyPart.setDataHandler(new DataHandler(source));
						         messageBodyPart.setFileName(filename);
						         multipart.addBodyPart(messageBodyPart);

						         message.setContent(multipart);
						         Transport.send(message);
						         System.out.println("Sent message With Attachments successfully....");
						      }
						      catch (MessagingException ae)
						      {
						         throw new RuntimeException(ae);
						      }
					*/
					 	}
					 

						
						
						
						
						
						JOptionPane.showMessageDialog(f,"Enquiry Saved Successfully","MessageBox",JOptionPane.PLAIN_MESSAGE);
						
						
						
						
						
						MainFrame mf=new MainFrame();
						f.dispose();
					}
					catch(Exception ae)
					{
						System.out.println(""+ae);
						JOptionPane.showMessageDialog(f,"Unable to Submit.","MessageBox",JOptionPane.PLAIN_MESSAGE);
					}
				}
				MainFrame mf=new MainFrame();
				f.dispose();
				
				
				
			}
		}
		else if(e.getSource()==cancel){
			int val=JOptionPane.showConfirmDialog(f,"Do You Want To Close Current Tab?","QuestionMessage",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(val==0)
			{
				MainFrame mf=new MainFrame();
				f.dispose();
			}
		}
		
		
	}
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Enquiry_form eq=new Enquiry_form();
		eq.create_Enquiry_form();
		/*new Enquiry_form();*/

	}

}
