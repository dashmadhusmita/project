
package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname,cancellation,tfcode,lbldateoftravel;
    JButton fetchButton, cancel;
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random=new Random();
        
        JLabel heading=new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
        
        JLabel lblpnr=new JLabel("PNR NUMBER");
      lblpnr.setBounds(60,80,150,25);
       lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpnr);
        
         tfpnr=new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);
        
       fetchButton=new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname=new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        JLabel lblnation=new JLabel("Cancellation No");
        lblnation.setBounds(60,180,150,25);
        lblnation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnation);
        
         cancellation=new JLabel("" +random.nextInt(1000000));
       cancellation.setBounds(220,180,150,25);
        add(cancellation);
        
        
        
        JLabel lbcode=new JLabel("Flight Code");
       lbcode.setBounds(60,230,150,25);
      lbcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbcode);
        
        tfcode=new JLabel();
       tfcode.setBounds(220,230,150,25);
        add(tfcode);
        
          
        JLabel lbldate=new JLabel("Date");
       lbldate.setBounds(60,280,150,25);
      lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
         lbldateoftravel=new JLabel();
      lbldateoftravel.setBounds(220,280,150,25);
        add(lbldateoftravel);
        
        
       cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.setBounds(220,330,120,25);
        cancel.addActionListener(this);
        add( cancel);
        
         
        
        
         
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==fetchButton){
            
       
        String pnr=tfpnr.getText();
       
       try{
           Conn conn=new Conn();
           
           String query="select * from reservation where  PNR='"+pnr+"'";
       
         ResultSet rs= conn.s.executeQuery(query);
          
         if(rs.next()){
             tfname.setText(rs.getString("name"));
             tfcode.setText(rs.getString("flightcode"));
             lbldateoftravel.setText(rs.getString("ddate"));         
         }else{
            JOptionPane.showMessageDialog(null,"please enter correct PNR");
         }
       } catch(Exception e){
           e.printStackTrace();
       }
        }else if(ae.getSource()==cancel){
           
        String name=tfname.getText();
        String pnr=tfpnr.getText();
        String cancelno=cancellation.getText();
        String fcode=tfcode.getText();
        String date=lbldateoftravel.getText();
       
       try{
           Conn conn=new Conn();
           
           String query="insert into cancel values ('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
       
         conn.s.executeUpdate(query);
         conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
         JOptionPane.showMessageDialog(null,"Ticket Cancelled");
         setVisible(false);
         
       } catch(Exception e){
           e.printStackTrace();
       }
    }
     
     }
    
    public static void main(String[] args){
        new Cancel();
    }
}

