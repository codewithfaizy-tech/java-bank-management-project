package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton deposit , fastCash , pinChange , widraw , statement , balanceEnquiry , exit;
    String pin;
    Transaction(String pin){
        this.pin = pin;
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(140,320,150,25);
        deposit.addActionListener(this);
        add(deposit);

        fastCash = new JButton("Fast cash");
        fastCash.setFont(new Font("System",Font.BOLD,16));
        fastCash.setBounds(140,350,150,25);
        fastCash.addActionListener(this);
        add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setFont(new Font("System",Font.BOLD,16));
        pinChange.setBounds(140,380,150,25);
        pinChange.addActionListener(this);
        add(pinChange);

        widraw = new JButton("Withdrawel");
        widraw.setFont(new Font("System",Font.BOLD,16));
        widraw.setBounds(310,320,150,25);
        widraw.addActionListener(this);
        add(widraw);

        statement= new JButton("Mini statement");
        statement.setFont(new Font("System",Font.BOLD,16));
        statement.setBounds(310,350,150,25);
        statement.addActionListener(this);
        add(statement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setFont(new Font("System",Font.BOLD,12));
        balanceEnquiry.setBounds(310,380,150,25);
        balanceEnquiry.addActionListener(this);
        add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(310,410,150,25);
        exit.addActionListener(this);
        add(exit);




        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon\\atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel label = new JLabel(l3);
        label.setBounds(0,0,800,700);
        add(label);


        setLayout(null);
        setSize(800,800);
        setLocation(220,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==deposit){
            setVisible(false);
            deposit d = new deposit(pin);
            d.setVisible(true);

        } else if (ae.getSource()==fastCash) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
            
        } else if (ae.getSource()==pinChange) {
            setVisible(false);
            new Pinchange(pin).setVisible(true);
        } else if (ae.getSource()==widraw) {
            setVisible(false);
            new Withdrawel(pin).setVisible(true);
            
        } else if (ae.getSource()==statement) {
            new MiniStatement(pin).setVisible(true);
            
        } else if (ae.getSource()==balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
            
        } else if (ae.getSource()==exit) {
            System.exit(0);
        }

    }



    public static void main(String[] args) {
        new Transaction("");

    }
}
