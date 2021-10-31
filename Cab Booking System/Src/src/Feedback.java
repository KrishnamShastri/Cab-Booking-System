import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Feedback extends JFrame {

    JLabel lbl1,lbl2,Heading,bg, lbl3;
    JTextField tf_Name;
    JTextArea tf_Feedback;
    JButton btn_submit,btn_Back;
    JPanel p1;

    Feedback(){
        p1 = new JPanel();

        Heading = new JLabel("Cab Booking System");
        Heading.setBounds(350,-50,400,200);
        Heading.setFont(new Font("Times New Roman",Font.BOLD,30));


        lbl1 = new JLabel("Enter your Name");
        lbl1.setBounds(30,140,100,30);
        tf_Name = new JTextField();
        tf_Name.setBounds(140,140,160,30);
        lbl2 = new JLabel("Give your Feedback");
        lbl2.setBounds(30,200,130,30);
        tf_Feedback = new JTextArea();
        tf_Feedback.setBounds(200,200,600,500);


        btn_submit = new JButton("Submit");
        btn_submit.setBounds(200,730,150,50);
        btn_Back = new JButton("Back");
        btn_Back.setBounds(650,730,150,50);

        ImageIcon img = new ImageIcon("Icon\\Background3.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1100,1100);

        ImageIcon img1 = new ImageIcon("Icon\\Background1.jpg");
        lbl3 = new JLabel("",img1,JLabel.CENTER);
        lbl3.setBounds(0,0,1100,1100);
        lbl3.setVisible(true);

        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btn_submit){
                    if(tf_Name.getText().equals("") || tf_Feedback.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Fill all the Fields","Alert",JOptionPane.ERROR_MESSAGE);
                    }else {
                        String Name = tf_Name.getText();
                        String Feedback = tf_Feedback.getText();

                        Conn C1 = new Conn();
                        try{
                            String q1 = "insert into feedback_detail values('" + Name + "' , '" + Feedback +"')";

                            C1.s.executeUpdate(q1);

                            JOptionPane.showMessageDialog(tf_Feedback,"FeedBack Submitted Successfully","Feedback",JOptionPane.INFORMATION_MESSAGE);

                        }catch (Exception ae){
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
        add(lbl1);
        add(tf_Name);
        add(lbl2);
        add(tf_Feedback);
        add(btn_submit);
        add(btn_Back);

        add(bg);
        add(lbl3);
        p1.add(lbl3);





        setTitle("Give your Feedback");
        setSize(1000,1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Feedback();
    }
}
