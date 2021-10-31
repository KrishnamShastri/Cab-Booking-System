import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer_Page extends JFrame{

    JFrame frame;
    JMenu menu,menu1;
    JMenuItem Change_Password,Logout,About_Us,Feedback;
    JMenuBar menuBar;
    JButton BookCab,Btn_cancel,Bookingdetails;
    JLabel Heading,bg, lbl1;
    JPanel p1;



    Customer_Page(){
        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(150,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        frame = new JFrame("Customer Page");

        menu = new JMenu("Options");

        menu1 = new JMenu("About");


        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.CYAN);

        Change_Password = new JMenuItem("Change Password");

        Logout = new JMenuItem("Logout");

        About_Us = new JMenuItem("About Us");

        Feedback = new JMenuItem("Give Feedback");

        BookCab = new JButton("Book Cab");
        BookCab.setBounds(100,250,150,50);

        Btn_cancel = new JButton("Cancel Booking");
        Btn_cancel.setBounds(300,250,150,50);

        Bookingdetails = new JButton("Booking Details");
        Bookingdetails.setBounds(200,350,150,50);

        ImageIcon img = new ImageIcon("Icon\\Background8.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl1 = new JLabel("", img1, JLabel.CENTER);
        lbl1.setBounds(0, 0, 900, 900);
        lbl1.setVisible(true);
        p1 = new JPanel();

        Change_Password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Change_Password){
                    new Change_Password_Customer();
                    dispose();
                }
            }
        });

        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Logout){
                    int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout","Logout",JOptionPane.YES_NO_OPTION);
                    if(opt==0){
                        JOptionPane.showMessageDialog(frame,"Logout Successful","Alert",JOptionPane.PLAIN_MESSAGE);
                        frame.setVisible(false);
                        new Login_Page();
                        dispose();
                    }
                }
            }
        });

        About_Us.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==About_Us){
                    new About_Us();
                }
            }
        });

        Feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Feedback){
                    new Feedback();
                    dispose();
                }
            }
        });

        BookCab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==BookCab){
                    new Book_Cab();
                    dispose();
                }
            }
        });

        Btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cancel_Booking();
                dispose();
            }
        });

        Bookingdetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Bookingdetails){
                    new Booking_Details();
                    dispose();
                }
            }
        });




        frame.add(Heading);
        menu.add(Change_Password);
        menu.add(Logout);
        menu1.add(About_Us);
        menu1.add(Feedback);
        menuBar.add(menu);
        menuBar.add(menu1);
        frame.add(BookCab);
        frame.add(Btn_cancel);
        frame.add(Bookingdetails);
        frame.add(bg);
        frame.add(lbl1);
        p1.add(lbl1);


        frame.setTitle("Customer Page");
        frame.setJMenuBar(menuBar);
        frame.setSize(600,700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Customer_Page();
    }
}
