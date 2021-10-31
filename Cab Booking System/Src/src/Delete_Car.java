import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Car extends JFrame {
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6,Heading,bg,lbl7;
    JTextField tf_carmodel, tf_company, tf_makeyear, tf_rent, tf_carnumber;
    JButton btn_Search,btn_Delete, btn_Back;
    JPanel p1;

    Delete_Car(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(200,-40,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));


     lbl5 = new JLabel("Enter Car Number");
     lbl5.setBounds(30,130,120,30);
     tf_carnumber = new JTextField();
     tf_carnumber.setBounds(140,130,150,30);

     lbl6 = new JLabel("Records:-");
     lbl6.setBounds(30,180,100,30);
     lbl6.setFont(new Font("Arial",Font.BOLD,18));

     lbl2 = new JLabel("Company");
     lbl2.setBounds(30,240,100,30);
     tf_company = new JTextField();
     tf_company.setBounds(100,240,150,30);
     tf_company.setEditable(false);

     lbl1 = new JLabel("Car Model");
     lbl1.setBounds(30,290,100,30);
     tf_carmodel = new JTextField();
     tf_carmodel.setBounds(100,290,150,30);
     tf_carmodel.setEditable(false);

     lbl3 = new JLabel("Make Year");
     lbl3.setBounds(30,340,100,30);
     tf_makeyear = new JTextField();
     tf_makeyear.setBounds(100,340,150,30);
     tf_makeyear.setEditable(false);

     lbl4 = new JLabel("Rent");
     lbl4.setBounds(30,390,100,30);
     tf_rent = new JTextField();
     tf_rent.setBounds(100,390,150,30);
     tf_rent.setEditable(false);

     btn_Search = new JButton("Search");
     btn_Search.setBounds(330,120,150,50);

     btn_Delete = new JButton("Delete");
     btn_Delete.setBounds(30,450,170,50);

     btn_Back = new JButton("Back");
     btn_Back.setBounds(250,450,170,50);

     ImageIcon img = new ImageIcon("Icon\\Background7.jpg");
     bg = new JLabel("", img, JLabel.CENTER);
     bg.setBounds(0, 0, 900, 1000);

     ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
     lbl7 = new JLabel("", img1, JLabel.CENTER);
     lbl7.setBounds(0, 0, 900, 900);
     lbl7.setVisible(true);
     p1 = new JPanel();


     btn_Search.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(e.getSource()==btn_Search){
                 try {


                     String carnumber1 = tf_carnumber.getText();

                     Connection conn;
                     PreparedStatement ps;

                     Class.forName("com.mysql.cj.jdbc.Driver");
                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                     String q1 = "select company,carmodel,makeyear,RentPerKM from cardetails where carnumber = ?";

                     ps = conn.prepareStatement(q1);
                     ps.setString(1,carnumber1);

                     ResultSet rs = ps.executeQuery();

                     if(rs.next()){
                         tf_company.setText(rs.getString("company"));
                         tf_carmodel.setText(rs.getString("carmodel"));
                         tf_makeyear.setText(rs.getString("makeyear"));
                         tf_rent.setText(rs.getString("RentPerKm"));
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"No Record Found","Alert",JOptionPane.ERROR_MESSAGE);
                         tf_carnumber.setText("");
                     }
                 }catch (Exception ae){
                     ae.printStackTrace();
                     System.out.println(ae);
                 }
             }
         }
     });

     btn_Delete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(e.getSource()==btn_Delete){
                 String carnumber2 = tf_carnumber.getText();

                 try {
                     if (tf_carnumber.getText().equals("")) {
                         JOptionPane.showMessageDialog(null, "Fill all the required details");
                     } else {
                         Connection conn;
                         PreparedStatement ps;

                         Class.forName("com.mysql.cj.jdbc.Driver");
                         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                         String q1 = "delete from cardetails where carnumber = ?";

                         ps = conn.prepareStatement(q1);
                         ps.setString(1,carnumber2);
                         int rows = ps.executeUpdate();

                         if(rows>0){
                             JOptionPane.showMessageDialog(null,"Car Deleted Successfully","Car Delete",JOptionPane.INFORMATION_MESSAGE);
                             new Delete_Car();
                             dispose();
                         }else{
                             JOptionPane.showMessageDialog(null,"No Such Car Found","Alert",JOptionPane.ERROR_MESSAGE);
                         }
                         conn.close();
                     }
                 }catch (Exception ae){
                     ae.printStackTrace();
                     System.out.println(ae);
                 }
             }
         }
     });

     btn_Back.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(e.getSource()==btn_Back){
                 dispose();
             }
         }
     });

     add(Heading);
     add(lbl5);
     add(tf_carnumber);
     add(lbl6);
     add(lbl2);
     add(tf_company);
     add(lbl1);
     add(tf_carmodel);
     add(lbl3);
     add(tf_makeyear);
     add(lbl4);
     add(tf_rent);
     add(btn_Search);
     add(btn_Delete);
     add(btn_Back);
     add(bg);
     add(lbl7);
     p1.add(lbl7);


     setTitle("Delete Car");
     setSize(700,600);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
     getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Delete_Car();
    }
}
