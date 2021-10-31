import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class New_Ride_Employee extends JFrame {

    JFrame frame;
    JTable Cab_Book_List;
    JScrollPane sp;


    New_Ride_Employee(){

        frame = new JFrame();
        frame.setTitle("New Rides");
        frame.setFont(new Font("Arial",Font.BOLD,11));
        Cab_Book_List = new JTable(0,11);
        Cab_Book_List.setBounds(30,40,300,300);
        Cab_Book_List.setBackground(Color.pink);
        Cab_Book_List.setFont(new Font("Arial",Font.BOLD,10));
        sp = new JScrollPane(Cab_Book_List);

        frame.add(sp);

        Connection conn;
        Statement ps;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

            ps = conn.createStatement();

            String q1 = "select * from cab_book";

            ResultSet rs = ps.executeQuery(q1);

            while (rs.next()){
                String Car_Number = rs.getString("Car_Number");
                String Driver_Name = rs.getString("Driver_Name");
                String Customer_Name = rs.getString("Customer_Name");
                String Car_Name = rs.getString("Car_Name");
                String Pickup_Point = rs.getString("Pickup_Point");
                String Drop_Point = rs.getString("Drop_Point");
                String Driver_Number = rs.getString("Driver_Number");
                String Customer_Number = rs.getString("Customer_Number");
                String Date = rs.getString("Date");
                String Time = rs.getString("Time");
                String RentperKM = rs.getString("RentPerKM");
                String TotalRent = rs.getString("TotalRent");

                String tbData[] = {Car_Number, Driver_Name, Customer_Name, Car_Name, Pickup_Point, Drop_Point, Date, Time, Driver_Number,Customer_Number, RentperKM,TotalRent};
                String tbData1[] = {"Car_Number","Driver_Name","Customer_Name","Car_Name","Pickup_Point","Drop_Point","Date","Time","Driver_Number","Customer_Number","RentPerKM","TotalRent"};


                DefaultTableModel tb1mode1 = (DefaultTableModel)Cab_Book_List.getModel();
                tb1mode1.setColumnIdentifiers(tbData1);
                tb1mode1.addRow(tbData);
            }

        }catch (Exception ae){
            ae.printStackTrace();
            System.out.println("DataBase Error" + ae);
        }
        setTitle("View Cars");
        frame.setSize(700,700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new New_Ride_Employee();
    }
}
