import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Employee extends JFrame {
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6,Heading,bg,lbl7;
    JTextField tf_name, tf_Age, tf_mobilenumber, tf_email, tf_licnse;
    JButton btn_Search,btn_Delete,btn_Back;
    JPanel p1;


    Delete_Employee(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(200,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        lbl4 = new JLabel("Enter Email ID");
        lbl4.setBounds(30,130,100,30);
        tf_email = new JTextField();
        tf_email.setBounds(130,130,130,30);


        lbl6 = new JLabel("Records:-");
        lbl6.setBounds(30,160,100,60);
        lbl6.setFont(new Font("Arial",Font.BOLD,18));



        lbl1 = new JLabel("Name");
        lbl1.setBounds(30,220,100,30);
        tf_name = new JTextField();
        tf_name.setBounds(80,220,130,30);
        tf_name.setEditable(false);


        lbl2 = new JLabel("Age");
        lbl2.setBounds(30,280,100,30);
        tf_Age = new JTextField();
        tf_Age.setBounds(80,280,130,30);
        tf_Age.setEditable(false);



        lbl3 = new JLabel("Mobile Number");
        lbl3.setBounds(30,340,100,30);
        tf_mobilenumber = new JTextField();
        tf_mobilenumber.setBounds(130,340,130,30);
        tf_mobilenumber.setEditable(false);



        lbl5 = new JLabel("License Number");
        lbl5.setBounds(30,400,100,30);
        tf_licnse = new JTextField();
        tf_licnse.setBounds(130,400,130,30);
        tf_licnse.setEditable(false);


        btn_Search = new JButton("Search");
        btn_Search.setBounds(290,120,130,50);


        btn_Delete = new JButton("Delete");
        btn_Delete.setBounds(30,470,130,50);


        btn_Back = new JButton("Back");
        btn_Back.setBounds(200,470,130,50);

        ImageIcon img = new ImageIcon("Icon\\Background7.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl7 = new JLabel("", img1, JLabel.CENTER);
        lbl7.setBounds(0, 0, 900, 900);
        lbl7.setVisible(true);
        p1 = new JPanel();





        add(Heading);
        add(lbl4);
        add(tf_email);
        add(lbl6);
        add(lbl1);
        add(tf_name);
        add(lbl2);
        add(tf_Age);
        add(lbl3);
        add(tf_mobilenumber);
        add(lbl5);
        add(tf_licnse);
        add(btn_Search);
        add(btn_Delete);
        add(btn_Back);
        add(bg);
        add(lbl7);
        p1.add(lbl7);


        btn_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_Search) {
                    try {


                        String Email1 = tf_email.getText();

                        Connection conn;
                        PreparedStatement ps;

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                        String q1 = "select Name , Age , MobileNumber , LicenseNumber from employee_info where Email=?";

                        ps = conn.prepareStatement(q1);
                        ps.setString(1, Email1);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            tf_name.setText(rs.getString("Name"));
                            tf_Age.setText(rs.getString("Age"));
                            tf_mobilenumber.setText(rs.getString("MobileNumber"));
                            tf_licnse.setText(rs.getString("LicenseNumber"));

                        } else {
                            JOptionPane.showMessageDialog(null, "No Record Found", "Alert", JOptionPane.ERROR_MESSAGE);
                            tf_email.setText("");
                        }
                    } catch (Exception ae) {
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        btn_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_Delete) {
                    String Email2 = tf_email.getText();
                    try {
                        if (tf_email.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Fill all the required details");
                        } else {
                            Connection conn;
                            PreparedStatement ps;

                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                            String q1 = "delete from employee_info where Email = ?";

                            ps = conn.prepareStatement(q1);
                            ps.setString(1, Email2);
                            int rows = ps.executeUpdate();

                            if (rows > 0) {
                                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully", "Car Delete", JOptionPane.INFORMATION_MESSAGE);
                                new Delete_Employee();
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "No Such Employee Found", "Alert", JOptionPane.ERROR_MESSAGE);
                            }
                            conn.close();
                        }
                    } catch (Exception ae) {
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_Back){
                    dispose();
                }
            }
        });


        setTitle("Delete Employee");
        setSize(700,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Delete_Employee();
    }
}
