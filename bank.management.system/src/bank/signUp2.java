package bank;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class signUp2 extends JFrame implements ActionListener{
    JTextField  adhar,pan;
    JButton next;
    JComboBox educationBox, relegionBox,catogaryBox,incomeBox,occupatiomBox;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    signUp2(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("page 2");

        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Railway", Font.BOLD, 25));
        additionalDetail.setBounds(290, 40, 400, 40);
        add(additionalDetail);

        JLabel name = new JLabel("Relegion ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String relegionval[] = {"hindu","muslim","sikh", "critial","other"};
        relegionBox = new JComboBox(relegionval);
        relegionBox.setFont(new Font("Railway", Font.PLAIN, 18));
        relegionBox.setBounds(300, 140, 400, 30);  // Added 50-pixel gap
        add(relegionBox);

        JLabel fname = new JLabel("Catogary ");
        fname.setFont(new Font("Railway", Font.BOLD, 18));
        fname.setBounds(100, 190, 100, 30);
        add(fname);

        String catogaryval[] = {"General","OBC","SC", "ST"};
        catogaryBox = new JComboBox(catogaryval);
        catogaryBox.setFont(new Font("Railway", Font.PLAIN, 18));
        catogaryBox.setBounds(300, 190, 400, 30);  // Added 50-pixel gap
        add(catogaryBox);


        JLabel dob = new JLabel("Income ");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 100, 30);
        add(dob);

        String incomeval[] = {"null","< 150,000","< 350,000", "< 750,000","upto 100,000"};
        incomeBox = new JComboBox(incomeval);
        incomeBox.setFont(new Font("Railway", Font.PLAIN, 18));
        incomeBox.setBounds(300, 240, 400, 30);  // Added 50-pixel gap
        add(incomeBox);


        JLabel gender = new JLabel("Senior Citizen ");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 20);
        add(gender);

        syes = new JRadioButton("Yes");
        syes.setBounds(350,290,60,20);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,290,160,20);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(syes);
        gendergroup.add(sno);


        JLabel email = new JLabel("Occupation ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 20);
        add(email);

        String occuval[] = {"Null","Salaried","Self-Employeed", "Business","Other"};
        occupatiomBox = new JComboBox(occuval);
        occupatiomBox.setFont(new Font("Railway", Font.PLAIN, 18));
        occupatiomBox.setBounds(300, 340, 400, 30);  // Added 50-pixel gap
        add(occupatiomBox);


        JLabel marital = new JLabel("Existing Account ");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 20);
        add(marital);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(350,390,60,20);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,390,160,20);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(eyes);
        maritalgroup.add(eno);


        JLabel address = new JLabel("Pan Number ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 20);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Railway", Font.PLAIN, 18));
       pan.setBounds(300, 440, 400, 30);  // Added 50-pixel gap
        add(pan);

        JLabel city = new JLabel("Education");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 20);
        add(city);

        JLabel state = new JLabel("Qualification ");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 515, 200, 20);
        add(state);

        String educationVal[] = {"Graduate","Under-Graduate","Post-Graduate", "No-Study","other"};
        educationBox = new JComboBox(educationVal);
        educationBox.setFont(new Font("Railway", Font.PLAIN, 18));
        educationBox.setBounds(300, 505, 400, 30);  // Added 50-pixel gap
        add(educationBox);


        JLabel adhartext = new JLabel("Adhar Number");
        adhartext.setFont(new Font("Railway", Font.BOLD, 20));
        adhartext.setBounds(100, 590, 200, 20);
        add(adhartext);

        adhar = new JTextField();
        adhar.setFont(new Font("Railway", Font.PLAIN, 18));
        adhar.setBounds(300, 590, 400, 30);  // Added 50-pixel gap
        add(adhar);

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
        String Relegion = (String)relegionBox.getSelectedItem();
        String Catogary = (String)catogaryBox.getSelectedItem();
        String Income = (String)incomeBox.getSelectedItem();
        String Education = (String) educationBox.getSelectedItem();
        String Occupation = (String) occupatiomBox.getSelectedItem();
        String Adhar = adhar.getText();
        String Pan = pan.getText();
        String Senior = null;
        if (syes.isSelected()){
            Senior = "YES";
        } else if (sno.isSelected()) {
            Senior = "NO";

        }

        String ExistingAccount = null;
        if (eyes.isSelected()){
            ExistingAccount = "YES";
        } else if (eno.isSelected()) {
            ExistingAccount = "NO";

        }

        try {
            if (adhar.equals("")){
                JOptionPane.showMessageDialog(null,"Adhar Number is required");
            }
            else {
                conn c = new conn();
                String query = "insert into signup2 values('"+formno+"','"+Relegion+"', '"+Education+"','"+Catogary+"','"+Income+"','"+Occupation+"','"+Adhar+"','"+Pan+"','"+Senior+"','"+ExistingAccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                signupThree sin = new signupThree(formno);
                sin.setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signUp2("");

    }
}
