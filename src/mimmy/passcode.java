import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
public class passcode {
    passcode(){
        JFrame f = new JFrame();
        f.getContentPane().setLayout(null);
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JPasswordField jp = new JPasswordField();   

        l2.setBounds(0,0,500,500);
        jp.setBounds(175, 210, 150, 25);
        b1.setBounds(0+175,210+30,50, 50);
        b2.setBounds(50+175,210+30,50, 50);
        b3.setBounds(100+175,210+30,50, 50);
        b4.setBounds(0+175,260+30,50, 50);
        b5.setBounds(50+175,260+30,50, 50);
        b6.setBounds(100+175,260+30,50, 50);
        b7.setBounds(0+175,310+30,50, 50);
        b8.setBounds(50+175,310+30,50, 50);
        b9.setBounds(100+175,310+30,50, 50);

        b1.setBackground(Color.red);
        b2.setBackground(Color.red);
        b3.setBackground(Color.red);
        b4.setBackground(Color.red);
        b5.setBackground(Color.red);
        b6.setBackground(Color.red);
        b7.setBackground(Color.red);
        b8.setBackground(Color.red);
        b9.setBackground(Color.red);

        l1.setBounds(150, 5, 200, 200);
        l1.setOpaque(true);
        l1.setIcon(new ImageIcon("images/lockrs.gif"));
        // f.setLocationRelativeTo(null);
        l2.setBackground(Color.pink);
        //l2.setBackground(Color.decode("#037A94"));

        f.add(l2);
        f.add(jp);
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"1");
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"2");
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"3");
            }
        });

        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"4");
            }
        });

        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"5");

            }
        });

        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"6");
            }
        });

        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"7");
            }
        });

        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"8");
            }
        });

        b9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jp.setText(jp.getText()+"9");
            }
        });
    }
}
