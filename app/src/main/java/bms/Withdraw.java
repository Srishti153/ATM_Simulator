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
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener{

    JButton withdraw, back;
    String pinno;
    JTextField tfamount;

    Withdraw(String pinno){
        this.pinno = pinno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);

        JLabel lblheading = new JLabel("Maximum withdrawable amount : ₹10,000");
        lblheading.setBounds(200, 280, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.PLAIN, 18));
        l3.add(lblheading);

        JLabel subheading = new JLabel("Please enter your amount :");
        subheading.setBounds(200, 340, 420, 30);
        subheading.setBackground(Color.BLACK);
        subheading.setForeground(Color.WHITE);
        subheading.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(subheading);

        tfamount = new JTextField();
        tfamount.setBounds(200, 390, 405, 30);
        tfamount.setBackground(Color.WHITE);
        tfamount.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(tfamount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(400, 470, 200, 30);
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        withdraw.setFont(new Font("arial", Font.PLAIN, 20));
        withdraw.addActionListener(this);
        l3.add(withdraw);

        back = new JButton("Back");
        back.setBounds(400, 510, 200, 30);
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
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdraw){

            String amount = tfamount.getText();
            Date d = new Date();
            int balance = 0;

            try {
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                }
                else{
                    Conn c = new Conn();
                    String q1 = "select * from bank where pin = '"+pinno+"'";
                    ResultSet rs = c.s.executeQuery(q1);

                    while(rs.next()){
                        if(rs.getString("transaction").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = "insert into bank values('"+pinno+"','"+d+"', 'Withdraw','"+amount+"')";
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
        else{
            setVisible(false);
            new Home(pinno);
        }
    }
}
