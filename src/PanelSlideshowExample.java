import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSlideshowExample {
     JFrame frame;
     TextArea t1,t2,t3;
    JPanel slideshowPanel,p1,p2,p3;
    JPanel[] pa=new JPanel[3];
    JButton b1,b2,b3,back,forward;
    Timer timer;
    int currentIndex = 0;
    JLabel b,c,p,s,line,bike,company,price,speed,detail;
    
    
    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
    Font bigfont=new Font("Copperplate Gothic Bold",Font.PLAIN,30);
    Font titlefont=new Font("Copperplate Gothic Bold",Font.PLAIN,25);
    Font btnfont=new Font("Copperplate Gothic Bold",Font.PLAIN,20);
    Font infofont=new Font("",Font.HANGING_BASELINE,10);

    JPanel[] slides = {
            createPanel(0,"Slide 1"),
            createPanel(1, "Slide 2"),
            createPanel(2, "Slide 3")
            // Add more panels as needed
    };
    static String[] str={"C://Users/saurabh/Desktop/movies/self/bike.jpg","C://Users/saurabh/Desktop/movies/self/bike2.jpg","C://Users/saurabh/Desktop/movies/self/bike3.jpg"};
    static String[] bstr={"Bike Name1 ","Bike Name2 ","Bike Name3 "};
    static String[] cstr={"Company Name1","Company Name2","Company Name3"};
    static String[] pstr={"Bike Price1","Bike Price2","Bike Price3"};
    static String[] sstr={"Top Speed1 ","Top Speed2 ","Top Speed3 "};
    

    public static void main(String[] args) {
            PanelSlideshowExample example = new PanelSlideshowExample();
            example.createAndShowGUI();
       
    }

    void createAndShowGUI() {
        frame = new JFrame("Panel Slideshow Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        slideshowPanel = new JPanel(new BorderLayout());

        // Create and start a Timer to switch panels every 3 seconds (adjust as needed)
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextSlide();
            }
        });
        timer.start();

        // Show the initial slide
        showSlide(currentIndex);

        frame.getContentPane().add(slideshowPanel);
       // frame.setSize(d.width,d.height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                                                                                                                   
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void showNextSlide() {
        currentIndex = (currentIndex + 1) % slides.length;
        showSlide(currentIndex);
    }

    void showSlide(int index) {
        slideshowPanel.removeAll();
        slideshowPanel.add(slides[index]);
        slideshowPanel.revalidate();
        slideshowPanel.repaint();
    }

    JPanel createPanel(int val, String text) {
       final int i=val;
    	final ImageIcon p1Icon=new ImageIcon(str[i]);
 		final Image p1icon=p1Icon.getImage();
 		pa[i]=new JPanel(){
 			protected void paintComponent(Graphics g){
 				super.paintComponent(g);
 			
 				g.drawImage(p1icon,1140, 100, this);
 			}
 		};
 		//address=new JPanel();
 		pa[i].setBounds(380, 300, 350, 600);
 		pa[i].setBackground(Color.decode("#8FE0D5"));
 		pa[i].setLayout(null);
 		pa[i].setVisible(true);
 		
 		bike=new JLabel("Bike Name            :");
 		bike.setBounds(70,20,500,200);
 		bike.setFont(bigfont);		
 		pa[i].add(bike);
 	
 	company=new JLabel("Company Name :");
 	company.setBounds(70,100,500,200);
 	company.setFont(bigfont);		
 	pa[i].add(company);
 	
 	price=new JLabel("Bike Price           :");
 	price.setBounds(70,180,500,200);
 	price.setFont(bigfont);		
 	pa[i].add(price);
 	
 	speed=new JLabel("Top Speed           :");
 	speed.setBounds(70,260,500,200);
 	speed.setFont(bigfont);		
 	pa[i].add(speed);
 	
 	b=new JLabel(bstr[i]);
 	b.setBounds(470,20,500,200);
 	b.setFont(bigfont);		
 	pa[i].add(b);
 	
 	c=new JLabel(cstr[i]);
 	c.setBounds(470,100,500,200);
 	c.setFont(bigfont);		
 	pa[i].add(c);
 	
 	p=new JLabel(pstr[i]);
 	p.setBounds(470,180,500,200);
 	p.setFont(bigfont);		
 	pa[i].add(p);
 		
 	s=new JLabel(sstr[i]);
 	s.setBounds(470,260,500,200);
 	s.setFont(bigfont);		
 	pa[i].add(s);
 	
 	back=new JButton("<");
 	back.setFont(bigfont);
 	back.setBackground(Color.decode("#a8642a"));
 	back.setForeground(Color.WHITE);
 	back.setBounds(20, 900,80,60);
 	pa[i].add(back);
 	
 	forward=new JButton(">");
 	forward.setFont(bigfont);
 	forward.setBackground(Color.decode("#a8642a"));
 	forward.setForeground(Color.WHITE);
 	forward.setBounds(1820,903,80,60);
 	forward.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
 		
 	});
 	pa[i].add(forward);
 	
 	line=new JLabel("_________________________________________________________________________");
 	line.setBounds(0,440,1000,30);
 	line.setFont(bigfont);		
 	pa[i].add(line);
 	
 	b1=new JButton("View Deatails");
		b1.setFont(btnfont);
		b1.setBackground(Color.decode("#a8642a"));
		b1.setForeground(Color.WHITE);
		b1.setBounds(710, 400,200,50);
		if(i==0){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t1=new TextArea("\n   Write \n   Detailed Phone Number");
					t1.setBounds(7,480,980,d.height-540);
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
					t2.setBounds(7,480,980,d.height-540);
					t2.setBackground(Color.decode("#8FE0D5"));
					t2.setEditable(false);
					t2.setFont(titlefont);
					pa[i].add(t2);
					
				}
				
			});
 		
 		}else if(i==2){
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					t3=new TextArea("\n   Write \n   Detailed Phone Number");
					t3.setBounds(7,480,980,d.height-540);
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















/*
if(val==1){
	 //  final Image Icon=new Image("C://Users/saurabh/Desktop/movies/self/logo.png");
	   final ImageIcon p1Icon=new ImageIcon("C://Users/saurabh/Desktop/movies/self/bike.jpg");
		final Image p1icon=p1Icon.getImage();
		p1=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
			
				g.drawImage(p1icon,1140, 100, this);
			}
		};
		//address=new JPanel();
		p1.setBounds(380, 300, 350, 600);
		p1.setBackground(Color.decode("#8FE0D5"));
		p1.setLayout(null);
		p1.setVisible(true);
		
		bike=new JLabel("Bike Name            :");
		bike.setBounds(70,20,500,200);
		bike.setFont(bigfont);		
	p1.add(bike);
	
	company=new JLabel("Company Name :");
	company.setBounds(70,120,500,200);
	company.setFont(bigfont);		
	p1.add(company);
	
	price=new JLabel("Bike Price           :");
	price.setBounds(70,220,500,200);
	price.setFont(bigfont);		
	p1.add(price);
	
	speed=new JLabel("Top Speed           :");
	speed.setBounds(70,320,500,200);
	speed.setFont(bigfont);		
	p1.add(speed);
	
	b=new JLabel("Bike Name1 ");
		b.setBounds(470,20,500,200);
		b.setFont(bigfont);		
	p1.add(b);
	
	c=new JLabel("Company Name1  ");
	c.setBounds(470,120,500,200);
	c.setFont(bigfont);		
	p1.add(c);
	
	p=new JLabel("Bike Price1  ");
	p.setBounds(470,220,500,200);
	p.setFont(bigfont);		
	p1.add(p);
	
	s=new JLabel("Top Speed1 ");
	s.setBounds(470,320,500,200);
	s.setFont(bigfont);		
	p1.add(s);
	
	b1=new JButton("View Deatails");
	b1.setFont(titlefont);
	b1.setBackground(Color.decode("#a8642a"));
	b1.setForeground(Color.WHITE);
	b1.setBounds(670, 500,250,60);
	p1.add(b1);
	
	back=new JButton("<");
	back.setFont(bigfont);
	back.setBackground(Color.decode("#a8642a"));
	back.setForeground(Color.WHITE);
	back.setBounds(20, 900,80,60);
	p1.add(back);
	
	forward=new JButton(">");
	forward.setFont(bigfont);
	forward.setBackground(Color.decode("#a8642a"));
	forward.setForeground(Color.WHITE);
	forward.setBounds(1820,903,80,60);
	p1.add(forward);
	
	line=new JLabel("_________________________________________________________________________");
	line.setBounds(0,430,1000,300);
	line.setFont(bigfont);		
	p1.add(line);
	
		
		return p1;
  }
  else if(val==2){
	   ImageIcon p2Icon=new ImageIcon("C://Users/saurabh/Desktop/movies/self/bike2.jpg");
 		final Image p2icon=p2Icon.getImage();
 		p2=new JPanel(){
 			protected void paintComponent(Graphics g){
 				super.paintComponent(g);
 				g.drawImage(p2icon,1140, 100, this);
 			}
 		};
 		//address=new JPanel();
 		p2.setBounds(380, 300, 350, 600);
 		p2.setBackground(Color.decode("#8FE0D5"));
 		p2.setLayout(null);
 		p2.setVisible(true);
 		
 		
 		bike=new JLabel("Bike Name            :");
  		bike.setBounds(70,20,500,200);
  		bike.setFont(bigfont);		
		p2.add(bike);
		
		company=new JLabel("Company Name :");
		company.setBounds(70,120,500,200);
		company.setFont(bigfont);		
		p2.add(company);
		
		price=new JLabel("Bike Price           :");
		price.setBounds(70,220,500,200);
		price.setFont(bigfont);		
		p2.add(price);
		
		speed=new JLabel("Top Speed           :");
		speed.setBounds(70,320,500,200);
		speed.setFont(bigfont);		
		p2.add(speed);
		
		b=new JLabel("Bike Name2 ");
  		b.setBounds(470,20,500,200);
  		b.setFont(bigfont);		
		p2.add(b);
		
		c=new JLabel("Company Name2  ");
		c.setBounds(470,120,500,200);
		c.setFont(bigfont);		
		p2.add(c);
		
		p=new JLabel("Bike Price2  ");
		p.setBounds(470,220,500,200);
		p.setFont(bigfont);		
		p2.add(p);
		
		s=new JLabel("Top Speed2 ");
		s.setBounds(470,320,500,200);
		s.setFont(bigfont);		
		p2.add(s);
		
		b1=new JButton("View Deatails");
		b1.setFont(titlefont);
		b1.setBackground(Color.decode("#a8642a"));
		b1.setForeground(Color.WHITE);
		b1.setBounds(670, 500,250,60);
		p2.add(b1);
		
		line=new JLabel("_________________________________________________________________________");
		line.setBounds(0,430,1000,300);
		line.setFont(bigfont);		
		p2.add(line);
 		
 		
 		return p2;
  }
  else{
	   ImageIcon p3Icon=new ImageIcon("C://Users/saurabh/Desktop/movies/self/bike3.jpg");
		final Image p3icon=p3Icon.getImage();
		p3=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(p3icon,1140, 100, this);
			}
		};
		//address=new JPanel();
		p3.setBounds(380, 300, 350, 600);
		p3.setBackground(Color.decode("#8FE0D5"));
		p3.setLayout(null);
		p3.setVisible(true);
		
		bike=new JLabel("Bike Name            :");
  		bike.setBounds(70,20,500,200);
  		bike.setFont(bigfont);		
		p3.add(bike);
		
		company=new JLabel("Company Name :");
		company.setBounds(70,120,500,200);
		company.setFont(bigfont);		
		p3.add(company);
		
		price=new JLabel("Bike Price           :");
		price.setBounds(70,220,500,200);
		price.setFont(bigfont);		
		p3.add(price);
		
		speed=new JLabel("Top Speed           :");
		speed.setBounds(70,320,500,200);
		speed.setFont(bigfont);		
		p3.add(speed);
		
		b=new JLabel("Bike Name3 ");
  		b.setBounds(470,20,500,200);
  		b.setFont(bigfont);		
		p3.add(b);
		
		c=new JLabel("Company Name3  ");
		c.setBounds(470,120,500,200);
		c.setFont(bigfont);		
		p3.add(c);
		
		p=new JLabel("Bike Price3  ");
		p.setBounds(470,220,500,200);
		p.setFont(bigfont);		
		p3.add(p);
		
		s=new JLabel("Top Speed3 ");
		s.setBounds(470,320,500,200);
		s.setFont(bigfont);		
		p3.add(s);
		
		b1=new JButton("View Deatails");
		b1.setFont(titlefont);
		b1.setBackground(Color.decode("#a8642a"));
		b1.setForeground(Color.WHITE);
		b1.setBounds(670, 500,250,60);
		p3.add(b1);
		
		line=new JLabel("_________________________________________________________________________");
		line.setBounds(0,430,1000,300);
		line.setFont(bigfont);		
		p3.add(line);
		
		
		return p3;
	   
  }*/