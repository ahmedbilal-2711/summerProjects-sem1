package javaCodes;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlPhA
 */
import java.awt.*;
import static java.awt.Color.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.SpringLayout.HEIGHT;
import static javax.swing.SpringLayout.WIDTH;

public class ProgressBarDemo {

	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0,100);
        JProgressBar bar1 = new JProgressBar(0,100);
        JProgressBar bar2 = new JProgressBar(0,100);
        JLabel happy=new JLabel("HAPPY");
        JLabel sad=new JLabel("SAD");
        JLabel angry=new JLabel("ANGRY");
        public static int ml=40;
        public static int bl=50;
        public static int ct=0;
	ProgressBarDemo(int fir,int sec,int thir) throws InterruptedException, IOException{

               /* JLabel label=new JLabel();
		ImageIcon image = new ImageIcon("C:\\Users\\AlPhA\\Desktop\\bg3.jpg");
                Image nimg=image.getImage();
                Image mimg=nimg.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH);
                image=new ImageIcon(nimg);
                label.setIcon(image);
                label.setVisible(true);
                frame.add(label);*/
                
    //               ImageIcon img = new ImageIcon(ImageIO.read(new File("welcome.png").getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill(happy,bar ,YELLOW,fir);
                fill(angry,bar1,CYAN,sec);
                fill(sad,bar2,ORANGE,thir);
	}
        public void fill(JLabel mood,JProgressBar ba,Color f,int lim) throws InterruptedException
        {
           // System.out.println(ml+" "+ct);
             ct=ct+1;
             frame.add(ba);
             frame.add(mood);
             ba.setBounds(250, bl, 420, 50);
             mood.setBounds(10, ml,100,100);
             mood.setFont(new Font("MV Boli",Font.BOLD,25));
             
             ba.setValue(0);
            ba.setFont(new Font("MV Boli",Font.BOLD,25));
            for(int i=0;i<=lim;i++)
            {
                Thread.sleep(30);
                ba.setString(i+"%");
                ba.setStringPainted(true);
                ba.setValue(i);
                ba.setForeground(f);
                ba.setBackground(Color.black);
                
            }
            if(ct>1){
                ml=ml+100;
            }else{
            ml=ml+80;}
            bl=bl+100;
        }
                }
	

