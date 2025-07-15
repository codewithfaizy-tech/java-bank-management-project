package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton exit;
    int balance;

    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon\\atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel text = new JLabel(l3);
        text.setBounds(0,0,800,750);
        add(text);

        exit = new JButton("Back");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(310,420,150,25);
        exit.addActionListener(this);
        add(exit);

        try {
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from bank where PinNum = " + pin + "");
            balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));

                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text2 = new JLabel("Your balance is = "+balance+"");
        text2.setBounds(220,250,200,20);
        text2.setForeground(Color.white);
        text.add(text2);

        setLayout(null);
        setSize(800,750);
        setLocation(220,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
