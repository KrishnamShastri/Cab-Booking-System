import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Customer_SignUp extends JFrame {

    JLabel lb1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10,lbl11,lbl12,Heading,bg,lbl13;
    JTextField tf_name, tf_Age, tf_mobl_number, tf_email, tf_Address,tf_answer;
    JPasswordField pf_pass, pf_conf_pass;
    JButton btn_add,btn_back;
    JComboBox cmb_state, cmb_city,cmb_securityquestion;
    JRadioButton male,female;
    ButtonGroup bggender;
    JPanel p1;

    String st_state[] = {"Gujrat","Madhya Pradesh","Maharashtra","Rajasthan"};
    String st_city[] = {"Ahemdabad","Ajmer","Aurangabad","Bhavnagar","Bhopal","Gwalior","Indore","Jabalpur","Jaipur","Jodhpur","Kota","Mumbai","Nagpur","Pune","Rajkot","Surat","Thane","Udaipur","Ujjain","Vadodra"};
    String st_security[] = {"What is your Nick Name","What is you Mother Tongue" , "What is your Favourite Food" , "Which is your Favourite Movie" , "Who is your Favourite Hero"};

    Customer_SignUp(){

        p1 = new JPanel();

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(250,-70,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));


        lb1 = new JLabel("Name");
        lb1.setBounds(30,100,100,30);
        tf_name = new JTextField();
        tf_name.setBounds(70,100,100,30);



        lbl2 = new JLabel("Age");
        lbl2.setBounds(200,100,100,30);
        tf_Age = new JTextField();
        tf_Age.setBounds(240,100,100,30);



        lbl3 = new JLabel("Mobile Number");
        lbl3.setBounds(370,100,100,30);
        tf_mobl_number = new JTextField();
        tf_mobl_number.setBounds(470,100,100,30);



        lbl4 = new JLabel("Email");
        lbl4.setBounds(30,150,100,30);
        tf_email = new JTextField();
        tf_email.setBounds(70,150,100,30);



        lbl5 = new JLabel("Password");
        lbl5.setBounds(200,150,100,30);
        pf_pass = new JPasswordField();
        pf_pass.setBounds(270,150,100,30);



        lbl6 = new JLabel("Confirm Password");
        lbl6.setBounds(400,150,120,30);
        pf_conf_pass = new JPasswordField();
        pf_conf_pass.setBounds(520,150,100,30);



        btn_add = new JButton("Login");
        btn_add.setBounds(30,600,150,50);
        btn_back = new JButton("Cancel");
        btn_back.setBounds(200,600,150,50);



        lbl7 = new JLabel("State");
        lbl7.setBounds(30,200,100,30);
        cmb_state = new JComboBox(st_state);
        cmb_state.setBounds(70,200,100,30);

        lbl8 = new JLabel("City");
        lbl8.setBounds(200,200,100,30);
        cmb_city = new JComboBox(st_city);
        cmb_city.setBounds(240,200,100,30);

        lbl9 = new JLabel("Gender");
        lbl9.setBounds(380,200,100,30);

        male = new JRadioButton("Male");
        male.setBounds(440,200,100,30);

        female = new JRadioButton("Female");
        female.setBounds(550,200,100,30);

        bggender = new ButtonGroup();
        bggender.add(male);
        bggender.add(female);

        lbl10 = new JLabel("Address");
        lbl10.setBounds(30,270,100,30);
        tf_Address = new JTextField();
        tf_Address.setBounds(90,260,400,90);

        lbl11 = new JLabel("Security Question");
        lbl11.setBounds(30,400,130,30);

        cmb_securityquestion = new JComboBox(st_security);
        cmb_securityquestion.setBounds(160,400,180,30);

        lbl12 = new JLabel("Your Answer");
        lbl12.setBounds(30,470,100,30);

        tf_answer = new JTextField();
        tf_answer.setBounds(160,470,180,30);

        ImageIcon img = new ImageIcon("Icon\\Background2.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl13 = new JLabel("", img1, JLabel.CENTER);
        lbl13.setBounds(0, 0, 900, 900);
        lbl13.setVisible(true);

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_add){
                    String Name = tf_name.getText();
                    String Age = tf_Age.getText();
                    String mobile_number = tf_mobl_number.getText();
                    String Email = tf_email.getText();

                    String Password = pf_pass.getText();
                    String Conf_pass = pf_conf_pass.getText();

                    String State = cmb_state.getSelectedItem().toString();
                    String City = cmb_city.getSelectedItem().toString();

                    String Gender = null;
                    if(male.isSelected()){
                        Gender = "Male";
                    }
                    if(female.isSelected()){
                        Gender = "Female";
                    }

                    String Address = tf_Address.getText();

                    String security_question = cmb_securityquestion.getSelectedItem().toString();
                    String answer = tf_answer.getText();
                    if(!(pf_pass.getText().equals(pf_conf_pass.getText()))){
                        JOptionPane.showMessageDialog(null,"Password and Confirm Password are not same");
                    }else {

                        try {
                            if (tf_name.getText().equals("") || tf_mobl_number.getText().equals("") || tf_email.getText().equals("") || pf_pass.getText().equals("") || pf_conf_pass.getText().equals("") || tf_answer.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Fill all the required details", "Alert", JOptionPane.ERROR_MESSAGE);
                            } else {
                                Conn c1 = new Conn();
                                String q1 = "insert into customer_info values('" + Name + "' , '" + Age + "' , '" + mobile_number + "' , '" + Email + "' , '" + Password + "' , '" + Conf_pass + "' , '" + State + "' , '" + City + "' , '" + Gender + "' , '" + Address + "' , '" + security_question + "' , '" + answer + "')";

                                c1.s.executeUpdate(q1);


                                JOptionPane.showMessageDialog(null, "Account Created Successfully", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
                                new Login_Customer();
                                dispose();

                            }


                        } catch (Exception ae) {
                            ae.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Student Already Exist", "Alert", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_back){
                    dispose();
                }
            }
        });



        add(Heading);
        add(lb1);
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
        add(cmb_state);
        add(lbl8);
        add(cmb_city);
        add(lbl9);
        add(male);
        add(female);
        add(lbl10);
        add(tf_Address);
        add(lbl11);
        add(cmb_securityquestion);
        add(lbl12);
        add(tf_answer);
        add(btn_add);
        add(btn_back);

        add(bg);

        add(lbl13);
        p1.add(lbl13);

        setSize(800,700);
        setTitle("New Customer/SignUp");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Customer_SignUp();
    }
}