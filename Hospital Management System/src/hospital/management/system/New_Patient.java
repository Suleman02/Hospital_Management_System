package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;

    JRadioButton r1, r2;

    Choice c1;

    JLabel date;

    JButton b1, b2;



    New_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel lableName = new JLabel("New Patient Form");
        lableName.setBounds(118,11,260,53);
        lableName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(lableName);

        JLabel lableID = new JLabel("ID");
        lableID.setBounds(35,76,200,14);
        lableID.setFont(new Font("Tahoma",Font.BOLD,14));
        lableID.setForeground(Color.WHITE);
        panel.add(lableID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter ID","Driving Licence"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel lableNumber = new JLabel("Number :");
        lableNumber.setBounds(35,111,200,14);
        lableNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        lableNumber.setForeground(Color.WHITE);
        panel.add(lableNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel lableName1 = new JLabel("Name :");
        lableName1.setBounds(35,151,200,14);
        lableName1.setFont(new Font("Tahoma",Font.BOLD,14));
        lableName1.setForeground(Color.WHITE);
        panel.add(lableName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel lableGender = new JLabel("Gender :");
        lableGender.setBounds(35,191,200,14);
        lableGender.setFont(new Font("Tahoma",Font.BOLD,14));
        lableGender.setForeground(Color.WHITE);
        panel.add(lableGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel lableDisease = new JLabel("Disease :");
        lableDisease.setBounds(35,231,200,14);
        lableDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDisease.setForeground(Color.WHITE);
        panel.add(lableDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel lableRoom = new JLabel("Room :");
        lableRoom.setBounds(35,274,200,14);
        lableRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        lableRoom.setForeground(Color.WHITE);
        panel.add(lableRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        JLabel lableDate = new JLabel("Time :");
        lableDate.setBounds(35,316,200,14);
        lableDate.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDate.setForeground(Color.WHITE);
        panel.add(lableDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel lableDeposite = new JLabel("Deposite :");
        lableDeposite.setBounds(35,359,200,17);
        lableDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        lableDeposite.setForeground(Color.WHITE);
        panel.add(lableDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);




        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()){
                radioBTN = "male";
            }else if (r2.isSelected()){
                radioBTN = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                String q = "insert info Patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no = " +s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
}
