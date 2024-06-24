package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JButton signin, clear, signup;
    JTextField tfcard, tfpin;

    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome to ATM");
        heading.setBounds(450, 60, 400, 30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("arial", Font.BOLD, 30));
        add(heading);

        JLabel lblcard = new JLabel("Card No:");
        lblcard.setBounds(200, 190, 200, 30);
        lblcard.setForeground(Color.BLACK);
        lblcard.setFont(new Font("arial", Font.PLAIN, 30));
        add(lblcard);

        tfcard = new JTextField();
        tfcard.setBounds(450, 190, 400, 30);
        tfcard.setForeground(Color.BLACK);
        tfcard.setFont(new Font("arial", Font.PLAIN, 30));
        add(tfcard);

        JLabel lblpin = new JLabel("Pin:");
        lblpin.setBounds(200, 280, 200, 30);
        lblpin.setForeground(Color.BLACK);
        lblpin.setFont(new Font("arial", Font.PLAIN, 30));
        add(lblpin);

        tfpin = new JTextField();
        tfpin.setBounds(450, 280, 400, 30);
        tfpin.setForeground(Color.BLACK);
        tfpin.setFont(new Font("arial", Font.PLAIN, 30));
        add(tfpin);

        signin = new JButton("Sign In");
        signin.setBounds(450, 370, 150, 30);
        signin.setForeground(Color.WHITE);
        signin.setBackground(Color.BLACK);
        signin.setFont(new Font("arial", Font.PLAIN, 20));
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("Clear");
        clear.setBounds(700, 370, 150, 30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.setFont(new Font("arial", Font.PLAIN, 20));
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(450, 460, 400, 30);
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.setFont(new Font("arial", Font.PLAIN, 20));
        signup.addActionListener(this);
        add(signup);

        setVisible(true);
        setLocation(400, 150);
        setSize(1200, 800);
    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==signin){
            
            String cardno = tfcard.getText();
            String pinno = tfpin.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where cardno='"+cardno+"'and pin='"+pinno+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Home(pinno);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN!");
                    tfcard.setText("");
                    tfpin.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==clear){
            tfcard.setText("");
            tfpin.setText("");
        }
        else{
            setVisible(false);
            new Signup1();
        }
    }
}
