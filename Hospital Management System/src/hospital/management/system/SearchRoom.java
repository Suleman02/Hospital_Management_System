package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {


    Choice choice;
    JTable table;

    SearchRoom (){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setForeground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(23,162,150,20);
        RoomNo.setForeground(Color.WHITE);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(RoomNo);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type :");
        Bed.setBounds(550,162,150,20);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,20);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
