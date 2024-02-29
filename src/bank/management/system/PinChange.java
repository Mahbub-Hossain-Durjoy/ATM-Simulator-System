package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin, rePin;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(215, 260, 500, 35);
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 14));
        pinText.setBounds(145, 317, 180, 25);
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(295, 315, 160, 25);
        image.add(pin);
           
        JLabel rePinText = new JLabel("Confirm New PIN:");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 14));
        rePinText.setBounds(145, 357, 180, 25);
        image.add(rePinText);
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(295, 355, 160, 25);
        image.add(rePin);
        
        change = new JButton("Change");
        change.setBounds(305, 410, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(305, 450, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = rePin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "PIN doesn't match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+ rpin + "' where pin = '"+ pinNumber + "'";
                String query2 = "update login set pin = '"+ rpin + "' where pin = '"+ pinNumber + "'";
                String query3 = "update signupthree set pin = '"+ rpin + "' where pin = '"+ pinNumber + "'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch (Exception e)  {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);;
    }
}
