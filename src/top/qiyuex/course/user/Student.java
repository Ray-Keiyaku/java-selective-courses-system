package top.qiyuex.course.user;

import top.qiyuex.course.data.StudentCourses;
import top.qiyuex.course.data.Courses;

// 学生实体类
public class Student extends User {
    private int studentID;
    private String className;

    public Student(String name, String password, int studentID, String className) {
        super(name, password);
        this.studentID = studentID;
        this.className = className;
    }

    // 返回学生学号
    public int getStudentID() {
        return studentID;
    }

    // 学生登录
    @Override
    public boolean login(String password) {
        if (this.getPassword().equals(password)) {
            System.out.printf("你好，%s %s，欢迎访问本系统！\n", this.className, this.getName());
            return true;
        } else {
            return false;
        }
    }

    // 返回格式化的学生信息，用于在终端输出
    @Override
    public String show() {
        return String.format("%6d", this.studentID) + super.show() + String.format("%6s", this.className);
    }

    // 学生菜单
    @Override
    public void userMenu() {
        while (true) {
            System.out.println("""
                    菜单：
                    1.修改登录密码
                    2.查看自己所上课程
                    3.选修课选课
                    4.退出系统""");
            int choice = stdIn.nextInt();
            switch (choice) {
                case 1 -> this.setPassword();
                case 2 -> StudentCourses.showStuCourses(this.studentID);
                case 3 -> {
                    Courses.showOptionalCourses();
                    System.out.println("请输入要选择的课程编号：");
                    int courseID = stdIn.nextInt();
                    StudentCourses.selectCourse(this.studentID, courseID);
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("输入错误，请重新输入！");
            }
        }
    }

}
