import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Cars extends JFrame {

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8,Heading,bg,lbl9;
    JComboBox cmb_sittingCapacity,cmb_type, cmb_variant;
    JTextField tf_carmodel, tf_company, tf_makeyear, tf_rent, tf_carnumber;
    JButton btn_add,btn_clear,btn_cancel;
    JPanel p1;

    String cm_sitting[] = {"2 Seater","4 Seater","5 Seater","7 Seater","10 Seater"};
    String cm_type[] = {"AC","Non-AC"};
    String cm_variant[] = {"Top Variant","Middle Variant","Low Varinat"};

    Add_Cars(){

        p1 = new JPanel();

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(250,10,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));

        lbl1 = new JLabel("Car Model");
        lbl1.setBounds(30,200,100,30);
        tf_carmodel = new JTextField();
        tf_carmodel.setBounds(100,200,100,30);


        lbl2 = new JLabel("Company");
        lbl2.setBounds(220,200,100,30);
        tf_company = new JTextField();
        tf_company.setBounds(290,200,100,30);



        lbl3 = new JLabel("Make Year");
        lbl3.setBounds(410,200,100,30);
        tf_makeyear = new JTextField();
        tf_makeyear.setBounds(490,200,100,30);



        lbl4 = new JLabel("Rent Per KM");
        lbl4.setBounds(600,200,100,30);
        tf_rent = new JTextField();
        tf_rent.setBounds(690,200,100,30);


        lbl5 = new JLabel("Sitting Capacity");
        lbl5.setBounds(30,250,100,30);
        cmb_sittingCapacity = new JComboBox(cm_sitting);
        cmb_sittingCapacity.setBounds(130,250,100,30);


        lbl6 = new JLabel("Type");
        lbl6.setBounds(250,250,100,30);
        cmb_type = new JComboBox(cm_type);
        cmb_type.setBounds(300,250,100,30);



        lbl7 = new JLabel("Variant");
        lbl7.setBounds(420,250,100,30);
        cmb_variant = new JComboBox(cm_variant);
        cmb_variant.setBounds(480,250,100,30);

        lbl8 = new JLabel("Car Number");
        lbl8.setBounds(620,250,100,30);
        tf_carnumber = new JTextField();
        tf_carnumber.setBounds(700,250,100,30);

        ImageIcon img = new ImageIcon("Icon\\Background2.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,900,1000);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl9 = new JLabel("",img1,JLabel.CENTER);
        lbl9.setBounds(0,0,900,900);
        lbl9.setVisible(true);




        btn_add = new JButton("Add");
        btn_add.setBounds(30,350,120,50);
        btn_add.setBorder(new LineBorder(Color.BLACK));
        btn_clear = new JButton("Clear");
        btn_clear.setBounds(190,350,120,50);
        btn_clear.setBorder(new LineBorder(Color.BLACK));
        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(350,350,120,50);
        btn_cancel.setBorder(new LineBorder(Color.BLACK));

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carmodel = tf_carmodel.getText();
                String company = tf_company.getText();
                String makeyear = tf_makeyear.getText();
                String RentPerKM = tf_rent.getText();
                String sittingcapacity = cmb_sittingCapacity.getSelectedItem().toString();
                String cartype = cmb_type.getSelectedItem().toString();
                String variant = cmb_variant.getSelectedItem().toString();
                String carnumber = tf_carnumber.getText();
                String CarStatus = "Not Ready";
                String Status = "Unbooked";

                try{
                    if(Add_Cars.this.tf_carmodel.getText().equals("") || Add_Cars.this.tf_makeyear.getText().equals("") || tf_rent.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Fill all the required details","Alert",JOptionPane.ERROR_MESSAGE);
                    } else {
                        Conn c1 = new Conn();
                        String q1 = "insert into cardetails values ('"+ carmodel +"' , '"+ company +"' , '"+ makeyear +"' , '"+ RentPerKM +"' , '"+ sittingcapacity +"' , '"+ cartype +"' , '"+ variant +"' , '"+carnumber+"' ,'"+CarStatus+"', '"+Status+"')";
                        c1.s.executeUpdate(q1);

                        JOptionPane.showMessageDialog(null,"Car Added Successfully");
                        new Add_Cars();
                        dispose();
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }


            }
        });

        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_clear){
                    tf_carmodel.setText("");
                    tf_company.setText("");
                    tf_makeyear.setText("");
                    tf_rent.setText("");
                    tf_carnumber.setText("");
                }
            }
        });


        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



        add(Heading);
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);
        add(lbl7);
        add(tf_carmodel);
        add(tf_company);
        add(tf_makeyear);
        add(tf_rent);
        add(cmb_sittingCapacity);
        add(cmb_type);
        add(cmb_variant);
        add(lbl8);
        add(tf_carnumber);
        add(btn_add);
        add(btn_clear);
        add(btn_cancel);

        add(bg);

        add(lbl9);
        p1.add(lbl9);


        setTitle("Add Cars");
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Add_Cars();
    }
}
