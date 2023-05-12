package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student_info")
public class Student_info {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private int studID;
   @Column(name = "stud_name")
   private String studName;

//   private Course_info couRef;
   @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.DETACH,CascadeType.MERGE})
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name = "stud_ref"),
            inverseJoinColumns =@JoinColumn(name = "cou_ref")

    )

   private List<Course_info> courseList;

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public List<Course_info> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course_info> courseList) {
        this.courseList = courseList;
    }



    public List<Course_info> getAddCourseList() {
        return courseList;
    }

    public void setAddCourseList(List<Course_info> addCourseList) {
        this.courseList = addCourseList;
    }
    public void addCourseList(Course_info courseRef){
        if(courseList==null){
            courseList=new LinkedList<>();

        }
        courseList.add(courseRef);
    }

    @Override
    public String toString() {
        return "Student_info{" +
                "studID=" + studID +
                ", courseList=" + courseList +
                '}';
    }
}