package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinNumber;
    
    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(10, 70, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("Bangladesh Bank");
        bank.setBounds(130, 20, 150, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(10, 50, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(10, 300, 300, 20);
        add(balance);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+ pinNumber +"'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            int balan = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+ pinNumber +"'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balan += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balan -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Tk. " + balan);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(400, 400);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
