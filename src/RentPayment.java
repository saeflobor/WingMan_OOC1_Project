import javax.swing.*;
import java.awt.*;

public class RentPayment extends JFrame {

    public RentPayment(){
        setBounds(100,100,1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        JLabel heading=new JLabel("Payment");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setSize(200,100);
        heading.setLocation(400,60);
        JLabel userName=new JLabel("User Name: ");
        userName.setFont(new Font("Arial",Font.PLAIN,15));
        userName.setSize(150, 50);
        userName.setLocation(300,160);
        JLabel password=new JLabel("Password: ");
        password.setFont(new Font("Arial",Font.PLAIN,15));
        password.setSize(150,50);
        password.setLocation(300,260);
        JLabel cardNo=new JLabel("Card Number: ");
        cardNo.setFont(new Font("Arial",Font.PLAIN,15));
        cardNo.setSize(150,50);
        cardNo.setLocation(300,360);
        JTextField userField=new JTextField();
        userField.setFont(new Font("Arial",Font.PLAIN,15));
        userField.setSize(150,50);
        userField.setLocation(450,160);
        JTextField passField=new JTextField();
        passField.setFont(new Font("Arial",Font.PLAIN,15));
        passField.setSize(150,50);
        passField.setLocation(450,260);
        JTextField cardField=new JTextField();
        cardField.setFont(new Font("Arial",Font.PLAIN,15));
        cardField.setSize(150,50);
        cardField.setLocation(450,360);
        JButton payButton=new JButton("Pay");
        payButton.setFont(new Font("Arial",Font.PLAIN,15));
        payButton.setSize(150,50);
        payButton.setLocation(400,460);
        mainPanel.add(heading);
        mainPanel.add(userName);
        mainPanel.add(password);
        mainPanel.add(cardNo);
        mainPanel.add(userField);
        mainPanel.add(passField);
        mainPanel.add(cardField);
        mainPanel.add(payButton);
        add(mainPanel);

    }
    public static void main(String[]args){
        new RentPayment().setVisible(true);
    }


}
