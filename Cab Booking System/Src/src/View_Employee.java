import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class View_Employee extends JFrame {
    JFrame frame;
    JTable Employee_List;
    JScrollPane sp;

    View_Employee(){
        frame = new JFrame();
        frame.setTitle("View Employees");
        frame.setFont(new Font("Arial",Font.BOLD,10));
        Employee_List = new JTable(0,10);
        Employee_List.setBounds(30,40,300,300);
        Employee_List.setFont(new Font("Arial",Font.BOLD,10));
        Employee_List.setBackground(Color.pink);
        sp = new JScrollPane(Employee_List);

        frame.add(sp);

        Connection conn;
        Statement ps;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

            ps = conn.createStatement();

            String q1 = "select * from employee_info";

            ResultSet rs = ps.executeQuery(q1);

            while (rs.next()){
                String Name = rs.getString("Name");
                String Age = rs.getString("Age");
                String MobileNumber = String.valueOf(rs.getInt("MobileNumber"));
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String Confirm_Password = rs.getString("ConfirmPassword");
                String State = rs.getString("State");
                String City = rs.getString("City");
                String Gender = rs.getString("Gender");
                String License_Number = rs.getString("LicenseNumber");

                String tbData[] = {Name, Age, MobileNumber, Email, Password,Confirm_Password,State,City,Gender,License_Number};
                String tbData1[] = {"Name","Age","MobileNumber","Email","Password","ConfirmPassword","State","City","Gender","LicenseNumber"};


                DefaultTableModel tb1mode1 = (DefaultTableModel) Employee_List.getModel();
                tb1mode1.setColumnIdentifiers(tbData1);
                tb1mode1.addRow(tbData);
            }

        }catch (Exception ae){
            ae.printStackTrace();
            System.out.println("DataBase Error" + ae);
        }
        setTitle("View Employees");
        frame.setSize(1000,1000);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new View_Employee();
    }
}
