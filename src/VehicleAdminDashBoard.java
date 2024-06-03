import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;z


public class VehicleAdminDashBoard extends JFrame implements ActionListener,readWrite{


    private JLabel label1, label2, label3, label4,label5,label6;
    private JTextField textField1, textField2, textField3, textField4,textField5,textField6;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private List<Vehicle> vehciles = new ArrayList<>();

    public VehicleAdminDashBoard() {

        getInformation();
        setLayout(null);
        setTitle("Vehicles Panel");
        setSize(1000, 900);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1000, 900);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String imagePath1 = "src//Car.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);
        mainPanel.add(backgroundLabel1);
        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        midPanel.setBackground(Color.blue);
        midPanel.setSize(1000, 80);
        midPanel.setLocation(0, 220);
        JLabel text = new JLabel("Vehicle Panel");
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setForeground(Color.white);
        text.setSize(200, 20);
        text.setBounds(420, 25, 300, 20);
        //text.setLocation(450,230);
        text.setVisible(true);
        midPanel.add(text);


        label1 = new JLabel("Car-ID: ");
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label2 = new JLabel("Brand");
        label2.setFont(new Font("Arial", Font.PLAIN, 25));
        label3 = new JLabel("Model: ");
        label3.setFont(new Font("Arial", Font.PLAIN, 25));
        label4 = new JLabel("Engine Cc: ");
        label4.setFont(new Font("Arial", Font.PLAIN, 25));
        label5 = new JLabel("Rent Per Month:");
        label5.setFont(new Font("Arial", Font.PLAIN, 25));
        label6 = new JLabel("Rented By");
        label6.setFont(new Font("Arial", Font.PLAIN, 25));

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5= new JTextField(20);
        textField6 = new JTextField(20);


        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10, 2));

        panel.setSize(1000, 620);
        panel.setLocation(0, 300);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        mainPanel.add(panel);

        mainPanel.add(midPanel);
        add(mainPanel);
        mainPanel.setVisible(true);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String[] vehcileInfo = new String[7];
            vehcileInfo[0] = textField1.getText();
            vehcileInfo[1] = textField2.getText();
            vehcileInfo[2] = textField3.getText();
            vehcileInfo[3] = textField4.getText();
            vehcileInfo[4]=textField5.getText();
            vehcileInfo[5]=textField6.getText();




            Vehicle v=new Vehicle(vehcileInfo[0],vehcileInfo[1],vehcileInfo[2],Integer.parseInt(vehcileInfo[3]),Integer.parseInt(vehcileInfo[4]),vehcileInfo[5],"Yes");
            if(textField6.getText().equals("None")){
                v.setAvailability("Yes");
            }else{
                v.setAvailability("No");
            }


            vehciles.add(v);
            JOptionPane.showMessageDialog(this, "Vehicle added successfully");
            printData();
            clearFields();
        } else if (e.getSource() == viewButton) {
            String[] columns = {"Car-Id","Brand Name","Model","Engine Cc","Rent Per Day","Rented By","Availabity"};
            Object[][] data = new Object[vehciles.size()][7];
            for (int i = 0; i < vehciles.size(); i++) {
                data[i][0] = vehciles.get(i).getVehicleId();
                data[i][1] = vehciles.get(i).getBrandName();
                data[i][2] = vehciles.get(i).getBrandName();
                data[i][3] = vehciles.get(i).getEnginceCC();
                data[i][4]=vehciles.get(i).getRentPerDay();
                data[i][5]=vehciles.get(i).getClient();
                data[i][6]=vehciles.get(i).getAvailability();




            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Vehicles");
            frame.add(scrollPane);
            frame.setSize(800, 600);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String carID  = JOptionPane.showInputDialog(this, "Enter Car ID to edit:");

            for (Vehicle v:vehciles) {
                if (v.getVehicleId().equals(carID )) {
                    v.setVehicleId(carID );
                    v.setBrandName(textField2.getText());
                    v.setModel(textField3.getText());
                    v.setEnginceCC(Integer.parseInt(textField4.getText()));
                    v.setRentPerDay(Integer.parseInt(textField5.getText()));
                    v.setClient(textField6.getText());
                    if(textField6.getText().equals("None")){
                        v.setAvailability("Yes");
                    }else{
                        v.setAvailability("No");
                    }


                    printData();
                    JOptionPane.showMessageDialog(this, "Vehicle edited successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Vehicle not found");
        } else if (e.getSource() == deleteButton) {
            String cardID = JOptionPane.showInputDialog(this, "Enter Car-ID to delete:");
            for (int i = 0; i < vehciles.size(); i++) {
                if (vehciles.get(i).getVehicleId().equals(cardID)) {
                    vehciles.remove(i);
                    JOptionPane.showMessageDialog(this, "Vehicle deleted successfully");
                    printData();
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Vehicle not found");
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            AdminMenu.main(new String[]{});
            dispose();
        }
    }

    private void clearFields() {


        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");

    }

    public static void main(String[] args) {
        new VehicleAdminDashBoard();
    }

    public void getInformation() {

        try (BufferedReader br = new BufferedReader(new FileReader("src//Vehicles.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {


                Vehicle v;
                String[] information = line.split("!");

                v=new Vehicle(information[0],information[1],information[2],Integer.parseInt(information[3]),Integer.parseInt(information[4]),information[5],information[6]);



                vehciles.add(v);


            }


        } catch (IOException e) {
            System.out.println("Can not get vehicle information");
        }


    }

    public void printData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src//Vehicles.txt"));
            String line;
            for (Vehicle v:vehciles) {
                bw.write(v.getVehicleId()+"!"+v.getBrandName()+"!"+v.getModel()+"!"+v.getEnginceCC()+"!"+v.getRentPerDay()+"!"+v.getClient()+"!"+v.getAvailability());

                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {

            System.out.println("Unable to Write");

        }


    }






}