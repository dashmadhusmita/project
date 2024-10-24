
package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname,tfnationality,tfsrc,tfdest,labelfname,labelfcode,labeldate;
    JButton fetchButton;
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Air India");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(heading);
        
        JLabel subheading=new JLabel("Boarding Pass");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,32));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblpnr=new JLabel("PNR DETAILS");
       lblpnr.setBounds(60,100,150,25);
       lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpnr);
        
         tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
       fetchButton=new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        JLabel lblnation=new JLabel("NATIONALITY");
        lblnation.setBounds(60,180,150,25);
        lblnation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnation);
        
         tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lbsrc=new JLabel("SRC");
       lbsrc.setBounds(60,220,150,25);
     lbsrc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbsrc);
        
        tfsrc=new JLabel();
       tfsrc.setBounds(220,220,150,25);
        add(tfsrc);
        
          
        JLabel lbldest=new JLabel("DEST");
       lbldest.setBounds(380,220,150,25);
      lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldest);
        
        tfdest=new JLabel();
       tfdest.setBounds(440,220,150,25);
        add(tfdest);
        
   
        
         JLabel lblfname=new JLabel("Flight Name");
       lblfname.setBounds(60,260,150,25);
      lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname=new JLabel();
      labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
         JLabel lblfcode=new JLabel("Flight Code");
       lblfcode.setBounds(380,260,150,25);
      lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        
        labelfcode=new JLabel();
      labelfcode.setBounds(480,260,150,25);
        add(labelfcode);
        
         JLabel lbldate=new JLabel("Date");
      lbldate.setBounds(60,300,150,25);
      lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        
       labeldate=new JLabel();
      labeldate.setBounds(220,300,150,25);
        add(labeldate);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/airindia.png"));
        Image i2=i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
    
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String pnr=tfpnr.getText();
       
       try{
           Conn conn=new Conn();
           
           String query="select * from reservation where  PNR='"+pnr+"'";
       
         ResultSet rs= conn.s.executeQuery(query);
          
        if(rs.next()){
             tfname.setText(rs.getString("name"));
             tfnationality.setText(rs.getString("nationality"));
             tfsrc.setText(rs.getString("src"));
             tfdest.setText(rs.getString("des"));
             labelfname.setText(rs.getString("flightname"));
             labelfcode.setText(rs.getString("flightcode"));
             labeldate.setText(rs.getString("ddate"));         
         }else{
            JOptionPane.showMessageDialog(null,"please enter correct PNR");
         }
       } catch(Exception e){
           e.printStackTrace();
       }
       
        }
    

    public static void main(String[] args){
        new BoardingPass();
}
}

