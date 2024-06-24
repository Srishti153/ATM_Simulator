package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener{

    JButton deposit, withdraw, fcash, minis, pchange, benquiry, exit;
    String pinno;

    Home(String pinno){

        this.pinno = pinno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);

        JLabel lblheading = new JLabel("Please select your transaction :");
        lblheading.setBounds(200, 300, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.BOLD, 20));
        l3.add(lblheading);

        deposit = new JButton("Deposit");
        deposit.setBounds(210, 380, 190, 30);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.setFont(new Font("arial", Font.BOLD, 15));
        deposit.addActionListener(this);
        l3.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(410, 380, 190, 30);
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        withdraw.setFont(new Font("arial", Font.BOLD, 15));
        withdraw.addActionListener(this);
        l3.add(withdraw);

        fcash = new JButton("Fast Cash");
        fcash.setBounds(210, 420, 190, 30);
        fcash.setForeground(Color.BLACK);
        fcash.setBackground(Color.WHITE);
        fcash.setFont(new Font("arial", Font.BOLD, 15));
        fcash.addActionListener(this);
        l3.add(fcash);

        minis = new JButton("Mini Statement");
        minis.setBounds(410, 420, 190, 30);
        minis.setForeground(Color.BLACK);
        minis.setBackground(Color.WHITE);
        minis.setFont(new Font("arial", Font.BOLD, 15));
        minis.addActionListener(this);
        l3.add(minis);

        pchange = new JButton("Pin Change");
        pchange.setBounds(210, 460, 190, 30);
        pchange.setForeground(Color.BLACK);
        pchange.setBackground(Color.WHITE);
        pchange.setFont(new Font("arial", Font.BOLD, 15));
        pchange.addActionListener(this);
        l3.add(pchange);

        benquiry = new JButton("Balance Enquiry");
        benquiry.setBounds(410, 460, 190, 30);
        benquiry.setForeground(Color.BLACK);
        benquiry.setBackground(Color.WHITE);
        benquiry.setFont(new Font("arial", Font.BOLD, 15));
        benquiry.addActionListener(this);
        l3.add(benquiry);

        exit = new JButton("Exit");
        exit.setBounds(410, 500, 190, 30);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setFont(new Font("arial", Font.BOLD, 15));
        exit.addActionListener(this);
        l3.add(exit);

        setVisible(true);
        setLocation(400, 150);
        setSize(1100, 900);
    }

    public static void main(String[] args) {
        new Home("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinno);
        }
        else if(e.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinno);
        }
        else if(e.getSource()==fcash){
            setVisible(false);
            new FastCash(pinno);
        }
        else if(e.getSource()==minis){
            //setVisible(false);
            new MiniStatement(pinno);
        }
        else if(e.getSource()==pchange){
            setVisible(false);
            new PinChange(pinno);
        }
        else if(e.getSource()==benquiry){
            setVisible(false);
            new BalanceEnquiry(pinno);
        }
        else{
            setVisible(false);
            System.exit(0);
        }
    }
}
