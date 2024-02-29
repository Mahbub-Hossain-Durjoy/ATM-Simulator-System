package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(180, 270, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Tk. 100");
        deposit.setBounds(140, 370, 150, 27);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Tk. 500");
        withdrawal.setBounds(303, 370, 155, 27);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastCash = new JButton("Tk. 1000");
        fastCash.setBounds(140, 400, 150, 27);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Tk. 2000");
        miniStatement.setBounds(303, 400, 155, 27);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Tk. 5000");
        pinChange.setBounds(140, 430, 150, 27);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Tk. 10000");
        balanceEnquiry.setBounds(303, 430, 155, 27);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Back");
        exit.setBounds(140, 460, 150, 27);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton) ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pinNumber +"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Tk. " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
