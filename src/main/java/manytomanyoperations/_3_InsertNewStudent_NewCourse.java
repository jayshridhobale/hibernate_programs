package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class _3_InsertNewStudent_NewCourse {
    public static void main(String[] args) {
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

        Student_info sd=new Student_info();
        sd.setStudName("akki");

        Course_info cf=new Course_info();
        cf.setCouName("springboot");

        sd.addCourseList(cf);

        tx=ses.beginTransaction();
        ses.save(cf);
        ses.save(sd);
        tx.commit();
        System.out.println("record Inserted");

    }
}
