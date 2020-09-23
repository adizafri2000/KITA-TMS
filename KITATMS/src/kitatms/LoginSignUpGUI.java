/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class LoginSignUpGUI extends JFrame implements ActionListener{
        public static boolean access = false;
	private  JTextField usernameText;
	private  JLabel passwordLabel;
	private  JPasswordField passwordText;
	private  JButton loginButton;
	private  JButton buttonRegisterTrainer;
        private  JButton buttonRegisterTrainee;
	private  JLabel label;
	private  JLabel message;
	private  JLabel title;
	
	
	public LoginSignUpGUI(){
		

		
		this.setSize(350,500);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("KITA TRAINING SYSTEM");
		title.setBounds(60,100,300,25);
		title.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(title);
		
		label = new JLabel("username");
		label.setBounds(15,170,80,25);
		panel.add(label);
		
		usernameText = new JTextField(20);
		usernameText.setBounds(120,170,190,25);
		panel.add(usernameText);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setBounds(15,200,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField(20);
		passwordText.setBounds(120,200,190,25);
		panel.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10,280,300,25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		//loginButton.setBackground(Color.GRAY);
		
		buttonRegisterTrainer = new JButton("Sign Up Trainer");
		buttonRegisterTrainer.setBounds(10,310,300,25);
		buttonRegisterTrainer.addActionListener(this);
		panel.add(buttonRegisterTrainer);
                
                buttonRegisterTrainee = new JButton("Sign Up Trainee");
		buttonRegisterTrainee.setBounds(10,340,300,25);
		buttonRegisterTrainee.addActionListener(this);
		panel.add(buttonRegisterTrainee);
		
		message = new JLabel("");
		message.setBounds(10,400,300,25);
		panel.add(message);
                
		this.add(panel);
		this.setVisible(true);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
            String username = usernameText.getText();
            String password = String.valueOf(passwordText.getPassword());
		
		
            if(e.getSource()==loginButton){
                    Login login = new Login();
                    boolean flag = login.verifyUser(username,password,"members.txt");	

		    if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
			message.setText("Please fill in username and password");
		    }	
		    else{
			if(flag==true){
				this.setVisible(false);
                                usernameText.setText("");
                                passwordText.setText("");
                                message.setText("");
                                access = true;
			}
			else{
				message.setText("Wrong username or password");
			}
		}		
            }

	    if(e.getSource()==buttonRegisterTrainer){
		SignIn signIn = new SignIn();
		boolean flag = false;
		if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
			message.setText("Please fill in username and password");
		}
		else{
	

                    try {
                        flag = signIn.register(username, password, password,"1");
                    } catch (SQLException ex) {
                        //Logger.getLogger(LoginSignUpGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                        if(flag==true){
                            message.setText("You are now registered as a trainer!");
                        }
                        else{
                            message.setText("Username is taken");
                        }
                }
		
            }
            if(e.getSource()==buttonRegisterTrainee){
		SignIn signIn = new SignIn();
		boolean flag = false;
		if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
			message.setText("Please fill in username and password");
		}
		else{
                        
                    try {
                        flag = signIn.register(username, password, password,"2");
                    } catch (SQLException ex) {
                        //Logger.getLogger(LoginSignUpGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
			if(flag==true){
				message.setText("You are now registered as a trainee!");
			}
			else{
				message.setText("Username is taken");
			}
		}			
            }
        }  

    private void setBackground(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
	
	
	

