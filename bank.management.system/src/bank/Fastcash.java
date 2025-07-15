package bank;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener{
    JButton r100 , r200 , r500 , r1000 , r1500 , r2000 , exit;
    String pin;
    Fastcash(String pin){
        this.pin = pin;
        r100 = new JButton("Rs. 100");
        r100.setFont(new Font("System",Font.BOLD,16));
        r100.setBounds(140,320,150,25);
        r100.addActionListener(this);
        add(r100);

        r200 = new JButton("Rs. 200");
        r200.setFont(new Font("System",Font.BOLD,16));
        r200.setBounds(140,350,150,25);
        r200.addActionListener(this);
        add(r200);

        r500 = new JButton("Rs. 500");
        r500.setFont(new Font("System",Font.BOLD,16));
        r500.setBounds(140,380,150,25);
        r500.addActionListener(this);
        add(r500);

        r1000 = new JButton("Rs. 1000");
        r1000.setFont(new Font("System",Font.BOLD,16));
        r1000.setBounds(310,320,150,25);
        r1000.addActionListener(this);
        add( r1000);

        r1500 = new JButton("Rs. 1500");
        r1500.setFont(new Font("System",Font.BOLD,16));
        r1500.setBounds(310,350,150,25);
        r1500.addActionListener(this);
        add(r1500);

        r2000 = new JButton("Rs. 2000");
        r2000.setFont(new Font("System",Font.BOLD,12));
        r2000.setBounds(310,380,150,25);
        r2000.addActionListener(this);
        add(r2000);

        exit = new JButton("Exit");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(310,410,150,25);
        exit.addActionListener(this);
        add(exit);




        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon\\atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
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
        if (ae.getSource()==exit){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            conn con = new conn();
            try {
                ResultSet rs = con.s.executeQuery("select * from bank where PinNum = "+pin+"");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance +=  Integer.parseInt(rs.getString("amount"));

                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Unsufficeint amount");
                    return;
                }
                Date date = new Date();
                String query2 = "INSERT INTO bank VALUES ('"+pin+"','"+date+"', 'Withdraw','"+amount+"')";
                con.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdraw Successfully");
            }catch (Exception e ){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new Fastcash("");

    }
}
