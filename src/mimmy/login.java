
// An intro page is created with an icon which is to be clicked and then will proceed forward
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

public class login {

    login() {
        JFrame f = new JFrame();
        f.getContentPane().setLayout(null);
        JLabel l1 = new JLabel();
        l1.setBackground(Color.decode("#037A94"));
        l1.setSize(500, 500);
        l1.setOpaque(true);
        JButton icon = new JButton(new ImageIcon("images/Mimmys.png"));
        // f.setLocationRelativeTo(null);
        f.add(l1);
        f.add(icon);
        f.setSize(500, 500);
        icon.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        icon.setSize(200, 200);
        icon.setLocation(140, 140);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                f.dispose();
                passcode p = new passcode();
                p.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        login n = new login();
    }
}
