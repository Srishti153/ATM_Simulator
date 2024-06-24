package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{

    JButton b1, b2, b3, b4, b5, b6, back;
    String pinno;
    
    FastCash(String pinno){

        this.pinno = pinno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);

        JLabel lblheading = new JLabel("Select Withdrawal Amount :");
        lblheading.setBounds(200, 300, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.BOLD, 20));
        l3.add(lblheading);

        b1 = new JButton("₹100");
        b1.setBounds(210, 380, 190, 30);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("arial", Font.BOLD, 15));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("₹500");
        b2.setBounds(410, 380, 190, 30);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("arial", Font.BOLD, 15));
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("₹1000");
        b3.setBounds(210, 420, 190, 30);
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("arial", Font.BOLD, 15));
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("₹2000");
        b4.setBounds(410, 420, 190, 30);
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("arial", Font.BOLD, 15));
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("₹5000");
        b5.setBounds(210, 460, 190, 30);
        b5.setForeground(Color.BLACK);
        b5.setBackground(Color.WHITE);
        b5.setFont(new Font("arial", Font.BOLD, 15));
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("₹10000");
        b6.setBounds(410, 460, 190, 30);
        b6.setForeground(Color.BLACK);
        b6.setBackground(Color.WHITE);
        b6.setFont(new Font("arial", Font.BOLD, 15));
        b6.addActionListener(this);
        l3.add(b6);

        back = new JButton("Back");
        back.setBounds(410, 500, 190, 30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("arial", Font.BOLD, 15));
        back.addActionListener(this);
        l3.add(back);

        setVisible(true);
        setLocation(400, 150);
        setSize(1100, 900);
    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==back){
            setVisible(false);
            new Home(pinno);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(1);
            Date d = new Date();
            int balance=0;
            try {
                Conn c = new Conn();
                String q1 = "select * from bank where pin = '" +pinno+"'";
                ResultSet rs = c.s.executeQuery(q1);
                while (rs.next()) {
                    if(rs.getString("transaction").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                else{
                    String query = "insert into bank values('"+pinno+"','"+d+"', 'Withdraw', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "₹ "+amount+" withdrawn succesfully!");
                    setVisible(false);
                    new Home(pinno);
                }

            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
