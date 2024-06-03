import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {

    public AdminLogin(){
        setSize(1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);

        JLabel heading=new JLabel("Admin Login");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setSize(200,80);
        heading.setLocation(430,50);
        JLabel userName=new JLabel("User Name");
        JLabel passWord=new JLabel("Password");
        JTextField userField=new JTextField();
        JPasswordField passField=new JPasswordField();
        JButton loginButton=new JButton("Login");
        userName.setFont(new Font("Arial",Font.PLAIN,20));
        userName.setSize(200,50);
        userName.setLocation(350,150);
        passWord.setFont(new Font("Arial",Font.PLAIN,20));
        passWord.setSize(200,50);
        passWord.setLocation(350,250);
        userField.setFont(new Font("Arial",Font.PLAIN,20));
        userField.setSize(200,50);
        userField.setLocation(550,150);
        passField.setFont(new Font("Arial",Font.PLAIN,20));
        passField.setSize(200,50);
        passField.setLocation(550,250);
        loginButton.setFont(new Font("Arial",Font.PLAIN,20));
        loginButton.setSize(200,50);
        loginButton.setLocation(450,350);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userField.getText().equals("") || passField.getText().equals("")){
                    JOptionPane.showMessageDialog(mainPanel,"Please fill up the inputs");
                }else{
                    if(userField.getText().equals("Admin") && passField.getText().equals("Admin")){
                        JOptionPane.showMessageDialog(mainPanel,"Log In Successful");
                        AdminMenu.main(new String[]{});
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(mainPanel,"Invalid username or password");
                    }
                }
            }
        });



        mainPanel.add(userName);
        mainPanel.add(passWord);
        mainPanel.add(userField);
        mainPanel.add(passField);
        mainPanel.add(heading);
        mainPanel.add(loginButton);
        add(mainPanel);






    }

    public static void main(String[]args){
        new AdminLogin().setVisible(true);
    }


}
