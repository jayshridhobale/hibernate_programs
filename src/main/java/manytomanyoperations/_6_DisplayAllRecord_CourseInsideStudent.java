package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class _6_DisplayAllRecord_CourseInsideStudent {
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

        Criteria crt=ses.createCriteria(Course_info.class);
        List<Course_info> data=crt.list();
        for (Course_info c1:data){
            System.out.println(":Course name\t"+c1.getCouName());
            List<Student_info> stud=c1.getStudentlist();
            for (Student_info info:stud){
                System.out.println("Student name:\t"+info.getStudName());
            }
        }

    }
}
