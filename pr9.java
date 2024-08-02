package akash;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RepresentativeApp implements ActionListener {
    JFrame jf;
    JButton submit, display;
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField jt1, jt2, jt3, jt4, jt5;
    Connection con;
    PreparedStatement st;
    ResultSet rs;

    RepresentativeApp() {
        jf = new JFrame("Representative Form");
        jl1 = new JLabel("Enter RepNo"); jt1 = new JTextField(20);
        jl2 = new JLabel("Enter RepName"); jt2 = new JTextField(20);
        jl3 = new JLabel("Enter State"); jt3 = new JTextField(20);
        jl4 = new JLabel("Enter Commission"); jt4 = new JTextField(20);
        jl5 = new JLabel("Enter Rate"); jt5 = new JTextField(20);
        submit = new JButton("Submit");
        display = new JButton("Display");

        jf.add(jl1); jf.add(jt1);
        jf.add(jl2); jf.add(jt2);
        jf.add(jl3); jf.add(jt3);
        jf.add(jl4); jf.add(jt4);
        jf.add(jl5); jf.add(jt5);
        jf.add(submit); submit.addActionListener(this);
        jf.add(display); display.addActionListener(this);

        jf.setVisible(true);
        jf.setSize(300, 300);
        jf.setLayout(new GridLayout(6, 2));

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SalesDB", "root", "Akashise@15");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public void actionPerformed(ActionEvent ae) {
    //     if (ae.getSource() == submit) {
    //         try {
    //             int repNo = Integer.parseInt(jt1.getText());
    //             String repName = jt2.getText();
    //             String state = jt3.getText();
    //             double commission = Double.parseDouble(jt4.getText());
    //             double rate = Double.parseDouble(jt5.getText());

    //             String query = "INSERT INTO Representative VALUES (?, ?, ?, ?, ?)";
    //             st = con.prepareStatement(query);
    //             st.setInt(1, repNo);
    //             st.setString(2, repName);
    //             st.setString(3, state);
    //             st.setDouble(4, commission);
    //             st.setDouble(5, rate);
    //             st.executeUpdate();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     } else if (ae.getSource() == display) {
    //         try {
    //             String query = "SELECT * FROM Representative";
    //             st = con.prepareStatement(query);
    //             rs = st.executeQuery();
    //             JFrame displayFrame = new JFrame("Representative Data");
    //             displayFrame.setLayout(new GridLayout(0, 5));

    //             displayFrame.add(new JLabel("RepNo"));
    //             displayFrame.add(new JLabel("RepName"));
    //             displayFrame.add(new JLabel("State"));
    //             displayFrame.add(new JLabel("Commission"));
    //             displayFrame.add(new JLabel("Rate"));

    //             while (rs.next()) {
    //                 displayFrame.add(new JLabel(String.valueOf(rs.getInt("RepNo"))));
    //                 displayFrame.add(new JLabel(rs.getString("RepName")));
    //                 displayFrame.add(new JLabel(rs.getString("State")));
    //                 displayFrame.add(new JLabel(String.valueOf(rs.getDouble("Commission"))));
    //                 displayFrame.add(new JLabel(String.valueOf(rs.getDouble("Rate"))));
    //             }

    //             displayFrame.setSize(500, 400);
    //             displayFrame.setVisible(true);
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    public static void main(String[] args) {
        new RepresentativeApp();
    }
}
// -- Create the database
// CREATE DATABASE IF NOT EXISTS SalesDB;

// -- Use the database
// USE SalesDB;

// -- Create the Representative table
// CREATE TABLE Representative (
//     RepNo INT PRIMARY KEY,
//     RepName VARCHAR(50),
//     State VARCHAR(50),
//     Commission DECIMAL(10, 2),
//     Rate DECIMAL(10, 2)
// );
