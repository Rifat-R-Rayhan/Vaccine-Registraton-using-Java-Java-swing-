package com.VR;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class NIDinformation {
    public JPanel NIDinfoPanel;
    JPanel panel;
    JTextField textField;
    JButton button;
    JTable table;
    JScrollPane scrollPane;

    public static void main(String[] args) {

    }

    public void infoRegScreen() {
        this.NIDinfoPanel = new JPanel();
        this.NIDinfoPanel.setLayout(null);
        this.NIDinfoPanel.setBounds(0, 0, 1650, 1080);
        this.NIDinfoPanel.setBackground(Color.LIGHT_GRAY);

        JPanel homepage = new JPanel();
        homepage.setLayout(null);
        homepage.setBounds(20, 10, 80, 40);
        homepage.setBackground(Color.DARK_GRAY);

        this.NIDinfoPanel.add(homepage);

        JLabel home = new JLabel();
        home.setText("HOME");
        home.setFont(new Font("Arial", Font.BOLD, 20));
        home.setBounds(10, 7, 60,30);
        home.setForeground(Color.white);

        homepage.add(home);

        homepage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InfoScreen obj3 = new InfoScreen();
                NIDinfoPanel.setVisible(false);
                obj3.loadRegScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                homepage.setBackground(Color.BLACK);
                home.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homepage.setBackground(Color.DARK_GRAY);
                home.setForeground(Color.white);
            }
        });

        JLabel text = new JLabel();
        text.setText("This is a NID_Holder_Information Table");
        text.setFont(new Font("Algerian", Font.BOLD,20));
        text.setBounds(460,15, 1650, 100);
        text.setForeground(Color.black);

        this.NIDinfoPanel.add(text);

        panel = new JPanel();
        panel.setBounds(0, 0, 1650, 1080);
        panel.setBackground(Color.white);
        panel.setLayout(null);

        JLabel label2 = new JLabel();
        label2.setText("Reg_No: ");
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setBounds(65,270,400,50);
        label2.setForeground(Color.BLACK);

        this.NIDinfoPanel.add(label2);

        textField = new JTextField();
        textField.setBounds(160, 280, 150, 20);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));



        button = new JButton();
        button.setText("Search");
        button.setBounds(140, 320, 100, 30);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id1 = textField.getText();
                String cmd;
                if (id1.equals("")) {
                    cmd = "SELECT * FROM nid_holder_information";
                } else {
                    cmd = "SELECT * FROM nid_holder_information WHERE `Reg_No`='" + id1 + "'";
                }
                ResultSet rz1 = GetData(cmd);
                table.setModel(DbUtils.resultSetToTableModel(rz1));
                scrollPane.setVisible(false);
                scrollPane.setVisible(true);
                panel.add(scrollPane);
            }
        });

        table = new JTable();
        ResultSet rz = GetData("SELECT * FROM nid_holder_information");
        table.setBounds(0, 0, 700, 400);
        table.setModel(DbUtils.resultSetToTableModel(rz));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 100, 800, 500);


        panel.add(textField);
        panel.add(button);
        panel.add(scrollPane);
        this.NIDinfoPanel.add(panel);
    }

    public ResultSet GetData(String Command) {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/vr", "root", "rifat");
            Statement st = connect.createStatement();
            rs = st.executeQuery(Command);

            HomeScreen obj1 = new HomeScreen();
            obj1.home.frame.add(this.NIDinfoPanel);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
