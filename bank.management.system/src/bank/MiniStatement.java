package bank;

import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pin;
    MiniStatement(String pin){
        this.pin = pin;

        JLabel mini = new JLabel();
        mini.setBounds(10, 100, 380, 400);
        add(mini);

        JLabel text = new JLabel("Indian Bank");
        text.setBounds(150,10,100,20);
        add(text);

        JLabel card = new JLabel();
        card.setBounds(10,50,300,20);
        add(card);


        try {
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from login where PinNum ="+pin+"");
            while (rs.next()){
                card.setText("Account Number:" + rs.getString("AccountNum").substring(0,4) + "XXXXXXXXXXXX");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        try {
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from bank where PinNum ="+pin+"");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "  " +
                        rs.getString("type") + "  " +
                        rs.getString("amount") + "<br><br><html>");
            }

        }catch (Exception e){
            System.out.println(e);
        }

        setLayout(null);
        setSize(400,600);
        setLocation(10,10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
