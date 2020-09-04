/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{
    public static LoginSignUpGUI loginSignUpGUI = new LoginSignUpGUI();
    public static MainMenu mainMenu = new MainMenu();
    public static boolean logout = false; 
    
    private static JPanel panel;
    private static JLabel title;
    private static JButton logoutButton;
    
    public MainMenu(){
        this.setSize(340,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	panel = new JPanel();
	this.add(panel);
	panel.setLayout(null);
		
	title = new JLabel("KITA TMS Menu");
	title.setBounds(100,20,165,25);
        title.setFont(new Font("Verdana", Font.BOLD, 15));
	panel.add(title);
		
	logoutButton = new JButton("Logout");
	logoutButton.setBounds(100,400,100,25);
	logoutButton.addActionListener(this);
	panel.add(logoutButton);
		
		
	this.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logoutButton){
			this.setVisible(false);
                        logout = true;
                        loginSignUpGUI.access=false;
			
        }
    }
    public static void main(String[] args){
        
        while(true){
            while(loginSignUpGUI.access==false){
                mainMenu.setVisible(false);
                loginSignUpGUI.setVisible(true);
                if(loginSignUpGUI.access==true){
                    loginSignUpGUI.setVisible(false);
                    break;
                }
            }
            logout=false;
            while(logout==false){
                
                mainMenu.setVisible(true);
                if(logout==true){
                    break;
                }
            }
            
        }
        

       
        
        
    }
    
}

	
	
	
