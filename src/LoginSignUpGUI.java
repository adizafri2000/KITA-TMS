package src;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JFrame;

public class LoginSignUpGUI implements ActionListener{
	private static JFrame frame;
	private static JTextField usernameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JButton buttonRegister;
	private static JLabel label;
	private static JLabel message;
	private static JLabel title;
	
	
	private static JFrame frameMenu;
	private static JPanel panel2;
	private static JLabel success;
	private static JButton logoutButton;
	
	
	public static void main(String[] args){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(340,500);
		frame.getContentPane().setBackground(Color.BLUE);
		
		
		//JFrame frame = new JFrame();
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setPreferredSize(new Dimension(340,500));
                //frame.getContentPane().setBackground(Color.BLUE);
                //frame.pack();
                //frame.setVisible(true);
				
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		title = new JLabel("KITA TRAINING SYSTEM");
		title.setBounds(60,100,300,25);
		title.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(title);
		
		label = new JLabel("username");
		label.setBounds(15,220,80,25);
		panel.add(label);
		
		usernameText = new JTextField(20);
		usernameText.setBounds(120,220,165,25);
		panel.add(usernameText);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setBounds(15,250,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField(20);
		passwordText.setBounds(120,250,165,25);
		panel.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10,280,80,25);
		loginButton.addActionListener(new LoginSignUpGUI());
		panel.add(loginButton);
		//loginButton.setBackground(Color.GRAY);
		
		buttonRegister = new JButton("Register");
		buttonRegister.setBounds(193,280,90,25);
		buttonRegister.addActionListener(new LoginSignUpGUI());
		panel.add(buttonRegister);
		
		message = new JLabel("");
		message.setBounds(10,310,300,25);
		//message.setFont(new Font("Verdana", Font.PLAIN, 15));
		panel.add(message);
		
		frame.setVisible(true);
		
		///////////////////////////////////////////////////////////////
		frameMenu = new JFrame();
		frameMenu.setSize(350,180);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel2 = new JPanel();
		frameMenu.add(panel2);
		panel2.setLayout(null);
		
		success = new JLabel("");
		success.setBounds(100,20,165,25);
		panel2.add(success);
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(100,80,100,25);
		logoutButton.addActionListener(new LoginSignUpGUI());
		panel2.add(logoutButton);
		
		
		frameMenu.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		String username = usernameText.getText();
		String password = String.valueOf(passwordText.getPassword());
		
		
		if(e.getSource()==loginButton){
            Login verifyUser = new Login();
            System.out.println("VerifyLogin created");
			boolean flag = verifyUser.verifyLogin(username,password,"members.txt");	

			if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
				message.setText("Please fill  in username and password");
			}	
			else{
				if(flag==true){
				
					success.setText("Main Menu");
					frameMenu.setVisible(true);
					frame.setVisible(false);	
				}
				else{
					message.setText("Wrong username or password");
				}
			}
				
				
		}
			
		
		if(e.getSource()==buttonRegister){
			SignUp newUser = new SignUp();
			boolean flag = false;
			if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
				message.setText("Please fill  in username and password");
			}
			else{
				flag = newUser.registerNewUser(username, password, password,"members.txt");	
				if(flag==true){
					message.setText("You are now registered!");
				}
				else{
					message.setText("Oops, username is taken");
				}
			}
			
			
		}
		
		if(e.getSource()==logoutButton){
			frameMenu.setVisible(false);
			frame.setVisible(true);
			usernameText.setText("");
			passwordText.setText("");
		}	
	
	}
}
	
	
	
