package top.qiyuex.course.course;

public class OptionalCourse extends Course {
    private int maxStudentNum;

    public OptionalCourse(int ID, String name, String teacherName, boolean isElective, int studentNum,
            int maxStudentNum) {
        super(ID, name, teacherName, isElective, studentNum);
        this.maxStudentNum = maxStudentNum;
    }

    @Override
    public String show() {
        return super.show() + String.format("%4d", this.maxStudentNum);
    }

}
