import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Page extends JFrame{
    JFrame frame;
    JMenu menu;
    JMenuItem Logout;
    JLabel Heading,bg,lbl1;
    JMenuBar menuBar;
    JButton addempbtn,addcarbtn,delempbtn,delcarbtn,delcust,viewemp,viewcar,viewcust,ChoosedCar;
    JPanel p1;

    Admin_Page(){
        //Initialise buttons



        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(230,10,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        frame = new JFrame("Admin Page");


        addempbtn = new JButton("Add Employee");
        addempbtn.setBounds(100,200,120,50);

        delempbtn = new JButton("Delete Employee");
        delempbtn.setBounds(270,200,150,50);

        viewemp = new JButton("View Employees");
        viewemp.setBounds(460,200,150,50);

        addcarbtn = new JButton("Add Cars");
        addcarbtn.setBounds(100,290,120,50);

        delcarbtn = new JButton("Delete Car");
        delcarbtn.setBounds(270,290,150,50);

        viewcar = new JButton("View Cars");
        viewcar.setBounds(460,290,150,50);


        delcust = new JButton("Delete Customer");
        delcust.setBounds(370,390,150,50);

        viewcust = new JButton("View Customers");
        viewcust.setBounds(170,390,150,50);

        ChoosedCar = new JButton("Booked Cars");
        ChoosedCar.setBounds(270,490,150,50);


        menu = new JMenu("Options");
        menu.setBackground(Color.RED);


        menuBar = new JMenuBar();

        menuBar.setOpaque(true);
        menuBar.setBackground(Color.CYAN);


        Logout = new JMenuItem("Logout");

        ImageIcon img = new ImageIcon("Icon\\Background8.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl1 = new JLabel("", img1, JLabel.CENTER);
        lbl1.setBounds(0, 0, 900, 900);
        lbl1.setVisible(true);
        p1 = new JPanel();


        ChoosedCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==ChoosedCar){
                    new New_Ride_Employee();
                    dispose();
                }
            }
        });



        addempbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addempbtn){
                    new Add_Employee();
                    dispose();
                }
            }
        });

        delempbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==delempbtn){
                    new Delete_Employee();
                    dispose();
                }
            }
        });

        viewemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewemp){
                    new View_Employee();
                    dispose();
                }
            }
        });

        addcarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addcarbtn){
                    new Add_Cars();
                    dispose();
                }
            }
        });

        delcarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==delcarbtn){
                    new Delete_Car();
                    dispose();
                }
            }
        });

        viewcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewcar){
                    new View_Cars();
                    dispose();
                }
            }
        });

        viewcust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewcust){
                    new View_Customer();
                    dispose();
                }
            }
        });

        delcust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==delcust){
                    new Delete_Customer();
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


        //Adding Buttons
        frame.add(Heading);
        frame.add(addempbtn);
        frame.add(addcarbtn);
        frame.add(delempbtn);
        frame.add(delcarbtn);
        frame.add(delcust);
        frame.add(viewemp);
        frame.add(viewcar);
        frame.add(viewcust);
        frame.add(ChoosedCar);
        menu.add(Logout);
        menuBar.add(menu);

        frame.add(bg);

        frame.add(lbl1);
        p1.add(lbl1);




        setTitle("Admin Page");
        frame.setJMenuBar(menuBar);
        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Admin_Page();
    }
}
