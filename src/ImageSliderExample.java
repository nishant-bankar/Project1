import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageSliderExample {
    private JFrame frame;
    private JPanel imagePanel;
    private Timer timer,timer1;
    private int currentIndex = 0;

    private String[] imagePaths = {"C://Users/saurabh/Desktop/movies/self/BlueTooth/a.jpeg","C://Users/saurabh/Desktop/movies/self/BlueTooth/b.jpg","C://Users/saurabh/Desktop/movies/self/BlueTooth/c.jpg"};
    
    ImageSliderExample()
    {
    	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
    	frame = new JFrame("Image Slider Example");
        
        
        frame.setSize(400, 300);
        //frame.setLocationRelativeTo(null);
        frame.setBounds(363,208, d.width,775);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    	
    }
    

    public static void main(String[] args)throws Exception {
            ImageSliderExample example = new ImageSliderExample();
           example.createAndShowGUI();
    }

    void createAndShowGUI() {

        imagePanel = new JPanel();
        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);

        // Create and start a Timer to switch images every 3 seconds (adjust as needed)
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        
     /*   timer1 = new Timer(9000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ImageSliderExample example = new ImageSliderExample();
                example.createAndShowGUI();
            }
        });*/
        timer.start();

        // Show the initial image
        showImage(currentIndex);

        
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % imagePaths.length;
        showImage(currentIndex);
    }

    private void showImage(int index) {
        if (index >= 0 && index < imagePaths.length) {
            // Load the image from the specified path
            ImageIcon imageIcon = new ImageIcon(imagePaths[index]);
            Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);

            // Update the JLabel in the JPanel
            imagePanel.removeAll();
            imagePanel.add(new JLabel(new ImageIcon(image)));
            imagePanel.revalidate();
            imagePanel.repaint();
        }
    }
}