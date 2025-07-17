import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;


@SuppressWarnings("serial")
public class MainWindow {

	
	JFrame frame;
	JPanel westpanel,centrepanel,add,update,dlt, search, desk;
	JButton dash,stud,walk,addb,updateb, dltb, searchb,deskb;
	MainWindow()
	{
		//MainFrame Layout Null
		frame=new JFrame("Vivekanand Study Centre");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon icon=new ImageIcon("C://internship/StudyCentre/LOGO.jpg");
		frame.setIconImage(icon.getImage());
		frame.setLayout(null);
		//frame.setVisible(true);
		
		
		
		
		
		
		
		
		//WestPanel{
		
		
		
		//TabExplorer
		westpanel=new JPanel();
		//westpanel.setSize(250, 990);
		westpanel.setBounds(0, 0, 250, 990);
		westpanel.setVisible(true);
		westpanel.setBackground(Color.decode("#9300C7"));
		westpanel.setLayout(null);
		frame.add(westpanel);
		
		dash=new JButton("Dashboard");
		dash.setBorder(null);
		dash.setBackground(Color.decode("#9300C7"));
		dash.setBounds(50, 100, 90, 20);
		westpanel.add(dash);
		
		
		stud=new JButton("Student");
		stud.setBorder(null);
		stud.setBackground(Color.decode("#9300C7"));
		stud.setBounds(50, 150, 90, 20);
		westpanel.add(stud);
	
		walk=new JButton("Walk-in");
		walk.setBorder(null);
		walk.setBackground(Color.decode("#9300C7"));
		walk.setBounds(50, 200, 90, 20);
		westpanel.add(walk);
		
		
		
		
		
	//}westPanel end
		
		
		
		
		
		
		
		
		//CentrePanel{
		centrepanel=new JPanel();
		centrepanel.setBounds(250, 0, 1668, 990);
		centrepanel.setVisible(true);
		centrepanel.setBackground(Color.decode("#030324"));
		centrepanel.setLayout(null);
		frame.add(centrepanel);
		
		
		//add panel{
		
		add=new JPanel(){
			protected void paintComponent(Graphics g){
			super.paintComponent(g);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			int cornerRadius=25;
			//g.drawImage(image, 0, 0, this);
			g.setColor(Color.decode("#BDBA0F"));
			g.fillRoundRect(0, 0, 300, 200, cornerRadius, cornerRadius);
						
			}
		}; 
		add.setBackground(Color.decode("#030324"));
		add.setLayout(null);
		add.setBounds(300,300,300, 200);
		centrepanel.add(add);
		
		
		
		//addPanel Button{
		ImageIcon addicon=new ImageIcon("C://Users/Mohit Patil/Downloads/add1.png");
		addb=new JButton("Add person",addicon);
		addb.setBackground(Color.decode("#BDBA0F"));
		addb.setForeground(Color.WHITE);
		addb.setBounds(170,90,110,20);
		addb.setBorder(null);
		add.add(addb);
		//}
		
		
		//Add panel Image{
		ImageIcon imageIcon1=new ImageIcon("C://Users/Mohit Patil/Downloads/add12.png");
		JLabel image1=new JLabel(imageIcon1);
		image1.setBounds(40, 50, 100, 100);
		add.add(image1);
		//}
		
		
		//}add panel end
		
		
	
				
				
				
				
				
				
		//update panel`{
		update=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
						
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						
				int cornerRadius=25;
				g.setColor(Color.decode("#BDBA0F"));
				g.fillRoundRect(0, 0, 300, 200, cornerRadius, cornerRadius);
						
			}
		}; 
		update.setLayout(null);
		update.setBackground(Color.decode("#030324"));
		update.setBounds(700,300,300, 200);
		centrepanel.add(update);
		
		
		//update panel button{
		ImageIcon updateicon=new ImageIcon("C://Users/Mohit Patil/Downloads/updateb.png");
		updateb=new JButton("Update person",updateicon);
		updateb.setBackground(Color.decode("#BDBA0F"));
		updateb.setForeground(Color.WHITE);
		updateb.setBounds(170,90,110,20);
		updateb.setBorder(null);
		update.add(updateb);
		//}
		
		
		
		//update panel image{
		ImageIcon imageIcon2=new ImageIcon("C://Users/Mohit Patil/Downloads/update.png");
		JLabel image2=new JLabel(imageIcon2);
		image2.setBounds(40, 50, 100, 100);
		update.add(image2);
		//}
		
		
		
		
		//}update panel end
		
		
		
		
		
		
		
		
				
		dlt=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
						
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						
				int cornerRadius=25;
				g.setColor(Color.decode("#BDBA0F"));
				g.fillRoundRect(0, 0, 300, 200, cornerRadius, cornerRadius);
						
			}
		}; 
		dlt.setLayout(null);
		dlt.setBackground(Color.decode("#030324"));
		//add.setBorder(BorderFactory.createLineBorder(Color.black));
		dlt.setBounds(1100,300,300, 200);
		centrepanel.add(dlt);
		
		ImageIcon dlticon=new ImageIcon("C://Users/Mohit Patil/Downloads/dltb.png");
		dltb=new JButton("Delete",dlticon);
		dltb.setBackground(Color.decode("#BDBA0F"));
		dltb.setForeground(Color.WHITE);
		dltb.setBounds(170,90,110,20);
		dltb.setBorder(null);
		dlt.add(dltb);
		
		
		ImageIcon imageIcon3=new ImageIcon("C://Users/Mohit Patil/Downloads/dlt.png");
		JLabel image3=new JLabel(imageIcon3);
		image3.setBounds(40, 50, 100, 100);
		dlt.add(image3);
		
		
		
		
		
		
		
		
			
		search=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
						
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						
				int cornerRadius=25;
				g.setColor(Color.decode("#BDBA0F"));
				g.fillRoundRect(0, 0, 300, 200, cornerRadius, cornerRadius);
						
			}
		}; 
		search.setLayout(null);
		search.setBackground(Color.decode("#030324"));
		search.setBounds(490,580,300, 200);
		centrepanel.add(search);
				
		ImageIcon searchicon=new ImageIcon("C://Users/Mohit Patil/Downloads/searchb.png");
		searchb=new JButton("Search",searchicon);
		searchb.setBackground(Color.decode("#BDBA0F"));
		searchb.setForeground(Color.WHITE);
		searchb.setBounds(170,90,110,20);
		searchb.setBorder(null);
		search.add(searchb);
				
				
		
		ImageIcon imageIcon4=new ImageIcon("C://Users/Mohit Patil/Downloads/search.png");
		JLabel image4=new JLabel(imageIcon4);
		image4.setBounds(40, 50, 100, 100);
		search.add(image4);
		
		
		
				
		desk=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
						
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						
				int cornerRadius=25;
				g.setColor(Color.decode("#BDBA0F"));
				g.fillRoundRect(0, 0, 300, 200, cornerRadius, cornerRadius);
						
			}
		}; 
		desk.setLayout(null);
		desk.setBackground(Color.decode("#030324"));
		//add.setBorder(BorderFactory.createLineBorder(Color.black));
		desk.setBounds(890,580,300, 200);
		centrepanel.add(desk);
		
		ImageIcon deskicon=new ImageIcon("C://Users/Mohit Patil/Downloads/deskb.png");
		deskb=new JButton("Desk",deskicon);
		deskb.setBackground(Color.decode("#BDBA0F"));
		deskb.setForeground(Color.WHITE);
		deskb.setBounds(170,90,110,20);
		deskb.setBorder(null);
		desk.add(deskb);
		
		
		
		ImageIcon imageIcon5=new ImageIcon("C://Users/Mohit Patil/Downloads/desk.png");
		JLabel image5=new JLabel(imageIcon5);
		image5.setBounds(40, 50, 100, 100);
		desk.add(image5);
				
		
		
		frame.setVisible(true);
		
		
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		MainWindow mw=new MainWindow();

	}

}
