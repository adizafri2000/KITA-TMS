package src;

import javax.swing.*;

public class MainMenu extends JFrame{

    
    
    static JFrame frame2;
    static JPanel panel2;
    static JLabel success;
    static JButton buttonClick;
    static JLabel countLabel;
    
    public MainMenu(){
        frame2 = new JFrame();
        frame2.setSize(350,180);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel2 = new JPanel();
        frame2.add(panel2);
        panel2.setLayout(null);
        
        success = new JLabel("");
        success.setBounds(100,20,165,25);
        panel2.add(success);
        
        buttonClick = new JButton("Logout");
        buttonClick.setBounds(100,80,100,25);
        buttonClick.addActionListener(new LoginSignUpGUI());
        panel2.add(buttonClick);
        
        countLabel = new JLabel("");
        countLabel.setBounds(100,50,165,25);
        panel2.add(countLabel);
        
        
        frame2.setVisible(false);
      }
}

	
	
	
