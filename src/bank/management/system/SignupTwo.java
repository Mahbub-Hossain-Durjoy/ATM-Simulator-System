package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField addressTextField, cityTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JLabel additionalDetails, name, fname, dob, email, marital, address, city, division, pin;
    ButtonGroup maritalGroup, emaritalGroup;
    JComboBox religion, category, income, education, occupation;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(270, 10, 400, 30);
        add(additionalDetails);

        name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 70, 100, 30);
        add(name);
        
        String valReligion[] = {"Muslim", "Hindu", "Buddhist", "Christian"};
        religion = new JComboBox(valReligion);
        religion.setBounds(310, 70, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        fname = new JLabel("Blood Group:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 110, 200, 30);
        add(fname);

        String valCategory[] = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        category = new JComboBox(valCategory);
        category.setBounds(310, 110, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 150, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "> 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(310, 150, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        email = new JLabel("Education:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 190, 200, 30);
        add(email);
        
        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(310, 190, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 230, 200, 30);
        add(marital);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(310, 230, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        address = new JLabel("NID No:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 270, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(310, 270, 400, 30);
        add(addressTextField);

        city = new JLabel("Passport No:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 310, 300, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(310, 310, 400, 30);
        add(cityTextField);

        division = new JLabel("Senior Citizen:");
        division.setFont(new Font("Raleway", Font.BOLD, 20));
        division.setBounds(100, 350, 200, 30);
        add(division);

        syes = new JRadioButton("Yes");
        syes.setBounds(310, 350, 60, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 350, 60, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

        pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 390, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(310, 390, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 390, 60, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(630, 450, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 550);
        setLocation(350, 10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        }
        else {
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        }
        else {
            existingAccount = "No"; 
        }
        
        String nid = addressTextField.getText();
        String passport = cityTextField.getText();
        
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+ formno +"', '"+ sreligion +"', '"+ scategory 
                    +"', '"+ sincome +"', '"+ seducation +"', '"+ soccupation +"', '"+ nid +"', '"+ passport
                    +"', '"+ seniorCitizen +"', '"+ existingAccount +"')";
            c.s.executeUpdate(query);
            
            // Signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
