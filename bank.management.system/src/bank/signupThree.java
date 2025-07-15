package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    Random random;
    String formno;

    signupThree(String formno) {
        this.formno = formno;

        // Initialize components as before...
        JLabel l1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Railway", Font.BOLD, 30));
        l1.setBounds(150, 40, 500, 40);
        add(l1);

        JLabel type = new JLabel("Account Type ");
        type.setFont(new Font("Railway", Font.BOLD, 25));
        type.setBounds(100, 120, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account ");
        r1.setFont(new Font("Railway", Font.BOLD, 16));
        r1.setBounds(100, 180, 300, 20);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway", Font.BOLD, 16));
        r2.setBounds(420, 180, 300, 20);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway", Font.BOLD, 16));
        r3.setBounds(100, 220, 300, 20);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway", Font.BOLD, 16));
        r4.setBounds(420, 220, 300, 20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupSaving = new ButtonGroup();
        groupSaving.add(r1);
        groupSaving.add(r2);
        groupSaving.add(r3);
        groupSaving.add(r4);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Railway", Font.BOLD, 25));
        card.setBounds(100, 270, 200, 30);
        add(card);

        JLabel cardDetail = new JLabel("Your 16 digit card number");
        cardDetail.setFont(new Font("Railway", Font.BOLD, 12));
        cardDetail.setBounds(100, 305, 200, 20);
        add(cardDetail);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-9302");
        number.setFont(new Font("Railway", Font.BOLD, 25));
        number.setBounds(420, 270, 600, 30);
        add(number);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(100, 345, 200, 30);
        add(pin);

        JLabel pinDetail = new JLabel("Your 4 digit pin number");
        pinDetail.setFont(new Font("Railway", Font.BOLD, 12));
        pinDetail.setBounds(100, 380, 200, 20);
        add(pinDetail);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Railway", Font.BOLD, 25));
        pnumber.setBounds(420, 345, 600, 30);
        add(pnumber);

        JLabel service = new JLabel("Services Required ");
        service.setFont(new Font("Railway", Font.BOLD, 25));
        service.setBounds(100, 420, 400, 30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Railway", Font.BOLD, 16));
        c1.setBounds(100, 470, 200, 20);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway", Font.BOLD, 16));
        c2.setBounds(310, 470, 200, 20);
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway", Font.BOLD, 16));
        c3.setBounds(530, 470, 200, 20);
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("Email & SMS");
        c4.setFont(new Font("Railway", Font.BOLD, 16));
        c4.setBounds(100, 500, 200, 20);
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("Cheque Book ");
        c5.setFont(new Font("Railway", Font.BOLD, 16));
        c5.setBounds(310, 500, 200, 20);
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway", Font.BOLD, 16));
        c6.setBounds(530, 500, 200, 20);
        c6.setBackground(Color.white);
        add(c6);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Railway", Font.BOLD, 16));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(100, 560, 200, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Railway", Font.BOLD, 16));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(530, 560, 200, 40);
        cancel.addActionListener(this);
        add(cancel);

        // Frame settings
        setLayout(null);
        setSize(800, 800);
        setVisible(true);
        setLocation(220, 0);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = " ";
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposite Account ";

            } else if (r3.isSelected()) {
                accountType = " Current Account";

            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposite Account";

            }
            random = new Random();
            String accountNumber = " " + 9302l + Math.abs(random.nextLong() % 900000000000l);
            String pinNum = " " + Math.abs(random.nextInt() % 9000l);
            String facility = "";
            if (c1.isSelected()) {
                facility += " ATM CARD ";
            }
            if (c2.isSelected()) {
                facility += " Internet Banking ";
            }
            if (c3.isSelected()) {
                facility += " Mobile Banking ";
            }
            if (c4.isSelected()) {
                facility += " E-mail & SMS ";
            }
            if (c5.isSelected()) {
                facility += " ChequeBook ";
            }
            if (c6.isSelected()) {
                facility += " E-statement ";
            }
            JOptionPane.showMessageDialog(null,"Your Account Number is :"+accountNumber+" and Pin Number "+pinNum+"");

            try {
                if (accountType.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    conn con = new conn();
                    String query = "insert into signup3 values ('"+formno+"','"+accountType+"','"+accountNumber+"','"+pinNum+"','"+facility+"')";
                    con.s.executeUpdate(query);
                    String query2 = "insert into login values ('"+formno+"','"+accountNumber+"','"+pinNum+"')";
                    con.s.executeUpdate(query2);
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            signUp2 sin = new signUp2("");
            sin.setVisible(true);


        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
