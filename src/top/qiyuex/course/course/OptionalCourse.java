package top.qiyuex.course.course;

public class OptionalCourse extends Course {
    // 最大选课人数
    private int maxStudentNum;

    public OptionalCourse(int ID, String name, int teacherID, boolean isElective, int studentNum, int maxStudentNum) {
        super(ID, name, teacherID, isElective, studentNum);
        this.maxStudentNum = maxStudentNum;
    }

    // 返回格式化的课程信息，用于在终端输出
    @Override
    public String show() {
        return super.show() + String.format("%4d", this.maxStudentNum);
    }

    // 重写toString方法，用于数据持久化
    @Override
    public String toString() {
        return super.toString() + String.format("%d", this.maxStudentNum);
    }

    // 判断当前人数是否超过最大选课人数，返回是否可以进行选课
    public boolean canSelect() {
        if (this.getStudentNum() < this.maxStudentNum) {
            return true;
        } else {
            return false;
        }
    }

}
