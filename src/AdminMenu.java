import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu extends JFrame {

    List<Client>clients=new ArrayList<>();




    public AdminMenu(){
        getClientInformation();
        setSize(1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1000,900);
        mainPanel.setBackground(Color.blue);
        JLabel headingText=new JLabel("Admin Panel");
        headingText.setFont(new Font("Arial",Font.BOLD,30));
        headingText.setSize(200,80);
        headingText.setLocation(400,50);
        JButton flatButton=new JButton("Flats Panel");
        flatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlatAdminDashBoard.main(new String[]{});
                dispose();
            }
        });
        flatButton.setFont(new Font("Arial",Font.PLAIN,20));
        flatButton.setSize(200,50);
        flatButton.setLocation(390,150);
        JButton vehicleButton=new JButton("Vehicles Panel");
        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleAdminDashBoard.main(new String[]{});
                dispose();
            }
        });
        vehicleButton.setFont(new Font("Arial",Font.PLAIN,20));
        vehicleButton.setSize(200,50);
        vehicleButton.setLocation(390,250);
        JButton foodButton=new JButton("Food Panel");
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodAdminDashBoard.main(new String[]{});
                dispose();
            }
        });
        foodButton.setFont(new Font("Arial",Font.PLAIN,20));
        foodButton.setSize(200,50);
        foodButton.setLocation(390,350);
        JButton clientButton=new JButton("View Client Information");
        clientButton.setFont(new Font("Arial",Font.BOLD,15));
        clientButton.setSize(200,50);
        clientButton.setLocation(390,450);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"UserName","Password","Contact","Card No.","Flat Rent Pending","Vehicle Rent Pending","Total Pending"};
                Object[][] data = new Object[clients.size()][7];
                for (int i = 0; i < clients.size(); i++) {
                    data[i][0] = clients.get(i).getUserName();
                    data[i][1] = clients.get(i).getPassWord();
                    data[i][2] = clients.get(i).getContact();
                    data[i][3] = clients.get(i).getCardNumber();
                    data[i][4]=clients.get(i).getFlatPaymentPending();
                    data[i][5]=clients.get(i).getVehiclePayemntPending();
                    data[i][6]=clients.get(i).getVehiclePayemntPending() + clients.get(i).getFlatPaymentPending();


                }
                JTable table = new JTable(data, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame frame = new JFrame("View Client Information");
                frame.add(scrollPane);
                frame.setSize(1000, 700);
                frame.setVisible(true);
            }
        });
        JButton exitButton=new JButton("Log Out");
        exitButton.setFont(new Font("Arial",Font.PLAIN,20));
        exitButton.setSize(200,50);
        exitButton.setLocation(390,550);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingPage.main(new String[]{});
                dispose();
            }
        });
        mainPanel.add(headingText);
        mainPanel.add(flatButton);
        mainPanel.add(vehicleButton);
        mainPanel.add(foodButton);
        mainPanel.add(clientButton);
        mainPanel.add(exitButton);
        add(mainPanel);




    }

    public static void main(String[] args){
        new AdminMenu().setVisible(true);
    }

    public void getClientInformation(){

        try(BufferedReader br=new BufferedReader(new FileReader("src//Clients.txt"))){

            String line;

            while ((line=br.readLine())!=null){


                Client c=new Client();
                String[] information=line.split("!");
                c.setUserName(information[0]);
                c.setPassWord(information[1]);
                c.setContact(information[2]);
                c.setCardNumber(information[3]);
                c.setFlatPaymentPending(Integer.parseInt(information[4]));
                c.setVehiclePayemntPending(Integer.parseInt(information[5]));
                clients.add(c);


            }



        }catch (IOException e){
            System.out.println("Can not get flat information");
        }


    }




}
