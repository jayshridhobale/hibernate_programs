package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class _4_Display_Course {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter State id");
        int id=s1.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student_info.class);
        cfg=cfg.addAnnotatedClass(Course_info.class);


        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Student_info s=ses.get(Student_info.class,id);
        List<Course_info>cour=s.getCourseList();
        for (Course_info c:cour){
            System.out.println(c.getCouName());
            System.out.println(c.getCouID());
        }

    }
}
