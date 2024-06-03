import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentDashBoard extends JFrame implements readWrite {

    List<Vehicle>vehicles=new ArrayList<>();
    List<Client>clients=new ArrayList<>();
    static Object data[][];


    String[] columns = {"Car-ID","Brand Name","Model","EngineCc","Rent per Day","Rented By","Availability"};


    private JLabel label1, label2;
    private JTextField textField1, textField2;
    private JButton rentButton, leaveButton;


    public VehicleRentDashBoard(){



        getInformation();
        getClientInformation();
        System.out.println(clients.size());
        data = new Object[vehicles.size()][7];
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

        JLabel heading=new JLabel("Rent your Favourite Vehicles on a single Click");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setSize(600,30);
        heading.setLocation(250,20);
        inputPanel.add(heading);

        String imagePath1 = "src//Logo.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);


        label1 = new JLabel("Car-ID: ");
        label1.setFont(new Font("Arial",Font.PLAIN,15));
        label1.setSize(100,20);
        label1.setLocation(300,60);
        label2 = new JLabel("Number of Days: ");
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

        rentButton = new JButton("Rent Now");

        rentButton.setFont(new Font("Arial",Font.PLAIN,15));
        rentButton.setSize(100,20);
        rentButton.setLocation(300,120);

        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=textField1.getText();
                int months=Integer.parseInt(textField2.getText());

                for(Vehicle v:vehicles){
                    if(v.getVehicleId().equals(id) && v.getAvailability().equals("Yes")){
                        confirmation(months,id);
                        dispose();
                        break;

                    }
                }
                for(Vehicle v:vehicles){
                    if(v.getVehicleId().equals(id) && v.getAvailability().equals("No")){
                        JOptionPane.showMessageDialog(mainPanel,"Not available");
                        dispose();
                        VehicleRentDashBoard.main(new String[]{});
                        break;

                    }
                }















            }
        });
        leaveButton = new JButton("Leave");
        leaveButton.setFont(new Font("Arial",Font.PLAIN,15));
        leaveButton.setSize(100,20);
        leaveButton.setLocation(450,120);
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leave(textField1.getText());
                dispose();
                VehicleRentDashBoard.main(new String[]{});
            }
        });


        inputPanel.add(label1);
        inputPanel.add(textField1);

        inputPanel.add(label2);
        inputPanel.add(textField2);

        inputPanel.add(rentButton);
        inputPanel.add(leaveButton);





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
        new VehicleRentDashBoard().setVisible(true);


    }

    public void getInformation(){

        try(BufferedReader br=new BufferedReader(new FileReader("src//Vehicles.txt"))){

            String line;

            while ((line=br.readLine())!=null){


                Vehicle v;
                String[] information = line.split("!");

                v=new Vehicle(information[0],information[1],information[2],Integer.parseInt(information[3]),Integer.parseInt(information[4]),information[5],information[6]);
                vehicles.add(v);


            }




        }catch (IOException e){
            System.out.println("Can not get vehcile information");
        }


    }

    public void loadData(){
        for (int i = 0; i < vehicles.size(); i++) {
            data[i][0] = vehicles.get(i).getVehicleId();
            data[i][1] = vehicles.get(i).getBrandName();
            data[i][2] = vehicles.get(i).getBrandName();
            data[i][3] = vehicles.get(i).getEnginceCC();
            data[i][4]=vehicles.get(i).getRentPerDay();
            data[i][5]=vehicles.get(i).getClient();
            data[i][6]=vehicles.get(i).getAvailability();




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

    public void confirmation(int numberOfMonths,String id){

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
                for(int i=0;i<vehicles.size();i++){
                    if(vehicles.get(i).getVehicleId().equals(id)){

                        rent = vehicles.get(i).getRentPerDay();
                        l=i;
                        break;

                    }
                }

                for(int i=0;i<clients.size();i++){

                    if(username.equals(clients.get(i).getUserName()) && password.equals(clients.get(i).getPassWord())&& card.equals(clients.get(i).getCardNumber())){

                        j=i;
                        clients.get(j).calculateVehiclePayment(numberOfMonths, rent);
                        vehicles.get(l).setClient(username);
                        vehicles.get(l).setAvailability("No");
                        break;


                    }
                }



                System.out.println(clients.size());
                System.out.println(rent);
                System.out.println(username);
                System.out.println(password);
//                clients.get(j).calculateVehiclePayment(numberOfMonths, rent);
//                vehicles.get(l).setClient(username);
//                vehicles.get(l).setAvailability("No");
                System.out.println(vehicles.size());
                System.out.println(clients.get(j).getFlatPaymentPending());
                System.out.println(clients.get(j).getUserName());
                System.out.println(vehicles.get(0).getClient());


                printData();
                JOptionPane.showMessageDialog(frame,"Confimed");
                frame.dispose();
                VehicleRentDashBoard.main(new String[]{});

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
            BufferedWriter bw = new BufferedWriter(new FileWriter("src//Vehicles.txt"));
            String line;
            for (Vehicle v:vehicles) {
                bw.write(v.getVehicleId()+"!"+v.getBrandName()+"!"+v.getModel()+"!"+v.getEnginceCC()+"!"+v.getRentPerDay()+"!"+v.getClient()+"!"+v.getAvailability());

                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {

            System.out.println("Unable to Write");

        }

    }
    public void leave(String ID){
        JFrame frame=new JFrame("Confirmation");
        frame.setLayout(new GridLayout(3, 2));
        JLabel userName=new JLabel("UserName");
        JLabel passWord=new JLabel("Password");
        JLabel pseudo=new JLabel("");
        JTextField userField=new JTextField();
        JTextField passField=new JTextField();
        JButton comfirmButton=new JButton("Confirm");
        frame.add(userName);
        frame.add(userField);
        frame.add(passWord);
        frame.add(passField);
        frame.add(pseudo);
        frame.add(comfirmButton);
        frame.setVisible(true);

        comfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Vehicle v :vehicles){
                    if(v.getVehicleId().equals(ID)){
                        if(v.getClient().equals(userField.getText())){

                            v.setClient("None");
                            v.setAvailability("Yes");
                            JOptionPane.showMessageDialog(frame,"Successfully left the Vehicle");


                        }else{
                            JOptionPane.showMessageDialog(frame,"This Vehicle is rented by another person");
                            VehicleRentDashBoard.main(new String[]{});
                            dispose();

                        }
                    }
                }
                printData();

            }
        });








    }





}
