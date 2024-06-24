package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener{

    JButton next;
    String formno;
    JComboBox religion, category, income, education, occupation;
    JTextField tfpan, tfaadhar;
    JRadioButton rbsenior1, rbsenior2, rbexac1, rbexac2;

    Signup2(String formno){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        this.formno = formno;

        JLabel heading = new JLabel("Page 2: Additional Details:");
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

        JLabel lblreligion = new JLabel("Religion");
        lblreligion.setBounds(200, 200, 300, 30);
        lblreligion.setForeground(Color.BLACK);
        lblreligion.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblreligion);

        String rel[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(rel);
        religion.setBounds(450, 200, 300, 30);
        religion.setForeground(Color.BLACK);
        religion.setFont(new Font("arial", Font.PLAIN, 20));
        add(religion);

        JLabel lblcategory = new JLabel("Category");
        lblcategory.setBounds(200, 250, 300, 30);
        lblcategory.setForeground(Color.BLACK);
        lblcategory.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblcategory);

        String cat[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(cat);
        category.setBounds(450, 250, 300, 30);
        category.setForeground(Color.BLACK);
        category.setFont(new Font("arial", Font.PLAIN, 20));
        add(category);

        JLabel lblincome = new JLabel("Income");
        lblincome.setBounds(200, 300, 300, 30);
        lblincome.setForeground(Color.BLACK);
        lblincome.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblincome);

        String inc[] = {"Null", "<1,50,000>", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        income = new JComboBox<>(inc);
        income.setBounds(450, 300, 300, 30);
        income.setForeground(Color.BLACK);
        income.setFont(new Font("arial", Font.PLAIN, 20));
        add(income);

        JLabel lbleducation = new JLabel("Qualification");
        lbleducation.setBounds(200, 350, 300, 30);
        lbleducation.setForeground(Color.BLACK);
        lbleducation.setFont(new Font("arial", Font.PLAIN, 20));
        add(lbleducation);

        String edu[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        education = new JComboBox<>(edu);
        education.setBounds(450, 350, 300, 30);
        education.setForeground(Color.BLACK);
        education.setFont(new Font("arial", Font.PLAIN, 20));
        add(education);

        JLabel lbloccupation = new JLabel("Occupation");
        lbloccupation.setBounds(200, 400, 300, 30);
        lbloccupation.setForeground(Color.BLACK);
        lbloccupation.setFont(new Font("arial", Font.PLAIN, 20));
        add(lbloccupation);

        String op[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox<>(op);
        occupation.setBounds(450, 400, 300, 30);
        occupation.setForeground(Color.BLACK);
        occupation.setFont(new Font("arial", Font.PLAIN, 20));
        add(occupation);

        JLabel lblpan = new JLabel("PAN No:");
        lblpan.setBounds(200, 450, 200, 30);
        lblpan.setForeground(Color.BLACK);
        lblpan.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblpan);

        tfpan = new JTextField();
        tfpan.setBounds(450, 450, 300, 30);
        tfpan.setForeground(Color.BLACK);
        tfpan.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfpan);

        JLabel lblaadhar = new JLabel("Aadhar No:");
        lblaadhar.setBounds(200, 500, 200, 30);
        lblaadhar.setForeground(Color.BLACK);
        lblaadhar.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(450, 500, 300, 30);
        tfaadhar.setForeground(Color.BLACK);
        tfaadhar.setFont(new Font("arial", Font.PLAIN, 20));
        add(tfaadhar);

        JLabel lblsenior = new JLabel("Senior Citizen:");
        lblsenior.setBounds(200, 550, 200, 30);
        lblsenior.setForeground(Color.BLACK);
        lblsenior.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblsenior);

        rbsenior1 = new JRadioButton("Yes");
        rbsenior1.setBounds(450, 550, 100, 30);
        rbsenior1.setForeground(Color.BLACK);
        rbsenior1.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbsenior1);

        rbsenior2 = new JRadioButton("No");
        rbsenior2.setBounds(600, 550, 100, 30);
        rbsenior2.setForeground(Color.BLACK);
        rbsenior2.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbsenior2);

        JLabel ExAccount = new JLabel("Existing Account:");
        ExAccount.setBounds(200, 600, 200, 30);
        ExAccount.setForeground(Color.BLACK);
        ExAccount.setFont(new Font("arial", Font.PLAIN, 20));
        add(ExAccount);

        rbexac1 = new JRadioButton("Yes");
        rbexac1.setBounds(450, 600, 100, 30);
        rbexac1.setForeground(Color.BLACK);
        rbexac1.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbexac1);

        rbexac2 = new JRadioButton("No");
        rbexac2.setBounds(600, 600, 100, 30);
        rbexac2.setForeground(Color.BLACK);
        rbexac2.setFont(new Font("arial", Font.PLAIN, 20));
        add(rbexac2);

        next = new JButton("Next");
        next.setBounds(550, 700, 200, 30);
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
        new Signup2("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){

            String religions = religion.getSelectedItem().toString();
            String categorys = category.getSelectedItem().toString();
            String incomes = income.getSelectedItem().toString();
            String qualifications = education.getSelectedItem().toString();
            String occupations = occupation.getSelectedItem().toString();
            String pans = tfpan.getText();
            String aadhars = tfaadhar.getText();
            String seniors = "";
            if(rbsenior1.isSelected()){
                seniors = "Yes";
            }
            else{
                seniors = "No";
            }
            String exacs = "";
            if(rbexac1.isSelected()){
                exacs = "Yes";
            }
            else{
                exacs = "No";
            }

            Conn c = new Conn();
            String query = "insert into signup2 values('"+religions+ "','"+categorys+ "','"+incomes+ "','"+qualifications+ "','"+occupations+ "','"+pans+ "','"+aadhars+ "','"+seniors+"','"+exacs+ "','"+formno+ "')";
            
            try {
                if(aadhars.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required details");
                }
                else{
                    c.s.executeUpdate(query);
                    //JOptionPane.showMessageDialog(null, "submitted");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(false);
            new Signup3(formno);
        }
    }
}
