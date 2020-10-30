package top.qiyuex.course.course;

import top.qiyuex.course.data.Users;

public abstract class Course implements Comparable<Course> {
    // 课程ID
    private int courseID;
    // 课程名称
    private String name;
    // 授课教师ID
    private int teacherID;
    // 是非为选修课：选修为true
    private boolean isElective;
    // 学生人数
    private int studentNum;

    public Course(int courseID, String name, int teacherID, boolean isElective, int studentNum) {
        this.courseID = courseID;
        this.name = name;
        this.teacherID = teacherID;
        this.isElective = isElective;
        this.studentNum = studentNum;
    }

    public Course() {
    }

    @Override
    public int compareTo(Course o) {
        return o.studentNum - this.studentNum;
    }

    public String getTeacherName() {
        return Users.findTeacher(this.teacherID).getName();
    }

    public int getTeacherID() {
        return this.teacherID;
    }

    public int getCourseID() {
        return this.courseID;
    }

    public int getStudentNum() {
        return this.studentNum;
    }

    public void changeTeacher(int teacherID) {
        this.teacherID = teacherID;
    }

    public String show() {
        String type = isElective ? "选修" : "必修";
        return String.format("%4d %10s %6s %3s %4d ", this.courseID, this.name, this.getTeacherName(), type,
                this.studentNum);
    }
}
