import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlatMenu extends JFrame {

    public FlatMenu(){
        setSize(1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1000,900);
        mainPanel.setBackground(Color.blue);
        JLabel headingText=new JLabel("Flats Section");
        headingText.setFont(new Font("Arial",Font.BOLD,30));
        headingText.setSize(200,80);
        headingText.setLocation(400,50);
        JButton rentButton=new JButton("Rent/Leave");
        rentButton.setFont(new Font("Arial",Font.PLAIN,20));
        rentButton.setSize(200,50);
        rentButton.setLocation(390,150);
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlatRentDashBoard.main(new String[]{});
                dispose();
            }
        });
        JButton payRentButton=new JButton("Pay Rent");

        payRentButton.setFont(new Font("Arial",Font.PLAIN,20));
        payRentButton.setSize(200,50);
        payRentButton.setLocation(390,250);

        payRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlatRentPay.main(new String[]{});
                dispose();
            }
        });
        JButton back=new JButton("Go Back");
        back.setFont(new Font("Arial",Font.PLAIN,20));
        back.setSize(200,50);
        back.setLocation(390,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.main(new String[]{});
                dispose();
            }
        });


        mainPanel.add(rentButton);
        mainPanel.add(payRentButton);
        mainPanel.add(back);
        mainPanel.add(headingText);

        add(mainPanel);




    }

    public static void main(String[] args){
        new FlatMenu().setVisible(true);
    }


}