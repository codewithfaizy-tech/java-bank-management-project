package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton sign , clear , signup;
    JTextField cardtextfield ;
    JPasswordField  pintextfield;
    String rpin;
    Login(String rpin){
        this.rpin = rpin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon\\logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,30,100,100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setBounds(270,40,400,100);
        text.setFont(new Font("Osward",Font.BOLD,34));
        add(text);

        JLabel card = new JLabel("CARD NO: ");
        card.setBounds(120,150,150,40);
        card.setFont(new Font("Railway",Font.BOLD,24));
        add(card);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,230,40);
        add(cardtextfield);

        JLabel pin = new JLabel("ENTER PIN: ");
        pin.setBounds(120,220,150,40);
        pin.setFont(new Font("Railway",Font.BOLD,24));
        add(pin);
        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,230,30);
        add(pintextfield);


        sign = new JButton("Sign in");
        sign.setBounds(300,300,100,40);
        sign.setBackground(Color.black);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);

        clear = new JButton("Clear");
        clear.setBounds(430,300,100,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(300,390,230,40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setTitle("FAIZY KA ATM");
        setSize(800,520);
        setVisible(true);
        setLocation(220,100);
    }


    public static void main(String[] args) {
        new Login("");
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == sign) {
            conn con = new conn();

            String accountNum = cardtextfield.getText();
            String pin = pintextfield.getText();

            if (accountNum.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both card number and PIN.");
            }

            String query2 = "SELECT * FROM login WHERE AccountNum = "+accountNum+" AND PinNum = "+pin+"";
            try {
                ResultSet rs = con.s.executeQuery(query2);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"no pin and account found");
                }

            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else if (e.getSource() == clear) {
            cardtextfield.setText("");
            pintextfield.setText("");
        } else if (e.getSource() == signup) {
            setVisible(false);
            signupOne sign = new signupOne();
            sign.setVisible(true);
        }
    }


}
