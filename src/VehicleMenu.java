import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleMenu extends JFrame {

    public VehicleMenu(){
        setSize(1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1000,900);
        mainPanel.setBackground(Color.blue);
        JLabel headingText=new JLabel("Vehicles Section");
        headingText.setFont(new Font("Arial",Font.BOLD,30));
        headingText.setSize(300,80);
        headingText.setLocation(380,50);
        JButton rentButton=new JButton("Rent/Leave");
        rentButton.setFont(new Font("Arial",Font.PLAIN,20));
        rentButton.setSize(200,50);
        rentButton.setLocation(390,150);
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRentDashBoard.main(new String[]{});
                dispose();
            }
        });
        JButton payRentButton=new JButton("Pay Rent");
        payRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRentPay.main(new String[]{});
                dispose();
            }
        });
        payRentButton.setFont(new Font("Arial",Font.PLAIN,20));
        payRentButton.setSize(200,50);
        payRentButton.setLocation(390,250);
        JButton back=new JButton("Go Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.main(new String[]{});
                dispose();
            }
        });
        back.setFont(new Font("Arial",Font.PLAIN,20));
        back.setSize(200,50);
        back.setLocation(390,350);


        mainPanel.add(rentButton);
        mainPanel.add(payRentButton);
        mainPanel.add(back);
        mainPanel.add(headingText);

        add(mainPanel);




    }

    public static void main(String[] args){
        new VehicleMenu().setVisible(true);
    }


}