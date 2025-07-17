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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*<Applet width=800 height=800>*/

public class Update_form implements ActionListener{
	
	JButton b1,b2,upload,cancel,search,updateb1,updateb2,updateb3;
	JLabel l1,l2,l3,l4,l5,l6,budget,model,payment,heading;
	JTextField t1,t2,t3,t4,t6,mt,bt,pt;
	TextArea t5;
	JRadioButton br1,br2,br3,mr1,mr2,pr1,pr2,pr3;
	ButtonGroup br,mr,pr;
	static JFrame f;
	
	void create_Update_form(){
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Font font=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
		Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
		Font fontt=new Font("",Font.BOLD,17);
		Font fonts=new Font("Copperplate Gothic Bold",Font.BOLD,17);
		Date cdate=new Date();  //date object to hold current date generated through Date()
		
		f=new JFrame("Upadte Form");
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon icon=new ImageIcon("C:\\project_img\\icon.png");
		f.setIconImage(icon.getImage());
		//f.setResizable(false);
		//f.setAlwaysOnTop(true);
		//f.setUndecorated(true);
		
		f.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			//f1.setVisible(false);
    			MainFrame.frame.setVisible(true);
    			f.dispose();
    		}
    	});
		
		
		
		//SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM//yy HH:mm:ss");
		//Create SimpleDateFormat object with desired date format 
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM//yy");  
		String date=dateFormat.format(cdate); //Convert Date Object to String
		
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
		br1.setBounds(440,490,150,40);
		br1.setFont(fontt);
		br1.setBackground(Color.white);

		br2=new JRadioButton("80k-1 Lakh");
		br2.setBounds(440,530,150,40);
		br2.setFont(fontt);
		br2.setBackground(Color.white);
		
		br3=new JRadioButton("1 Lakh & Above");
		br3.setBounds(440,570,150,40);
		br3.setFont(fontt);
		br3.setBackground(Color.white);

		br=new ButtonGroup();
		br.add(br1);
		br.add(br2);
		br.add(br3);
		
		//model speed Radio Button
		mr1=new JRadioButton("High Speed");
		mr1.setBounds(440,640,150,40);
		mr1.setFont(fontt);
		mr1.setBackground(Color.white);

		mr2=new JRadioButton("Low Speed");
		mr2.setBounds(440,680,150,40);
		mr2.setFont(fontt);
		mr2.setBackground(Color.white);
		
		mr=new ButtonGroup();
		mr.add(mr1);
		mr.add(mr2);
		
		//payment Method Radio Button
		pr1=new JRadioButton("Cash");
		pr1.setBounds(440,750,150,40);
		pr1.setFont(fontt);
		pr1.setBackground(Color.white);

		pr2=new JRadioButton("EMI");
		pr2.setBounds(440,790,150,40);
		pr2.setFont(fontt);
		pr2.setBackground(Color.white);
		
		pr3=new JRadioButton("Online");
		pr3.setBounds(440,830,150,40);
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
		
		heading=new JLabel("Update Form");
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
		
		t1=new JTextField();
		t1.setText("");
		t1.setFont(fontt);
		t1.setBounds(300,80,250,40);
		t1.addActionListener(this);
		p.add(t1);
		
		t2=new JTextField();
		t2.setBounds(300,150,250,40);
		t2.addActionListener(this);
		t2.setFont(fontt);
		t2.setEditable(false);
		p.add(t2);
		
		t3=new JTextField();
		t3.setBounds(300,220,250,40);
		t3.addActionListener(this);
		t3.setEditable(false);
		t3.setFont(fontt);
		p.add(t3);
		
		t4=new JTextField();
		t4.setBounds(300,290,250,40);
		t4.addActionListener(this);
		t4.setEditable(false);
		t4.setFont(fontt);
		p.add(t4);
		
		t5=new TextArea(" ",10,15);
		t5.setBounds(300,360,250,100);
		t5.setFont(fontt);
		t5.setEditable(false);
		p.add(t5);
		
		
		ImageIcon searchicon=new ImageIcon("C:/project_img/search.png");
		search =new JButton("",searchicon);
		search.setBounds(570,80,40,40);
		search.addActionListener(this);
		p.add(search);
		
		upload =new JButton("Upload");
		upload.setBounds(190,940,130,40);
		upload.addActionListener(this);
		upload.setFont(fonts);
		p.add(upload);
		
		cancel =new JButton("Cancel");
		cancel.setBounds(350,940,130,40);
		cancel.addActionListener(this);
		cancel.setFont(fonts);
		p.add(cancel);
		
		bt=new JTextField("");
		bt.setBounds(300,495,130,30);
		bt.setEditable(false);
		bt.setFont(fontt);
		p.add(bt);
		
		mt=new JTextField("");
		mt.setBounds(300,645,130,30);
		mt.setEditable(false);
		mt.setFont(fontt);
		p.add(mt);
		
		pt=new JTextField("");
		pt.setBounds(300,755,130,30);
		pt.setEditable(false);
		pt.setFont(fontt);
		p.add(pt);
		
		f.add(p);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search){
			
			t2.setEditable(true);
			t3.setEditable(true);
			t4.setEditable(true);
			t5.setEditable(true);
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			bt.setText("");
			mt.setText("");
			pt.setText("");
			
			try{
			//set text from the dataBase corresponds to id number
				DBC db=new DBC();
				Connection conn=db.getConnection();
				
				String insertquery="select * from entry where id=?";
				PreparedStatement preparedStatement;
				
				preparedStatement =conn.prepareStatement(insertquery);
				preparedStatement.setInt(1,Integer.parseInt(t1.getText()));
				
				ResultSet result=preparedStatement.executeQuery();
				if(result.next()){
					String name=result.getString(2);
					String email=result.getString(3);
					String mob=result.getString(4);
					String add=result.getString(5);
					String budget=result.getString(6);
					String model=result.getString(7);
					String payment=result.getString(8);
					
					t2.setText(name);
					t3.setText(email);
					t4.setText(mob);
					t5.setText(add);
					bt.setText(budget);
					mt.setText(model);
					pt.setText(payment);
					
					
				}else{
					JOptionPane.showMessageDialog(f,"Invalid ID : ID NOT FOUND IN RECORDS! ","ErrorBox",JOptionPane.ERROR_MESSAGE);
				}
			
			}catch(Exception ae){
				JOptionPane.showMessageDialog(f,"  PLZ Enter valid ID   ","MessageBox",JOptionPane.ERROR_MESSAGE);

			}
			}
		if(e.getSource()==upload){
			
			 Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		     Pattern mobPattern = Pattern.compile("^[789]\\d{9}$");
			
		     Matcher emailMatcher = emailPattern.matcher(t3.getText());
		     Matcher mobMatcher = mobPattern.matcher(t4.getText());
		        
		 	if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(f,"  PLZ Enter ID   ","MessageBox",JOptionPane.ERROR_MESSAGE);
			}    
		    else if(!emailMatcher.matches() || !emailMatcher.matches())
			{
				JOptionPane.showMessageDialog(f,"Mandatory Fields are invalid....... \n i.e. name/ Mobile No/ email","MessageBox",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int c=JOptionPane.showConfirmDialog(f,"Do Want to Update corresponding entry","QuestionMessage",JOptionPane.YES_NO_OPTION);
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
						else
							budget=bt.getText();
							
						
						String model="";
						if(mr1.isSelected())
							model=mr1.getText();
						else if(mr2.isSelected())
							model=mr2.getText();
						else
							model=mt.getText();
						
						String payment="";
						if(pr1.isSelected())
							payment=pr1.getText();
						else if(pr2.isSelected())
							payment=pr2.getText();
						else if(pr3.isSelected())
							payment=pr3.getText();
						else
							payment=pt.getText();
						
						String selectQuery="update entry set name=?,email=?,mobile_no=?,address=?,budget=?,model=?,payment=? where id=? ";
						PreparedStatement pstmt;
						
						pstmt =conn.prepareStatement(selectQuery);
						pstmt.setString(8,id+"");
						pstmt.setString(1,t2.getText());
						pstmt.setString(2,t3.getText());
						pstmt.setString(3,t4.getText());
						pstmt.setString(4,t5.getText());
						pstmt.setString(5,budget);
						pstmt.setString(6,model);
						pstmt.setString(7,payment);
						
						
						int val=pstmt.executeUpdate();
						
						if(val!=0){
							JOptionPane.showMessageDialog(f,"Record Successfully Updated!","MessageBox",JOptionPane.PLAIN_MESSAGE);
							f.dispose();
						}
					}
					catch(Exception ae)
					{
						System.out.println(""+ae);
						JOptionPane.showMessageDialog(f,"Unable to Submit.","MessageBox",JOptionPane.PLAIN_MESSAGE);
					}
				}
				
				
				
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
		Update_form a=new Update_form ();
		a.create_Update_form();

	}

}

