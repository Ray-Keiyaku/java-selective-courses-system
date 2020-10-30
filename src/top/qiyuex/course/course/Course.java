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

    // 重写compareTo方法用于按学生人数排序
    @Override
    public int compareTo(Course o) {
        return o.studentNum - this.studentNum;
    }

    // 返回教师姓名
    public String getTeacherName() {
        return Users.findTeacher(this.teacherID).getName();
    }

    // 返回教师工号
    public int getTeacherID() {
        return this.teacherID;
    }

    // 返回课程ID
    public int getCourseID() {
        return this.courseID;
    }

    // 返回当前学生人数
    public int getStudentNum() {
        return this.studentNum;
    }

    // 修改当前课程的任课教师
    public void changeTeacher(int teacherID) {
        this.teacherID = teacherID;
    }

    // 返回格式化的课程信息，用于在终端输出
    public String show() {
        String type = isElective ? "选修" : "必修";
        return String.format("%4d %10s %6s %3s %4d ", this.courseID, this.name, this.getTeacherName(), type,
                this.studentNum);
    }

    // 重写toString方法，用于数据持久化
    @Override
    public String toString() {
        return String.format("%d %s %d %b %d", this.courseID, this.name, this.teacherID, this.isElective,
                this.studentNum);
    }
}
