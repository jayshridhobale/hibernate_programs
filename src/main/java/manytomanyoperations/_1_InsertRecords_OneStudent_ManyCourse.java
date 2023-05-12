package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _1_InsertRecords_OneStudent_ManyCourse {
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

        //One Student Object
        Student_info stud=new Student_info();
        stud.setStudName("jayu");

        // Two course objcets
        Course_info c1=new Course_info();
        c1.setCouName("j2ee");

        Course_info c2=new Course_info();
        c2.setCouName("java");

        //add course Object into CourseList
        stud.addCourseList(c1);
        stud.addCourseList(c2);

        tx=ses.beginTransaction();
        ses.save(stud);
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("record Inserted");
    }
}
