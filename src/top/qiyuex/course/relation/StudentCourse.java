package top.qiyuex.course.relation;

public class StudentCourse {
    private int studentID;
    private int courseID;

    public StudentCourse(int studentID, int courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StudentCourse) {
            StudentCourse tmp = (StudentCourse) obj;
            if (this.studentID == tmp.studentID && this.courseID == tmp.courseID) {
                return true;
            }
        }
        return false;
    }
}

