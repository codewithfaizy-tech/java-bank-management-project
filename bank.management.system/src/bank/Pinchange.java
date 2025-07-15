package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    String pinchange;
    JButton exit,change;
    JTextField Pintextfield,repintextfield;

    Pinchange(String pinchange){
        this.pinchange = pinchange;
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon\\atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel image = new JLabel(l3);
        image.setBounds(0,0,800,750);

        JLabel text = new JLabel(" Change Pin ");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(250,250,100,20);
        image.add(text);

        JLabel pintext = new JLabel("New pin: ");
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        pintext.setBounds(150,350,100,20);
        image.add(pintext);

        JLabel repintext = new JLabel("Re-Enter New pin: ");
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.white);
        repintext.setBounds(150,380,150,20);
        image.add(repintext);

        Pintextfield = new JTextField();
        Pintextfield.setBounds(320,350,100,20);
        image.add(Pintextfield);

        repintextfield = new JTextField();
        repintextfield.setBounds(320,380,100,20);
        image.add(repintextfield);

        change = new JButton("Change");
        change.setFont(new Font("System",Font.BOLD,12));
        change.setBounds(310,410,150,25);
        change.addActionListener(this);
        add(change);

        exit = new JButton("Back");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(310,440,150,25);
        exit.addActionListener(this);
        add(exit);


        setLayout(null);
        setSize(800,800);
        setLocation(220,0);
        setVisible(true);
        add(image);

    }

    public void actionPerformed(ActionEvent e){
       String npin = Pintextfield.getText();
       String rpin = repintextfield.getText();
       if (e.getSource()==change){
           try {
               if (!npin.equals(rpin)){
                   JOptionPane.showMessageDialog(null,"Pin is not same");
                   return;
               }
               if (npin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please enter new Pin");
                    return;
               }
               if (rpin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                   return;
               }
               conn con = new conn();

               String query = "UPDATE bank SET PinNum = '" + rpin + "' WHERE PinNum = '" + pinchange + "'";
               String query1 = "UPDATE signup3 SET PinNum = '" + rpin + "' WHERE PinNum = '" + pinchange + "'";
               String query2 = "UPDATE login SET PinNum = '" + rpin + "' WHERE PinNum = '" + pinchange + "'";

                con.s.executeUpdate(query);
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);

               setVisible(false);
               new Login(rpin).setVisible(true);

           }catch (Exception ae){
               System.out.println(ae);
           }
       } else if (e.getSource()==exit) {
           setVisible(false);
           new Transaction(pinchange).setVisible(true);
       }

    }
    public static void main(String[] args) {
        new Pinchange("");
    }
}
