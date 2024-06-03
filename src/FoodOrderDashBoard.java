import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderDashBoard extends JFrame implements readWrite {

    List<Food>foods=new ArrayList<>();
    List<Client>clients=new ArrayList<>();
    static Object data[][];


    String[] columns = {"Item No","Item Name","Price","Quantity"};


    private JLabel label1, label2;
    private JTextField textField1, textField2;
    private JButton orderButton, leaveButton;


    public FoodOrderDashBoard(){



        getInformation();
        getClientInformation();
        System.out.println(clients.size());
        data = new Object[foods.size()][4];
        loadData();
        System.out.println(data[0][0]);






        setBounds(100,100,1000,900);
        setSize(1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);

        mainPanel.setBounds(0,0,1000,900);
        //Input Panel is used for taking inputs from users
        JPanel inputPanel=new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(0,220,1000,200);
        inputPanel.setBackground(Color.BLUE);

        JLabel heading=new JLabel("Your Favourite Meal is just one click away");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setSize(600,30);
        heading.setLocation(250,20);
        inputPanel.add(heading);

        String imagePath1 = "src//Logo.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);


        label1 = new JLabel("Item No: ");
        label1.setFont(new Font("Arial",Font.PLAIN,15));
        label1.setSize(100,20);
        label1.setLocation(300,60);
        label2 = new JLabel("Quantity: ");
        label2.setFont(new Font("Arial",Font.PLAIN,15));
        label2.setSize(200,20);
        label2.setLocation(300,90);
        textField1 = new JTextField(10);
        textField1.setFont(new Font("Arial",Font.PLAIN,15));
        textField1.setSize(200,20);
        textField1.setLocation(450,60);

        textField2 = new JTextField(20);
        textField2.setFont(new Font("Arial",Font.PLAIN,15));
        textField2.setSize(200,20);
        textField2.setLocation(450,90);

        orderButton= new JButton("Order");

        orderButton.setFont(new Font("Arial",Font.PLAIN,15));
        orderButton.setSize(100,20);
        orderButton.setLocation(500,120);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = textField1.getText();
                    int quantity = Integer.parseInt(textField2.getText());
                    confirmation(quantity, id);
                    dispose();
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(mainPanel,"Invalid Input");
                    textField2.setText("");
                    textField1.setText("");
                }





            }
        });



        inputPanel.add(label1);
        inputPanel.add(textField1);

        inputPanel.add(label2);
        inputPanel.add(textField2);

        inputPanel.add(orderButton);






        //Table part
        JPanel viewPanel=new JPanel();
        viewPanel.setLayout(null);
        viewPanel.setBounds(0,420,1000,480);
        //viewPanel.setBackground(Color.GRAY);
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(1000,700);


        viewPanel.add(scrollPane);
        mainPanel.add(inputPanel);
        mainPanel.add(viewPanel);
        mainPanel.add(backgroundLabel1);
        add(mainPanel);





    }

    public static void main(String[]args){
        new FoodOrderDashBoard().setVisible(true);


    }

    public void getInformation(){
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

    public void loadData(){
        for (int i = 0; i < foods.size(); i++) {
            data[i][0] = foods.get(i).getItemNo();
            data[i][1] = foods.get(i).getItemName();
            data[i][2] = foods.get(i).getPrice();
            data[i][3] = foods.get(i).getQuantity();





        }

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

    public void confirmation(int quantity,String id){

        String username;
        String password;
        String card;


        JFrame frame=new JFrame("Confirmation");
        frame.setLayout(new GridLayout(4, 2));




        JLabel userName=new JLabel("UserName");
        JLabel passWord=new JLabel("Password");
        JLabel cardNo=new JLabel("Enter Card No.");
        JLabel pseudo=new JLabel("");
        JTextField userField=new JTextField();
        JTextField passField=new JTextField();
        JTextField cardField=new JTextField();
        JButton comfirmButton=new JButton("Confirm");
        frame.add(userName);
        frame.add(userField);
        frame.add(passWord);
        frame.add(passField);
        frame.add(cardNo);
        frame.add(cardField);
        frame.add(pseudo);
        frame.add(comfirmButton);

        Flat f;




        comfirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String username,password,card;


                username=userField.getText();
                password=passField.getText();
                card=cardField.getText();




                int j=0;
                int l=0;

                int rent=0;
                for(int i=0;i<foods.size();i++){
                    if(foods.get(i).getItemNo()==Integer.parseInt(id)){

                        rent =foods.get(i).getPrice();
                        l=i;
                        break;

                    }
                }

                for(int i=0;i<clients.size();i++){

                    if(username.equals(clients.get(i).getUserName()) && password.equals(clients.get(i).getPassWord())&& clients.get(i).equals(clients.get(i).getCardNumber())){




                        j=i;
                        break;


                    }
                }





                if(quantity<=foods.get(l).getQuantity()){
                    foods.get(l).buyFood(quantity);

                }else {
                    JOptionPane.showMessageDialog(frame,"Amount exceeded");
                }



                printData();
                JOptionPane.showMessageDialog(frame,"Confimed");
                frame.dispose();
                FoodOrderDashBoard.main(new String[]{});

            }
        });



        frame.setVisible(true);

    }

    public void printData()
    {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("src//Clients.txt"));
            String line;
            for(Client c:clients){
                bw.write(c.getUserName()+"!"+c.getPassWord()+"!"+c.getContact()+"!"+c.getCardNumber()+"!"+c.getFlatPaymentPending()+"!"+c.getVehiclePayemntPending());
                bw.newLine();
            }
            bw.close();
        }catch(IOException e){

            System.out.println("Unable to Write");

        }
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

