package com.VR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InfoScreen {
    //public JFrame infoFrame;
    public JPanel mainRegPanel;

    //public static InfoScreen info = new InfoScreen();

    public static void main(String[] args) {
        /*info.infoFrame = new JFrame();
        info.infoFrame.setTitle("Vaccine Registration");
        info.infoFrame.setSize(1650, 1080);
        info.infoFrame.setLayout(null);
        info.infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        info.loadRegScreen();
        info.infoFrame.setVisible(true);*/

    }

    public void loadRegScreen(){
        this.mainRegPanel = new JPanel();
        this.mainRegPanel.setLayout(null);
        this.mainRegPanel.setBounds(0,0,1650,1080);
        this.mainRegPanel.setBackground(Color.LIGHT_GRAY);

        JPanel homepage = new JPanel();
        homepage.setLayout(null);
        homepage.setBounds(20, 10, 80, 40);
        homepage.setBackground(Color.DARK_GRAY);

        this.mainRegPanel.add(homepage);

        JLabel home = new JLabel();
        home.setText("HOME");
        home.setFont(new Font("Arial", Font.BOLD, 20));
        home.setBounds(10, 7, 60,30);
        home.setForeground(Color.white);

        homepage.add(home);

        homepage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HomeScreen obj3 = new HomeScreen();
                mainRegPanel.setVisible(false);
                obj3.homePanel();
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
        text.setText("Log In To See Your Information");
        text.setFont(new Font("Algerian", Font.BOLD,20));
        text.setBounds(500,30, 1650, 100);

        this.mainRegPanel.add(text);

        JPanel regForm = new JPanel();
        regForm.setLayout(null);
        regForm.setBounds(380, 160, 600, 400);
        regForm.setBackground(Color.DARK_GRAY);

        this.mainRegPanel.add(regForm);

        JLabel label1 = new JLabel();
        label1.setText("Log In Form");
        label1.setFont(new Font("Arial",Font.BOLD,24));
        label1.setBounds(240,25,300,50);
        label1.setForeground(Color.LIGHT_GRAY);

        regForm.add(label1);

        JLabel label4 = new JLabel();
        label4.setText("LogIn With: ");
        label4.setFont(new Font("Arial",Font.BOLD,18));
        label4.setBounds(80,100,400,30);
        label4.setForeground(Color.white);

        regForm.add(label4);

        String[] options = {"","NID Number (Reg No)", "Birth Registration Number (Reg No)"};

        JComboBox regOP = new JComboBox(options);
        regOP.setBounds(205,100,275,30);

        regForm.add(regOP);

        JLabel label2 = new JLabel();
        label2.setText("NAME: ");
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setBounds(80,160,400,50);
        label2.setForeground(Color.white);

        regForm.add(label2);

        JTextField name = new JTextField();
        name.setBounds(125,10,400,30);
        name.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        name.setFont(new Font("Times New Roman",Font.PLAIN,18));
        name.setBackground(Color.DARK_GRAY);
        name.setForeground(Color.white);

        label2.add(name);

        JLabel label3 = new JLabel();
        label3.setText("Reg No: ");
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setBounds(80,240,400,50);
        label3.setForeground(Color.white);

        regForm.add(label3);

        JTextField nid = new JTextField();
        nid.setBounds(125,10,400,30);
        nid.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        nid.setFont(new Font("Times New Roman",Font.PLAIN,18));
        nid.setBackground(Color.DARK_GRAY);
        nid.setForeground(Color.white);

        label3.add(nid);

        JButton btn = new JButton("LogIn");
        btn.setBounds(420,320,150,40);
        btn.setBackground(Color.magenta);
        btn.setForeground(Color.white);
        btn.setFocusable(false);
        btn.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.WHITE));

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.BLACK);
                btn.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.magenta);
                btn.setForeground(Color.white);
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String user = name.getText();
                    String dob = nid.getText();
                    String NIDreg = regOP.getSelectedItem().toString();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/vr","root","rifat");
                    Statement st = connect.createStatement();
                    ResultSet rs;

                    if(NIDreg.equals("NID Number (Reg No)")){
                        rs = st.executeQuery("SELECT * FROM nid_holder_information WHERE Reg_No = '"+dob+"'");
                    }
                    else {
                        rs = st.executeQuery("SELECT * FROM brn_holder_information WHERE Reg_No = '"+dob+"'");
                    }

                    int count = 0;

                    if(user.equals("") || dob.equals("") || NIDreg.equals("")){
                        JOptionPane.showMessageDialog(null, "Option Blank!");
                        count = 1;

                    }
                    else{

                        while(rs.next()){
                            String userName = rs.getString("Name");
                            String regNo = rs.getString("Reg_No");
                            if(userName.equals(user)) {
                                if(regNo.equals(dob)){
                                   if(NIDreg.equals("NID Number (Reg No)")){
                                       NIDinformation obj = new NIDinformation();
                                       mainRegPanel.setVisible(false);
                                       obj.infoRegScreen();
                                   }
                                   else{
                                       BRNinformation object = new BRNinformation();
                                       mainRegPanel.setVisible(false);
                                       object.BRNRegScreen();
                                   }
                                   count = 1;
                                   break;
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Wrong registration number.");
                                    count = 1;
                                    break;
                                }

                            }


                        }

                    }
                    if(count==0){
                        JOptionPane.showMessageDialog(null, "User not found.");
                    }
                }

                catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        regForm.add(btn);





        HomeScreen obj1 = new HomeScreen();
        obj1.home.frame.add(this.mainRegPanel);
    }
}
