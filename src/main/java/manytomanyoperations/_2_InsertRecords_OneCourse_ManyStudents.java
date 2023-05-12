package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _2_InsertRecords_OneCourse_ManyStudents {
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

        //one course objcet
        Course_info c1=new Course_info();
        c1.setCouName("sql");

        //multiple Student Object
        Student_info s1=new Student_info();
        s1.setStudName("shubham");

        Student_info s2=new Student_info();
        s2.setStudName("akash");

        //add student object into studentlist
        c1.AddstudentList(s1);
        c1.AddstudentList(s2);

        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(s1);
        ses.save(s2);
        tx.commit();
        System.out.println("Record Inserted Successfully");
    }
}
