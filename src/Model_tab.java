import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Model_tab {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    TextArea t1,t2,t3,t4,t5;
    JPanel slideshowPanel,p1,p2,p3;
    JPanel[] pa=new JPanel[5];
    JButton b1,b2,b3,back,forward;
    Timer timer;
    int currentIndex = 0;
    JLabel b,c,p,s,line,bike,company,price,speed,detail;
    
    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
    Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,40);
    Font titlefont=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
    Font btnfont=new Font("Copperplate Gothic Bold",Font.PLAIN,30);
    Font infofont=new Font("",Font.HANGING_BASELINE,10);
    
    String[] str={"C:/project_img/bike.jpg","C:/project_img/bike2.jpg","C:/project_img/bike3.jpg","C:/project_img/bike4.jpg","C:/project_img/bike5.jpg"};
    String[] bstr={"Bike Name1 ","Bike Name2 ","Bike Name3 ","Bike Name4 ","Bike Name5 "};
    String[] cstr={"Company Name1","Company Name2","Company Name3","Company Name4","Company Name5"};
    String[] pstr={"Bike Price1","Bike Price2","Bike Price3","Bike Price4","Bike Price5"};
    String[] sstr={"Top Speed1 ","Top Speed2 ","Top Speed3 ","Top Speed4 ","Top Speed5 "};

    public static void main(String[] args) {
    	Model_tab app = new Model_tab();
            app.createAndShowGUI();
       
    }
 

    void createAndShowGUI() {
        frame = new JFrame("Panel Slideshow");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			//f1.setVisible(false);
    			MainFrame.frame.setVisible(true);
    			frame.dispose();
    		}
    	});
        
        
        
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create and add panels
        JPanel panel1 = createPanel(0);
        JPanel panel2 = createPanel(1);
        JPanel panel3 = createPanel(2);
        JPanel panel4 = createPanel(3);
        JPanel panel5 = createPanel(4);

        // Add panels to main panel
        mainPanel.add(panel1, "Panel 1");
        mainPanel.add(panel2, "Panel 2");
        mainPanel.add(panel3, "Panel 3");
        mainPanel.add(panel4, "Panel 4");
        mainPanel.add(panel5, "Panel 5");

        // Create buttons to navigate through panels
        JButton prevButton = new JButton("<<-    PREV   ");
        prevButton.setFont(btnfont);
        prevButton.setBackground(Color.decode("#a8642a"));
        prevButton.setForeground(Color.WHITE);
        
        
        JButton nextButton = new JButton("   NEXT    ->>");
        nextButton.setFont(btnfont);
        nextButton.setBackground(Color.decode("#a8642a"));
        nextButton.setForeground(Color.WHITE);
        

        // Add action listeners to buttons
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(mainPanel);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(mainPanel);
            }
        });

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#8FE0D5"));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black,5));
  
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        // Add panels to the frame
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

       // frame.setSize(d.width,d.height);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    private JPanel createPanel(int val) {
    	final int i=val;
    	final ImageIcon p1Icon=new ImageIcon(str[i]);
 		final Image p1icon=p1Icon.getImage();
 		pa[i]=new JPanel(){
 			protected void paintComponent(Graphics g){
 				super.paintComponent(g);
 			
 				g.drawImage(p1icon,1000, 90, this);
 			}
 		};
 		//address=new JPanel();
 		pa[i].setBounds(380, 300, 350, 600);
 		pa[i].setBackground(Color.decode("#8FE0D5"));
 		pa[i].setLayout(null);
 		pa[i].setVisible(true);
 		
 		bike=new JLabel("Bike Name            :");
 		bike.setBounds(70,0,500,150);
 		bike.setFont(bigfont);		
 		pa[i].add(bike);
 	
 	company=new JLabel("Company Name :");
 	company.setBounds(70,80,500,150);
 	company.setFont(bigfont);		
 	pa[i].add(company);
 	
 	price=new JLabel("Bike Price           :");
 	price.setBounds(70,160,500,150);
 	price.setFont(bigfont);		
 	pa[i].add(price);
 	
 	speed=new JLabel("Top Speed           :");
 	speed.setBounds(70,240,500,150);
 	speed.setFont(bigfont);		
 	pa[i].add(speed);
 	
 	b=new JLabel(bstr[i]);
 	b.setBounds(470,0,500,150);
 	b.setFont(bigfont);		
 	pa[i].add(b);
 	
 	c=new JLabel(cstr[i]);
 	c.setBounds(470,80,500,150);
 	c.setFont(bigfont);		
 	pa[i].add(c);
 	
 	p=new JLabel(pstr[i]);
 	p.setBounds(470,160,500,150);
 	p.setFont(bigfont);		
 	pa[i].add(p);
 		
 	s=new JLabel(sstr[i]);
 	s.setBounds(470,240,500,150);
 	s.setFont(bigfont);		
 	pa[i].add(s);
 	
// 	back=new JButton("<");
// 	back.setFont(bigfont);
// 	back.setBackground(Color.decode("#a8642a"));
// 	back.setForeground(Color.WHITE);
// 	back.setBounds(20, 900,80,60);
// 	pa[i].add(back);
// 	
// 	forward=new JButton(">");
// 	forward.setFont(bigfont);
// 	forward.setBackground(Color.decode("#a8642a"));
// 	forward.setForeground(Color.WHITE);
// 	forward.setBounds(1820,903,80,60);
// 	forward.addActionListener(new ActionListener(){
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
// 		
// 	});
// 	pa[i].add(forward);
 	
 	line=new JLabel("__________________________________________________");
 	line.setBounds(0,400,1030,40);
 	line.setFont(bigfont);		
 	pa[i].add(line);
 	
 	b1=new JButton("View Deatails");
		b1.setFont(titlefont);
		b1.setBackground(Color.decode("#a8642a"));
		b1.setForeground(Color.WHITE);
		b1.setBounds(710, 360,230,50);
		if(i==0){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t1=new TextArea("\n   Write \n   Detailed Phone Number");
					t1.setBounds(7,447,980,d.height-575);
					t1.setBackground(Color.decode("#8FE0D5"));
					t1.setEditable(false);
					t1.setFont(titlefont);
					pa[i].add(t1);
					
				}
				
			});
 		
 		}else if(i==1){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t2=new TextArea("\n   Write \n   Detailed Phone Number");
					t2.setBounds(7,447,980,d.height-575);
					t2.setBackground(Color.decode("#8FE0D5"));
					t2.setEditable(false);
					t2.setFont(titlefont);
					pa[i].add(t2);
					
				}
				
			});
 		}else if(i==3){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t4=new TextArea("\n   Write \n   Detailed Phone Number");
					t4.setBounds(7,447,980,d.height-575);
					t4.setBackground(Color.decode("#8FE0D5"));
					t4.setEditable(false);
					t4.setFont(titlefont);
					pa[i].add(t4);
					
				}
				
			});
 		}else if(i==4){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t5=new TextArea("\n   Write \n   Detailed Phone Number");
					t5.setBounds(7,447,980,d.height-575);
					t5.setBackground(Color.decode("#8FE0D5"));
					t5.setEditable(false);
					t5.setFont(titlefont);
					pa[i].add(t5);
					
				}
				
			});
 		
 		}else if(i==2){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t3=new TextArea("\n   Write \n   Detailed Phone Number");
					t3.setBounds(7,447,980,d.height-575);
					t3.setBackground(Color.decode("#8FE0D5"));
					t3.setEditable(false);
					t3.setFont(titlefont);
					pa[i].add(t3);
					
				}
				
			});
 		
 		}
 	pa[i].add(b1);
 		
 	return pa[i];
    }
}