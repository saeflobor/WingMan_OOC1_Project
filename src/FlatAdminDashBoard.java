import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class FlatAdminDashBoard extends JFrame implements ActionListener,readWrite {


    private JLabel label1, label2, label3, label4,label5,label6;
    private JTextField textField1, textField2, textField3, textField4,textField5,textField6;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private List<Flat> flats= new ArrayList<>();

    public FlatAdminDashBoard() {


        getInformation();
        setLayout(null);
        setTitle("Flats Panel");
        setSize(1000, 900);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1000, 900);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String imagePath1 = "src//Flat.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);
        mainPanel.add(backgroundLabel1);
        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        midPanel.setBackground(Color.blue);
        midPanel.setSize(1000, 80);
        midPanel.setLocation(0, 220);
        JLabel text = new JLabel("Flats Panel");
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setForeground(Color.white);
        text.setSize(200, 20);
        text.setBounds(420, 25, 300, 20);
        //text.setLocation(450,230);
        text.setVisible(true);
        midPanel.add(text);


        label1 = new JLabel("Flat-ID: ");
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label2 = new JLabel("Number of Rooms");
        label2.setFont(new Font("Arial", Font.PLAIN, 25));
        label3 = new JLabel("Location: ");
        label3.setFont(new Font("Arial", Font.PLAIN, 25));
        label4 = new JLabel("Rent Per Month: ");
        label4.setFont(new Font("Arial", Font.PLAIN, 25));
        label5 = new JLabel("Rented By: ");
        label5.setFont(new Font("Arial", Font.PLAIN, 25));


        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5= new JTextField(20);



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

        panel.setSize(1000, 700);
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
            String[] flatInfo = new String[7];
            flatInfo[0] = textField1.getText();
            flatInfo[1] = textField2.getText();
            flatInfo[2] = textField3.getText();
            flatInfo[3] = textField4.getText();
            flatInfo[4]=textField5.getText();



            Flat f=new Flat(flatInfo[0],Integer.parseInt(flatInfo[1]),flatInfo[2],Integer.parseInt(flatInfo[3]),flatInfo[4],"Yes");

            if(textField5.getText().equals("None")){
                f.setAvailability("Yes");

            }else{
                f.setAvailability("No");
            }


            flats.add(f);
            JOptionPane.showMessageDialog(this, "Flat added successfully");
            printData();
            clearFields();
        } else if (e.getSource() == viewButton) {
            String[] columns = {"Flat-ID","Number of Rooms","Location","Rent Per Month","Rented By","Availabity"};
            Object[][] data = new Object[flats.size()][6];
            for (int i = 0; i < flats.size(); i++) {
                data[i][0] = flats.get(i).getFlatID();
                data[i][1] = flats.get(i).getNumberOfRooms();
                data[i][2] = flats.get(i).getLocation();
                data[i][3] = flats.get(i).getRentPerMonth();
                data[i][4]=flats.get(i).getClient();
                data[i][5]=flats.get(i).getAvailability();





            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Books");
            frame.add(scrollPane);
            frame.setSize(800, 600);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String flatID = JOptionPane.showInputDialog(this, "Enter Flat ID to edit:");

            for (Flat f:flats) {
                if (f.getFlatID().equals(flatID)) {
                    f.setFlatID(flatID);
                    f.setNumberOfRooms(Integer.parseInt(textField2.getText()));
                    f.setLocation(textField3.getText());
                    f.setRentPerMonth(Integer.parseInt(textField4.getText()));
                    f.setClient(textField5.getText());
                    if(textField5.getText().equals("None")){
                        f.setAvailability("YES");
                    }else{
                        f.setAvailability("NO");
                    }



                    printData();
                    JOptionPane.showMessageDialog(this, "Flat edited successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Flat not found");
        } else if (e.getSource() == deleteButton) {
            String flatID = JOptionPane.showInputDialog(this, "Enter Flat ID to delete:");
            for (int i = 0; i < flats.size(); i++) {
                if (flats.get(i).getFlatID().equals(flatID)) {
                    flats.remove(i);
                    JOptionPane.showMessageDialog(this, "Flat deleted successfully");
                    printData();
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Flat not found");
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
        new FlatAdminDashBoard();
    }

    public void getInformation() {

        try (BufferedReader br = new BufferedReader(new FileReader("src//Flats.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {


                Flat f;
                String[] information = line.split("!");


                f=new Flat(information[0],Integer.parseInt(information[1]),information[2],Integer.parseInt(information[3]),information[4],information[5]);






                flats.add(f);


            }


        } catch (IOException e) {
            System.out.println("Can not get flat information");
        }


    }

    public void printData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src//Flats.txt"));
            String line;
            for (Flat f:flats) {
                bw.write(f.getFlatID()+"!"+f.getNumberOfRooms()+"!"+f.getLocation()+"!"+f.getRentPerMonth()+"!"+f.getClient()+"!"+f.getAvailability());

                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {

            System.out.println("Unable to Write");

        }


    }






}