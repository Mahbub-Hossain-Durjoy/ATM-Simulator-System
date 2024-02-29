package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    Random ran;
    long random;
    JTextField nameTextField,  fnameTextField, emailTextField, addressTextField, cityTextField,
            divisionTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dateChooser;
    JLabel formno, personalDetails, name, fname, dob, gender, email, marital, address, city, 
            division, pin;
    ButtonGroup genderGroup, maritalGroup;
    
    SignupOne() {
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");

        ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(110, 10, 600, 35);
        add(formno);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(270, 60, 400, 30);
        add(personalDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 110, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(310, 110, 400, 30);
        add(nameTextField);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 150, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(310, 150, 400, 30);
        add(fnameTextField);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(310, 190, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 230, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(310, 230, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 230, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 270, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(310, 270, 400, 30);
        add(emailTextField);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 310, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(310, 310, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 310, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);


        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 350, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(310, 350, 400, 30);
        add(addressTextField);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 390, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(310, 390, 400, 30);
        add(cityTextField);

        division = new JLabel("Division:");
        division.setFont(new Font("Raleway", Font.BOLD, 20));
        division.setBounds(100, 430, 200, 30);
        add(division);

        divisionTextField = new JTextField();
        divisionTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        divisionTextField.setBounds(310, 430, 400, 30);
        add(divisionTextField);

        pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 470, 200, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(310, 470, 400, 30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(630, 530, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 650);
        setLocation(350, 10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long value type cast to string
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        }
        else {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        }
        else {
            marital = "Unmarried"; 
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String division = divisionTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else {
                Conn c = new Conn();
                String query = "insert into signup values('"+ formno +"', '"+ name +"', '"+ fname 
                        +"', '"+ dob +"', '"+ gender +"', '"+ email +"', '"+ marital +"', '"+ address
                        +"', '"+ city +"', '"+ division +"', '"+ pin +"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
