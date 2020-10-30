package top.qiyuex.course.relation;

public class StudentCourse {
    private int studentID;
    private int courseID;

    public StudentCourse(int studentID, int courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
    }

    // 重写equals方法，用于判断选课信息是否存在
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

    // 返回该选课记录的学生学号
    public int getStudentID() {
        return this.studentID;
    }

    // 返回该选课记录的课程ID
    public int getCourseID() {
        return this.courseID;
    }

    // 重写toString方法，用于数据持久化
    @Override
    public String toString() {
        return String.format("%d %d", this.studentID, this.courseID);
    }
}
