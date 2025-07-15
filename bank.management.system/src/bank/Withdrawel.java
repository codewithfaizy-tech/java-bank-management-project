package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class Withdrawel extends JFrame implements ActionListener {
    JButton back , withdraw;
    JTextField amount;
    String pin;
    Withdrawel(String pin){
        this.pin = pin;
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon\\atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel label = new JLabel(l3);
        label.setBounds(0,0,800,700);
        add(label);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(150,220,400,20);
        text.setForeground(Color.white);
        label.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setBounds(150,270,300,30);
        label.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(310,380,150,25);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back = new JButton("Back");
        back.setBounds(310,410,150,25);
        back.addActionListener(this);
        label.add(back);



        setLayout(null);
        setSize(800,800);
        setLocation(230,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==withdraw){
            String Amount = amount.getText();
            Date date = new Date();
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter amount");
            } else{
                conn con = new conn();
                String query = "INSERT INTO bank VALUES ('" + pin + "', '" + date + "', 'Withdraw', '" + Amount + "')";
                JOptionPane.showMessageDialog(null,"Rupees "+Amount+" Withdraw successfully");
                setVisible(false);
                new Transaction(pin).setVisible(true);
                try {
                    con.s.executeUpdate(query);
                }catch (Exception ae){
                    System.out.println(ae);
                }

            }

        } else if (e.getSource()==back) {
            setVisible(false);
            Transaction t1 = new Transaction(pin);
            t1.setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Withdrawel("");
    }
}
