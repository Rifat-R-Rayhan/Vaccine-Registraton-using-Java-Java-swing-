package com.VR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NIDregScreen {
    public JPanel mainRegPanel;

    public static void main(String[] args) {

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
        text.setText("Welcome to The Registration page");
        text.setFont(new Font("Algerian", Font.BOLD,20));
        text.setBounds(480,5, 1650, 100);

        this.mainRegPanel.add(text);

        JPanel regForm = new JPanel();
        regForm.setLayout(null);
        regForm.setBounds(380, 80, 600, 600);
        regForm.setBackground(Color.DARK_GRAY);

        this.mainRegPanel.add(regForm);

        JLabel label1 = new JLabel();
        label1.setText("Registration Form");
        label1.setFont(new Font("Arial",Font.BOLD,24));
        label1.setBounds(200,15,300,50);
        label1.setForeground(Color.LIGHT_GRAY);

        regForm.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("NAME: ");
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setBounds(80,80,400,50);
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
        label3.setText("PHONE: ");
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setBounds(80,140,400,50);
        label3.setForeground(Color.white);

        regForm.add(label3);

        JTextField phone = new JTextField();
        phone.setBounds(125,10,400,30);
        phone.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        phone.setFont(new Font("Times New Roman",Font.PLAIN,18));
        phone.setBackground(Color.DARK_GRAY);
        phone.setForeground(Color.white);

        label3.add(phone);

        JLabel label4 = new JLabel();
        label4.setText("NID No: ");
        label4.setFont(new Font("Arial",Font.BOLD,18));
        label4.setBounds(80,200,400,50);
        label4.setForeground(Color.white);

        regForm.add(label4);

        JTextField nid = new JTextField();
        nid.setBounds(125,10,400,30);
        nid.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        nid.setFont(new Font("Times New Roman",Font.PLAIN,18));
        nid.setBackground(Color.DARK_GRAY);
        nid.setForeground(Color.white);

        label4.add(nid);

        JLabel label5 = new JLabel();
        label5.setText("DOB: ");
        label5.setFont(new Font("Arial",Font.BOLD,18));
        label5.setBounds(80,260,400,50);
        label5.setForeground(Color.white);

        regForm.add(label5);

        JTextField age = new JTextField();
        age.setBounds(125,10,400,30);
        age.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        age.setText("YYYY-MM-DD");
        age.setFont(new Font("Times New Roman",Font.PLAIN,18));
        age.setBackground(Color.DARK_GRAY);
        age.setForeground(Color.white);

        age.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(age.getText().equals("YYYY-MM-DD")){
                    age.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(age.getText().equals("")){
                    age.setText("YYYY-MM-DD");
                }
            }
        });

        label5.add(age);

        JLabel label6 = new JLabel();
        label6.setText("LOCATION: ");
        label6.setFont(new Font("Arial",Font.BOLD,18));
        label6.setBounds(80,320,400,50);
        label6.setForeground(Color.white);

        regForm.add(label6);

        JTextField location = new JTextField();
        location.setBounds(125,10,400,30);
        location.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        location.setFont(new Font("Times New Roman",Font.PLAIN,18));
        location.setBackground(Color.DARK_GRAY);
        location.setForeground(Color.white);

        label6.add(location);

        JLabel label7 = new JLabel();
        label7.setText("NATIONALITY: ");
        label7.setFont(new Font("Arial",Font.BOLD,18));
        label7.setBounds(80,380,400,50);
        label7.setForeground(Color.white);

        regForm.add(label7);

        JTextField nation = new JTextField();
        nation.setBounds(130,10,400,30);
        nation.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
        nation.setFont(new Font("Times New Roman",Font.PLAIN,18));
        nation.setBackground(Color.DARK_GRAY);
        nation.setForeground(Color.white);

        label7.add(nation);

        JLabel label8 = new JLabel();
        label8.setText("V.CENTER: ");
        label8.setFont(new Font("Arial",Font.BOLD,18));
        label8.setBounds(80,440,400,50);
        label8.setForeground(Color.white);

        regForm.add(label8);


        String[] options = {"","Kuwait Bangladesh Friendship Government Hospital","Kurmitola General Hospital","National Chest Infectious Diseases Hospital","Dhaka Medical College Hospital","Bangladesh Railway Hospital","Mohanagar General Hospital","Sheikh Russel Gastro Liver Institute & Hospital","Sajida Foundation Hospital","Mirpur Maternity Hospital","Jinjira Specialized Hospital","Amin Bazar Hospital","Kamrangirchar Hospital"};

        JComboBox vCenter = new JComboBox(options);
        vCenter.setBounds(205,450,275,30);

        regForm.add(vCenter);
        JButton btn = new JButton("Registration");
        btn.setBounds(420,520,150,40);
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
                String user = name.getText();
                String contact = phone.getText();
                String dob = nid.getText();
                String age1 = age.getText();
                String loc = location.getText();
                String nationality = nation.getText();
                String center = vCenter.getSelectedItem().toString();

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/vr","root","rifat");
                    Statement st = connect.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM nid_holder_information");

                    int count = 0;

                    if(user.equals("") || contact.equals("") || dob.equals("") || age1.equals("") || loc.equals("") || nationality.equals("") || center.equals("")){
                        JOptionPane.showMessageDialog(null, "Option Blank!");

                    }
                    else{

                        while(rs.next()){
                            String regNo = rs.getString("Reg_No");
                            if(regNo.equals(dob)){
                                JOptionPane.showMessageDialog(null, "Already Registered.");
                                count = 1;
                            }
                        }

                        if(count == 0){
                            String command = "INSERT INTO nid_holder_information(Name, Phone, Reg_No, DOB, Location, Nationality, Center, Reg_Date) VALUES('"+user+"','"+contact+"', '"+dob+"', '"+age1+"', '"+nationality+"', '"+loc+"','"+center+"', CURDATE())";
                            st.execute(command);

                            //System.out.println("Registration Complete.");
                            JOptionPane.showMessageDialog(null, "Registration Complete.");
                        }
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
