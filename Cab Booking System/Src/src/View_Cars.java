import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class View_Cars extends JFrame {

    JFrame frame;
    JTable Cars_List;
    JScrollPane sp;

    View_Cars(){

        frame = new JFrame();
        frame.setTitle("View Cars");
        frame.setFont(new Font("Arial",Font.BOLD,10));
        Cars_List = new JTable(0,10);
        Cars_List.setBounds(30,40,300,300);
        Cars_List.setBackground(Color.pink);
        Cars_List.setFont(new Font("Arial",Font.BOLD,10));
        sp = new JScrollPane(Cars_List);

        frame.add(sp);

        Connection conn;
        Statement ps;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

            ps = conn.createStatement();

            String q1 = "select * from cardetails";

            ResultSet rs = ps.executeQuery(q1);

            while (rs.next()){
                String Carmodel = rs.getString("carmodel");
                String Company = rs.getString("company");
                String Makeyear = String.valueOf(rs.getInt("makeyear"));
                String RentPerKM = String.valueOf(rs.getDouble("RentPerKM"));
                String Sitting_Capacity = rs.getString("sittingcapacity");
                String Cartype = rs.getString("cartype");
                String Variant = rs.getString("variant");
                String Carnumber = rs.getString("carnumber");
                String CarStatus = rs.getString("CarStatus");
                String Status = rs.getString("Status");

                String tbData[] = {Carmodel,Company,Makeyear, RentPerKM,Sitting_Capacity,Cartype,Variant,Carnumber,CarStatus,Status};
                String tbData1[] = {"carmodel","company","makeyear","RentPerKM","sittingcapacity","cartype","variant","carnumber","CarStatus","Status"};


                DefaultTableModel tb1mode1 = (DefaultTableModel)Cars_List.getModel();
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
        new View_Cars();
    }
}
