package manytomanyoperations;

import domain.Course_info;
import domain.Student_info;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class _5_DisplayAllRecord_StudentWithCourse {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student_info.class);
        cfg=cfg.addAnnotatedClass(Course_info.class);


        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student_info.class);
        List<Student_info> data=crt.list();

        for (Student_info s:data){
            System.out.println("Student name:\t"+s.getStudName());
           List<Course_info> cour=s.getCourseList();
           for (Course_info c1:cour){
               System.out.println(c1.getCouName());
           }
            System.out.println("============================");
        }
    }

}
