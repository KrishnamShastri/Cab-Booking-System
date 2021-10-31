import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Change_Password_Employee extends JFrame{
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,Heading,bg,lbl6;
    JTextField tf_Usrname,tf_securityquestion,tf_answer;
    JPasswordField tf_NewPassword,tf_Conf_New_Password;
    JButton Search,Change,Back;
    JPanel p1;
    Change_Password_Employee(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(200,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        lbl1 = new JLabel("Username");
        lbl1.setBounds(120,150,100,30);
        tf_Usrname = new JTextField();
        tf_Usrname.setBounds(190,150,130,30);
        lbl2 = new JLabel("Security Question");
        lbl2.setBounds(120,220,120,30);
        tf_securityquestion = new JTextField();
        tf_securityquestion.setBounds(230,220,190,30);
        tf_securityquestion.setEditable(false);
        lbl3 = new JLabel("Answer");
        lbl3.setBounds(120,290,100,30);
        tf_answer = new JTextField();
        tf_answer.setBounds(190,290,160,30);
        lbl4 = new JLabel("New Password");
        lbl4.setBounds(120,360,100,30);
        tf_NewPassword = new JPasswordField();
        tf_NewPassword.setBounds(220,360,130,30);
        lbl5 = new JLabel("Confirm New Password");
        lbl5.setBounds(120,430,150,30);
        tf_Conf_New_Password = new JPasswordField();
        tf_Conf_New_Password.setBounds(270,430,150,30);
        Search = new JButton("Search");
        Search.setBounds(360,150,150,30);
        Change = new JButton("Update Password");
        Change.setBounds(120,500,150,30);
        Back = new JButton("Back");
        Back.setBounds(290,500,150,30);

        ImageIcon img = new ImageIcon("Icon\\Background5.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 1100, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl6 = new JLabel("", img1, JLabel.CENTER);
        lbl6.setBounds(0, 0, 1100, 900);
        lbl6.setVisible(true);
        p1 = new JPanel();

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Search){
                    String Username = tf_Usrname.getText();
                    Connection conn;
                    Statement st;

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                        st = conn.createStatement();

                        ResultSet rs = st.executeQuery("select security_question from employee_info where Name = '"+Username+"'");

                        if(rs.next()){
                            tf_securityquestion.setText(rs.getString(1));
                        }else{
                            JOptionPane.showMessageDialog(null,"Please Write Correct Username","Username Error",JOptionPane.ERROR_MESSAGE);
                        }
                        conn.close();
                        rs.close();
                    }catch (Exception ae){
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Change){
                    String Username = tf_Usrname.getText();
                    String New_Password = tf_NewPassword.getText();
                    String Conf_New_Password = tf_Conf_New_Password.getText();
                    String SecurityQues = tf_securityquestion.getText();
                    String Answer = tf_answer.getText();

                    Connection conn;
                    Statement st;

                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                        st = conn.createStatement();

                        ResultSet rs = st.executeQuery("select security_question from employee_info where Name = '"+Username+"' and answer = '"+Answer+"' ");

                        if(rs.next()) {
                            st.executeUpdate("update employee_info set Password = '"+New_Password+"' , ConfirmPassword = '"+Conf_New_Password+"' where Name = '"+Username+"' and answer = '"+Answer+"'");
                            JOptionPane.showMessageDialog(null,"Your Password is Updated Successfully","Password Change",JOptionPane.INFORMATION_MESSAGE);
                            new Login_Employee();
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null,"Please Write Correct Username or Answer","Username or Answer Error",JOptionPane.ERROR_MESSAGE);
                        }
                        conn.close();
                        rs.close();

                    }catch (Exception ae){
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Back){
                    dispose();
                }
            }
        });


        add(Heading);

        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(tf_Usrname);
        add(tf_securityquestion);
        add(tf_answer);
        add(tf_NewPassword);
        add(tf_Conf_New_Password);
        add(Search);
        add(Change);
        add(Back);
        add(bg);

        add(lbl6);
        p1.add(lbl6);




        p1.setBounds(140,120,480,500);
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
        setTitle("Change Password Employee");
        setSize(700,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Change_Password_Employee();
    }
}

