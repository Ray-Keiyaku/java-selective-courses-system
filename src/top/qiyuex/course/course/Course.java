package top.qiyuex.course.course;

public abstract class Course {
    // 课程ID
    private int ID;
    // 课程名称
    private String name;
    // 授课教师名称
    private String teacherName;
    // 是非为选修课：选修为true
    private boolean isElective;
    // 学生人数
    private int studentNum;

    public Course(int ID, String name, String teacherNme, boolean isElective, int studentNum) {
        this.ID = ID;
        this.name = name;
        this.teacherName = teacherNme;
        this.isElective = isElective;
        this.studentNum = studentNum;
    }

    public Course() {
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public String show() {
        String type = isElective ? "选修" : "必修";
        return String.format("%4d %10s %6s %3s %4d ", this.ID, this.name, this.teacherName, type, this.studentNum);
    }
}
