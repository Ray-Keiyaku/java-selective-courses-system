package top.qiyuex.course.course;

public class RequiredCourse extends Course {
    // 学分
    private int credit;

    public RequiredCourse(int ID, String name, int teacherID, boolean isElective, int studentNum, int credit) {
        super(ID, name, teacherID, isElective, studentNum);
        this.credit = credit;
    }

    @Override
    public String show() {
        return super.show() + String.format("%4d", this.credit);
    }
}
