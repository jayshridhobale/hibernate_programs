package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class _10_InsertNewStudent_WithOldCourses {
    public static void main(String[] args) {
            Scanner s1=new Scanner(System.in);
            System.out.println("Enter Course ID");
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

            Course_info cf =ses.get(Course_info.class,id);

            Student_info sd = new Student_info();
            sd.setStudName("shubh");


            sd.addCourseList(cf);

            tx = ses.beginTransaction();
            ses.save(sd);

            tx.commit();
            System.out.println("record Inserted");


    }
}
