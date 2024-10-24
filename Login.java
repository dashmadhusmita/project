/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagmentsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author KIIT0001
 */
public class Login extends JFrame implements ActionListener {
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
     public Login(){

         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername = new JLabel("username");
         lblusername.setBounds(20,20,100,20);
         add(lblusername);
         
          tfusername=new JTextField();
         tfusername.setBounds(130,20,200,20);
         add(tfusername);
         
          JLabel lblpassword = new JLabel("password");
         lblpassword.setBounds(20,50,100,20);
         add(lblpassword);
         
          tfpassword=new JPasswordField();
         tfpassword.setBounds(130,50,200,20);
         add(tfpassword);
         
          reset=new JButton("Reset");
         reset.setBounds(40,100,200,20);
        reset.addActionListener(this);
         add(reset);
         
          submit=new JButton("Submit");
         submit.setBounds(280,100,200,20);
         submit.addActionListener(this);
         add(submit);
         
          close=new JButton("Close");
         close.setBounds(180,140,200,20);
         close.addActionListener(this);
         add(close);
         
         
         
         setSize(500,250);
         setLocation(600,250);
         setVisible(true);
         
     }
     @Override
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            try{
                Conn c=new Conn();
                String query="select * from login where username = '"+username+"'and password = '"+password+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              
              if(rs.next()){
                  new Home();
                  setVisible(false);
              }else{
                  JOptionPane.showMessageDialog(null,"Invalid username or password");
                  setVisible(false);
              }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == close){
            setVisible(false);

        }else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
        }
     }
      
    public static void main(String[] args){
        new Login();
    }
}

