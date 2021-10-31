import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Choose_Car extends JFrame {

    JPanel p1,p2;
    JTable t1;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,Heading,bg,lbl6;
    JTextField tf_carnumber,tf_Name,tf_carname,tf_Mobile,tf_rent;
    JButton btn_choose,btn_cancel;
    JScrollPane sp;

    Choose_Car(){

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(450,-80,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));


        p1 = new JPanel();
        p1.setBounds(150,100,150,140);
        p1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Choose Car", TitledBorder.CENTER, TitledBorder.TOP));
        p1.setBackground(Color.WHITE);

        t1 = new JTable(0,9);
        t1.setBounds(5,15,890,530);
        t1.setBackground(Color.cyan);

        lbl1 = new JLabel("Car Number");
        lbl1.setBounds(30,50,100,30);

        tf_carnumber = new JTextField();
        tf_carnumber.setBounds(120,50,150,30);
        tf_carnumber.setEditable(false);

        btn_choose = new JButton("Choose this Car");
        btn_choose.setBounds(150,700,130,50);

        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(920,700,130,50);

        lbl2 = new JLabel("Name");
        lbl2.setBounds(290,50,100,30);
        tf_Name = new JTextField();
        tf_Name.setBounds(340,50,150,30);

        lbl3 = new JLabel("Car Name");
        lbl3.setBounds(500,50,100,30);
        tf_carname = new JTextField();
        tf_carname.setBounds(570,50,130,30);
        tf_carname.setEditable(false);

        lbl4 = new JLabel("Mobile Number");
        lbl4.setBounds(720,50,100,30);
        tf_Mobile = new JTextField();
        tf_Mobile.setBounds(820,50,130,30);

        lbl5 = new JLabel("Rent");
        lbl5.setBounds(970,50,100,30);
        tf_rent = new JTextField();
        tf_rent.setBounds(1020,50,130,30);
        tf_rent.setEditable(false);

        sp = new JScrollPane(t1);

        ImageIcon img = new ImageIcon("Icon\\Background6.jpg");
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(0, 0, 1300, 1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl6 = new JLabel("", img1, JLabel.CENTER);
        lbl6.setBounds(0, 0, 1300, 900);
        lbl6.setVisible(true);
        p2 = new JPanel();

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

                String tbData[] = {Carmodel,Company,Makeyear, RentPerKM,Sitting_Capacity,Cartype,Variant,Carnumber,CarStatus};
                String tbData1[] = {"carmodel","company","makeyear","RentPerKM","sittingcapacity","cartype","variant","carnumber","CarStatus"};


                DefaultTableModel tb1mode1 = (DefaultTableModel)t1.getModel();
                tb1mode1.setColumnIdentifiers(tbData1);
                tb1mode1.addRow(tbData);
            }

        }catch (Exception ae){
            ae.printStackTrace();
            System.out.println("DataBase Error" + ae);
        }

        t1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)t1.getModel();
                int selecteddata = t1.getSelectedRow();
                String CarStatus = model.getValueAt(selecteddata,8).toString();
                if(CarStatus.equals("Not Ready")) {
                    tf_carnumber.setText(model.getValueAt(selecteddata, 7).toString());
                    tf_carname.setText(model.getValueAt(selecteddata, 0).toString());
                    tf_rent.setText(model.getValueAt(selecteddata, 3).toString());
                }else{
                    JOptionPane.showMessageDialog(null,"Car Already Choosed by Driver","Alert",JOptionPane.ERROR_MESSAGE);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        btn_choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_choose) {

                    if (tf_Name.getText().equals("") || tf_Mobile.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the required Details", "Alert", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String Car_Number = tf_carnumber.getText();
                        String Driver_Name = tf_Name.getText();
                        String Car_Name = tf_carname.getText();
                        int Driver_Number = Integer.parseInt(tf_Mobile.getText());
                        double Rent = Double.parseDouble(tf_rent.getText());
                        String CarStatus = "Ready";
                        String Carnumber = tf_carnumber.getText();


                        try {
                            Conn c1 = new Conn();

                            String str = "insert into cab_book(Car_Number,Driver_Name,Car_Name,Driver_Number,RentPerKM) values('" + Car_Number + "' , '" + Driver_Name + "' , '" + Car_Name + "' , '" + Driver_Number + "' , '" + Rent + "')";
                            String str1 = "update cardetails set CarStatus = '"+CarStatus+"' where carnumber = '"+Carnumber+"'";
                            c1.s.executeUpdate(str);
                            c1.s.executeUpdate(str1);

                            JOptionPane.showMessageDialog(null, "Car Chosed Successfully", "Car Choose", JOptionPane.INFORMATION_MESSAGE);
                            dispose();

                        } catch (Exception ae) {
                            ae.printStackTrace();
                            System.out.println(ae);
                        }
                    }
                }
            }
        });

        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_cancel){
                    dispose();
                }
            }
        });


        add(Heading);
        add(p1);
        p1.add(sp);
        p1.add(t1);
        add(lbl1);
        add(tf_carnumber);
        add(lbl2);
        add(tf_Name);
        add(btn_choose);
        add(btn_cancel);
        add(lbl3);
        add(tf_carname);
        add(lbl4);
        add(tf_Mobile);
        add(lbl5);
        add(tf_rent);
        add(bg);

        add(lbl6);
        p2.add(lbl6);

        setTitle("Choose Car");
        setSize(1300,1000);
        p1.setSize(900,550);
        setLayout(null);
        p1.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        p1.setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Choose_Car();
    }
}
