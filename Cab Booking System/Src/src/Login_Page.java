import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Page extends JFrame {

    JFrame frame;
    JButton AdminLogin,EmployeeLogin,CustomerLogin;
    JLabel Heading,bg,lbl1;
    JButton Exit;
    JPanel p1;

    Login_Page(){
        frame = new JFrame("Login Page");

        p1 = new JPanel();
        p1.setBounds(30,200,700,300);
        p1.setBackground(Color.WHITE);

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(250,10,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Downloads\\Background.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,800,1000);

        ImageIcon img1 = new ImageIcon("C:\\Users\\HP\\Downloads\\Background1.jpg");
        lbl1 = new JLabel("",img1,JLabel.CENTER);
        lbl1.setBounds(0,0,700,900);
        lbl1.setVisible(true);

        AdminLogin = new JButton("Login As Admin");
        AdminLogin.setBounds(30,300,150,30);

        EmployeeLogin = new JButton("Login As Employee");
        EmployeeLogin.setBounds(280,300,150,30);

        CustomerLogin = new JButton("Login As Customer");
        CustomerLogin.setBounds(530,300,150,30);

        Exit = new JButton("Exit Page");
        Exit.setBounds(300,550,100,30);
        Exit.setVisible(true);


        AdminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==AdminLogin){
                    new Login_Admin().setVisible(true);
                    dispose();
                }
            }
        });

        EmployeeLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==EmployeeLogin){
                    new Login_Employee().setVisible(true);
                    dispose();
                }
            }
        });

        CustomerLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==CustomerLogin){
                    new Login_Customer().setVisible(true);
                    dispose();
                }
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



        add(Heading);
        add(AdminLogin);
        add(EmployeeLogin);
        add(CustomerLogin);
        add(Exit);
        add(bg);

        add(lbl1);
        p1.add(lbl1);




        setVisible(true);
        setLayout(null);
        setSize(800,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new Login_Page();
    }
}
