package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    
    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(305, 450, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pinNumber +"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is");
        text.setForeground(Color.WHITE);
        text.setBounds(180, 280, 500, 30);
        image.add(text);
        
        JLabel text2 = new JLabel("Tk. " + balance);
        text2.setForeground(Color.WHITE);
        text2.setBounds(230, 300, 500, 30);
        image.add(text2);
        
        setSize(800, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String[] args) { 
        new BalanceEnquiry("");
    }
}
