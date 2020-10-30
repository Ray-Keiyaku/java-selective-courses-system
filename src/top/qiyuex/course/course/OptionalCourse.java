package top.qiyuex.course.course;

public class OptionalCourse extends Course {
    // 最大选课人数
    private int maxStudentNum;

    public OptionalCourse(int ID, String name, int teacherID, boolean isElective, int studentNum, int maxStudentNum) {
        super(ID, name, teacherID, isElective, studentNum);
        this.maxStudentNum = maxStudentNum;
    }

    @Override
    public String show() {
        return super.show() + String.format("%4d", this.maxStudentNum);
    }

    public boolean canSelect() {
        if (this.getStudentNum() < this.maxStudentNum) {
            return true;
        } else {
            return false;
        }
    }

}
