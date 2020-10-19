package top.qiyuex.course.course;

public class RequiredCourse extends Course {
    private int credit;

    public RequiredCourse(int ID, String name, String teacherName, boolean isElective, int studentNum, int credit) {
        super(ID, name, teacherName, isElective, studentNum);
        this.credit = credit;
    }

    @Override
    public String show() {
        return super.show() + String.format("4d", this.credit);
    }
}
