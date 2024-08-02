import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerApp implements ActionListener {
    JFrame jf;
    JButton submit, display;
    JLabel jl1, jl2, jl3, jl4;
    JTextField jt1, jt2, jt3, jt4;
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    CustomerApp() {
        jf = new JFrame("Customer Form");
        jl1 = new JLabel("Enter CustNo"); jt1 = new JTextField(20);
        jl2 = new JLabel("Enter CustName"); jt2 = new JTextField(20);
        jl3 = new JLabel("Enter State"); jt3 = new JTextField(20);
        jl4 = new JLabel("Enter Credit Limit"); jt4 = new JTextField(20);
        submit = new JButton("Submit");
        display = new JButton("Display");
        jf.add(jl1); jf.add(jt1);
        jf.add(jl2); jf.add(jt2);
        jf.add(jl3); jf.add(jt3);
        jf.add(jl4); jf.add(jt4);
        jf.add(submit); submit.addActionListener(this);
        jf.add(display); display.addActionListener(this);
        jf.setVisible(true);
        jf.setSize(300, 300);
        jf.setLayout(new GridLayout(5, 2));

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SalesDB","root", "Akashise@15");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public void actionPerformed(ActionEvent ae) {
    //     if (ae.getSource() == submit) {
    //         try {
    //             int custNo = Integer.parseInt(jt1.getText());
    //             String custName = jt2.getText();
    //             String state = jt3.getText();
    //             double creditLimit = Double.parseDouble(jt4.getText());

    //             String query = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
    //             st = con.prepareStatement(query);
    //             st.setInt(1, custNo);
    //             st.setString(2, custName);
    //             st.setString(3, state);
    //             st.setDouble(4, creditLimit);
    //             st.executeUpdate();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     } else if (ae.getSource() == display) {
    //         try {
    //             String query = "SELECT * FROM Customer";
    //             st = con.prepareStatement(query);
    //             rs = st.executeQuery();
    //             JFrame displayFrame = new JFrame("Customer Data");
    //             displayFrame.setLayout(new GridLayout(0, 4));

    //             displayFrame.add(new JLabel("CustNo"));
    //             displayFrame.add(new JLabel("CustName"));
    //             displayFrame.add(new JLabel("State"));
    //             displayFrame.add(new JLabel("Credit Limit"));

    //             while (rs.next()) {
    //                 displayFrame.add(new JLabel(String.valueOf(rs.getInt("CustNo"))));
    //                 displayFrame.add(new JLabel(rs.getString("CustName")));
    //                 displayFrame.add(new JLabel(rs.getString("State")));
    //                 displayFrame.add(new JLabel(String.valueOf(rs.getDouble("Credit_Limit"))));
    //             }

    //             displayFrame.setSize(400, 400);
    //             displayFrame.setVisible(true);
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    public static void main(String[] args) {
        new CustomerApp();
    }
}

// -- Create the database
// CREATE DATABASE IF NOT EXISTS SalesDB;

// -- Use the database
// USE SalesDB;

// -- Create the Customer table
// CREATE TABLE Customer (
//     CustNo INT PRIMARY KEY,
//     CustName VARCHAR(50),
//     State VARCHAR(50),
//     Credit_Limit DECIMAL(10, 2)
// );
