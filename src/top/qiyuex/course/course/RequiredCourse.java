package top.qiyuex.course.course;

public class RequiredCourse extends Course {
    // 学分
    private int credit;

    public RequiredCourse(int ID, String name, int teacherID, boolean isElective, int studentNum, int credit) {
        super(ID, name, teacherID, isElective, studentNum);
        this.credit = credit;
    }

    // 返回格式化的课程信息，用于在终端输出
    @Override
    public String show() {
        return super.show() + String.format("%4d", this.credit);
    }

    // 重写toString方法，用于数据持久化
    @Override
    public String toString() {
        return super.toString() + String.format("%d", this.credit);
    }
}
