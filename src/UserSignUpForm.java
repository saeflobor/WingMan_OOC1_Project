import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserSignUpForm extends JFrame {




    public UserSignUpForm(){
        setBounds(0,0,1000,900);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        String imagePath1 = "src//Logo.jpg"; // Replace with your image path
        JLabel backgroundLabel1 = new JLabel(new ImageIcon(imagePath1));
        backgroundLabel1.setBounds(0, 0,1000,220);
        backgroundLabel1.setOpaque(true);


        JLabel userName,passWord,confirmPassWord,contactNumber,cardNumber,address,nationality,dob;
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confirmPasswordField = new JPasswordField(20);
        JTextField userField,dobField,contactField,cardField,addressField,nationalityField;



        userName=new JLabel("UserName: ");
        userName.setFont(new Font("Arial",Font.PLAIN,20));
        userName.setSize(200,50);
        userName.setLocation(300,260);
        dob=new JLabel("Date of Birth: ");
        dob.setFont(new Font("Arial",Font.PLAIN,20));
        dob.setSize(200,50);
        dob.setLocation(300,300);
        contactNumber=new JLabel("Contact: ");
        contactNumber.setFont(new Font("Arial",Font.PLAIN,20));
        contactNumber.setSize(200,50);
        contactNumber.setLocation(300,340);
        cardNumber=new JLabel("Card No: ");
        cardNumber.setFont(new Font("Arial",Font.PLAIN,20));
        cardNumber.setSize(200,50);
        cardNumber.setLocation(300,380);
        address=new JLabel("Address: ");
        address.setFont(new Font("Arial",Font.PLAIN,20));
        address.setSize(200,50);
        address.setLocation(300,420);
        nationality=new JLabel("Nationality: ");
        nationality.setFont(new Font("Arial",Font.PLAIN,20));
        nationality.setSize(200,50);
        nationality.setLocation(300,460);
        passWord=new JLabel("Password: ");
        passWord.setFont(new Font("Arial",Font.PLAIN,20));
        passWord.setSize(200,50);
        passWord.setLocation(300,500);
        confirmPassWord=new JLabel("Confirm Password: ");
        confirmPassWord.setFont(new Font("Arial",Font.PLAIN,20));
        confirmPassWord.setSize(200,50);
        confirmPassWord.setLocation(300,540);

        userField=new JTextField();
        userField.setFont(new Font("Arial",Font.PLAIN,20));
        userField.setSize(200,35);
        userField.setLocation(500,260);
        dobField=new JTextField();
        dobField.setFont(new Font("Arial",Font.PLAIN,20));
        dobField.setSize(200,35);
        dobField.setLocation(500,300);
        contactField=new JTextField();
        contactField.setFont(new Font("Arial",Font.PLAIN,20));
        contactField.setSize(200,35);
        contactField.setLocation(500,340);
        cardField=new JTextField();
        cardField.setFont(new Font("Arial",Font.PLAIN,20));
        cardField.setSize(200,35);
        cardField.setLocation(500,380);
        addressField=new JTextField();
        addressField.setFont(new Font("Arial",Font.PLAIN,20));
        addressField.setSize(200,35);
        addressField.setLocation(500,420);
        nationalityField=new JTextField();
        nationalityField.setFont(new Font("Arial",Font.PLAIN,20));
        nationalityField.setSize(200,35);
        nationalityField.setLocation(500,460);
        passwordField.setFont(new Font("Arial",Font.PLAIN,20));
        passwordField.setSize(200,35);
        passwordField.setLocation(500,500);
        confirmPasswordField.setFont(new Font("Arial",Font.PLAIN,20));
        confirmPasswordField.setSize(200,35);
        confirmPasswordField.setLocation(500,540);
        JButton submitButton=new JButton("Submit");
        submitButton.setForeground(Color.GRAY);
        submitButton.setFont(new Font("Arial",Font.PLAIN,20));
        submitButton.setSize(200,50);
        submitButton.setLocation(420,600);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (userField.getText().equals("") || dobField.getText().equals("") || contactField.getText().equals("") || cardField.getText().equals("") || nationalityField.getText().equals("") || addressField.getText().equals("") || passwordField.getText().equals("") || confirmPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill in the inputs properly");
                } else {


                    if (passwordField.getText().equals(confirmPasswordField.getText())) {


                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("src//Clients.txt", true));
                            String line;

                            bw.write(userField.getText() + "!" + passwordField.getText() + "!" + contactField.getText() + "!" + cardField.getText() + "!" + 0 + "!" + 0);
                            JOptionPane.showMessageDialog(mainPanel, "Sign Up successful");
                            bw.newLine();
                            bw.close();
                            StartingPage.main(new String[]{});
                            dispose();


                        } catch (IOException i) {

                            System.out.println("Unable to Write");

                        }
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Password does not Match");

                    }
                }
            }
        });










        mainPanel.add(backgroundLabel1);

        mainPanel.add(userName);
        mainPanel.add(dob);
        mainPanel.add(contactNumber);
        mainPanel.add(address);
        mainPanel.add(nationality);
        mainPanel.add(cardNumber);
        mainPanel.add(passWord);
        mainPanel.add(userField);
        mainPanel.add(dobField);
        mainPanel.add(cardField);
        mainPanel.add(contactField);
        mainPanel.add(addressField);
        mainPanel.add(nationalityField);
        mainPanel.add(passwordField);
        mainPanel.add(confirmPasswordField);
        mainPanel.add(confirmPassWord);
        mainPanel.add(submitButton);
        add(mainPanel);
    }

    public static void main(String[]args){
        new UserSignUpForm().setVisible(true);
    }





}
