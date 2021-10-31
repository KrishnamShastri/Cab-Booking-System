import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Admin extends JFrame {
    JPanel panel,p1;
    JLabel lbl1,lbl2,lblmsg,Heading,bg,lbl3;
    JButton loginbtn,cancelbtn,clrbtn;
    JTextField usrname;
    JPasswordField password;

    Login_Admin(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(30,-70,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));


        lbl1 = new JLabel("Username");
        usrname = new JTextField();
        lbl1.setBounds(60,80,100,30);
        usrname.setBounds(130,80,140,30);


        lbl2 = new JLabel("Password");
        password = new JPasswordField();
        lbl2.setBounds(60,120,100,30);
        password.setBounds(130,120,140,30);


        loginbtn = new JButton("Login");
        loginbtn.setBounds(80,200,80,30);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(170,200,80,30);

        clrbtn = new JButton("Clear");
        clrbtn.setBounds(120,250,80,30);


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
        add(usrname);
        add(lbl2);
        add(password);
        add(loginbtn);
        add(cancelbtn);
        add(clrbtn);
        add(panel);
        add(lblmsg);
        add(bg);
        add(lbl3);
        p1.add(lbl3);



        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = usrname.getText();
                String Password = password.getText();
                if(Username.equals("101") && Password.equals("Admin123")){
                    JOptionPane.showMessageDialog(loginbtn,"Login Successful","Welcome Admin",JOptionPane.INFORMATION_MESSAGE);
                    new Admin_Page();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password","Alert",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cancelbtn){
                    new Login_Page().setVisible(true);
                    dispose();
                }
            }
        });

        clrbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clrbtn){
                    usrname.setText("");
                    password.setText("");
                }
            }
        });

        setSize(350,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new Login_Admin();
    }
}
