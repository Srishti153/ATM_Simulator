package bms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener{

    JTextField tfname, tffname, tfemail, tfaddress, tfcity, tfpincode, tfstate;
    JDateChooser dob;
    Choice mstatus;
    JRadioButton rbgender1, rbgender2;
    JButton next;

    int first4 = (int) (Math.random() * 10000);
    String numstring = first4 + "";

    Signup1(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Application Form No. ");
        heading.setBounds(400, 60, 400, 30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("arial", Font.BOLD, 30));
        add(heading);

        JLabel fno = new JLabel(numstring);
        fno.setBounds(770, 60, 400, 30);
        fno.setForeground(Color.BLACK);
        fno.setFont(new Font("arial", Font.BOLD, 30));
        add(fno);

        JLabel subheading = new JLabel("Page 1: Personal Details");
        subheading.setBounds(470, 100, 400, 30);
        subheading.setForeground(Color.BLACK);
        subheading.setFont(new Font("arial", Font.PLAIN, 20));
        add(subheading);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(200, 200, 200, 30);
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(450, 200, 300, 30);
        tfname.setForeground(Color.BLACK);
        tfname.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(200, 250, 200, 30);
        lblfname.setForeground(Color.BLACK);
        lblfname.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(450, 250, 300, 30);
        tffname.setForeground(Color.BLACK);
        tffname.setFont(new Font("arial", Font.PLAIN, 20));
        add(tffname);

        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(200, 300, 200, 30);
        lbldob.setForeground(Color.BLACK);
        lbldob.setFont(new Font("arial", Font.PLAIN, 20));
        add(lbldob);

        dob = new JDateChooser();
        dob.setBounds(450, 300, 300, 30);
        add(dob);

        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(200, 350, 200, 30);
        lblgender.setForeground(Color.BLACK);
        lblgender.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblgender);

        rbgender1 = new JRadioButton("Male");
        rbgender1.setBounds(450, 350, 100, 30);
        rbgender1.setForeground(Color.BLACK);
        rbgender1.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbgender1);

        rbgender2 = new JRadioButton("Female");
        rbgender2.setBounds(600, 350, 100, 30);
        rbgender2.setForeground(Color.BLACK);
        rbgender2.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbgender2);

        JLabel lblemail = new JLabel("Email ID:");
        lblemail.setBounds(200, 400, 200, 30);
        lblemail.setForeground(Color.BLACK);
        lblemail.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(450, 400, 300, 30);
        tfemail.setForeground(Color.BLACK);
        tfemail.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfemail);

        JLabel lblmstatus = new JLabel("Marital Status:");
        lblmstatus.setBounds(200, 450, 200, 30);
        lblmstatus.setForeground(Color.BLACK);
        lblmstatus.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblmstatus);

        mstatus = new Choice();
        mstatus.setBounds(450, 450, 300, 30);
        mstatus.setForeground(Color.BLACK);
        mstatus.setFont(new Font("arial", Font.PLAIN, 20));
        add(mstatus);
        mstatus.add("Single");
        mstatus.add("Married");
        mstatus.add("Unmarried");
        mstatus.add("Prefer Not to say");

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(200, 500, 200, 30);
        lbladdress.setForeground(Color.BLACK);
        lbladdress.setFont(new Font("arial", Font.PLAIN, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(450, 500, 300, 30);
        tfaddress.setForeground(Color.BLACK);
        tfaddress.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfaddress);

        JLabel lblcity = new JLabel("City:");
        lblcity.setBounds(200, 550, 200, 30);
        lblcity.setForeground(Color.BLACK);
        lblcity.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(450, 550, 300, 30);
        tfcity.setForeground(Color.BLACK);
        tfcity.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfcity);

        JLabel lblpincode = new JLabel("Pin Code:");
        lblpincode.setBounds(200, 600, 200, 30);
        lblpincode.setForeground(Color.BLACK);
        lblpincode.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblpincode);

        tfpincode = new JTextField();
        tfpincode.setBounds(450, 600, 300, 30);
        tfpincode.setForeground(Color.BLACK);
        tfpincode.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfpincode);

        JLabel lblstate = new JLabel("State:");
        lblstate.setBounds(200, 650, 200, 30);
        lblstate.setForeground(Color.BLACK);
        lblstate.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(450, 650, 300, 30);
        tfstate.setForeground(Color.BLACK);
        tfstate.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfstate);

        next = new JButton("Next");
        next.setBounds(550, 750, 200, 30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("arial", Font.PLAIN, 20));
        next.addActionListener(this);
        add(next);

        setVisible(true);
        setLocation(400, 150);
        setSize(1100, 900);
    }

    public static void main(String[] args) {
        new Signup1();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){

            String name = tfname.getText();
            String fname = tffname.getText();
            String dobs = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String gender = "";
            if(rbgender1.isSelected()){
                gender = "Male";
            }
            else if(rbgender2.isSelected()){
                gender = "Female";
            }
            String email = tfemail.getText();
            String marital = mstatus.getSelectedItem().toString();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String pincode = tfpincode.getText();
            String state = tfstate.getText();

            Conn c = new Conn();
            String query = "insert into signup values('"+name+"','"+fname+"','"+dobs+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"','"+numstring+"')";

            try {
                if(pincode.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required details");
                }
                else{
                    c.s.executeUpdate(query);
                    //JOptionPane.showMessageDialog(null, "submitted");
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(false);
            new Signup2(numstring);
        }
    }
}


