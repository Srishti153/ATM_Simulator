package bms;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{

    String pinno;

    MiniStatement(String pinno){

        this.pinno = pinno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblheading = new JLabel("INDIAN BANK");
        lblheading.setBounds(450, 100, 420, 30);
        lblheading.setForeground(Color.BLACK);
        lblheading.setFont(new Font("arial", Font.BOLD, 20));
        add(lblheading);

        JLabel card = new JLabel();
        card.setBounds(200, 200, 420, 30);
        card.setForeground(Color.BLACK);
        card.setFont(new Font("arial", Font.PLAIN, 20));
        add(card);

        JLabel minis = new JLabel();
        minis.setBounds(200, 250, 600, 400);
        minis.setForeground(Color.BLACK);
        minis.setFont(new Font("arial", Font.PLAIN, 20));
        add(minis);

        JLabel bal = new JLabel();
        bal.setBounds(200, 680, 420, 100);
        bal.setForeground(Color.BLACK);
        bal.setFont(new Font("arial", Font.PLAIN, 20));
        add(bal);

        try {
            Conn c = new Conn();
            String query = "select * from login where pin = '" +pinno+ "'";
            ResultSet rs = c.s.executeQuery(query); 
            while(rs.next()){
                card.setText("Card No : " + rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            int balance=0;
            String query = "select * from bank where pin = '" +pinno+ "'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                minis.setText(minis.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>" + "<html>");
                if(rs.getString("transaction").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your current account balance is ₹" + balance);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
        setLocation(200, 150);
        setSize(1100, 900);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
