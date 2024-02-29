package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber; 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(180, 270, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140, 370, 150, 27);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(303, 370, 155, 27);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(140, 400, 150, 27);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(303, 400, 155, 27);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(140, 430, 150, 27);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(303, 430, 155, 27);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(140, 460, 150, 27);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(750, 750);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        }
        else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
