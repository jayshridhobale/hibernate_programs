package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class _12_InsertNewCourse_WithOld_Student {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter student ID");
        int id=s1.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student_info.class);
        cfg = cfg.addAnnotatedClass(Course_info.class);


        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Student_info sd = ses.get(Student_info.class,id);

        Course_info cf =new Course_info();
        cf.setCouName("jdbc");

        cf.AddstudentList(sd);

        tx = ses.beginTransaction();
        ses.save(cf);

        tx.commit();
        System.out.println("record Inserted");


    }
}
