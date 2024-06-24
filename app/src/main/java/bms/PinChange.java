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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{

    JButton change, back;
    String pinno;
    JTextField pin1, pin2;

    PinChange(String pinno){

        this.pinno = pinno;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1100, 900);
        add(l3);

        JLabel lblheading = new JLabel("Change your PIN :");
        lblheading.setBounds(310, 300, 420, 30);
        lblheading.setBackground(Color.BLACK);
        lblheading.setForeground(Color.WHITE);
        lblheading.setFont(new Font("arial", Font.BOLD, 20));
        l3.add(lblheading);

        JLabel subheading1 = new JLabel("New PIN :");
        subheading1.setBounds(200, 350, 200, 30);
        subheading1.setBackground(Color.BLACK);
        subheading1.setForeground(Color.WHITE);
        subheading1.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(subheading1);

        pin1 = new JTextField();
        pin1.setBounds(450, 350, 150, 30);
        pin1.setBackground(Color.WHITE);
        pin1.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(pin1);

        JLabel subheading2 = new JLabel("Re-Enter New PIN :");
        subheading2.setBounds(200, 395, 200, 30);
        subheading2.setBackground(Color.BLACK);
        subheading2.setForeground(Color.WHITE);
        subheading2.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(subheading2);

        pin2 = new JTextField();
        pin2.setBounds(450, 395, 150, 30);
        pin2.setBackground(Color.WHITE);
        pin2.setFont(new Font("arial", Font.PLAIN, 20));
        l3.add(pin2);

        change = new JButton("Change");
        change.setBounds(410, 470, 190, 30);
        change.setForeground(Color.BLACK);
        change.setBackground(Color.WHITE);
        change.setFont(new Font("arial", Font.BOLD, 15));
        change.addActionListener(this);
        l3.add(change);

        back = new JButton("Back");
        back.setBounds(410, 510, 190, 30);
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
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Home(pinno);
        }
        else{
            String p1 = pin1.getText();
            String p2 = pin2.getText();

            if(p1.equals("") || p2.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter pin info correctly");
            }

            else if(!p1.equals(p2)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
            }
            else{
                Conn c = new Conn();
                String query1 = "update bank set pin = '" +p2+ "' where pin = '" +pinno+ "'";
                String query2 = "update login set pin = '" +p2+ "' where pin = '" +pinno+ "'";
                String query3 = "update signup3 set pin = '" +p2+ "' where pin = '" +pinno+ "'";

                try {
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "PIN changed succesfully");
                    setVisible(false);
                    new Home(pinno);

                } 
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
