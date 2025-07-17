import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

public class ViewOneByOne  implements ActionListener
{
	static JFrame f=new JFrame("Database Records");

	private static JPanel jpRec;

	private static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,heading;

	private static JTextField t1,t2,t3,t4,t6,t7,t8,t9,t10;
	private static TextArea t5;
	private static JTextField txtRec;

	private static JButton btnFirst,cancel;
	private static JButton btnBack;
	private static JButton btnNext;
	private static JButton btnLast;

	private static int recCount = 0;
	private static	int total = DisplayAll.row;
	
	static Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	static Font font=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
	static Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,50);
	static Font fontt=new Font("",Font.BOLD,17);
	static Font fonts=new Font("Copperplate Gothic Bold",Font.BOLD,17);

	static void populateArray ()
	{
		f.setSize (d.width,d.height);
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
		
		ImageIcon BannerIcon=new ImageIcon("C:/project_img/bgimg2.jpg");
		final Image bannericon=BannerIcon.getImage();
		JPanel jpRec=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(bannericon,0,0 , this);
			}
		};

		jpRec.setLayout (null);
		jpRec.setBackground(Color.decode("#8FE0D5"));
		
		heading=new JLabel("Record Display");
		heading.setBounds(820,30,500,50);
		heading.setFont(bigfont);
		jpRec.add(heading);

		
		l1=new JLabel("ID                 :");
		l1.setBounds(130,80,170,30);
		l1.setFont(font);
		jpRec.add(l1);
		
		l2=new JLabel("Name         :");
		l2.setBounds(130,150,170,30);
		l2.setFont(font);
		jpRec.add(l2);
		
		l3=new JLabel("E-mail        :");
		l3.setBounds(130,220,170,30);
		l3.setFont(font);
		jpRec.add(l3);
		
		l4=new JLabel("Mobile      :");
		l4.setBounds(130,290,170,30);
		l4.setFont(font);
		jpRec.add(l4);
		
		l5=new JLabel("Address  :");
		l5.setBounds(130,360,170,30);
		l5.setFont(font);
		jpRec.add(l5);
		
		l6=new JLabel("Budget     :");
		l6.setBounds(130,500,170,30);
		l6.setFont(font);
		jpRec.add(l6);
		
		l7=new JLabel("Model       :");
		l7.setBounds(130,640,170,30);
		l7.setFont(font);
		jpRec.add(l7);
		
		l8=new JLabel("Payment  :");
		l8.setBounds(130,750,170,30);
		l8.setFont(font);
		jpRec.add(l8);
		
		l10=new JLabel("E-mail  Status  :");
		l10.setBounds(130,820,300,30);
		l10.setFont(font);
		jpRec.add(l10);
		
		l9=new JLabel("Date :");
		l9.setBounds(10,10,100,30);
		//l9.setFont(font);
	
		
		t1=new JTextField();
		t1.setBounds(300,80,250,40);
		t1.setFont(fontt);
		
		t2=new JTextField();
		t2.setBounds(300,150,250,40);
		t2.setFont(fontt);
		
		t3=new JTextField();
		t3.setBounds(300,220,250,40);
		t3.setFont(fontt);
		
		t4=new JTextField();
		t4.setBounds(300,290,250,40);
		t4.setFont(fontt);
		
		t5=new TextArea(" ",10,15);
		t5.setBounds(300,360,250,70);
		t5.setFont(fontt);
		
		t6=new JTextField();
		t6.setBounds(300,495,250,30);
		t6.setFont(fontt);
		
		t7=new JTextField();
		t7.setBounds(300,645,250,30);
		t7.setFont(fontt);
		
		t8=new JTextField();
		t8.setBounds(300,755,250,30);
		t8.setFont(fontt);
		
		t10=new JTextField();
		t10.setBounds(365,825,185,30);
		t10.setFont(fontt);
		
		t9=new JTextField();
		t9.setBounds(50,10,250,30);
		t9.setFont(fontt);
		
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		t9.setEditable(false);
		t10.setEditable(false);
		
		Image imgs=Toolkit.getDefaultToolkit().getImage("C:/project_img/cancel.png");
		
		ImageIcon is=new ImageIcon(imgs);
		
		cancel =new JButton(is);
		cancel.setBounds(570,80,40,40);
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int val=JOptionPane.showConfirmDialog(f,"Do You Want To Close Current Tab?","QuestionMessage",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(val==0)
				{
					MainFrame mf=new MainFrame();
					f.dispose();
				}
				
			}
			
		});
		

		btnFirst = new JButton ("<<First");
		btnFirst.setBounds (610, 920, 100, 50);
		btnFirst.addActionListener (new ViewOneByOne());

		btnBack = new JButton ("<Prev");
		btnBack.setBounds (710, 920, 100, 50);
		btnBack.addActionListener (new ViewOneByOne());

		btnNext = new JButton ("Next>");
		btnNext.setBounds (990, 920, 100, 50);
		btnNext.addActionListener (new ViewOneByOne());

		btnLast = new JButton ("Last>>");
		btnLast.setBounds (1090, 920, 100, 50);
		btnLast.addActionListener (new ViewOneByOne());

		txtRec = new JTextField ();
		txtRec.setFont(font);
		txtRec.setEnabled (false);
		txtRec.setHorizontalAlignment (JTextField.CENTER);
		txtRec.setBounds (820, 920, 160, 50);

		jpRec.add (l1);
		jpRec.add (l2);
		jpRec.add (l3);
		jpRec.add (l4);
		jpRec.add (l5);
		jpRec.add (l6);
		jpRec.add (l7);
		jpRec.add (l8);
		jpRec.add(l9);
		jpRec.add(l10);
		jpRec.add (t1);
		jpRec.add (t2);
		jpRec.add (t3);
		jpRec.add (t4);
		jpRec.add (t5);
		jpRec.add (t6);
		jpRec.add (t7);
		jpRec.add (t8);
		jpRec.add(t9);
		jpRec.add(t10);
		jpRec.add (btnFirst);
		jpRec.add (btnBack);
		jpRec.add (btnNext);
		jpRec.add (btnLast);
		jpRec.add (txtRec);
		jpRec.add(cancel);

		f.getContentPane().add (jpRec);

		showRec (0);

		f.setVisible (true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void actionPerformed (ActionEvent ae)
	{
		Object obj = ae.getSource();

		if (obj == btnFirst)
		{
			recCount = 0;
			showRec (recCount);
		}
		else if (obj == btnBack)
		{
			recCount = recCount - 1;
			if (recCount < 0)
			{
				recCount = 0;
				showRec (recCount);
				JOptionPane.showMessageDialog (f, "You are on First Record.","UserSystem - 1st Record", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				showRec (recCount);
			}
		}
		else if (obj == btnNext)
		{
			recCount = recCount + 1;
			if (recCount == total)
			{
				recCount = total - 1;
				showRec (recCount);
				JOptionPane.showMessageDialog (f, "You are on Last Record.","UserSystem - End of Records", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				showRec (recCount);
			}
		}
		else if (obj == btnLast)
		{
			recCount = total - 1;
			showRec (recCount);
		}
	}

	public static void showRec (int intRec)
	{
		t1.setText (DisplayAll.rows[intRec][0]);
		t2.setText (DisplayAll.rows[intRec][1]);
		t3.setText (DisplayAll.rows[intRec][2]);
		t4.setText (DisplayAll.rows[intRec][3]);
		t5.setText (DisplayAll.rows[intRec][4]);
		t6.setText (DisplayAll.rows[intRec][5]);
		t7.setText (DisplayAll.rows[intRec][6]);
		t8.setText (DisplayAll.rows[intRec][7]);
		t9.setText (DisplayAll.rows[intRec][8]);
		t10.setText(DisplayAll.rows[intRec][9]);
		

		if (total == 0)
			txtRec.setText (intRec + "/" + total); //Showing Record No. and Total Records.
		else
			txtRec.setText ((intRec + 1) + "/" + total); //Showing Record No. and Total Records.
	}
}

