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

public class Moodbars {

	JFrame frame = new JFrame();
        JPanel panel=new JPanel();
	JProgressBar bar = new JProgressBar(0,100);
        JProgressBar bar1 = new JProgressBar(0,100);
        JProgressBar bar2 = new JProgressBar(0,100);
        JLabel happy=new JLabel("HAPPY");
        JLabel sad=new JLabel("SAD");
        JLabel angry=new JLabel("ANGRY");
        public static int ml=120;
        public static int bl=130;
        public static int ct=0;
           JLabel bg;
	Moodbars(double fir,double sec,double thir) throws InterruptedException, IOException{

    	
           
              ImageIcon imgh=new ImageIcon("C:\\Users\\AlPhA\\Desktop\\sg.jpg");
              bg=new JLabel("",imgh,JLabel.CENTER);
              bg.setBounds(0, 0, 700, 500);
               frame.add(bg);   
    
            JLabel label=new JLabel("YOUR MONTHLY RATIO");
               label.setFont(new Font("MV Boli",Font.BOLD,30));
               label.setBounds(150,10,420,70);
		label.setForeground(Color.MAGENTA);
                bg.add(label);
    
                
               
                frame.setLayout(null); 
              
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBackground(Color.MAGENTA);
		frame.setSize(700, 500);
		
		frame.setVisible(true);
                
		
		fill(happy,bar ,YELLOW,fir);
                fill(angry,bar1,CYAN,sec);
                fill(sad,bar2,ORANGE,thir);
	}
        public void fill(JLabel mood,JProgressBar ba,Color f,double lim) throws InterruptedException
        {
           // System.out.println(ml+" "+ct);
             ct=ct+1;
            bg.add(ba);
            bg.add(mood);
             ba.setBounds(250, bl, 420, 50);
             mood.setBounds(10, ml,100,100);
             mood.setFont(new Font("MV Boli",Font.BOLD,25));
             mood.setForeground(Color.CYAN);
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
	

