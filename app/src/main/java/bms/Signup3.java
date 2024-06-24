package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup3 extends JFrame implements ActionListener{

    JButton submit, cancel;
    long first14 = (long) (Math.random() * 100000000000000L);
    long number = 5200000000000000L + first14;
    String numstring = number + "";
    String num3 = numstring.substring(numstring.length() - 3);
    int pinnumber = (int) (Math.random() * 10000);
    String pinstring = pinnumber + "";

    String formno;

    JRadioButton rbac1, rbac2, rbac3, rbac4;
    JLabel lblno, pin;
    JCheckBox cbservices1, cbservices2, cbservices3, cbservices4, cbservices5, cbservices6;

    Signup3(String formno){

        this.formno = formno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Page 3: Account Details:");
        heading.setBounds(400, 60, 500, 30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("arial", Font.BOLD, 20));
        add(heading);

        JLabel fno = new JLabel("Form No: ");
        fno.setBounds(900, 30, 100, 20);
        fno.setForeground(Color.BLACK);
        fno.setFont(new Font("arial", Font.PLAIN, 20));
        add(fno);

        JLabel fnum = new JLabel(formno);
        fnum.setBounds(995, 30, 100, 20);
        fnum.setForeground(Color.BLACK);
        fnum.setFont(new Font("arial", Font.PLAIN, 20));
        add(fnum);

        JLabel lblactype = new JLabel("Account Type:");
        lblactype.setBounds(200, 200, 300, 30);
        lblactype.setForeground(Color.BLACK);
        lblactype.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblactype);

        rbac1 = new JRadioButton("Savings Account");
        rbac1.setBounds(200, 250, 250, 30);
        rbac1.setForeground(Color.BLACK);
        rbac1.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbac1);

        rbac2 = new JRadioButton("Current Account");
        rbac2.setBounds(550, 250, 300, 30);
        rbac2.setForeground(Color.BLACK);
        rbac2.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbac2);

        rbac3 = new JRadioButton("Fixed Deposit Account");
        rbac3.setBounds(200, 300, 250, 30);
        rbac3.setForeground(Color.BLACK);
        rbac3.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbac3);

        rbac4 = new JRadioButton("Recurring Deposit Account");
        rbac4.setBounds(550, 300, 300, 30);
        rbac4.setForeground(Color.BLACK);
        rbac4.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbac4);

        JLabel lblcard = new JLabel("Card No:");
        lblcard.setBounds(200, 370, 300, 30);
        lblcard.setForeground(Color.BLACK);
        lblcard.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblcard);

        lblno = new JLabel("XXXX-XXXX-XXXX-X" + num3);
        lblno.setBounds(450, 370, 300, 30);
        lblno.setForeground(Color.BLACK);
        lblno.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblno);

        JLabel lblsub1 = new JLabel("(Your 16 digit card no.)");
        lblsub1.setBounds(200, 395, 300, 30);
        lblsub1.setForeground(Color.BLACK);
        lblsub1.setFont(new Font("arial", Font.PLAIN, 13));
        add(lblsub1);

        JLabel lblsub2 = new JLabel("(It would appear on ATM Card, Cheque Book and statements)");
        lblsub2.setBounds(450, 395, 500, 30);
        lblsub2.setForeground(Color.BLACK);
        lblsub2.setFont(new Font("arial", Font.PLAIN, 13));
        add(lblsub2);

        JLabel lblpin = new JLabel("PIN:");
        lblpin.setBounds(200, 445, 200, 30);
        lblpin.setForeground(Color.BLACK);
        lblpin.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblpin);

        pin = new JLabel("XXXX");
        pin.setBounds(450, 445, 300, 30);
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("arial", Font.PLAIN, 20));
        add(pin);

        JLabel lblsub3 = new JLabel("(4-Digit Password)");
        lblsub3.setBounds(200, 465, 300, 30);
        lblsub3.setForeground(Color.BLACK);
        lblsub3.setFont(new Font("arial", Font.PLAIN, 13));
        add(lblsub3);

        JLabel lblservices = new JLabel("Services Required:");
        lblservices.setBounds(200, 510, 200, 30);
        lblservices.setForeground(Color.BLACK);
        lblservices.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblservices);

        cbservices1 = new JCheckBox("ATM Card");
        cbservices1.setBounds(200, 560, 200, 30);
        cbservices1.setForeground(Color.BLACK);
        cbservices1.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices1);

        cbservices2 = new JCheckBox("Internet Banking");
        cbservices2.setBounds(550, 560, 200, 30);
        cbservices2.setForeground(Color.BLACK);
        cbservices2.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices2);

        cbservices3 = new JCheckBox("Mobile Banking");
        cbservices3.setBounds(200, 610, 200, 30);
        cbservices3.setForeground(Color.BLACK);
        cbservices3.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices3);

        cbservices4 = new JCheckBox("Email Alerts");
        cbservices4.setBounds(550, 610, 200, 30);
        cbservices4.setForeground(Color.BLACK);
        cbservices4.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices4);

        cbservices5 = new JCheckBox("Cheque Book");
        cbservices5.setBounds(200, 660, 200, 30);
        cbservices5.setForeground(Color.BLACK);
        cbservices5.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices5);

        cbservices6 = new JCheckBox("E-Statement");
        cbservices6.setBounds(550, 660, 200, 30);
        cbservices6.setForeground(Color.BLACK);
        cbservices6.setFont(new Font("arial", Font.PLAIN, 20));
        add(cbservices6);

        JCheckBox declare = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declare.setBounds(200, 720, 800, 30);
        declare.setBackground(Color.WHITE);
        declare.setForeground(Color.BLACK);
        declare.setFont(new Font("arial", Font.PLAIN, 13));
        add(declare);

        submit = new JButton("Submit");
        submit.setBounds(250, 770, 200, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("arial", Font.PLAIN, 20));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(550, 770, 200, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("arial", Font.PLAIN, 20));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setLocation(400, 150);
        setSize(1100, 900);
    }

    public static void main(String[] args) {
        new Signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){

            String atype = "";
            if(rbac1.isSelected()){
                atype = "Savings Account";
            }
            else if(rbac2.isSelected()){
                atype = "Current Account";
            }
            else if(rbac3.isSelected()){
                atype = "Fixed Deposit Account";
            }
            else if(rbac4.isSelected()){
                atype = "Recurring Deposit Account";
            }
            String services = "";
            if(cbservices1.isSelected()){
                services += "ATM Card";
            }
            else if(cbservices2.isSelected()){
                services += ", Internet Banking";
            }
            else if(cbservices3.isSelected()){
                services += ", Mobile Banking";
            }
            else if(cbservices4.isSelected()){
                services += ", Email Alerts";
            }
            else if(cbservices5.isSelected()){
                services += ", Cheque Book";
            }
            else if(cbservices6.isSelected()){
                services += ", E-Statement";
            }

            try {
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required details");
                }
                else{
                    Conn c = new Conn();
                    String query1 = "insert into signup3 values('"+atype+"','"+numstring+"','"+pinstring+"','"+services+"','"+formno+"')";
                    String query2 = "insert into login values('"+formno+"','"+numstring+"','"+pinstring+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card No: " + numstring + "\n Pin: " + pinstring);
                    setVisible(false);
                    new Deposit(pinstring);
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==cancel){
            System.exit(0);
        }
    }
}
