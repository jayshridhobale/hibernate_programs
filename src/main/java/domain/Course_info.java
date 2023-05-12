package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "course_info")
public class Course_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cou_id")
    private  int couID;
    @Column(name = "cou_name")
    private String couName;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.DETACH,CascadeType.MERGE})
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name = "cou_ref"),
            inverseJoinColumns =@JoinColumn(name = "stud_ref")

    )
    private List<Student_info> studentlist;

    public int getCouID() {
        return couID;
    }

    public void setCouID(int couID) {
        this.couID = couID;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public List<Student_info> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(List<Student_info> studentlist) {
        this.studentlist = studentlist;
    }
    public void AddstudentList(Student_info studRef){
        if(studentlist==null){
            studentlist=new LinkedList<>();

        }
        studentlist.add(studRef);
    }

    @Override
    public String toString() {
        return "Course_info{" +
                "couID=" + couID +
                ", couName='" + couName + '\'' +
                ", studentlist=" + studentlist +
                '}';
    }
}
