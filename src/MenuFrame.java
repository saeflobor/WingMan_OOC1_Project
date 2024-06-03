import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    public MenuFrame(){



        setSize(1000,900);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) size.getWidth() - 1000, 0,1000,900);
        setBounds(0,0,1000,900);

        JPanel mainPanel=new JPanel(new GridLayout(3,1));




        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        panel1.setSize(1000,300);

        JButton button1 = new JButton("Flats");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlatMenu.main(new String[]{});
                dispose();
            }
        });
        button1.setBounds(430,150,100,60);
        String imagePath = "src//Flat.jpg"; // Replace with your image path
        JLabel backgroundLabel = new JLabel(new ImageIcon(imagePath));
        backgroundLabel.setBounds(0, 0,1000,300);
        backgroundLabel.setOpaque(true);
        panel1.add(backgroundLabel, 0);





        panel1.add(button1);







        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setSize(1000,300);
        JButton button2 = new JButton("Vehicles");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleMenu.main(new String[]{});
                dispose();
            }
        });
        button2.setBounds(430,150,100,60);
        String imagePath1 = "src//Car.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,300);
        backgroundLabel1.setOpaque(true);
        panel2.add(backgroundLabel1, 0);
        panel2.add(button2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setSize(1000,300);
        JButton button3 = new JButton("Food Section");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodOrderDashBoard.main(new String[]{});
                dispose();
            }
        });
        button3.setBounds(430,150,100,60);
        String imagePath2 = "src//Burger.jpg"; // Replace with your image path
        JLabel backgroundLabel2 = new JLabel(new ImageIcon(imagePath2));
        backgroundLabel2.setBounds(0, 0,1000,300);
        backgroundLabel2.setOpaque(true);
        panel3.add(backgroundLabel2, 0);
        panel3.add(button3);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        mainPanel.setVisible(true);
        add(mainPanel);




    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }




}
