import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cancel_Booking extends JFrame {

    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,Heading,bg,lbl13;
    JTextField tf_CarNumber,tf_DriverName,tf_Customer_name,tf_Carname,tf_PickupPoint,tf_droppoint,tf_Customer_Number, tf_DriverNumber, tf_Date, tf_Time, tf_RentperKM,tf_Totalrent;
    JButton btn_Search,btn_Cancelbooking,btn_Back;
    JPanel p1;

    Cancel_Booking(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(270,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        lbl1 = new JLabel("Enter Your Name");
        lbl1.setBounds(30,100,100,30);
        tf_Customer_name = new JTextField();
        tf_Customer_name.setBounds(140,100,130,30);
        lbl2 = new JLabel("Car Number");
        lbl2.setBounds(30,150,100,30);
        tf_CarNumber = new JTextField();
        tf_CarNumber.setBounds(140,150,130,30);
        tf_CarNumber.setEditable(false);
        lbl3 = new JLabel("Driver Name");
        lbl3.setBounds(300,150,100,30);
        tf_DriverName = new JTextField();
        tf_DriverName.setBounds(390,150,130,30);
        tf_DriverName.setEditable(false);
        lbl4 = new JLabel("Car Name");
        lbl4.setBounds(540,150,100,30);
        tf_Carname = new JTextField();
        tf_Carname.setBounds(610,150,130,30);
        tf_Carname.setEditable(false);
        lbl5 = new JLabel("Pickup Point");
        lbl5.setBounds(30,200,100,30);
        tf_PickupPoint = new JTextField();
        tf_PickupPoint.setBounds(140,200,130,30);
        tf_PickupPoint.setEditable(false);
        lbl6 = new JLabel("Drop Point");
        lbl6.setBounds(300,200,100,30);
        tf_droppoint = new JTextField();
        tf_droppoint.setBounds(390,200,130,30);
        tf_droppoint.setEditable(false);
        lbl7 = new JLabel("Customer Number");
        lbl7.setBounds(30,250,120,30);
        tf_Customer_Number = new JTextField();
        tf_Customer_Number.setBounds(140,250,130,30);
        tf_Customer_Number.setEditable(false);
        lbl8 = new JLabel("Driver Number");
        lbl8.setBounds(300,250,100,30);
        tf_DriverNumber = new JTextField();
        tf_DriverNumber.setBounds(390,250,130,30);
        tf_DriverNumber.setEditable(false);
        lbl9 = new JLabel("Date");
        lbl9.setBounds(540,200,100,30);
        tf_Date = new JTextField();
        tf_Date.setBounds(610,200,130,30);
        tf_Date.setEditable(false);
        lbl10 = new JLabel("Time");
        lbl10.setBounds(540,250,100,30);
        tf_Time = new JTextField();
        tf_Time.setBounds(610,250,130,30);
        tf_Time.setEditable(false);
        lbl11 = new JLabel("Rent Per KM");
        lbl11.setBounds(30,300,100,30);
        tf_RentperKM = new JTextField();
        tf_RentperKM.setBounds(140,300,130,30);
        tf_RentperKM.setEditable(false);
        lbl12 = new JLabel("Total Rent");
        lbl12.setBounds(300,300,100,30);
        tf_Totalrent = new JTextField();
        tf_Totalrent.setBounds(390,300,130,30);
        tf_Totalrent.setEditable(false);


        btn_Search = new JButton("Search");
        btn_Search.setBounds(300,100,150,30);
        btn_Cancelbooking = new JButton("Cancel Booking");
        btn_Cancelbooking.setBounds(30,400,180,80);
        btn_Back = new JButton("Back");
        btn_Back.setBounds(560,400,180,80);

        ImageIcon img = new ImageIcon("Icon\\Background4.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 1100, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl13 = new JLabel("", img1, JLabel.CENTER);
        lbl13.setBounds(0, 0, 1100, 900);
        lbl13.setVisible(true);
        p1 = new JPanel();

        btn_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_Search){
                    String Customer_Name = tf_Customer_name.getText();

                    Connection conn;
                    PreparedStatement ps;

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                        String q1 = "select Car_Number , Driver_Name , Car_Name , Pickup_Point , Drop_Point , Customer_Number , Driver_Number , Date , Time , RentPerKM , TotalRent from cab_book where Customer_Name = ?";

                        ps = conn.prepareStatement(q1);
                        ps.setString(1,Customer_Name);

                        ResultSet rs = ps.executeQuery();

                        if(rs.next()){
                          tf_CarNumber.setText(rs.getString("Car_Number"));
                          tf_DriverName.setText(rs.getString("Driver_Name"));
                          tf_Carname.setText(rs.getString("Car_Name"));
                          tf_PickupPoint.setText(rs.getString("Pickup_Point"));
                          tf_droppoint.setText(rs.getString("Drop_Point"));
                          tf_Customer_Number.setText(rs.getString("Customer_Number"));
                          tf_DriverNumber.setText(rs.getString("Driver_Number"));
                          tf_Date.setText(rs.getString("Date"));
                          tf_Time.setText(rs.getString("Time"));
                          tf_RentperKM.setText(rs.getString("RentPerKM"));
                          tf_Totalrent.setText(rs.getString("TotalRent"));

                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No Booking Found","Alert",JOptionPane.ERROR_MESSAGE);
                            tf_Customer_name.setText("");

                        }

                    }catch (Exception ae){
                        ae.printStackTrace();
                        System.out.println(ae);
                    }

                }
            }
        });

        btn_Cancelbooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_Cancelbooking) {
                    if (tf_Customer_name.getText().equals("") || tf_CarNumber.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the required details", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String Name = tf_Customer_name.getText();
                        String Status = "Unbooked";
                        String Carnumber = tf_CarNumber.getText();


                        try {
                            Conn c1 = new Conn();


                            String q1 = "update cab_book set Customer_Name = null , Pickup_Point = null , Drop_Point = null , Customer_Number = null , Date = null , Time = null , TotalRent = null where Customer_Name ='" + Name + "'";
                            String q = "update cardetails set Status = '" + Status + "' where carnumber = '" + Carnumber + "'";

                            c1.s.executeUpdate(q1);
                            c1.s.executeUpdate(q);


                            JOptionPane.showMessageDialog(null, "Booking Cancelled", "Booking Cancelled", JOptionPane.INFORMATION_MESSAGE);
                            new Cancel_Booking();
                            dispose();

                        } catch (Exception ae) {
                            ae.printStackTrace();
                            System.out.println(ae);
                        }
                    }
                }
            }
        });

        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(Heading);
        add(lbl1);
        add(tf_Customer_name);
        add(lbl2);
        add(tf_CarNumber);
        add(lbl3);
        add(tf_DriverName);
        add(lbl4);
        add(tf_Carname);
        add(lbl5);
        add(tf_PickupPoint);
        add(lbl6);
        add(tf_droppoint);
        add(lbl7);
        add(tf_Customer_Number);
        add(lbl8);
        add(tf_DriverNumber);
        add(lbl9);
        add(tf_Date);
        add(lbl10);
        add(tf_Time);
        add(lbl11);
        add(tf_RentperKM);
        add(lbl12);
        add(tf_Totalrent);
        add(btn_Search);
        add(btn_Cancelbooking);
        add(btn_Back);
        add(bg);
        add(lbl13);
        p1.add(lbl13);





        setTitle("Cancel Booking");
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Cancel_Booking();
    }
}
