import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class FoodAdminDashBoard extends JFrame implements ActionListener,readWrite{


    private JLabel label1, label2, label3, label4;
    private JTextField textField1, textField2, textField3, textField4;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private List<Food> foods = new ArrayList<>();

    public FoodAdminDashBoard() {

        getInformation();
        setLayout(null);
        setTitle("Food Panel");
        setSize(1000, 900);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1000, 900);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String imagePath1 = "src//Burger.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);
        mainPanel.add(backgroundLabel1);
        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        midPanel.setBackground(Color.blue);
        midPanel.setSize(1000, 80);
        midPanel.setLocation(0, 220);
        JLabel text = new JLabel("Food Panel");
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setForeground(Color.white);
        text.setSize(200, 20);
        text.setBounds(420, 25, 300, 20);
        //text.setLocation(450,230);
        text.setVisible(true);
        midPanel.add(text);


        label1 = new JLabel("Item-No:");
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label2 = new JLabel("Item Name: ");
        label2.setFont(new Font("Arial", Font.PLAIN, 25));
        label3 = new JLabel("Price: ");
        label3.setFont(new Font("Arial", Font.PLAIN, 25));
        label4 = new JLabel("Quantity");
        label4.setFont(new Font("Arial", Font.PLAIN, 25));

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);


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

        panel.setSize(1000, 800);
        panel.setLocation(0, 300);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);

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
            String[] foodInfo = new String[7];
            foodInfo[0] = textField1.getText();
            foodInfo[1] = textField2.getText();
            foodInfo[2] = textField3.getText();
            foodInfo[3] = textField4.getText();

            Food f=new Food(Integer.parseInt(foodInfo[0]),foodInfo[1],Integer.parseInt(foodInfo[2]),Integer.parseInt(foodInfo[3]));


            foods.add(f);
            JOptionPane.showMessageDialog(this, "Food Item added successfully");
            printData();
            clearFields();
        } else if (e.getSource() == viewButton) {
            String[] columns = {"Item No", "Item Name", "Price", "Quantity"};
            Object[][] data = new Object[foods.size()][4];
            for (int i = 0; i < foods.size(); i++) {
                data[i][0] = foods.get(i).getItemNo();
                data[i][1] = foods.get(i).getItemName();
                data[i][2] = foods.get(i).getPrice();
                data[i][3] = foods.get(i).getQuantity();

            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Food Items");
            frame.add(scrollPane);
            frame.setSize(800, 600);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String foodID = JOptionPane.showInputDialog(this, "Enter Item No to edit:");

            for (Food f:foods) {
                if (f.getItemNo()==Integer.parseInt(foodID)) {
                    f.setItemNo(Integer.parseInt(foodID));
                    f.setItemName(textField2.getText());
                    f.setPrice(Integer.parseInt(textField3.getText()));
                    f.setQuantity(Integer.parseInt(textField4.getText()));
                    printData();
                    JOptionPane.showMessageDialog(this, "Item edited successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Item not found");
        } else if (e.getSource() == deleteButton) {
            String foodID = JOptionPane.showInputDialog(this, "Enter Item No to delete:");
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).getItemNo()==Integer.parseInt(foodID)) {
                    foods.remove(i);
                    JOptionPane.showMessageDialog(this, "Item deleted successfully");
                    printData();
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Item not found");
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
        new FoodAdminDashBoard();
    }

    public void getInformation() {

        try (BufferedReader br = new BufferedReader(new FileReader("src//Food.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {


                Food f;
                String[] information = line.split("!");

                f = new Food(Integer.parseInt(information[0]),information[1], Integer.parseInt(information[2]), Integer.parseInt(information[3]));
                foods.add(f);


            }


        } catch (IOException e) {
            System.out.println("Can not get food information");
        }


    }

    public void printData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src//Food.txt"));
            String line;
            for (Food f:foods) {
                bw.write(f.getItemNo()+"!"+f.getItemName()+"!"+f.getPrice()+"!"+f.getQuantity());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {

            System.out.println("Unable to Write");

        }


    }






}