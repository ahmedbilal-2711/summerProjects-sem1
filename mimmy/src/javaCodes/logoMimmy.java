import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logoMimmy {


    logoMimmy(){
        JFrame f = new JFrame();
        JLabel signIn = new JLabel("Press the icon to Sign in");
        JLabel signUp = new JLabel("Want to create new account ?");
        JButton signUpBtn = new JButton("Sign Up");
        f.getContentPane().setLayout(null);
        JLabel l1 = new JLabel();
        l1.setBackground(Color.decode("#E8B345"));
        l1.setSize(500,500);
        l1.setOpaque(true);
        JButton icon = new JButton(new ImageIcon("H:\\summerProjects-sem1\\mimmy\\src\\images\\Mimmy.png"));
        f.setLocationRelativeTo(null);
        signUpBtn.setBounds(310,422,80,20);
        signUpBtn.setBackground(Color.black);
        signUpBtn.setForeground(Color.white);
        signUp.setBounds(220,400,300,20);
        signIn.setBounds(90, 60, 300, 30);
        f.add(signUpBtn);
        f.add(signUp);
        f.add(signIn);
        f.add(l1);
        f.add(icon);
        f.setSize(500, 500);
        icon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        icon.setSize(300, 300);
        icon.setLocation(90, 90);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        icon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                f.dispose();
            }
        });
    }

    
    public static void main(String[] args) {
        logoMimmy n = new logoMimmy();   
    }
}
