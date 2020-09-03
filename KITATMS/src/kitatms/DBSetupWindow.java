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
import javax.swing.JFrame;
/**
 *
 * @author adiza
 */
public class DBSetupWindow extends JFrame implements ActionListener {

    JButton passwordButton = new JButton("Submit");
    JPasswordField passwordInput = new JPasswordField(20);
    
    public DBSetupWindow(){
        super("MySQL Database Password Setup");
        JPanel top = new JPanel();
        top.add(passwordInput);
        passwordInput.setBounds(120,250,165,25);
        top.add(passwordButton);
        passwordButton.addActionListener(this);
        this.add(top);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setVisible(true);
        
        
        /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1060, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.setFocusable(true);*/
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getPassword(passwordInput);
    }
    
    private String getPassword(JPasswordField pw){
        return pw.getSelectedText();
    }
    
}
