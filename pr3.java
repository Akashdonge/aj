//3.b
import java.util.*;
import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
import java.awt.event.*;

public class main implements ActionListener {
    ArrayList<Student> arr = new ArrayList<>();
    static JFrame jf;
    static JPanel jp;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
    JTextField name, usn, age, address, s1, s2, s3, s4, department;
    JButton compute, done, display;
    JTextArea jt;
    double cgpa;
    double[] sgpa = {0.0, 0.0, 0.0, 0.0};
    main() {
        jf = new JFrame("Student details");
        jp = new JPanel();
        jl1 = new JLabel("Enter name : ");
        jl2 = new JLabel("Enter USN : ");
        jl3 = new JLabel("Enter age : ");
        jl4 = new JLabel("Enter address : ");
        jl5 = new JLabel("Enter SGPA1 : ");
        jl6 = new JLabel("Enter SGPA2 : ");
        jl7 = new JLabel("Enter SGPA3 : ");
        jl8 = new JLabel("Enter SGPA4 : ");
        jl9 = new JLabel("Entr department : ");
        name = new JTextField(20);
        usn = new JTextField(20);
        age = new JTextField(20);
        address = new JTextField(20);
        s1 = new JTextField(20);
        s2 = new JTextField(20);
        s3 = new JTextField(20);
        s4 = new JTextField(20);
        department = new JTextField(20);
        compute = new JButton("COMPUTE");
        done = new JButton("DONE");
        display = new JButton("DISPLAY");
        jt = new JTextArea(5, 50);
        jp.add(jl1);
        jp.add(name);
        jp.add(jl2);
        jp.add(usn);
        jp.add(jl3);
        jp.add(age);
        jp.add(jl4);
        jp.add(address);
        jp.add(jl5);
        jp.add(s1);
        jp.add(jl6);
        jp.add(s2);
        jp.add(jl7);
        jp.add(s3);
        jp.add(jl8);
        jp.add(s4);
        jp.add(jl9);
        jp.add(department);
        jp.add(compute);
        jp.add(display);
        jp.add(done);
        jp.add(jt);
        jf.add(jp);
        done.addActionListener(this);
        compute.addActionListener(this);
        display.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == compute) {
            cgpa = 0.0;
            sgpa[0] = Double.parseDouble(s1.getText());
            sgpa[1] = Double.parseDouble(s2.getText());
            sgpa[2] = Double.parseDouble(s3.getText());
            sgpa[3] = Double.parseDouble(s4.getText());
            for (double n : sgpa)
                cgpa += n;
            cgpa /= 4;
            JOptionPane.showMessageDialog(null, "The CGPA is : " + cgpa);
        }
        if (ae.getSource() == done) {
            String name1 = name.getText();
            String usn1 = usn.getText();
            String age1 = age.getText();
            int a = Integer.parseInt(age1);
            String address1 = address.getText();
            String department1 = department.getText();
            if (name1.isEmpty() || usn1.isEmpty() || age.getText().isEmpty() || address1.isEmpty() || department1.isEmpty() || s1.getText().isEmpty() || s2.getText().isEmpty() || s3.getText().isEmpty() || s4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Information Missing");
            }
            else if (a < 18 || a >30)        
                JOptionPane.showMessageDialog(null, "Invalid age.");
            arr.add(new Student(name1, usn1, a, address1, department1, cgpa));
        }
        if (ae.getSource() == display){
            for(Student s : arr)
                jt.append(s.toString() + "\n");
        }
    }
    public static void main(String[] args) {
        main student_management = new main();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(700, 700);
        jf.setVisible(true);
    }
}
// sub class student 
//3.a
public class Student {
    String name, usn, address, department;
    int age;
    double cgpa;
    Student(String name, String usn, int age, String address, String department, double cgpa){
        this.name = name;
        this.usn = usn;
        this.age = age;
        this.address = address;
        this.department = department;
        this.cgpa = cgpa;
    }
    public String toString(){
        return name + ":" + usn + ":" + age + ":" + address + ":" + department + ":" + cgpa;
    }
}
