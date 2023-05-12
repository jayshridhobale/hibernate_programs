package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class _11_InsertOldStudent_WithOldCourse {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter Stud id");
        int sId=s1.nextInt();

        System.out.println("Enter course id");
        int cId=s1.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student_info.class);
        cfg=cfg.addAnnotatedClass(Course_info.class);


        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Student_info std=ses.get(Student_info.class,sId);

        Course_info cour=ses.get(Course_info.class,cId);

        if(std!=null && cour!=null){
            cour.AddstudentList(std);
            std.addCourseList(cour);
            tx=ses.beginTransaction();
            ses.save(std);
            ses.save(cour);
            tx.commit();
            System.out.println("record inserted");
        }

    }
}
