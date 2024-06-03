import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentPay extends JFrame {

    List<Client>clients=new ArrayList<>();




    public VehicleRentPay(){
        getClientInformation();
        setBounds(0,0,1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        String imagePath1 = "src//Logo.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);



        JPasswordField passwordField = new JPasswordField(20);




        JLabel userName=new JLabel("UserName: ");
        userName.setFont(new Font("Arial",Font.PLAIN,20));
        userName.setSize(200,50);
        userName.setLocation(300,260);
        JLabel passWord =new JLabel("Password: ");
        passWord.setFont(new Font("Arial",Font.PLAIN,20));
        passWord.setSize(200,50);
        passWord.setLocation(300,300);
        JLabel cardNumber=new JLabel("Card No.");
        cardNumber.setFont(new Font("Arial",Font.PLAIN,20));
        cardNumber.setSize(200,50);
        cardNumber.setLocation(300,340);


        JTextField userField=new JTextField();
        userField.setFont(new Font("Arial",Font.PLAIN,20));
        userField.setSize(200,35);
        userField.setLocation(500,260);
        JTextField passField=new JTextField();
        passField.setFont(new Font("Arial",Font.PLAIN,20));
        passField.setSize(200,35);
        passField.setLocation(500,300);
        JTextField cardField=new JTextField();
        cardField.setFont(new Font("Arial",Font.PLAIN,20));
        cardField.setSize(200,35);
        cardField.setLocation(500,340);

        JButton payRent=new JButton("Pay Rent");
        payRent.setFont(new Font("Arial",Font.PLAIN,20));
        payRent.setSize(200,35);
        payRent.setLocation(430,380);



        payRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Client c:clients){
                    if(c.getUserName().equals(userField.getText())&&c.getPassWord().equals(passField.getText()) && c.getCardNumber().equals(cardField.getText())){
                        c.setVehiclePayemntPending(0);
                        break;

                    }
                }
                JOptionPane.showMessageDialog(mainPanel,"Paid Successfully");
                VehicleMenu.main(new String[]{});


                printData();
                dispose();
            }

        });













        mainPanel.add(backgroundLabel1);

        mainPanel.add(userName);
        mainPanel.add(passWord);
        mainPanel.add(cardNumber);

        mainPanel.add(userField);

        mainPanel.add(cardField);



        mainPanel.add(passField);

        mainPanel.add(payRent);
        add(mainPanel);
    }

    public static void main(String[]args){
        new VehicleRentPay().setVisible(true);
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

    public  void printData(){

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


    }





}