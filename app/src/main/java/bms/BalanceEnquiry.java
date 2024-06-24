package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinno;

    BalanceEnquiry(String pinno){

        this.pinno = pinno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);
        
        int balance = 0;

        try {
            Conn c = new Conn();
            String query = "select * from bank where pin = '" +pinno +"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("transaction").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblheading = new JLabel("Your current account balance is : ₹" + balance);
        lblheading.setBounds(210, 300, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.PLAIN, 18));
        l3.add(lblheading);

        back = new JButton("Back");
        back.setBounds(400, 500, 200, 30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("arial", Font.PLAIN, 20));
        back.addActionListener(this);
        l3.add(back);

        setVisible(true);
        setLocation(400, 150);
        setSize(1100, 900);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Home(pinno);
        }
    }
}
