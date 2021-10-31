import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Employee extends JFrame {

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10,lbl11,lbl12,Heading,bg,lbl13;
    JTextField tf_name, tf_Age, tf_mobl_number, tf_email, tf_License,tf_answer;
    JPasswordField pf_pass, pf_conf_pass;
    JButton btn_add,btn_back;
    JComboBox state,city,cmb_securityquestion;
    JRadioButton male,female;
    ButtonGroup bggender;
    JPanel p1;

    String st_state[] = {"Gujrat","Madhya Pradesh","Maharashtra","Rajasthan"};
    String st_city[] = {"Ahemdabad","Ajmer","Aurangabad","Bhavnagar","Bhopal","Gwalior","Indore","Jabalpur","Jaipur","Jodhpur","Kota","Mumbai","Nagpur","Pune","Rajkot","Surat","Thane","Udaipur","Ujjain","Vadodra"};
    String st_security[] = {"What is your Nick Name","What is you Mother Tongue" , "What is your Favourite Food" , "Which is your Favourite Movie" , "Who is your Favourite Hero"};


    Add_Employee() {

        String st_state[] = {"Gujrat", "Madhya Pradesh", "Maharashtra", "Rajasthan"};
        String st_city[] = {"Ahemdabad", "Ajmer", "Aurangabad", "Bhavnagar", "Bhopal", "Gwalior", "Indore", "Jabalpur", "Jaipur", "Jodhpur", "Kota", "Mumbai", "Nagpur", "Pune", "Rajkot", "Surat", "Thane", "Udaipur", "Ujjain", "Vadodra"};
        String st_security[] = {"What is your Nick Name", "What is you Mother Tongue", "What is your Favourite Food", "Which is your Favourite Movie", "Who is your Favourite Hero"};


        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(250, 10, 400, 200);
        Heading.setFont(new Font("Times New Roman", Font.BOLD, 30));

        lbl1 = new JLabel("Name");
        lbl1.setBounds(30, 200, 100, 30);
        tf_name = new JTextField();
        tf_name.setBounds(70, 200, 100, 30);


        lbl2 = new JLabel("Age");
        lbl2.setBounds(200, 200, 100, 30);
        tf_Age = new JTextField();
        tf_Age.setBounds(240, 200, 100, 30);


        lbl3 = new JLabel("Mobile Number");
        lbl3.setBounds(370, 200, 100, 30);
        tf_mobl_number = new JTextField();
        tf_mobl_number.setBounds(470, 200, 100, 30);


        lbl4 = new JLabel("Email");
        lbl4.setBounds(30, 250, 100, 30);
        tf_email = new JTextField();
        tf_email.setBounds(70, 250, 100, 30);


        lbl5 = new JLabel("Password");
        lbl5.setBounds(200, 250, 100, 30);
        pf_pass = new JPasswordField();
        pf_pass.setBounds(270, 250, 100, 30);


        lbl6 = new JLabel("Confirm Password");
        lbl6.setBounds(400, 250, 120, 30);
        pf_conf_pass = new JPasswordField();
        pf_conf_pass.setBounds(520, 250, 100, 30);


        btn_add = new JButton("Add");
        btn_add.setBounds(30, 600, 150, 50);
        btn_back = new JButton("Back");
        btn_back.setBounds(200, 600, 150, 50);


        lbl7 = new JLabel("State");
        lbl7.setBounds(30, 300, 100, 30);
        state = new JComboBox(st_state);
        state.setBounds(70, 300, 100, 30);

        lbl8 = new JLabel("City");
        lbl8.setBounds(200, 300, 100, 30);
        city = new JComboBox(st_city);
        city.setBounds(240, 300, 100, 30);

        lbl9 = new JLabel("Gender");
        lbl9.setBounds(380, 300, 100, 30);


        male = new JRadioButton("Male");
        male.setBounds(440, 300, 100, 30);


        female = new JRadioButton("Female");
        female.setBounds(550, 300, 100, 30);

        bggender = new ButtonGroup();
        bggender.add(male);
        bggender.add(female);

        lbl10 = new JLabel("License Number");
        lbl10.setBounds(30, 370, 100, 30);
        tf_License = new JTextField();
        tf_License.setBounds(130, 370, 150, 30);

        lbl11 = new JLabel("Security Question");
        lbl11.setBounds(30, 440, 120, 30);

        cmb_securityquestion = new JComboBox(st_security);
        cmb_securityquestion.setBounds(150, 440, 180, 30);


        lbl12 = new JLabel("Your Answer");
        lbl12.setBounds(30, 510, 100, 30);

        tf_answer = new JTextField();
        tf_answer.setBounds(150, 510, 180, 30);


        ImageIcon img = new ImageIcon("Icon\\Background2.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl13 = new JLabel("", img1, JLabel.CENTER);
        lbl13.setBounds(0, 0, 900, 900);
        lbl13.setVisible(true);
        p1 = new JPanel();


        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = tf_name.getText();
                String Age = tf_Age.getText();
                String MobileNumber = tf_mobl_number.getText();
                String Email = tf_email.getText();
                String Password = pf_pass.getText();
                String ConfirmPassword = pf_conf_pass.getText();
                String State = state.getSelectedItem().toString();
                String City = city.getSelectedItem().toString();
                String Gender = null;
                if (male.isSelected()) {
                    Gender = "Male";
                }
                if (female.isSelected()) {
                    Gender = "Female";
                }
                String LicenseNumber = tf_License.getText();
                String security_question = cmb_securityquestion.getSelectedItem().toString();
                String answer = tf_answer.getText();
                if(!(pf_pass.getText().equals(pf_conf_pass.getText()))){
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password Doesn't Match","Error",JOptionPane.ERROR_MESSAGE);
                }else {

                    try {
                        if (tf_name.getText().equals("") || tf_Age.getText().equals("") || tf_mobl_number.getText().equals("") || tf_License.getText().equals("") || tf_answer.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Fill all the required details", "Alert", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Conn c1 = new Conn();
                            String q1 = "insert into employee_info values('" + Name + "' , '" + Age + "' , '" + MobileNumber + "' , '" + Email + "' , '" + Password + "' , '" + ConfirmPassword + "' , '" + State + "' , '" + City + "' , '" + Gender + "' , '" + LicenseNumber + "' , '" + security_question + "' , '" + answer + "')";

                            c1.s.executeUpdate(q1);

                            JOptionPane.showMessageDialog(btn_add, "Employee Added Succefully", "Add Employee", JOptionPane.INFORMATION_MESSAGE);
                            new Add_Employee();
                            dispose();
                        }
                    } catch (Exception ae) {
                        ae.printStackTrace();
                        System.out.println(ae);
                    }
                }
            }
        });

        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_back) {
                    dispose();
                }
            }
        });


        add(Heading);
        add(lbl1);
        add(tf_name);
        add(lbl2);
        add(tf_Age);
        add(lbl3);
        add(tf_mobl_number);
        add(lbl4);
        add(tf_email);
        add(lbl5);
        add(pf_pass);
        add(lbl6);
        add(pf_conf_pass);
        add(lbl7);
        add(state);
        add(lbl8);
        add(city);
        add(lbl9);
        add(male);
        add(female);
        add(lbl10);
        add(tf_License);
        add(lbl11);
        add(cmb_securityquestion);
        add(lbl12);
        add(tf_answer);
        add(btn_add);
        add(btn_back);
        add(bg);

        add(lbl13);
        p1.add(lbl13);

        setSize(900, 800);
        setTitle("Add Employee");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Add_Employee();
    }
}
