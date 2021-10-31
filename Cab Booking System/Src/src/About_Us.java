import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About_Us extends JFrame {

    JLabel Heading,bg, lbl2,tf_About;
    JScrollPane sp;
    JButton btn_Back;
    JPanel p1;

    About_Us(){

        p1 = new JPanel();

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(350,-50,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        String text = "<html><p>The Project is all about Cab Booking System.</p>\n" +
                "<p>The Company was Started in October 2021.\n</p>" +
                "<p>In this System You can Book cabs from Indore(Madhya Pradesh) to all big cities of India. Soon we will add all the cities and villages of india in it.\n</p>" +
                "<p>Our Company provides all the Best cars in good condition and best drivers which makes you journey safe.\n</p>" +
                "\n" +
                "<p>You can also provide feedback of our service from the feedback option available both in Employee and Customer Page.\n</p>" +
                "\n" +
                "\n" +
                "<p>This software includes 3 main pages:-\n</p>" +
                "<p>1. Admin Page:- Admin Page is a page which is handled by the admin.It has many features like adding new Cars,new Employees,delete Cars,delete Employees etc.\n</p>" +
                "<p>2. Customer Page:- Customer Page has the features of Booking a cab , Cancelling a cab and viewing details of Booked cabs. Cusotmer can also change the password of his/her account.\n</p>" +
                "<p>3. Employee Page:- Employee Page has the features of Viewing the new rides which are booked by customers. Employee can also change the password of his/her account.\n</p>" +
                "\n" +
                "\n" +
                "<p>Devloped by:-\n</p>" +
                "\n" +
                "<p>Krishnam Shastri\n</p>" +
                "<p>(Ec 3rd Year)</p></html>";

        tf_About = new JLabel(text);
        tf_About.setBounds(80,150,800,500);
        tf_About.setFont(new Font("Comic Sans MS",Font.BOLD,16));

        btn_Back = new JButton("Back");
        btn_Back.setBounds(380,700,150,50);

        sp = new JScrollPane(tf_About);

        ImageIcon img = new ImageIcon("Icon\\Background3.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1100,1100);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl2 = new JLabel("",img1,JLabel.CENTER);
        lbl2.setBounds(0,0,1100,1100);
        lbl2.setVisible(true);

        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_Back){
                    dispose();
                }
            }
        });

        add(Heading);
        add(tf_About);
        add(btn_Back);
        add(sp);

        add(bg);
        add(lbl2);
        p1.add(lbl2);

        setTitle("About Us");
        setSize(1000,1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new About_Us();
    }
}
