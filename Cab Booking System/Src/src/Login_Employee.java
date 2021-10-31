import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Employee extends JFrame {

    JPanel panel,p1;
    JLabel lbl1,lbl2,lblmsg,Heading,bg,lbl3;
    JButton loginbtn,cancelbtn,clrbtn,changepassbtn;
    JTextField tf_usrname;
    JPasswordField pf_password;

    Login_Employee(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(50,-70,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        lbl1 = new JLabel("Username");
        tf_usrname = new JTextField();
        lbl1.setBounds(60,80,100,30);
        tf_usrname.setBounds(130,80,140,30);


        lbl2 = new JLabel("Password");
        pf_password = new JPasswordField();
        lbl2.setBounds(60,120,100,30);
        pf_password.setBounds(130,120,140,30);


        loginbtn = new JButton("Login");
        loginbtn.setBounds(80,200,80,30);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(170,200,80,30);

        clrbtn = new JButton("Clear");
        clrbtn.setBounds(120,250,80,30);

        changepassbtn = new JButton("Forgot Password");
        changepassbtn.setBounds(85,300,150,30);


        panel = new JPanel();
        lblmsg = new JLabel("");

        ImageIcon img = new ImageIcon("Icon\\Background8.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl3 = new JLabel("", img1, JLabel.CENTER);
        lbl3.setBounds(0, 0, 900, 900);
        lbl3.setVisible(true);
        p1 = new JPanel();

        add(Heading);
        add(lbl1);
        add(tf_usrname);
        add(lbl2);
        add(pf_password);
        add(loginbtn);
        add(cancelbtn);
        add(clrbtn);
        add(changepassbtn);
        add(panel);
        add(lblmsg);
        add(bg);
        add(lbl3);
        p1.add(lbl3);



        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginbtn) {
                    try {
                        String Email = tf_usrname.getText();
                        String Password = pf_password.getText();
                        Connection conn;
                        PreparedStatement ps;

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                        String q1 = "select * from employee_info where Email = ? and Password = ?";

                        ps = conn.prepareStatement(q1);

                        ps.setString(1, Email);
                        ps.setString(2, Password);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Login Successful", "Welcome Employee", JOptionPane.INFORMATION_MESSAGE);
                            new Employee_Page();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ae) {
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cancelbtn){
                    new Login_Page();
                    dispose();
                }
            }
        });

        clrbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clrbtn){
                    tf_usrname.setText("");
                    pf_password.setText("");
                }
            }
        });

        changepassbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==changepassbtn){
                    new Change_Password_Employee();
                    dispose();
                }
            }
        });

        setSize(350,450);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Employee Login");
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new Login_Employee();
    }
}
