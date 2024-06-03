import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingPage extends JFrame {
    public StartingPage(){
        setBounds(0,0,1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        String imagePath1 = "src//Logo.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);
        JPanel midPanel=new JPanel();
        midPanel.setSize(1000,80);
        midPanel.setBounds(0,220,1000,80);
        midPanel.setBackground(Color.BLUE);


        JPanel bottomPanel=new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setSize(1000,600);
        bottomPanel.setLocation(0,350);
        JButton adminLogin=new JButton("Admin Login");
        adminLogin.setBackground(Color.blue);
        adminLogin.setSize(200,100);
        adminLogin.setBounds(400,20,200,100);
        adminLogin.setFont(new Font("Arial",Font.BOLD,25));
        adminLogin.setForeground(Color.white);
        adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin.main(new String[]{});
                dispose();
            }
        });
        JButton userSignUp=new JButton("Sign Up");
        userSignUp.setBackground(Color.blue);
        userSignUp.setSize(200,100);
        userSignUp.setLocation(400,150);
        userSignUp.setFont(new Font("Arial",Font.BOLD,25));
        userSignUp.setForeground(Color.white);
        userSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserSignUpForm.main(new String[]{});
                dispose();
            }
        });
        bottomPanel.add(userSignUp);
        JButton exploreButton=new JButton("Explore");
        exploreButton.setBackground(Color.blue);
        exploreButton.setSize(200,100);
        exploreButton.setLocation(400,280);
        exploreButton.setFont(new Font("Arial",Font.BOLD,25));
        exploreButton.setForeground(Color.white);
        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.main(new String[]{});
                dispose();

            }
        });
        bottomPanel.add(exploreButton);

        bottomPanel.add(adminLogin);


        mainPanel.add(backgroundLabel1);
        mainPanel.add(bottomPanel);
        mainPanel.add(midPanel);
        add(mainPanel);
        setVisible(true);




    }

    public static void main(String[]args){
        new StartingPage();

    }
}
