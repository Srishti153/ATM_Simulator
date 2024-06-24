package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{

    JButton deposit, back;
    String pinstring;
    JTextField tfamount;

    Deposit(String pinstring){

        this.pinstring = pinstring;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);

        JLabel lblheading = new JLabel("Enter amount you want to deposit :");
        lblheading.setBounds(200, 300, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.BOLD, 20));
        l3.add(lblheading);

        tfamount = new JTextField();
        tfamount.setBounds(200, 350, 405, 30);
        tfamount.setBackground(Color.WHITE);
        tfamount.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(tfamount);

        deposit = new JButton("Deposit");
        deposit.setBounds(400, 450, 200, 30);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.setFont(new Font("arial", Font.PLAIN, 20));
        deposit.addActionListener(this);
        l3.add(deposit);

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
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String amount = tfamount.getText();
            Date d = new Date();

            try {
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                }
                else{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinstring+"','"+d+"', 'Deposit','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "₹ "+amount+" deposited succesfully!");
                    setVisible(false);
                    new Home(pinstring);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home(pinstring);
        }
    }
}
