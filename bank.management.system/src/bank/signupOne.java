package bank;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class signupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameField, fnameField, emailField, cityField, stateField , pincodeField, addressField;
    JButton next;
    JRadioButton male,female,married,numarried;
    JDateChooser datechose;
    signupOne(){
        setLayout(null);
        Random ran = new Random();
        random = ran.nextInt(9999);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Railway", Font.BOLD, 34));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Railway", Font.BOLD, 22));
        personalDetail.setBounds(290, 80, 400, 30);
        add(personalDetail);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 20);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Railway", Font.PLAIN, 20));
        nameField.setBounds(300, 140, 400, 20);  // Added 50-pixel gap
        add(nameField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 20);
        add(fname);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Railway", Font.PLAIN, 20));
        fnameField.setBounds(300, 190, 400, 20);  // Added 50-pixel gap
        add(fnameField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 20);
        add(dob);

        datechose = new JDateChooser();
        datechose.setBounds(300,240,400,20);
        datechose.setForeground(Color.black);
        add(datechose);


        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 20);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(350,290,60,20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450,290,160,20);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 20);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Railway", Font.PLAIN, 18));
        emailField.setBounds(300, 340, 400, 20);  // Added 50-pixel gap
        add(emailField);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 20);
        add(marital);

        married = new JRadioButton("MARRIED");
        married.setBounds(350,390,160,20);
        married.setBackground(Color.white);
        add(married);

        numarried = new JRadioButton("UNMARRIE");
        numarried.setBounds(520,390,160,20);
        numarried.setBackground(Color.white);
        add(numarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(numarried);


        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 20);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Railway", Font.PLAIN, 18));
        addressField.setBounds(300, 440, 400, 20);  // Added 50-pixel gap
        add(addressField);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 20);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Railway", Font.PLAIN, 18));
        cityField.setBounds(300, 490, 400, 20);  // Added 50-pixel gap
        add(cityField);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 20);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Railway", Font.PLAIN, 18));
        stateField.setBounds(300, 540, 400, 20);  // Added 50-pixel gap
        add(stateField);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 20);
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Railway", Font.PLAIN, 18));
        pincodeField.setBounds(300, 590, 400, 20);  // Added 50-pixel gap
        add(pincodeField);

        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(600,630,120,20);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(220, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField)datechose.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "MALE";
        } else if (female.isSelected()) {
            gender = "FEMALE";

        }
        String email = emailField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String address = addressField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "MARRIED";
        } else if (numarried.isSelected()) {
            marital = "UNMARRIED";

        }
        String pincode = pincodeField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"name is compulsory");
            }
            else {
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"', '"+fname+"','"+dob+"','"+gender+"','"+email+"','"+city+"','"+state+"','"+address+"','"+marital+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                signUp2 two = new signUp2(formno);
                two.setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signupOne();

    }
}
