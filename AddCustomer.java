
package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField tfname,tfphn,tfadhar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(300,20,500,32);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //NAME OF CUSTOMER
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname=new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        JLabel lblnation=new JLabel("Nationality");
        lblnation.setBounds(60,130,150,25);
        lblnation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnation);
        
         tfnationality=new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        JLabel lbladhar=new JLabel("Adhar Number");
       lbladhar.setBounds(60,180,150,25);
       lbladhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladhar);
        
         tfadhar=new JTextField();
        tfadhar.setBounds(220,180,150,25);
        add(tfadhar);
        
        JLabel lbaddress=new JLabel("Address");
       lbaddress.setBounds(60,230,150,25);
      lbaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaddress);
        
        tfaddress=new JTextField();
       tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender=new JLabel("Gender");
       lblgender.setBounds(60,280,150,25);
      lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup=new ButtonGroup();
        
         rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale=new JRadioButton("FeMale");
        rbfemale.setBounds(300,280,70,25);
         rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale); 
        gendergroup.add(rbfemale);
        
         JLabel lblphn=new JLabel("Phone");
        lblphn.setBounds(60,330,150,25);
        lblphn.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphn);
        
         tfphn=new JTextField();
       tfphn.setBounds(220,330,150,25);
        add(tfphn);
        
        JButton save=new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/emp.png"));
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
        
        
         
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phone=tfphn.getText();
        String address=tfaddress.getText();
        String adhar=tfadhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
       try{
           Conn conn=new Conn();
           
           String query="insert into passanger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+adhar+"','"+gender+"')";
       
          conn.s.executeUpdate(query);
          
          JOptionPane.showMessageDialog(null,"Customer Detailed Added Successfully");
           setVisible(false);
       } catch(Exception e){
           e.printStackTrace();
       }
    }
    public static void main(String[] args){
        new AddCustomer();
    }
}
