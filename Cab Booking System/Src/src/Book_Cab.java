import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.Statement;


    public class Book_Cab extends JFrame {

        JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,Heading,bg,lbl12,lbl11;
        JTextField tf_Pickup,tf_time, tf_Mobile,tf_Name,tf_carNumber,tf_rent,tf_Totalrent,tf_Distance;
        JButton btn_Confirm,btn_Back;
        JTable table;
        JScrollPane sp;
        JPanel p1,p2;
        JDateChooser tf_date;
        JComboBox cmb_Drop;

        String st_Drop[] = {"Ahemdabad","Ajmer","Aurangabad","Bhavnagar","Bhopal","Gwalior","Ratlam","Jabalpur","Jaipur","Jodhpur","Kota","Mumbai","Nagpur","Omkareshwar","Pune","Rajkot","Surat","Thane","Udaipur","Ujjain","Vadodra"};

        Book_Cab(){

            p2 = new JPanel();

            Heading = new JLabel("Cab Booking System");
            Heading.setBounds(350,-40,400,200);
            Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

            lbl1 = new JLabel("Pickup Point");
            lbl1.setBounds(30,100,100,30);
            tf_Pickup = new JTextField("Indore");
            tf_Pickup.setBounds(120,100,120,30);
            tf_Pickup.setEditable(false);


            lbl2 = new JLabel("Drop Point");
            lbl2.setBounds(30,150,100,30);
            cmb_Drop = new JComboBox(st_Drop);
            cmb_Drop.setBounds(120,150,120,30);


            lbl3 = new JLabel("Time");
            lbl3.setBounds(270,100,100,30);
            tf_time = new JTextField();
            tf_time.setBounds(320,100,120,30);


            lbl4 = new JLabel("Date");
            lbl4.setBounds(270,150,100,30);
            tf_date = new JDateChooser();
            tf_date.setBounds(320,150,120,30);

            lbl5 = new JLabel("Available Cars");
            lbl5.setBounds(30,280,100,30);

            btn_Confirm = new JButton("Confirm Booking");
            btn_Confirm.setBounds(150,700,150,50);
            btn_Back = new JButton("Back");
            btn_Back.setBounds(500,700,150,50);

            lbl6 = new JLabel("Mobile Number");
            lbl6.setBounds(220,200,100,30);
            tf_Mobile = new JTextField();
            tf_Mobile.setBounds(320,200,120,30);

            lbl7 = new JLabel("Name");
            lbl7.setBounds(30,200,100,30);
            tf_Name = new JTextField();
            tf_Name.setBounds(80,200,130,30);

            lbl8 = new JLabel("Car Number");
            lbl8.setBounds(460,100,100,30);
            tf_carNumber = new JTextField();
            tf_carNumber.setBounds(550,100,130,30);
            tf_carNumber.setEditable(false);

            lbl9 = new JLabel("Rent Per KM");
            lbl9.setBounds(460,150,100,30);
            tf_rent = new JTextField();
            tf_rent.setBounds(550,150,130,30);
            tf_rent.setEditable(false);

            lbl10 = new JLabel("Total Rent");
            lbl10.setBounds(460,200,100,30);
            tf_Totalrent = new JTextField();
            tf_Totalrent.setBounds(550,200,130,30);
            tf_Totalrent.setEditable(false);

            lbl11 = new JLabel("Distance From Pickup");
            lbl11.setBounds(700,100,140,30);
            tf_Distance = new JTextField();
            tf_Distance.setBounds(840,100,130,30);
            tf_Distance.setEditable(false);



            table = new JTable(0,11);
            table.setBounds(10,20,780,370);
            table.setBackground(Color.pink);

            p1 = new JPanel();
            p1.setBounds(150,260,800,400);
            p1.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Choose Cab", TitledBorder.CENTER, TitledBorder.TOP));


            sp = new JScrollPane(table);

            ImageIcon img = new ImageIcon("Icon\\Background4.jpg");
            bg = new JLabel("", img, JLabel.CENTER);
            bg.setBounds(0, 0, 1100, 1000);

            ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
            lbl12 = new JLabel("", img1, JLabel.CENTER);
            lbl12.setBounds(0, 0, 1100, 900);
            lbl12.setVisible(true);

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
                    String tbData1[] = {"carmodel","company","makeyear","RentPerKM","sittingcapacity","cartype","variant","carnumber","Status","CarStatus"};


                    DefaultTableModel tb1mode1 = (DefaultTableModel)table.getModel();
                    tb1mode1.setColumnIdentifiers(tbData1);
                    tb1mode1.addRow(tbData);
                }

            }catch (Exception ae){
                ae.printStackTrace();
                System.out.println("DataBase Error" + ae);
            }


            table.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    int selecteddata = table.getSelectedRow();
                    String Status = model.getValueAt(selecteddata,9).toString();
                    String CarStatus = model.getValueAt(selecteddata,8).toString();
                    if(Status.equals("Unbooked") && CarStatus.equals("Ready")) {
                        tf_carNumber.setText(model.getValueAt(selecteddata, 7).toString());
                        tf_rent.setText(model.getValueAt(selecteddata, 3).toString());

                        double Rent = Double.parseDouble(tf_rent.getText());
                        double Distance = Double.parseDouble(tf_Distance.getText());

                        double TotalRent = Rent * Distance;

                        tf_Totalrent.setText(String.valueOf(TotalRent));

                    }else{
                        JOptionPane.showMessageDialog(null,"Cab not Available","Error",JOptionPane.ERROR_MESSAGE);
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



            cmb_Drop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                        String Drop = cmb_Drop.getSelectedItem().toString();

                        try{
                            Connection conn;

                            Statement stmt;

                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking_system?", "root", "Krishnam1023!@#$");

                            stmt = conn.createStatement();

                            String str = "select DistanceFromPickupinKM from rent_per_km where DropPoint = '"+Drop+"'";

                            ResultSet rs = stmt.executeQuery(str);

                            while (rs.next()) {
                                String DropPoint = rs.getString("DistanceFromPickupinKM");

                                tf_Distance.setText(DropPoint);
                            }


                        }catch (Exception ae){
                            ae.printStackTrace();
                            System.out.println(ae);
                        }
                }
            });



            btn_Confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==btn_Confirm) {

                        if (tf_Name.getText().equals("") || tf_time.getText().equals("") || tf_date.getDate().equals("") || tf_Mobile.getText().equals("")) {
                            JOptionPane.showMessageDialog(null,"FIll all the required details" , "Alert" , JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            String Pickup_Point = tf_Pickup.getText();
                            String Drop_Point = cmb_Drop.getSelectedItem().toString();
                            String Customer_Name = tf_Name.getText();
                            String Time = tf_time.getText();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            String Date = df.format(tf_date.getDate());
                            int Customer_Number = Integer.parseInt(tf_Mobile.getText());
                            String Car_Number = tf_carNumber.getText();
                            String Status = "Booked";
                            String Carnumber = tf_carNumber.getText();
                            String TotalRent = tf_Totalrent.getText();



                            try {
                                Conn c1 = new Conn();

                                String str1 = "update cardetails set Status = '"+Status+"' where carnumber = '"+Carnumber+"'";
                                String str = "update cab_book set Customer_Name = '" + Customer_Name + "' , Pickup_Point = '" + Pickup_Point + "' , Drop_Point = '" + Drop_Point + "' , Customer_Number = '" + Customer_Number + "', Date = '" + Date + "', Time = '" + Time + "' , TotalRent = '" + TotalRent + "' where Car_Number = '" + Car_Number + "'";

                                c1.s.executeUpdate(str);
                                c1.s.executeUpdate(str1);

                                JOptionPane.showMessageDialog(null, "Car Booked Successfully", "Car Booked", JOptionPane.INFORMATION_MESSAGE);

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
                    if(e.getSource()==btn_Back){
                        dispose();
                    }
                }
            });



            add(Heading);
            add(p1);
            p1.add(sp);
            p1.add(table);
            add(lbl1);
            add(tf_Pickup);
            add(lbl2);
            add(lbl3);
            add(lbl4);
            add(cmb_Drop);
            add(tf_time);
            add(tf_date);
            add(lbl5);
            add(lbl6);
            add(tf_Mobile);
            add(lbl7);
            add(tf_Name);
            add(lbl8);
            add(lbl9);
            add(tf_carNumber);
            add(tf_rent);
            add(lbl10);
            add(tf_Totalrent);
            add(lbl11);
            add(tf_Distance);
            add(btn_Confirm);
            add(btn_Back);

            add(sp);

            add(bg);

            add(lbl12);
            p2.add(lbl12);


            setTitle("Book Cab");
            setSize(1000,1000);
            setLayout(null);
            p1.setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            p1.setVisible(true);
            getContentPane().setBackground(Color.WHITE);
        }
        public static void main(String[] args) {
            new Book_Cab();
        }
    }

