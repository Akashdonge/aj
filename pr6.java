import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Cgpa implements ActionListener {
    ArrayList<Student> arr=new ArrayList<>();
    static JFrame jf;
    static JPanel  jp;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
    JTextField name,usn,age,address,s1,s2,s3,s4,dep;
    JButton done,display,compute;
    JTextArea jt;
    double cgpa;
    double sgpa[]={0,0,0,0};
    Cgpa(){
        jf=new JFrame("student details");
        jp=new JPanel();
        jl1=new JLabel("Enter student name");
        jl2=new JLabel("STUDENT USN");
        jl3=new JLabel("Student age");
        jl4=new JLabel("Student address");
        jl5=new JLabel(" ENter sgpa 1 ");
        jl6=new JLabel(" ENter sgpa 2");
        jl7=new JLabel(" ENter sgpa 3");
        jl8=new JLabel(" ENter sgpa 4");
        jl9=new JLabel(" ENter Deparment ");
        name=new JTextField(20);
        usn=new JTextField(20);
        age=new JTextField(20);
        address=new JTextField(20);
        s1=new JTextField(20);
        s2=new JTextField(20);
        s3=new JTextField(20);
        s4=new JTextField(20);
        dep=new JTextField(20);
        jt=new JTextArea(5,20);
        done=new JButton("done");
        display=new JButton("display");
        compute=new JButton("compute");
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
        jp.add(dep);
        jp.add(done);
        jp.add(display);
        jp.add(compute);
        jp.add(jt);
        jf.add(jp);
        done.addActionListener(this);
        compute.addActionListener(this);
        display.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==compute){ cgpa=0;
            sgpa[0]=Double.parseDouble(s1.getText());
            sgpa[1]=Double.parseDouble(s2.getText());
            sgpa[2]=Double.parseDouble(s3.getText());
            sgpa[3]=Double.parseDouble(s4.getText());
            for(double a:sgpa)
                    {cgpa+=a;}
                    cgpa/=4;
           JOptionPane.showMessageDialog(null,"cgpa is "+cgpa); 


        }
        if(ae.getSource()==done){
            String name1=name.getText();
            String usn1=usn.getText();
            String address1=address.getText();
            int age1=Integer.parseInt(age.getText());
            String dep1=dep.getText();
            if(name1.isEmpty()|| usn1.isEmpty()||address1.isEmpty()||dep1.isEmpty()||age.getText().isEmpty()||s1.getText().isEmpty()||s4.getText().isEmpty()||s2.getText().isEmpty()||s3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"incoreect data");
            }
            else if(age1<18||age1>30){
                JOptionPane.showMessageDialog(null,"Invalid age"); }
                arr.add(new Student(name1, usn1, age1, address1, dep1, cgpa));
           
        }
        else{
            for(Student a:arr){
                jt.append(a.toString()+"\n ");
            }
        }
    }
    public static void main(String[] args) {
        Cgpa studentdetails = new Cgpa();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(700,700);
        jf.setVisible(true);
    }

}
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
