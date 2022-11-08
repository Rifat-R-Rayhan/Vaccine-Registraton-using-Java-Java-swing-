package com.VR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeScreen {
    public JFrame frame;
    public JPanel homepanel;

    public static HomeScreen home = new HomeScreen();

    public static void main(String[] args) {
        home.frame = new JFrame();
        home.frame.setTitle("Vaccine Registration");
        home.frame.setSize(1650, 1080);
        home.frame.setLayout(null);
        home.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.homePanel();
        home.frame.setVisible(true);

    }

    public void homePanel() {
        this.homepanel = new JPanel();
        this.homepanel.setLayout(null);
        this.homepanel.setBounds(0, 0, 1650, 1080);
        this.homepanel.setBackground(Color.LIGHT_GRAY);

        ImageIcon img = new ImageIcon("G:\\Course of CSE\\Seventh Semester\\CSE 2291-Software Development II (Database Programming)\\IdeaProjects\\VRFontpage\\src");
        JLabel imglebel = new JLabel();
        imglebel.setBounds(0,0,1360,700);

        Image resize = img.getImage();
        Image resizeImg = resize.getScaledInstance(1360, 700, Image.SCALE_DEFAULT);
        img = new ImageIcon(resizeImg);
        imglebel.setIcon(img);

        this.homepanel.add(imglebel);

        JLabel msg = new JLabel();
        msg.setText("Take Vaccine");
        msg.setFont(new Font("Arial", Font.BOLD, 34));
        msg.setBounds(775, 30, 820, 580);
        msg.setForeground(Color.DARK_GRAY);

        imglebel.add(msg);

        JLabel msg2 = new JLabel();
        msg2.setText("Stay Safe");
        msg2.setFont(new Font("Arial", Font.BOLD, 34));
        msg2.setBounds(775, 75, 820, 580);
        msg2.setForeground(Color.DARK_GRAY);

        imglebel.add(msg2);

        home.frame.add(this.homepanel);

        JLabel identityLabel = new JLabel();
        identityLabel.setText("Rifat Hossen: 1448");
        identityLabel.setFont(new Font("Arial", Font.BOLD,24));
        identityLabel.setBounds(560,10, 300, 50);
        identityLabel.setForeground(Color.red);

       imglebel.add(identityLabel);


        JPanel regPanel = new JPanel();
        regPanel.setLayout(null);
        regPanel.setBounds(895, 560, 210, 50);
        regPanel.setBackground(Color.GREEN);

       imglebel.add(regPanel);

        JLabel regLabel = new JLabel();
        regLabel.setText("REG WITH BIRTH NO");
        regLabel.setFont(new Font("Arial", Font.BOLD,20));
        regLabel.setForeground(Color.white);
        regLabel.setBounds(2,4, 210, 50);

        regPanel.add(regLabel);

        regPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                regScreen obj2 = new regScreen();
                homepanel.setVisible(false);
                obj2.loadRegScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                regPanel.setBackground(Color.BLUE);
                regLabel.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regPanel.setBackground(Color.GREEN);
                regLabel.setForeground(Color.white);
            }
        });

        JPanel NIDregPanel = new JPanel();
        NIDregPanel.setLayout(null);
        NIDregPanel.setBounds(700, 560, 160, 50);
        NIDregPanel.setBackground(Color.GREEN);

        imglebel.add(NIDregPanel);

        JLabel INDregLabel = new JLabel();
        INDregLabel.setText("REG WITH NID");
        INDregLabel.setFont(new Font("Arial", Font.BOLD,20));
        INDregLabel.setForeground(Color.white);
        INDregLabel.setBounds(6,4, 150, 50);

        NIDregPanel.add(INDregLabel);

        NIDregPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NIDregScreen obj2 = new NIDregScreen();
                homepanel.setVisible(false);
                obj2.loadRegScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                NIDregPanel.setBackground(Color.BLUE);
                INDregLabel.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NIDregPanel.setBackground(Color.GREEN);
                INDregLabel.setForeground(Color.white);
            }
        });


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(1140, 560, 160, 50);
        infoPanel.setBackground(Color.GREEN);

        imglebel.add(infoPanel);

        JLabel infoLabel = new JLabel();
        infoLabel.setText("INFORMATION");
        infoLabel.setFont(new Font("Arial", Font.BOLD,20));
        infoLabel.setBounds(10,4, 150, 50);
        infoLabel.setForeground(Color.white);

        infoPanel.add(infoLabel);

        infoPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InfoScreen obj2 = new InfoScreen();
                homepanel.setVisible(false);
                obj2.loadRegScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                infoPanel.setBackground(Color.BLUE);
                infoLabel.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                infoPanel.setBackground(Color.GREEN);
                infoLabel.setForeground(Color.white);
            }
        });

    }
}