package top.qiyuex.course.user;

// 学生实体类
public class Student extends User {
    private int studentID;
    private String className;

    public Student(String name, String password, int studentID, String className) {
        super(name, password);
        this.studentID = studentID;
        this.className = className;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public boolean login() {
        return true;
    }

    @Override
    public String show() {
        return String.format("%6d", this.studentID) + super.show() + String.format("%6s", this.className);
    }

    // TODO: 学生用户菜单
    @Override
    public void userMenu() {

    }

}
