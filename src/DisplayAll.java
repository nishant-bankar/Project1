import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class DisplayAll implements ActionListener {
	static JFrame f;
	JPanel p;
	JRadioButton rb1,rb2;
	JLabel l;
	JButton b,cancel;
	
	static String rows[][]=new String[200][10];
	static int row=0;
	
	Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
	Font titlefont=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
	Font btnfont=new Font("Copperplate Gothic Bold",Font.PLAIN,15);
	Font infofont=new Font("",Font.HANGING_BASELINE,20);
	
	void  create_DisplayAll(){
		
		f=new JFrame("Selcting view");
		f.setLocation(660,380);
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
		
		p=new JPanel();
		p.setBounds(0,0,535,253);		
		p.setBackground(Color.decode("#8FE0D5"));
		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		p.setVisible(true);
		
		l=new JLabel("Select The View For Records! ");
		l.setFont(titlefont);
		l.setBounds(60,20,500,30);
		
		rb1=new JRadioButton("View All Record",true);
		rb1.setBackground(Color.decode("#8FE0D5"));
		rb1.setFont(btnfont);
		rb1.setBounds(175,100,250,30);
		
		rb2=new JRadioButton("One-By-One record",false);
		rb2.setBackground(Color.decode("#8FE0D5"));
		rb2.setFont(btnfont);
		rb2.setBounds(175,150,250,30);

		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);

		b=new JButton(" Show ");
		b.setFont(btnfont);
		b.setBackground(Color.decode("#a8642a"));
		b.setForeground(Color.WHITE);
		b.setBounds(395,200,120,40);
		b.addActionListener(this);
		
		cancel=new JButton(" Cancel ");
		cancel.setFont(btnfont);
		cancel.setBackground(Color.decode("#a8642a"));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(20,200,120,40);
		cancel.addActionListener(this);

		p.add(l);
		p.add(rb1);
		p.add(rb2);
		p.add(b);
		p.add(cancel);

		f.add(p);
		f.setSize(555,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new DisplayAll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
		
			if(rb1.isSelected())
			{
				try{
					DBC db=new DBC();
					Connection conn=db.getConnection();
					
					String selectQuery="select * from entry";
					PreparedStatement preparedStatment;
					
					preparedStatment =conn.prepareStatement(selectQuery);
					
					ResultSet result=preparedStatment.executeQuery();
					
					while(result.next()){
						for(int i=0;i<9;i++){
							rows[row][i]=result.getString(i+1);
						}
						row++;
					}
					CustomerTable.populateArray(rows);
					//ViewOneByOne.populateArray();
				}
				catch(Exception ae){
					System.out.println(ae);
					
				}
			}
			if(rb2.isSelected())
			{
				try{
					DBC db=new DBC();
					Connection conn=db.getConnection();
					
					String selectQuery="select * from entry";
					PreparedStatement preparedStatment;
					
					preparedStatment =conn.prepareStatement(selectQuery);
					
					ResultSet result=preparedStatment.executeQuery();
					
					while(result.next()){
						for(int i=0;i<9;i++){
							rows[row][i]=result.getString(i+1);
						}
						row++;
					}
					//CustomerTable.populateArray(rows);
					ViewOneByOne.populateArray();
				}
				catch(Exception ae){
					System.out.println(ae);
					
				}
			
			}
			MainFrame mf=new MainFrame();
			f.dispose();
		}
		else if(e.getSource()==cancel)
		{
			MainFrame mf=new MainFrame();
			f.dispose();
		}
		
	}

}
