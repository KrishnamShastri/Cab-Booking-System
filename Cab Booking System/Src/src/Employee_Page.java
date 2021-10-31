import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee_Page extends JFrame {

    JFrame frame;
    JMenu menu,menu1;
    JMenuBar menuBar;
    JMenuItem Logout,Change_Password,choose_car,About_Us,Feedback;
    JButton New_Ride;
    JLabel Heading,bg,lbl1;
    JPanel p1;
    Employee_Page(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(200,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        frame = new JFrame("Employee Page");

        menu = new JMenu("Options");

        menu1 = new JMenu("About");

        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.CYAN);

        Logout = new JMenuItem("Logout");

        Change_Password = new JMenuItem("Change Password");

        choose_car = new JMenuItem("Choose Car");

        About_Us = new JMenuItem("About Us");

        Feedback = new JMenuItem("Give Feedback");

        New_Ride = new JButton("New Ride");
        New_Ride.setBounds(270,250,150,50);

        ImageIcon img = new ImageIcon("Icon\\Background8.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl1 = new JLabel("", img1, JLabel.CENTER);
        lbl1.setBounds(0, 0, 900, 900);
        lbl1.setVisible(true);
        p1 = new JPanel();

        New_Ride.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==New_Ride){
                    new New_Ride_Employee();
                }
            }
        });

        choose_car.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==choose_car){
                    new Choose_Car();
                    dispose();
                }
            }
        });

        Change_Password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Change_Password){
                    new Change_Password_Employee();
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
                    dispose();
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


        frame.add(Heading);
        frame.add(New_Ride);
        menu.add(choose_car);
        menu.add(Change_Password);
        menu.add(Logout);
        menu1.add(About_Us);
        menu1.add(Feedback);
        menuBar.add(menu);
        menuBar.add(menu1);
        frame.add(bg);
        frame.add(lbl1);
        p1.add(lbl1);

        frame.setTitle("Employee Page");
        frame.setJMenuBar(menuBar);
        frame.setSize(700,700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new Employee_Page();

    }
}
